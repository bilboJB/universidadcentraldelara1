package model;

public class Asignatura {
    private Seccion[] secciones;
    private String nombreAsignatura;

    public Asignatura(Seccion[] secciones, String nombreAsignatura) {
        this.secciones = secciones;
        this.nombreAsignatura = nombreAsignatura;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
}
