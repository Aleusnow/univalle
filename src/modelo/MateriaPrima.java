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
public class MateriaPrima {
    //ATRIBUTOS
    private int codigoMatPri;
    private String  nombreMatPri;
    private int inventarioMatPri;
        
    //METODOS

    public MateriaPrima() {
    }

    public MateriaPrima(int codigoMatPri, String nombreMatPri, int inventarioMatPri) {
        this.codigoMatPri = codigoMatPri;
        this.nombreMatPri = nombreMatPri;
        this.inventarioMatPri = inventarioMatPri;
    }

    public int getCodigoMatPri() {
        return codigoMatPri;
    }

    public void setCodigoMatPri(int codigoMatPri) {
        this.codigoMatPri = codigoMatPri;
    }

    public String getNombreMatPri() {
        return nombreMatPri;
    }

    public void setNombreMatPri(String nombreMatPri) {
        this.nombreMatPri = nombreMatPri;
    }

    public int getInventarioMatPri() {
        return inventarioMatPri;
    }

    public void setInventarioMatPri(int inventarioMatPri) {
        this.inventarioMatPri = inventarioMatPri;
    }
    
    
}
