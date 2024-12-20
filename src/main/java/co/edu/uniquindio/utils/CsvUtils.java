package co.edu.uniquindio.utils;

import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.services.SuperCache;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvUtils {

    // Método para guardar los cotizantes en un archivo CSV
    public static void guardarCotizantesEnArchivo(String rutaArchivo, SuperCache superCache, Map<String, String> ciudades, Map<String, String> fondosPensiones) throws IOException {
        // Asociar cotizantes con datos base
        superCache.asociarCotizantesConDatosBase(ciudades, fondosPensiones);

        // Recuperar la caché de cotizantes desde la instancia de SuperCache
        Map<String, Contributor> cotizantes = superCache.getAllContributors();

        if (cotizantes == null || cotizantes.isEmpty()) {
            throw new IllegalArgumentException("No hay cotizantes en la caché para guardar.");
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir encabezados en el archivo
            escritor.write("nombre;;identificacion;;edad;;embargado;;salario;;ciudad;;fondo_pensiones\n");

            for (Contributor cotizante : cotizantes.values()) {
                // Obtener la ciudad y fondo de pensiones del cotizante
                String ciudad = cotizante.getCiudad();
                String fondo = cotizante.getFondoPensiones();

                // Escribir los datos en el archivo CSV
                String linea = String.join(";;",
                        cotizante.getNombre(),
                        cotizante.getIdentificacion(),
                        String.valueOf(cotizante.getEdad()),
                        String.valueOf(cotizante.getEmbargado()),
                        String.valueOf(cotizante.getSalario()),
                        ciudad,
                        fondo
                );
                escritor.write(linea + "\n");
            }
        }
    }
}
