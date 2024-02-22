/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
package model;

public class Decanato {
    private Carrera[] carreras;
    private String periodoAcademico;
    private String nombreDecanato;
    
    public Decanato(Carrera[] carreras, String periodoAcademico, String nombreDecanato) {
        this.carreras = carreras;
        this.periodoAcademico = periodoAcademico;
        this.nombreDecanato = nombreDecanato;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }

    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
    }

    public String getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(String periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public String getNombreDecanato() {
        return nombreDecanato;
    }

    public void setNombreDecanato(String nombreDecanato) {
        this.nombreDecanato = nombreDecanato;
    }
    
}
