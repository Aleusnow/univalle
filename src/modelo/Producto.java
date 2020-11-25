/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Amelia Wolf
 */
public class Producto {
    //ATRIBUTOS
    private int codigoPro;
    private String nombrePro;
    private double precioUni;
    private double precioMeDoce;
    private double precioDoce;
    private int inventarioPro;
    
    //METODOS

    public Producto() {
    }

    public Producto(int codigoPro, String nombrePro, double precioUni, double precioMeDoce, double precioDoce, int inventarioPro) {
        this.codigoPro = codigoPro;
        this.nombrePro = nombrePro;
        this.precioUni = precioUni;
        this.precioMeDoce = precioMeDoce;
        this.precioDoce = precioDoce;
        this.inventarioPro = inventarioPro;
    }

    public int getCodigoPro() {
        return codigoPro;
    }

    public void setCodigoPro(int codigoPro) {
        this.codigoPro = codigoPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(double precioUni) {
        this.precioUni = precioUni;
    }

    public double getPrecioMeDoce() {
        return precioMeDoce;
    }

    public void setPrecioMeDoce(double precioMeDoce) {
        this.precioMeDoce = precioMeDoce;
    }

    public double getPrecioDoce() {
        return precioDoce;
    }

    public void setPrecioDoce(double precioDoce) {
        this.precioDoce = precioDoce;
    }

    public int getInventarioPro() {
        return inventarioPro;
    }

    public void setInventarioPro(int inventarioPro) {
        this.inventarioPro = inventarioPro;
    }
    
    
}
