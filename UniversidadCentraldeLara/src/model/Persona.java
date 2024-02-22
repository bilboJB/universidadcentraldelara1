/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
package model;

public abstract class Persona {
    protected String nombreCompleto;
    protected String cedula;

    public Persona(String nombreCompleto, String cedula) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
    }
}
