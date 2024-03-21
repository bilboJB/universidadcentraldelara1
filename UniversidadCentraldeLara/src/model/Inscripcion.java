/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
package model;

public class Inscripcion {
	private Carrera carrera;
	private Asignatura[] asignatura;
	private Seccion[] secciones;
	private Estudiante estudiante;
	private PeriodoAcademico periodo;
	
	public Inscripcion(Carrera c, Estudiante e, PeriodoAcademico periodo, Seccion[] s) {
		this.carrera = c;
		this.asignatura = c.getAsignaturas();
		this.secciones = s;
		this.estudiante = e;
		this.periodo = periodo;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Asignatura[] getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura[] asignatura) {
		this.asignatura = asignatura;
	}

	public Seccion[] getSecciones() {
		return secciones;
	}

	public void setSecciones(Seccion[] secciones) {
		this.secciones = secciones;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public PeriodoAcademico getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoAcademico periodo) {
		this.periodo = periodo;
	}
}
