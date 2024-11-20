package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.utils.LectorArchivosUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SuperCache {
    private Map<String, Map<String, String>> cache= new HashMap<>();

    public void addCache(String key, Map<String, String> value) {
        cache.put(key, value);
    }

    public Map<String, String> getCache(String key) {
        return cache.get(key);
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
            Map<String, String> solicitud = new HashMap<>();
            solicitud.put("nombre", linea[0]);
            solicitud.put("identificacion", linea[1]);
            solicitud.put("edad", linea[2]);
            solicitud.put("embargado", linea[3]);
            solicitud.put("salario", linea[4]);

            addCache(key, solicitud);
        }
    }


    public void extraerCotizantesEnCache() {
        Map<String, Contributor> cotizantesCache = new HashMap<>();

        for (Map.Entry<String, Map<String, String>> entry : cache.entrySet()) {
            Map<String, String> datosSolicitud = entry.getValue();

            // Crear un Contributor desde los datos de la solicitud
            Contributor cotizante = new Contributor(
                    datosSolicitud.get("nombre"),
                    datosSolicitud.get("identificacion"),
                    Integer.parseInt(datosSolicitud.get("edad")),
                    Boolean.parseBoolean(datosSolicitud.get("embargado")),
                    Double.parseDouble(datosSolicitud.get("salario"))
            );

            // Cargar el cotizante en la nueva caché
            cotizantesCache.put(cotizante.getIdentificacion(), cotizante);
        }

        // Guardar cotizantes en otra instancia de SuperCache (o en una caché dedicada)
        cache.put("cotizantes", (Map) cotizantesCache);
    }


    public void asociarCotizantesConDatosBase(Map<String, String> ciudades, Map<String, String> fondosPensiones) {
        // Obtener los cotizantes desde la caché
        Map<String, Contributor> cotizantes = (Map<String, Contributor>) cache.get("cotizantes");

        // Asociar los datos base a cada cotizante
        for (Contributor cotizante : cotizantes.values()) {
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

