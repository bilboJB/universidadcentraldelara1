/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
*/
package model;

public class Nota {
    private Estudiante estudiante;
    private Seccion seccion;
    private float[] valor;
    private PeriodoAcademico periodoNota;
    
    public Nota(Estudiante e, Seccion s, float[] v, PeriodoAcademico pn) {
        this.estudiante = e;
        this.seccion = s;
        this.valor = v;
        this.periodoNota = pn;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public float[] getValor() {
        return valor;
    }

    public void setValor(float[] valor) {
        this.valor = valor;
    }

	public PeriodoAcademico getPeriodoNota() {
		return periodoNota;
	}

	public void setPeriodoNota(PeriodoAcademico periodoNota) {
		this.periodoNota = periodoNota;
	}
    
}
