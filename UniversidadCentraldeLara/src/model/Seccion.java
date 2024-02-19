package model;

public class Seccion {
    private Profesor profesor;
    private Estudiante[] estudiantes;
    private String codigoSeccion;
    
    public Seccion(Profesor profesor, Estudiante[] estudiantes, String codigoSeccion) {
        this.profesor = profesor;
        this.estudiantes = estudiantes;
        this.codigoSeccion = codigoSeccion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }
}
