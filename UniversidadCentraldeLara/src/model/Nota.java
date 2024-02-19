package model;

public class Nota {
    private Estudiante estudiante;
    private Seccion seccion;
    private float valor;
    
    public Nota(Estudiante estudiante, Seccion seccion, float valor) {
        this.estudiante = estudiante;
        this.seccion = seccion;
        this.valor = valor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
