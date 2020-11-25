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
public class IngresoDetalle {
    //ATRIBUTOS
    private int codigoIngDet;
    private int ingreso;
    private int matPrima;
    private double costoUni;
    private int cantidad;
    private double total;
    
    //METODOS

    public IngresoDetalle() {
    }

    public IngresoDetalle(int codigoIngDet, int ingreso, int matPrima, double costoUni, int cantidad, double total) {
        this.codigoIngDet = codigoIngDet;
        this.ingreso = ingreso;
        this.matPrima = matPrima;
        this.costoUni = costoUni;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getCodigoIngDet() {
        return codigoIngDet;
    }

    public void setCodigoIngDet(int codigoIngDet) {
        this.codigoIngDet = codigoIngDet;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getMatPrima() {
        return matPrima;
    }

    public void setMatPrima(int matPrima) {
        this.matPrima = matPrima;
    }

    public double getCostoUni() {
        return costoUni;
    }

    public void setCostoUni(double costoUni) {
        this.costoUni = costoUni;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
