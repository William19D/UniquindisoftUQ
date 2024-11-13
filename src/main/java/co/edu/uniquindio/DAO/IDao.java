package co.edu.uniquindio.DAO;

import java.util.List;

public interface IDao<ClaseEntidad, TipoId> {

    public List<ClaseEntidad> obtenerTodos();
}