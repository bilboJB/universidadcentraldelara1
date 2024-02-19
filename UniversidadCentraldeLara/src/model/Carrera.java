package model;

public class Carrera {
    private Asignatura[] asignaturas;
    private String nombreCarrera;
    
    public Carrera(Asignatura[] asignaturas, String nombreCarrera) {
        this.asignaturas = asignaturas;
        this.nombreCarrera = nombreCarrera;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    
}
