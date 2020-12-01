/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.*;


/**
 *
 * @author Amelia Wolf
 */
public class CtrlVenta {
    
    private VentanaVenta vistaVenta;
    private VentaDAO modeloVenta;
    private VentaDetalleDAO modeloVentDet;
    
    private ArrayList<Producto> listaprodu;
    private ArrayList<Cliente> listacli;
    private ArrayList<Vendedor> listaven;

    public CtrlVenta(VentanaVenta vistaVenta, VentaDAO modeloVenta, VentaDetalleDAO modeloVentDet) {
        this.vistaVenta = vistaVenta;
        this.modeloVenta = modeloVenta;
        this.modeloVentDet = modeloVentDet;
        
        this.vistaVenta.addListenerAgregar(new Listen());
        this.vistaVenta. addListenerActualizar(new Listen());
        this.vistaVenta.addListenerEliminar(new Listen());
    }
    
     class Listen implements ActionListener {
        // sobrecarga la funcion que se le entrega

        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("agregar")) {
                //cargar();
            } else if (e.getActionCommand().equalsIgnoreCase("actualizar")) {
                //modifica();
            } else if (e.getActionCommand().equalsIgnoreCase("eliminar")) {
                //eliminar();
            } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
                //vistaCli.cancelarAction();
            }
        }
        
        
        
     }
    
}
