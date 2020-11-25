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
public class VentaDetalle {
    //ATRIBUTOS
    private int codigoVentaDet;
    private int venta;
    private int producto;
    private double precio;
    private int cantidad;
    private double total;
    
    //METODOS

    public VentaDetalle() {
    }

    public VentaDetalle(int codigoVentaDet, int venta, int producto, double precio, int cantidad, double total) {
        this.codigoVentaDet = codigoVentaDet;
        this.venta = venta;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getCodigoVentaDet() {
        return codigoVentaDet;
    }

    public void setCodigoVentaDet(int codigoVentaDet) {
        this.codigoVentaDet = codigoVentaDet;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
