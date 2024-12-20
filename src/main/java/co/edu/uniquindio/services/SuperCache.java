package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Caracterizacion;
import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.utils.LectorArchivosUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SuperCache {
    private Map<String, Contributor> cache = new HashMap<>();
    private Map<String, Caracterizacion> caracterizacionMap = new HashMap<>();
    private Map<String, Caracterizacion> inhabilitarMap = new HashMap<>();
    private Map<String, Caracterizacion> embargablesMap = new HashMap<>();

    public void addCache(String key, Contributor value) {
        cache.put(key, value);
    }

    public Contributor getCache(String key) {
        return cache.get(key);
    }

    public Map<String, Contributor> getAllContributors() {
        return cache;
    }

    public void cargarSolicitudesDesdeArchivo(String rutaArchivo) throws IOException {
        LinkedList<String[]> lineas = LectorArchivosUtil.leerTodasLasLineasCsv(rutaArchivo);

        if (lineas.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío: " + rutaArchivo);
        }

        for (String[] linea : lineas) {
            if (linea.length != 5) { // Validamos la estructura
                throw new IllegalArgumentException("Archivo inválido en " + rutaArchivo + ". Línea: " + String.join(";;", linea));
            }

            String key = linea[1]; // La clave será la identificación
            Contributor solicitud = new Contributor(
                    linea[0], // nombre
                    linea[1], // identificacion
                    Integer.parseInt(linea[2]), // edad
                    Boolean.parseBoolean(linea[3]), // embargado
                    Double.parseDouble(linea[4]) // salario
            );

            addCache(key, solicitud);
        }
    }

    public void cargarCaracterizacionesDesdeArchivo(String rutaArchivo) throws IOException {
        LinkedList<String[]> lineas = LectorArchivosUtil.leerTodasLasLineasCsv(rutaArchivo);

        if (lineas.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío: " + rutaArchivo);
        }

        for (String[] linea : lineas) {
            if (linea.length != 4) { // Validamos la estructura
                throw new IllegalArgumentException("Archivo inválido en " + rutaArchivo + ". Línea: " + String.join(";;", linea));
            }

            String key = linea[1]; // La clave será la identificación
            Caracterizacion caracterizacion = new Caracterizacion(
                    linea[0], // tipoIdentificacion
                    linea[1], // identificacion
                    linea[2], // nombre
                    linea[3]  // estado
            );

            caracterizacionMap.put(key, caracterizacion);

            // Verificar si el estado es "INHABILITAR" y agregar al mapa inhabilitarMap
            if ("INHABILITAR".equalsIgnoreCase(caracterizacion.getEstado())) {
                inhabilitarMap.put(key, caracterizacion);
            }

            // Verificar si el estado es "EMBARGABLES" y agregar al mapa embargablesMap
            if ("EMBARGAR".equalsIgnoreCase(caracterizacion.getEstado())) {
                embargablesMap.put(key, caracterizacion);
            }
        }
    }

    public void cargarDatosDesdeDirectorios(String[] directorios) throws IOException {
        for (String directorio : directorios) {
            File dir = new File(directorio);
            if (dir.isDirectory()) {
                for (File archivo : dir.listFiles()) {
                    if (archivo.getName().endsWith(".csv")) {
                        cargarCaracterizacionesDesdeArchivo(archivo.getAbsolutePath());
                    }
                }
            }
        }
    }

    public Map<String, Caracterizacion> getAllCharacterizations() {
        return caracterizacionMap;
    }

    public Map<String, Caracterizacion> getInhabilitarCharacterizations() {
        return inhabilitarMap;
    }

    public Map<String, Caracterizacion> getEmbargablesCharacterizations() {
        return embargablesMap;
    }

    public void asociarCotizantesConDatosBase(Map<String, String> ciudades, Map<String, String> fondosPensiones) {
        // Asociar los datos base a cada cotizante
        for (Contributor cotizante : cache.values()) {
            String identificacion = cotizante.getIdentificacion();

            // Obtener la ciudad y el fondo de pensiones desde los mapas pasados
            String ciudad = ciudades.get(identificacion);
            String fondoPensiones = fondosPensiones.get(identificacion);

            // Si los datos existen, asociarlos al cotizante
            if (ciudad != null && fondoPensiones != null) {
                cotizante.setCiudad(ciudad);
                cotizante.setFondoPensiones(fondoPensiones);
            } else {
                // Si no existen, asociarlos a un valor en especifico
                cotizante.setCiudad("Desconocida");
                cotizante.setFondoPensiones("Desconocido");
            }
        }
    }
}