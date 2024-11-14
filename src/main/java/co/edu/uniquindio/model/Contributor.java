package co.edu.uniquindio.model;

public class Contributor implements Comparable<Contributor> {

    String nombre;
    String identificacion;
    Integer edad;
    Boolean embargado;
    String telefono;

    public Contributor() {
        this.nombre = null;
        this.identificacion = null;
        this.edad = null;
        this.edad= null;
        this.telefono = null;
    }

    public Contributor(String nombre, String identificacion, Integer edad, Boolean embargado, String salario) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.embargado = embargado;
        this.telefono = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEmbargado() {
        return embargado;
    }

    public void setEmbargado(Boolean embargado) {
        this.embargado = embargado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "Cotizante{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", embargado=" + embargado +
                ", salario='" + telefono + '\'' +
                '}';
    }


    @Override
    public int compareTo(Contributor o) {
        return Double.compare(this.edad, o.edad);
    }
}

