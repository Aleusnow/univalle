/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlProducto {
    private VentanaProductos vistaPro;
    private ProductoDAO modeloPro;

    public CtrlProducto(VentanaProductos vistaPro, ProductoDAO modeloPro) {
        this.vistaPro = vistaPro;
        this.modeloPro = modeloPro;
        
        ArrayList<Producto> listaPro;
        listaPro = this.modeloPro.listadoProductos(0);
        this.vistaPro.cargarProductos(listaPro);

        this.vistaPro.addListenerAgregar(new Listen());
        this.vistaPro.addListenerBtnActualizar(new Listen());
        this.vistaPro.addListenerEliminar(new Listen());
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
                vistaPro.cancelarAction();
            }
        }

        public void cargar() {
            if (vistaPro.revisaDatos()) {
                Producto producto = new Producto();
                producto.setNombrePro(vistaPro.getNombre());
                producto.setInventarioPro(vistaPro.getCantidad());
                producto.setPrecioUni(vistaPro.getUnitario());
                producto.setPrecioMeDoce(vistaPro.getMediaDocena());
                producto.setPrecioDoce(vistaPro.getDocena());

                int resultado = modeloPro.grabarProducto(producto);
                if (resultado == 1) {
                    vistaPro.gestionMensajes("Registro Grabado con éxito",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    vistaPro.cargarProductos(modeloPro.listadoProductos(0));
                    vistaPro.cancelarAction();
                } else {
                    vistaPro.gestionMensajes("Error al grabar",
                            "Confirmación", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        public void eliminar() {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar el Cliente con Codigo: "
                    + vistaPro.getCodigo() + "?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                if (modeloPro.borrarProducto(vistaPro.getCodigo()) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxtio",
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);
                    vistaPro.cargarProductos(modeloPro.listadoProductos(0));
                    vistaPro.cancelarAction();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public void modifica() {
            if (vistaPro.revisaDatos()) {
                Producto producto = new Producto();
                producto.setCodigoPro(vistaPro.getCodigo());
                producto.setNombrePro(vistaPro.getNombre());
                producto.setInventarioPro(vistaPro.getCantidad());
                producto.setPrecioUni(vistaPro.getUnitario());
                producto.setPrecioMeDoce(vistaPro.getMediaDocena());
                producto.setPrecioDoce(vistaPro.getDocena());

                if (modeloPro.modificarProducto(producto) == 1) {
                    vistaPro.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                    vistaPro.cancelarAction();
                    vistaPro.cargarProductos(modeloPro.listadoProductos(0));
                } else {
                    vistaPro.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
    
    
}
