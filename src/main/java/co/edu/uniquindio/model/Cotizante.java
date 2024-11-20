package co.edu.uniquindio.model;

public class Cotizante {

    String nombre;
    String identificacion;
    Integer edad;
    Boolean embargado;
    Double salario;

    public Cotizante() {
        this.nombre = null;
        this.identificacion = null;
        this.edad = null;
        this.edad= null;
        this.salario = null;
    }

    public Cotizante(String nombre, String identificacion, Integer edad, Boolean embargado, Double salario) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.embargado = embargado;
        this.salario = salario;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "Cotizante{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", embargado=" + embargado +
                ", salario='" + salario + '\'' +
                '}';
    }
}