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
public class Venta {
        //ATRIBUTOS
        private int codigoVenta;
        private int cliente;
        private double total;
        private int vendedor;
        private String tipoVenta;
    
        //METODOS

    public Venta() {
    }

    public Venta(int codigoVenta, int cliente, double total, int vendedor, String tipoVenta) {
        this.codigoVenta = codigoVenta;
        this.cliente = cliente;
        this.total = total;
        this.vendedor = vendedor;
        this.tipoVenta = tipoVenta;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
        
    
    
}
