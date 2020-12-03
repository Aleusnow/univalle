/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaMatPri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MateriaPrima;
import modelo.MateriaPrimaDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlMatPrima {
    
    private VentanaMatPri vistaMatPri;
    private MateriaPrimaDAO modeloMatPri;

    public CtrlMatPrima(VentanaMatPri vistaMatPri, MateriaPrimaDAO modeloMatPri) {
        this.vistaMatPri = vistaMatPri;
        this.modeloMatPri = modeloMatPri;
        
        ArrayList<MateriaPrima> listaMatPri;
        listaMatPri = this.modeloMatPri.listadoMateriasPrimas(0);
        this.vistaMatPri.cargarMateriasPrimas(listaMatPri);

        this.vistaMatPri.addListenerAgregar(new Listen());
        this.vistaMatPri.addListenerBtnActualizar(new Listen());
        this.vistaMatPri.addListenerEliminar(new Listen());
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
                vistaMatPri.cancelarAction();
            }
        }

        public void cargar() {
            if (vistaMatPri.revisaDatos()) {
                MateriaPrima matpri = new MateriaPrima();
                matpri.setNombreMatPri(vistaMatPri.getNombre());
                matpri.setInventarioMatPri(vistaMatPri.getCantidad());


                int resultado = modeloMatPri.grabarMateriaPrima(matpri);
                if (resultado == 1) {
                    vistaMatPri.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vistaMatPri.cargarMateriasPrimas(modeloMatPri.listadoMateriasPrimas(0));
                    vistaMatPri.cancelarAction();
                } else {
                    vistaMatPri.gestionMensajes("Error al grabar",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        public void eliminar() {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar el Cliente con Codigo: "
                    + vistaMatPri.getCodigo() + "?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                if (modeloMatPri.borrarMateriaPrima(vistaMatPri.getCodigo()) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);
                    vistaMatPri.cargarMateriasPrimas(modeloMatPri.listadoMateriasPrimas(0));
                    vistaMatPri.cancelarAction();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public void modifica() {
            if (vistaMatPri.revisaDatos()) {
                MateriaPrima matpri = new MateriaPrima();
                matpri.setCodigoMatPri(vistaMatPri.getCodigo());
                matpri.setNombreMatPri(vistaMatPri.getNombre());
                matpri.setInventarioMatPri(vistaMatPri.getCantidad());


                if (modeloMatPri.modificarMateriaPrima(matpri) == 1) {
                    vistaMatPri.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                    vistaMatPri.cancelarAction();
                    vistaMatPri.cargarMateriasPrimas(modeloMatPri.listadoMateriasPrimas(0));
                } else {
                    vistaMatPri.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
    
    
}
