package main.java.com.zerolcamb.clases;

import java.util.Date;

/**
 *
 * @author Zerol
 * Clase Datos, esta clase es un objeto de las mediciones realizadas por
 * el sensor ultrasonico
 */
public class Datos implements Comparable<Datos>{
    private int medicion;
    private Date fecha;
    private double distancia;

    /* Constructor */
    public Datos(int medicion, Date fecha, double distancia) {
        this.medicion = medicion;
        this.fecha = fecha;
        this.distancia = distancia;
    }
    /* Getters & Setters */ 
    public int getMedicion() {
        return medicion;
    }

    public void setMedicion(int medicion) {
        this.medicion = medicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /* Metodo toString para imprimir el objeto*/
    @Override
    public String toString() {
        return "Fecha: "+(getFecha().getYear()+1900)+ "/" 
                + getFecha().getDate()+ "/"  + getFecha().getDay()
                + " Hora: " + getFecha().getHours() +  ":" +getFecha().getMinutes()
                + ":" + getFecha().getSeconds()
                + " Med"+getMedicion()
                + " Distancia: " + 
                String.format("%.3f", (getDistancia()/100)) + " cm";
    }
    /* Comparador */
    @Override
    public int compareTo(Datos arg0) {
        if(this.getDistancia() > arg0.getDistancia()) return -1;
        if(this.getDistancia() < arg0.getDistancia()) return 1;
        else return 0;
    }

}
