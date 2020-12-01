/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaDistri;
import modelo.DistribuidorDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlDistribuidor {
    
    private VentanaDistri vistaDistri;
    private DistribuidorDAO modeloDistri;

    public CtrlDistribuidor(VentanaDistri vistaDistri, DistribuidorDAO modeloDistri) {
        this.vistaDistri = vistaDistri;
        this.modeloDistri = modeloDistri;
    }
    
    
}
