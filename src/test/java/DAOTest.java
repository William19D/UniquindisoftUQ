import co.edu.uniquindio.DAO.ContributorDAO;
import co.edu.uniquindio.DAO.CotizanteDAO;
import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.model.Cotizante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class DAOTest {

    private CotizanteDAO cotizanteDAO;
    private ContributorDAO contributorDAO;

    @BeforeEach
    public void setUp() throws IOException {
        // Asegúrate de que las rutas de los archivos CSV sean correctas y existan en el proyecto
        cotizanteDAO = new CotizanteDAO("src/main/resources/cotizantes.csv");
        contributorDAO = new ContributorDAO("src/main/resources/contribuidores.csv");
    }

    @Test
    public void printCSVCotizantes() {
        List<Cotizante> cotizantes = cotizanteDAO.obtenerTodos();
        System.out.println("Contenido del archivo CSV Cotizantes:");
        for (Cotizante cotizante : cotizantes) {
            System.out.println("Nombre: " + cotizante.getNombre() +
                    ", Apellido: " + cotizante.getApellido() +
                    ", Edad: " + cotizante.getEdad() +
                    ", Salario: " + cotizante.getSalario());
        }
    }

    @Test
    public void printCSVContribuidores() {
        List<Contributor> contribuidores = contributorDAO.obtenerTodos();
        System.out.println("Contenido del archivo CSV Contribuidores:");
        for (Contributor contributor : contribuidores) {
            System.out.println("Nombre: " + contributor.getNombre() +
                    ", Apellido: " + contributor.getApellido() +
                    ", Edad: " + contributor.getEdad() +
                    ", Salario: " + contributor.getSalario());
        }
    }
}
