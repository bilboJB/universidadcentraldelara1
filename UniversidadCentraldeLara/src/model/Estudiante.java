/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
package model;

import java.time.LocalDate;

public class Estudiante extends Persona{
    private Seccion[] secciones;

    public Estudiante(String n, String c, String t, LocalDate f, char g, Seccion[] s) {
        super(n, c, t, f, g);
        this.secciones = s;
    }

    public void solicitarRetiro(){

    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }
    public void solicitarRetiro(Seccion s) {
    	for(Seccion seccion: secciones) {
    		if(s.equals(seccion)) {
    			seccion = null;
    		}
    	}
    }
}
