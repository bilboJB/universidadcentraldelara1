/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
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
