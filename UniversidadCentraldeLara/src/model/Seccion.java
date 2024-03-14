/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
*/
package model;

public class Seccion {
    private Profesor profesor;
    private Estudiante[] estudiantes;
    private String codigoSeccion;
    private PeriodoAcademico periodoSeccion;
    
    public Seccion(Profesor p, Estudiante[] e, String c, PeriodoAcademico pa) {
        this.profesor = p;
        this.estudiantes = e;
        this.codigoSeccion = c;
        this.periodoSeccion = pa;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

	public PeriodoAcademico getPeriodoSeccion() {
		return periodoSeccion;
	}

	public void setPeriodoSeccion(PeriodoAcademico periodoSeccion) {
		this.periodoSeccion = periodoSeccion;
	}
    
}
