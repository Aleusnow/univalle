/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaCli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlCliente {

    private VentanaCli vistaCli;
    private ClienteDAO modeloCli;

    
    public CtrlCliente(VentanaCli vistaCli, ClienteDAO modeloCli) {
        this.vistaCli = vistaCli;
        this.modeloCli = modeloCli;

        //Llamando a todos los clientes de la tabla
        ArrayList<Cliente> listaCli;
        listaCli = this.modeloCli.listadoClientes(0);
        this.vistaCli.cargarClientes(listaCli);

        this.vistaCli.addListenerAgregar(new Listen());
        this.vistaCli.addListenerBtnActualizar(new Listen());
        this.vistaCli.addListenerEliminar(new Listen());
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
                vistaCli.cancelarAction();
            }
        }

        public void cargar() {
            if (vistaCli.revisaDatos()) {
                Cliente cliente = new Cliente();
                cliente.setcCCli(vistaCli.getCc());
                cliente.setNombreCli(vistaCli.getNombre());
                cliente.setTelefonoCli(vistaCli.getTelefono());
                cliente.setDireccionCli(vistaCli.getDireccion());

                int resultado = modeloCli.grabarCliente(cliente);
                if (resultado == 1) {
                    vistaCli.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vistaCli.cargarClientes(modeloCli.listadoClientes(0));
                    vistaCli.cancelarAction();
                } else {
                    vistaCli.gestionMensajes("Error al grabar",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        public void eliminar() {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar el Cliente con Codigo: "
                    + vistaCli.getCodigo() + "?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                if (modeloCli.borrarCliente(vistaCli.getCodigo()) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);
                    vistaCli.cargarClientes(modeloCli.listadoClientes(0));
                    vistaCli.cancelarAction();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public void modifica() {
            if (vistaCli.revisaDatos()) {
                Cliente cliente = new Cliente();
                cliente.setCodigoCli(vistaCli.getCodigo());
                cliente.setcCCli(vistaCli.getCc());
                cliente.setNombreCli(vistaCli.getNombre());
                cliente.setTelefonoCli(vistaCli.getTelefono());
                cliente.setDireccionCli(vistaCli.getDireccion());

                if (modeloCli.modificarCliente(cliente) == 1) {
                    vistaCli.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                    vistaCli.cancelarAction();
                    vistaCli.cargarClientes(modeloCli.listadoClientes(0));
                } else {
                    vistaCli.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}
