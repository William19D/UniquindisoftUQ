package co.edu.uniquindio.model;

public class Contributor implements Comparable<Contributor> {

    private String nombre;
    private String identificacion;
    private Integer edad;
    private Boolean embargado;
    private Double salario;
    private String ciudad;
    private String fondoPensiones;

    public Contributor() {
        this.nombre = null;
        this.identificacion = null;
        this.edad = null;
        this.embargado = null;
        this.salario = null;
        this.ciudad = null;
        this.fondoPensiones = null;
    }

    public Contributor(String nombre, String identificacion, Integer edad, Boolean embargado, Double salario) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.embargado = embargado;
        this.salario = salario;
        this.ciudad = null;
        this.fondoPensiones = null;
    }

    // Getters and setters
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFondoPensiones() {
        return fondoPensiones;
    }

    public void setFondoPensiones(String fondoPensiones) {
        this.fondoPensiones = fondoPensiones;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", embargado=" + embargado +
                ", salario=" + salario +
                ", ciudad='" + ciudad + '\'' +
                ", fondoPensiones='" + fondoPensiones + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contributor o) {
        return Double.compare(this.edad, o.edad);
    }
}