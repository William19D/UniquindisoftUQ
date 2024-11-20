package co.edu.uniquindio.utils;

import co.edu.uniquindio.model.Contributor;

import java.util.List;

public class CaracterizacionValidator {

    private ListaNegra listaAceptados;
    private ListaNegra listaEmbargados;
    private ListaNegra listaRechazados;

    public CaracterizacionValidator() {
        this.listaAceptados = new ListaNegra();
        this.listaEmbargados = new ListaNegra();
        this.listaRechazados = new ListaNegra();
    }

    /**
     * Valida si un contributor puede ser aceptado por las reglas de caracterización.
     *
     * @param contributor  El contributor a evaluar.
     * @param inhabilitado Si está inhabilitado por algún criterio externo.
     * @param deuda        El monto de deuda del contributor.
     * @param salarioMinimo El salario mínimo requerido.
     * @return true si es aceptado, false en caso contrario.
     */
    public boolean validarCaracterizacion(Contributor contributor, boolean inhabilitado, double deuda, double salarioMinimo) {
        if (inhabilitado || deuda > 0 || contributor.getSalario() < salarioMinimo) {
            listaRechazados.addContributor(contributor);
            return false;
        }
        listaAceptados.addContributor(contributor);
        return true;
    }

    /**
     * Verifica si el contributor está embargado.
     *
     * @param contributor El contributor a evaluar.
     * @return true si está embargado, false en caso contrario.
     */
    public boolean verificarEmbargo(Contributor contributor) {
        if (contributor.getEmbargado()) {
            listaEmbargados.addContributor(contributor);
            return true;
        }
        return false;
    }

    public void procesarContributors(List<Contributor> contributors, double salarioMinimo) {
        for (Contributor contributor : contributors) {
            if (verificarEmbargo(contributor)) {
                // Ya fue clasificado como embargado, no necesita más validación
                continue;
            }
            // Valida con las reglas generales
            validarCaracterizacion(contributor, false, 0, salarioMinimo);
        }
    }


    public ListaNegra getListaAceptados() {
        return listaAceptados;
    }

    public ListaNegra getListaEmbargados() {
        return listaEmbargados;
    }

    public ListaNegra getListaRechazados() {
        return listaRechazados;
    }
}
