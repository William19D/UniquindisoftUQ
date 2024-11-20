package co.edu.uniquindio.utils;

import co.edu.uniquindio.model.Contributor;

public class CaracterizacionValidator {

    public static boolean esElegible(Contributor contributor, boolean inhabilitado, double deuda, double salarioMinimo) {

        if (contributor.getEmbargado() || inhabilitado) {
            return false;
        }

        if (deuda > 0) {
            return false;
        }

        if (contributor.getSalario() < salarioMinimo) {
            return false;
        }
        return true;
    }

}
