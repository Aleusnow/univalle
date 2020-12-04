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
public class Producidos {
    //ATRIBUTOS
    private int idProducidos;
    private int producto;
    private int cantidadProducida;
    
    //METODOS

    public Producidos() {
    }

    public Producidos(int idProducidos, int producto, int cantidadProducida) {
        this.idProducidos = idProducidos;
        this.producto = producto;
        this.cantidadProducida = cantidadProducida;
    }

    public int getIdProducidos() {
        return idProducidos;
    }

    public void setIdProducidos(int idProducidos) {
        this.idProducidos = idProducidos;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(int cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }
    
    
}
