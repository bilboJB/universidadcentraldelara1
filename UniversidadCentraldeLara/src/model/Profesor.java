package model;

public class Profesor extends Persona{
    private Seccion[] secciones;

    public Profesor(String nombreCompleto, String cedula, Seccion[] secciones) {
        super(nombreCompleto, cedula);
        this.secciones = secciones;
    }  
    public Nota generarNota(Seccion seccion, Estudiante estudiante, float valor){
        //posiblemente cambie
        return null;
    }
    public Seccion[] getSecciones() {
        return secciones;
    }
    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }
}
