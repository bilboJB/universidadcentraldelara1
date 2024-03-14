/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
*/
package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PeriodoAcademico {
	private String codigoPeriodo;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private LocalDate fechaLimiteRetiro;
	
	public PeriodoAcademico(String c, LocalDate fI, LocalDate fL) {
		this.codigoPeriodo = c;
		this.fechaInicio = fI;
		this.fechaFinal = fL;
		this.fechaLimiteRetiro = fI.plus(4, ChronoUnit.WEEKS);
	}

	public String getCodigoPeriodo() {
		return codigoPeriodo;
	}

	public void setCodigoPeriodo(String codigoPeriodo) {
		this.codigoPeriodo = codigoPeriodo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public LocalDate getFechaLimiteRetiro() {
		return fechaLimiteRetiro;
	}

	public void setFechaLimiteRetiro(LocalDate fechaLimiteRetiro) {
		this.fechaLimiteRetiro = fechaLimiteRetiro;
	}
	
}
