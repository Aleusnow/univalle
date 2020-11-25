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
public class Produccion {
    //ATRIBUTOS
    private int codigoProdu;
    private int producto;
    private  int materiaPrima;
    private int cantidadMatPrima;
        
    //METODOS

    public Produccion() {
    }

    public Produccion(int codigoProdu, int producto, int materiaPrima, int cantidadMatPrima) {
        this.codigoProdu = codigoProdu;
        this.producto = producto;
        this.materiaPrima = materiaPrima;
        this.cantidadMatPrima = cantidadMatPrima;
    }

    public int getCodigoProdu() {
        return codigoProdu;
    }

    public void setCodigoProdu(int codigoProdu) {
        this.codigoProdu = codigoProdu;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(int materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public int getCantidadMatPrima() {
        return cantidadMatPrima;
    }

    public void setCantidadMatPrima(int cantidadMatPrima) {
        this.cantidadMatPrima = cantidadMatPrima;
    }
    
    
            
            
}
