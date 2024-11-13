package co.edu.uniquindio.DAO;

import co.edu.uniquindio.model.Contributor;

import java.io.IOException;

public class ContributorDAO extends ADao<Contributor, Integer>{
    public ContributorDAO(String rutaArchivo) throws IOException {
        super(rutaArchivo);
    }
}
