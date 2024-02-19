package model;

public class Estudiante extends Persona{
    private Seccion[] secciones;

    public Estudiante(String nombreCompleto, String cedula, Seccion[] secciones) {
        super(nombreCompleto, cedula);
        this.secciones = secciones;
    }

    public void solicitarRetiro(){

    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }
}
