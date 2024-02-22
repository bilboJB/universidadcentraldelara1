/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
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
