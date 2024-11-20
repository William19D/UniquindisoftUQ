package co.edu.uniquindio.app;

import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.services.SuperCache;
import co.edu.uniquindio.utils.CsvUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        SuperCache superCache = new SuperCache();

        // Ruta de los archivos CSV
        String rutaSolicitudes = "ruta/del/directorio/con/solicitudes";
        File directorio = new File(rutaSolicitudes);

        if (directorio.isDirectory()) {
            for (File archivo : directorio.listFiles()) {
                if (archivo.getName().endsWith(".csv")) {
                    // Cargar solicitudes de traslado desde cada archivo
                    superCache.cargarSolicitudesDesdeArchivo(archivo.getAbsolutePath());
                }
            }
        }

        // Extraer cotizantes desde las solicitudes cargadas en caché
        superCache.extraerCotizantesEnCache();

        // Mostrar resultado
        Map<String, Contributor> cotizantes = (Map<String, Contributor>) superCache.getCache("cotizantes");
        System.out.println("Cotizantes cargados en caché: " + cotizantes.size());

        // Opcional: mostrar detalles de los cotizantes cargados
        cotizantes.values().forEach(System.out::println);

        // Mapas de ciudades y fondos de pensiones (esto debe provenir de tus datos)
        Map<String, String> ciudades = new HashMap<>();
        Map<String, String> fondosPensiones = new HashMap<>();

        // Ejemplo de cómo podrías cargar estos datos (esto puede provenir de archivos o base de datos)
        ciudades.put("2015925972", "Medellín");
        fondosPensiones.put("2015925972", "FondoA");

        // Guardar cotizantes en archivo
        String rutaSalida = "ruta/del/archivo/salida/cotizantes.csv";
        CsvUtils.guardarCotizantesEnArchivo(rutaSalida, superCache, ciudades, fondosPensiones);

        System.out.println("Cotizantes guardados en el archivo: " + rutaSalida);
    }
}
