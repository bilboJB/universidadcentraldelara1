/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
*/
package model;

public class Universidad {
    private Decanato[] decanatos;

    public Universidad(Decanato[] d) {
        this.decanatos = d;
    }
    public void generarListado(Decanato decanato){

    }
    public Decanato[] getDecanatos() {
        return decanatos;
    }
    public void setDecanatos(Decanato[] d) {
        this.decanatos = d;
    }
}
