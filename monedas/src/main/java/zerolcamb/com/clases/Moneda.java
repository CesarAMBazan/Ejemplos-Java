package zerolcamb.com.clases;

/*Clase moneda*/
public class Moneda {
    private float diametro;
    private double peso;

    /*Constructor*/
    public Moneda(float diametro, double peso) {
        this.diametro = diametro;
        this.peso = peso;
    }

    /* Getters & Setters */
    public float getDiametro() {
        return diametro;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
}
