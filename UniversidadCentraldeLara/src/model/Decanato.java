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
    private String nombreDecanato;
    private String direccionDecanato;
    private String tlfDecanato;

    public Decanato(Carrera[] c, String d, String n, String t) {
        this.carreras = c;
        this.direccionDecanato = d;
        this.nombreDecanato = n;
        this.tlfDecanato = t;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }

    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
    }

    public String getNombreDecanato() {
        return nombreDecanato;
    }

    public void setNombreDecanato(String nombreDecanato) {
        this.nombreDecanato = nombreDecanato;
    }

	public String getDireccionDecanato() {
		return direccionDecanato;
	}

	public void setDireccionDecanato(String direccionDecanato) {
		this.direccionDecanato = direccionDecanato;
	}

	public String getTlfDecanato() {
		return tlfDecanato;
	}

	public void setTlfDecanato(String tlfDecanato) {
		this.tlfDecanato = tlfDecanato;
	}
    
}
