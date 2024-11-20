package co.edu.uniquindio.services;


import co.edu.uniquindio.model.Contributor;
import co.edu.uniquindio.model.Cotizante;
import co.edu.uniquindio.utils.ContributorQueue;

import java.util.List;
import java.util.Objects;

public class CotizanteValidador {

    private ContributorQueue contributorQueue = new ContributorQueue();

    public ContributorQueue getContributorQueue() {
        return contributorQueue;
    }

    public List<String> validateAll(Cotizante cotizante) {
        return List.of(
                validarNombre(cotizante.getNombre()),
                validarApellido(cotizante.getIdentificacion()),
                validarEdad(cotizante.getEdad()),
                validarSalario(cotizante.getTelefono())
        );
    }

    public String validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return "El nombre no puede estar vacío";
        }
        return null;
    }

    public String validarApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            return "El apellido no puede estar vacío";
        }
        return null;
    }

    public String validarEdad(int edad) {
        if (edad < 18) {
            return "El cotizante debe ser mayor de edad";
        }
        return null;
    }

    public String validarSalario(String telefono) {
        if (telefono.isEmpty()) {
            return "El telefono no puede estar vacío";
        }
        return null;
    }

    public boolean esValido(Cotizante cotizante) {
        List<String> errors = validateAll(cotizante);
        boolean isValid = errors.stream().allMatch(Objects::isNull);
        if (isValid) {
            Contributor contributor = new Contributor(
                    cotizante.getNombre(),
                    cotizante.getIdentificacion(),
                    cotizante.getEdad(),
                    cotizante.getEmbargado(),
                    cotizante.getTelefono()
            );
            contributorQueue.addContributor(contributor);
        }
        return isValid;
    }

}

