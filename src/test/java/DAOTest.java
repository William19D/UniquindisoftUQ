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
        cotizanteDAO = new CotizanteDAO("src/main/resources/co/edu/uniquindio/csv/cotizantes.csv");
        contributorDAO = new ContributorDAO("src/main/resources/co/edu/uniquindio/csv/contribuidores.csv");
    }

    @Test
    public void printCSVCotizantes() {
        List<Cotizante> cotizantes = cotizanteDAO.obtenerTodos();
        System.out.println("Contenido del archivo CSV Cotizantes:");
        for (Cotizante cotizante :cotizantes) {
            System.out.println("Nombre: " + cotizante.getNombre() +
                    ", Identificación: " + cotizante.getIdentificacion() +
                    ", Edad: " + cotizante.getEdad() +
                    ", Embargado: " + cotizante.getEmbargado() +
                    ", Teléfono: " + cotizante.getTelefono());
        }
    }

    @Test
    public void printCSVContribuidores() {
        List<Contributor> contributors = contributorDAO.obtenerTodos();
        System.out.println("Contenido del archivo CSV Contribuidores:");
        for (Contributor contribuidor : contributors) {
            System.out.println("Nombre: " + contribuidor.getNombre() +
                    ", Identificación: " + contribuidor.getIdentificacion() +
                    ", Edad: " + contribuidor.getEdad() +
                    ", Embargado: " + contribuidor.getEmbargado() +
                    ", Teléfono: " + contribuidor.getTelefono());
        }
    }
}
