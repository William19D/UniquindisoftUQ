package co.edu.uniquindio.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class App {

    public static void main(String[] args) {
        // Configurar el temporizador para ejecutar la tarea cada hora
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TrasladoArchivosTask(), 0, 60 * 60 * 1000); // Ejecutar cada hora (en milisegundos)

        // Mantener el programa en ejecución
        System.out.println("El sistema está en ejecución, esperando mover archivos cada hora...");
        try {
            Thread.sleep(Long.MAX_VALUE); // Esto mantiene la aplicación en ejecución
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Tarea que se ejecutará cada hora para mover los archivos
    static class TrasladoArchivosTask extends TimerTask {

        // Ajusta las rutas de las carpetas dentro de recursos
        private static final String SOLICITUDES_ENTRANTES = "src/main/resources/solicitudesEntrantes";
        private static final String SOLICITUDES_EN_PROCESAMIENTO = "src/main/resources/solicitudesEnProcesamiento";

        @Override
        public void run() {
            try {
                File carpetaEntrantes = new File(SOLICITUDES_ENTRANTES);
                File carpetaProcesamiento = new File(SOLICITUDES_EN_PROCESAMIENTO);

                // Verificar que ambas carpetas existen
                if (!carpetaEntrantes.exists() || !carpetaEntrantes.isDirectory()) {
                    System.err.println("La carpeta 'solicitudesEntrantes' no existe o no es un directorio.");
                    return;
                }

                if (!carpetaProcesamiento.exists()) {
                    carpetaProcesamiento.mkdirs(); // Crear la carpeta 'solicitudesEnProcesamiento' si no existe
                }

                // Mover archivos de la carpeta 'solicitudesEntrantes' a 'solicitudesEnProcesamiento'
                for (File archivo : carpetaEntrantes.listFiles()) {
                    if (archivo.isFile() && archivo.getName().endsWith(".csv")) {
                        File destino = new File(carpetaProcesamiento, archivo.getName());

                        // Mover el archivo
                        Files.move(Paths.get(archivo.getAbsolutePath()), Paths.get(destino.getAbsolutePath()));
                        System.out.println("Archivo movido: " + archivo.getName());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
