package co.edu.uniquindio.DAO;

import co.edu.uniquindio.utils.LectorArchivosUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GestorDeEntidad {
    private Map<Integer, String> mapeoColumnas;
    protected String rutaArchivo;

    public GestorDeEntidad(String rutaArchivo) throws IOException {
        this.rutaArchivo = rutaArchivo;
        construirMapeo();
    }

    public void construirMapeo() throws IOException {
        this.mapeoColumnas = new HashMap<>();
        String[] primeraLinea = LectorArchivosUtil.leerPrimeraLineaCsv(this.rutaArchivo);

        for(int i = 0; i < primeraLinea.length; i++) {
            this.mapeoColumnas.put(i, primeraLinea[i]);
        }
    }

    public <ClaseEntidad> List<ClaseEntidad> obtenerTodos(Class<ClaseEntidad> claseEntidad) {

        LinkedList<ClaseEntidad> entidades = new LinkedList<>();

        try {
            LinkedList<String[]> lineas = LectorArchivosUtil.leerTodasLasLineasCsv(this.rutaArchivo);

            for (String[] linea : lineas) {
                ClaseEntidad instancia = claseEntidad.getDeclaredConstructor().newInstance();

                for (Map.Entry<Integer, String> itemMapa : this.mapeoColumnas.entrySet()) {

                    Field atributo = claseEntidad.getDeclaredField(itemMapa.getValue());
                    atributo.setAccessible(true);
                    String value = linea[itemMapa.getKey()];

                    /** Se cambian por los atributos de los CSV
                    if (atributo.getType().equals(Integer.class) || atributo.getType().equals(int.class)) {
                        atributo.set(instancia, Integer.parseInt(value));
                    } else if (atributo.getType().equals(Double.class) || atributo.getType().equals(double.class)) {
                        atributo.set(instancia, Double.parseDouble(value));
                    } else if (atributo.getType().equals(Boolean.class) || atributo.getType().equals(boolean.class)) {
                        atributo.set(instancia, Boolean.parseBoolean(value));
                    } else if (atributo.getType().equals(Long.class) || atributo.getType().equals(long.class)) {
                        atributo.set(instancia, Long.parseLong(value));
                    } else {
                        atributo.set(instancia, value);
                    }
                     /**/
                }

                entidades.add(instancia);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return entidades;
    }
}
