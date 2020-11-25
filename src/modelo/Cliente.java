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
public class Cliente {
    //ATRIBUTOS
    private int codigoCli;
    private String nombreCli;
    private String direccionCli;
    private String telefonoCli;
    private String cCCli;
    
    //METODOS

    public Cliente() {
    }

    public Cliente(int codigoCli, String nombreCli, String direccionCli, String telefonoCli, String cCCli) {
        this.codigoCli = codigoCli;
        this.nombreCli = nombreCli;
        this.direccionCli = direccionCli;
        this.telefonoCli = telefonoCli;
        this.cCCli = cCCli;
    }

    public int getCodigoCli() {
        return codigoCli;
    }

    public void setCodigoCli(int codigoCli) {
        this.codigoCli = codigoCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    public String getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(String telefonoCli) {
        this.telefonoCli = telefonoCli;
    }

    public String getcCCli() {
        return cCCli;
    }

    public void setcCCli(String cCCli) {
        this.cCCli = cCCli;
    }
    
    
}
