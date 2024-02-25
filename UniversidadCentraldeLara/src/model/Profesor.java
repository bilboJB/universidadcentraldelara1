/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
package model;

import java.time.LocalDate;

public class Profesor extends Persona{
    private Seccion[] secciones;

    public Profesor(String n, String c, String t, LocalDate f, char g, Seccion[] s) {
        super(n, c, t, f,g);
        this.secciones = s;
    }  
    public Nota generarNota(Seccion seccion, Estudiante estudiante, float[] valor, PeriodoAcademico periodo){
        Nota nota = new Nota(estudiante,seccion,valor,periodo);
    	return nota;
    }
    public Seccion[] getSecciones() {
        return secciones;
    }
    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }
}
