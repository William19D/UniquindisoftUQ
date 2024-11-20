package co.edu.uniquindio.model;

public class Contributor implements Comparable<Contributor> {

     String nombre;
     String apellido;
     Integer edad;
     Double salario;
     Boolean embargado;

    public Contributor() {
        this.nombre = null;
        this.apellido = null;
        this.edad = null;
        this.salario = null;
        this.embargado = null;
    }

    public Contributor(String nombre, String apellido, int edad, double salario, boolean embargado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
        this.embargado = embargado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public boolean getEmbargado() {
        return embargado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setEmbargado(boolean embargado) {
        this.embargado = embargado;
    }


    @Override
    public int compareTo(Contributor o) {
        return Double.compare(this.salario, o.salario);
    }
}

