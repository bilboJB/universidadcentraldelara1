/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
*/
package model;

import java.time.LocalDate;

public abstract class Persona {
    protected String nombreCompleto;
    protected String cedula;
    protected String tlfPersona;
    protected LocalDate fechaNacimiento;
    protected char genero;

    public Persona(String n, String c, String t, LocalDate f, char g) {
        this.nombreCompleto = n;
        this.cedula = c;
        this.tlfPersona = t;
        this.fechaNacimiento = f;
        this.genero = g;
    }

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTlfPersona() {
		return tlfPersona;
	}

	public void setTlfPersona(String tlfPersona) {
		this.tlfPersona = tlfPersona;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
    
}
