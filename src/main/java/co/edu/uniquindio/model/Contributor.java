package co.edu.uniquindio.model;

public class Contributor implements Comparable<Contributor> {

     String nombre;
     String apellido;
     Integer edad;
     Double salario;

    public Contributor() {
        this.nombre = null;
        this.apellido = null;
        this.edad = null;
        this.salario = null;
    }

    public Contributor(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
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


    @Override
    public int compareTo(Contributor o) {
        return Double.compare(this.salario, o.salario);
    }
}

