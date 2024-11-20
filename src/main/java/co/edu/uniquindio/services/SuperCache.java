package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.utils.LectorArchivosUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SuperCache {
    private Map<String, Contributor> cache = new HashMap<>();

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