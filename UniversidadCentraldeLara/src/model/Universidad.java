package model;

public class Universidad {
    private Decanato[] decanatos;

    public Universidad(Decanato[] decanatos) {
        this.decanatos = decanatos;
    }
    public void generarListado(Decanato decanato){

    }
    public Decanato[] getDecanatos() {
        return decanatos;
    }
    public void setDecanatos(Decanato[] decanatos) {
        this.decanatos = decanatos;
    }
}
