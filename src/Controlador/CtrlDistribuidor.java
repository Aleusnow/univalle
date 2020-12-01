/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaDistri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Distribuidor;
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
        
         //Llamando a todos los clientes de la tabla
        ArrayList<Distribuidor> listaDis;
        listaDis = this.modeloDistri.listadoDistribuidores(0);
        this.vistaDistri.cargarDistribuidores(listaDis);

        this.vistaDistri.addListenerAgregar(new CtrlDistribuidor.Listen());
        this.vistaDistri.addListenerBtnActualizar(new CtrlDistribuidor.Listen());
        this.vistaDistri.addListenerEliminar(new CtrlDistribuidor.Listen());
    }
    
    
    class Listen implements ActionListener {
        // sobrecarga la funcion que se le entrega

        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("agregar")) {
                cargar();
            } else if (e.getActionCommand().equalsIgnoreCase("actualizar")) {
                modifica();
            } else if (e.getActionCommand().equalsIgnoreCase("eliminar")) {
                eliminar();
            } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
                vistaDistri.cancelarAction();
            }
        }

        public void cargar() {
            if (vistaDistri.revisaDatos()) {
                Distribuidor distri = new Distribuidor();
                distri.setcCDis(vistaDistri.getCc());
                distri.setNombreDis(vistaDistri.getNombre());
                distri.setTelefonoDis(vistaDistri.getTelefono());
                distri.setDireccionDis(vistaDistri.getDireccion());

                int resultado = modeloDistri.grabarDistribuidor(distri);
                if (resultado == 1) {
                    vistaDistri.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vistaDistri.cargarDistribuidores(modeloDistri.listadoDistribuidores(0));
                    vistaDistri.cancelarAction();
                } else {
                    vistaDistri.gestionMensajes("Error al grabar",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        public void eliminar() {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar el Cliente con Codigo: "
                    + vistaDistri.getCodigo() + "?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                if (modeloDistri.borrarDistribuidor(vistaDistri.getCodigo()) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);
                    vistaDistri.cargarDistribuidores(modeloDistri.listadoDistribuidores(0));
                    vistaDistri.cancelarAction();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public void modifica() {
            if (vistaDistri.revisaDatos()) {
                Distribuidor distri = new Distribuidor();
                distri.setCodigoDis(vistaDistri.getCodigo());
                distri.setcCDis(vistaDistri.getCc());
                distri.setNombreDis(vistaDistri.getNombre());
                distri.setTelefonoDis(vistaDistri.getTelefono());
                distri.setDireccionDis(vistaDistri.getDireccion());

                if (modeloDistri.modificarDistribuidor(distri) == 1) {
                    vistaDistri.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                    vistaDistri.cancelarAction();
                    vistaDistri.cargarDistribuidores(modeloDistri.listadoDistribuidores(0));
                } else {
                    vistaDistri.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
    
}
