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
