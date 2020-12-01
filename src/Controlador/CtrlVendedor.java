/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaCli;
import Vista.VentanaVen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Vendedor;
import modelo.VendedorDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlVendedor {
    
    private VentanaVen vistaVen;
    private VendedorDAO modeloVen;

    public CtrlVendedor(VentanaVen vistaVen, VendedorDAO modeloVen) {
        this.vistaVen = vistaVen;
        this.modeloVen = modeloVen;
        
        //Llamando a todos los clientes de la tabla
        ArrayList<Vendedor> listaVen;
        listaVen = this.modeloVen.listadoVendedores(0);
        this.vistaVen.cargarVendedores(listaVen);

        this.vistaVen.addListenerAgregar(new Listen());
        this.vistaVen.addListenerBtnActualizar(new Listen());
        this.vistaVen.addListenerEliminar(new Listen());
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
                vistaVen.cancelarAction();
            }
        }

        public void cargar() {
            if (vistaVen.revisaDatos()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setcCVen(vistaVen.getCc());
                vendedor.setNombreVen(vistaVen.getNombre());
                vendedor.setTelefonoVen(vistaVen.getTelefono());
                vendedor.setDireccionVen(vistaVen.getDireccion());

                int resultado = modeloVen.grabarVendedor(vendedor);
                if (resultado == 1) {
                    vistaVen.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vistaVen.cargarVendedores(modeloVen.listadoVendedores(0));
                    vistaVen.cancelarAction();
                } else {
                    vistaVen.gestionMensajes("Error al grabar",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        public void eliminar() {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar el Cliente con Codigo: "
                    + vistaVen.getCodigo() + "?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                if (modeloVen.borrarVendedor(vistaVen.getCodigo()) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);
                    vistaVen.cargarVendedores(modeloVen.listadoVendedores(0));
                    vistaVen.cancelarAction();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public void modifica() {
            if (vistaVen.revisaDatos()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCodigoVen(vistaVen.getCodigo());
                vendedor.setcCVen(vistaVen.getCc());
                vendedor.setNombreVen(vistaVen.getNombre());
                vendedor.setTelefonoVen(vistaVen.getTelefono());
                vendedor.setDireccionVen(vistaVen.getDireccion());

                if (modeloVen.modificarVendedor(vendedor) == 1) {
                    vistaVen.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                    vistaVen.cancelarAction();
                    vistaVen.cargarVendedores(modeloVen.listadoVendedores(0));
                } else {
                    vistaVen.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}
