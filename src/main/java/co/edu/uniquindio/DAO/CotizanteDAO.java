package co.edu.uniquindio.DAO;

import co.edu.uniquindio.model.Cotizante;

import java.io.IOException;

public class CotizanteDAO extends ADao<Cotizante, Integer> {
    public CotizanteDAO(String rutaArchivo) throws IOException {
        super(rutaArchivo);
    }
}
