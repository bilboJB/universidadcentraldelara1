package model;

public abstract class Persona {
    protected String nombreCompleto;
    protected String cedula;

    public Persona(String nombreCompleto, String cedula) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
    }
}
