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
public class Vendedor {
    //ATRIBUTOS
    private int codigoVen;
    private String nombreVen;
    private String cCVen;
    private String telefonoVen;
    private String direccionVen;
    
    //METODOS

    public Vendedor() {
    }

    public Vendedor(int codigoVen, String nombreVen, String cCVen, String telefonoVen, String direccionVen) {
        this.codigoVen = codigoVen;
        this.nombreVen = nombreVen;
        this.cCVen = cCVen;
        this.telefonoVen = telefonoVen;
        this.direccionVen = direccionVen;
    }

    
    public int getCodigoVen() {
        return codigoVen;
    }

    public void setCodigoVen(int codigoVen) {
        this.codigoVen = codigoVen;
    }

    public String getNombreVen() {
        return nombreVen;
    }

    public void setNombreVen(String nombreVen) {
        this.nombreVen = nombreVen;
    }

    public String getcCVen() {
        return cCVen;
    }

    public void setcCVen(String cCVen) {
        this.cCVen = cCVen;
    }

    public String getTelefonoVen() {
        return telefonoVen;
    }

    public void setTelefonoVen(String telefonoVen) {
        this.telefonoVen = telefonoVen;
    }

    public String getDireccionVen() {
        return direccionVen;
    }

    public void setDireccionVen(String direccionVen) {
        this.direccionVen = direccionVen;
    }
    
    
    
    
}
