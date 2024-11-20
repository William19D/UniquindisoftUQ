import co.edu.uniquindio.model.Caracterizacion;
import co.edu.uniquindio.services.SuperCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class FCPCaractTest {

    private SuperCache superCache;

    @BeforeEach
    public void setup() {
        superCache = new SuperCache();
    }

    @Test
    public void testCargarCaracterizacionesDesdeDirectorios() throws IOException {
        // Directorios de recursos
        String[] directorios = {
                "src/main/resources/contraloria",
                "src/main/resources/fiscalia",
                "src/main/resources/procuraduria"
        };

        // Cargar datos desde los directorios
        for (String directorio : directorios) {
            File dir = new File(directorio);
            if (dir.isDirectory()) {
                int count = 0;
                for (File archivo : dir.listFiles()) {
                    if (archivo.getName().endsWith(".csv")) {
                        superCache.cargarCaracterizacionesDesdeArchivo(archivo.getAbsolutePath());
                        count++;
                        if (count >= 3) break; // Limitar a los primeros 3 archivos
                    }
                }
            }
        }

        // Verificar que la caché no esté vacía
        Map<String, Caracterizacion> caracterizaciones = superCache.getAllCharacterizations();
        assertFalse(caracterizaciones.isEmpty(), "La caché no debe estar vacía después de cargar los datos.");

        // Imprimir el contenido de la caché
        System.out.println("Contenido de la caché:");
        for (Caracterizacion caracterizacion : caracterizaciones.values()) {
            System.out.println(caracterizacion);
        }
    }
}