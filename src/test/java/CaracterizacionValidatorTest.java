import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.utils.CaracterizacionValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaracterizacionValidatorTest {
    private CaracterizacionValidator validator;

    @BeforeEach
    public void setup() {
        validator = new CaracterizacionValidator();
    }

    @Test
    public void testProcesarContributors() {
        // Datos de prueba
        Contributor contributor1 = new Contributor("Juan", "124124", 35, false, 2000.0);
        Contributor contributor2 = new Contributor("María", "124125", 40, true, 1500.0);
        Contributor contributor3 = new Contributor("Carlos", "124126", 25, false, 1000.0);
        Contributor contributor4 = new Contributor("Ana", "124127", 30, false, 10000.0);

        // Lista de prueba
        validator.procesarContributors(
                List.of(contributor1, contributor2, contributor3, contributor4),
                1200.0 // Salario mínimo
        );

        // Validaciones
        assertEquals(2, validator.getListaAceptados().getListaNegra().size(), "Debe haber 2 aceptados");
        assertTrue(validator.getListaAceptados().getListaNegra().contains(contributor1), "Juan debe estar aceptado");
        assertTrue(validator.getListaAceptados().getListaNegra().contains(contributor4), "Ana debe estar aceptada");

        assertEquals(1, validator.getListaEmbargados().getListaNegra().size(), "Debe haber 1 embargado");
        assertTrue(validator.getListaEmbargados().getListaNegra().contains(contributor2), "María debe estar embargada");

        assertEquals(1, validator.getListaRechazados().getListaNegra().size(), "Debe haber 1 rechazado");
        assertTrue(validator.getListaRechazados().getListaNegra().contains(contributor3), "Carlos debe estar rechazado");
    }


}
