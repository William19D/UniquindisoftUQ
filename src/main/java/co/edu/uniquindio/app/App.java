package co.edu.uniquindio.app;

import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.utils.CaracterizacionValidator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CaracterizacionValidator validator = new CaracterizacionValidator();

        // Ejemplo de lista de contribuyentes
        List<Contributor> contributors = List.of(
                new Contributor("Juan", "Pérez", 35, 2000.0, false),
                new Contributor("María", "López", 40, 1500.0, true),
                new Contributor("Carlos", "Ramírez", 28, 1000.0, false),
                new Contributor("Ana", "Gómez", 30, 2500.0, false)
        );

        // Procesar contribuyentes
        validator.procesarContributors(contributors, 1200.0);

        // Mostrar resultados
        System.out.println("Aceptados: " + validator.getListaAceptados().getListaNegra().size());
        System.out.println("Embargados: " + validator.getListaEmbargados().getListaNegra().size());
        System.out.println("Rechazados: " + validator.getListaRechazados().getListaNegra().size());
    }
}


