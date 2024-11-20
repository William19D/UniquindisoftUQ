import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.services.SuperCache;
import co.edu.uniquindio.utils.CsvUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperCacheCsvUtilsTest {

    @Test
    public void testSuperCacheAndCsvUtils() throws IOException {
        SuperCache superCache = new SuperCache();

        // Datos quemados
        Contributor contributor1 = new Contributor("Juan", "2015925972", 35, false, 2000.0);
        Contributor contributor2 = new Contributor("María", "2015925973", 40, true, 1500.0);
        Contributor contributor3 = new Contributor("Carlos", "2015925974", 28, false, 1000.0);

        // Agregar datos a la caché
        superCache.addCache(contributor1.getIdentificacion(), contributor1);
        superCache.addCache(contributor2.getIdentificacion(), contributor2);
        superCache.addCache(contributor3.getIdentificacion(), contributor3);

        // Mapas de ciudades y fondos de pensiones
        Map<String, String> ciudades = new HashMap<>();
        Map<String, String> fondosPensiones = new HashMap<>();

        ciudades.put("2015925972", "Medellín");
        ciudades.put("2015925973", "Bogotá");
        ciudades.put("2015925974", "Cali");

        fondosPensiones.put("2015925972", "FondoA");
        fondosPensiones.put("2015925973", "FondoB");
        fondosPensiones.put("2015925974", "FondoC");

        // Guardar cotizantes en archivo
        String rutaSalida = "cotizantes_test.csv";
        CsvUtils.guardarCotizantesEnArchivo(rutaSalida, superCache, ciudades, fondosPensiones);

        // Verificar que el archivo se haya creado
        File archivoSalida = new File(rutaSalida);
        assertTrue(archivoSalida.exists());

        // Imprimir la ruta absoluta del archivo generado
        System.out.println("Archivo generado en: " + archivoSalida.getAbsolutePath());

        // Imprimir el contenido de la caché
        System.out.println("Contenido de la caché:");
        for (Contributor contributor : superCache.getAllContributors().values()) {
            System.out.println(contributor);
        }

        // Leer el contenido del archivo y verificar que contiene los datos esperados
        String contenido = new String(Files.readAllBytes(Paths.get(rutaSalida)));
        assertTrue(contenido.contains("Juan;;2015925972;;35;;false;;2000.0;;Medellín;;FondoA"));
        assertTrue(contenido.contains("María;;2015925973;;40;;true;;1500.0;;Bogotá;;FondoB"));
        assertTrue(contenido.contains("Carlos;;2015925974;;28;;false;;1000.0;;Cali;;FondoC"));

        // Eliminar el archivo de prueba
        archivoSalida.delete();
    }
}