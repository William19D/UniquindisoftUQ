package co.edu.uniquindio.model;

public class Cotizante {

    String nombre;
    String apellido;
    Integer edad;
    Double salario;
    Boolean embargado;

    public Cotizante() {
        this.nombre = null;
        this.apellido = null;
        this.edad = null;
        this.salario = null;
        this.embargado = null;
    }

    public Cotizante(String nombre, String apellido, Integer edad, Double salario, Boolean embargado) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
        this.embargado = embargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Boolean getEmbargado() {
        return embargado;
    }

    public void setEmbargado(Boolean embargado) {
        this.embargado = embargado;
    }

    @Override
    public String toString() {
        return "Cotizante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                ", embargado=" + embargado +
                '}';
    }
}