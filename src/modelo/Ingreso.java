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
public class Ingreso {
    //ATRIBUTOS
    private int codigoIng;
    private int distribuidor;
    private double total;
    
    //METODOS

    public Ingreso() {
    }

    public Ingreso(int codigoIng, int distribuidor, double total) {
        this.codigoIng = codigoIng;
        this.distribuidor = distribuidor;
        this.total = total;
    }

    public int getCodigoIng() {
        return codigoIng;
    }

    public void setCodigoIng(int codigoIng) {
        this.codigoIng = codigoIng;
    }

    public int getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(int distribuidor) {
        this.distribuidor = distribuidor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
