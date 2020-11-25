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
public class Distribuidor {
    //ATRIBUTOS
    private int codigoDis;
    private String nombreDis;
    private String direccionDis;
    private String telefonoDis;
    private String cCDis;
    
    //METODOS

    public Distribuidor() {
    }

    public Distribuidor(int codigoDis, String nombreDis, String direccionDis, String telefonoDis, String cCDis) {
        this.codigoDis = codigoDis;
        this.nombreDis = nombreDis;
        this.direccionDis = direccionDis;
        this.telefonoDis = telefonoDis;
        this.cCDis = cCDis;
    }

    public int getCodigoDis() {
        return codigoDis;
    }

    public void setCodigoDis(int codigoDis) {
        this.codigoDis = codigoDis;
    }

    public String getNombreDis() {
        return nombreDis;
    }

    public void setNombreDis(String nombreDis) {
        this.nombreDis = nombreDis;
    }

    public String getDireccionDis() {
        return direccionDis;
    }

    public void setDireccionDis(String direccionDis) {
        this.direccionDis = direccionDis;
    }

    public String getTelefonoDis() {
        return telefonoDis;
    }

    public void setTelefonoDis(String telefonoDis) {
        this.telefonoDis = telefonoDis;
    }

    public String getcCDis() {
        return cCDis;
    }

    public void setcCDis(String cCDis) {
        this.cCDis = cCDis;
    }
    
    
    
}
