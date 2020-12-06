/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaProduccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MateriaPrima;
import modelo.MateriaPrimaDAO;
import modelo.Produccion;
import modelo.ProduccionDAO;
import modelo.Producidos;
import modelo.ProducidosDAO;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlProduccion {

    private VentanaProduccion vistaProduccion;
    private ProduccionDAO modeloProdu;
    private ProducidosDAO modeloPr;

    private ArrayList<Producto> listapro;
    private ArrayList<MateriaPrima> listamatpri;

    public CtrlProduccion(VentanaProduccion vistaProduccion, ProduccionDAO modeloProdu, ProducidosDAO modeloPr) {
        this.vistaProduccion = vistaProduccion;
        this.modeloProdu = modeloProdu;
        this.modeloPr = modeloPr;

        this.vistaProduccion.addListenerAgregar(new Listen());
        this.vistaProduccion.addListenerEliminar(new Listen());
        this.vistaProduccion.addListenerActualizar(new Listen());
        this.vistaProduccion.addListenerProducir(new Listen());
        this.vistaProduccion.addListenerSelectProdu1(new Listen());
        this.vistaProduccion.addListenerSelectProdu2(new Listen());

        ProductoDAO mPro = new ProductoDAO();
        MateriaPrimaDAO mMatPri = new MateriaPrimaDAO();

        this.listapro = mPro.listadoProductos(0);
        this.listamatpri = mMatPri.listadoMateriasPrimas(0);

        this.vistaProduccion.cargarProducto(listapro);
        this.vistaProduccion.cargarMatPri(listamatpri);
    }

    class Listen implements ActionListener {
        // sobrecarga la funcion que se le entrega

        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("agregar")) {
                agregar();
            } else if (e.getActionCommand().equalsIgnoreCase("actualizar")) {
                modifica();
            } else if (e.getActionCommand().equalsIgnoreCase("eliminar")) {
                eliminar();
            } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
                vistaProduccion.cancelarAction();
            } else if (e.getActionCommand().equalsIgnoreCase("cmbproducto1")) {
                cargarProduccion();
            } else if (e.getActionCommand().equalsIgnoreCase("cmbproducto2")) {
                cargarReceta();
            } else if (e.getActionCommand().equalsIgnoreCase("Producir")) {
                producir();
            }

        }

        public void cargarProduccion() {
            int x = vistaProduccion.getProducto1();
            int pro = listapro.get(x).getCodigoPro();

            ArrayList<Produccion> produ = modeloProdu.listadoProducciones(pro);
            vistaProduccion.cargarProduccion(produ, listamatpri);
        }

        public void cargarReceta() {
            int y = vistaProduccion.getProducto2();
            int rece = listapro.get(y).getCodigoPro();

            ArrayList<Produccion> produ = modeloProdu.listadoProducciones(rece);
            vistaProduccion.cargarReceta(produ, listamatpri);
        }

        public void agregar() {
            if (vistaProduccion.revisaReceta()) {
                int x = vistaProduccion.getProducto2();
                int pro = listapro.get(x).getCodigoPro();

                int y = vistaProduccion.getMatPri();
                int matpri = listamatpri.get(y).getCodigoMatPri();

                int cuantos = vistaProduccion.getCuantos();

                Produccion produccion = new Produccion();
                produccion.setProducto(pro);
                produccion.setMateriaPrima(matpri);
                produccion.setCantidadMatPrima(cuantos);

                modeloProdu.grabarProduccion(produccion);
                ArrayList<Produccion> produ = modeloProdu.listadoProducciones(pro);
                vistaProduccion.cargarReceta(produ, listamatpri);
            }
        }

        public void eliminar() {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea Eliminar la Materia Prima con Codigo: "
                    + vistaProduccion.getTablaReceta() + "?",
                    "Confirmación de Acción", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                if (modeloProdu.borrarProduccion(vistaProduccion.getTablaReceta()) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Borrado con éxito",
                            "Confirmación de acción", JOptionPane.INFORMATION_MESSAGE);
                    int codproducto = listapro.get(vistaProduccion.getProducto2()).getCodigoPro();
                    vistaProduccion.cargarReceta(modeloProdu.listadoProducciones(codproducto), listamatpri);
                    vistaProduccion.cancelarAction();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error al borrar",
                            "Confirmación de acción", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public void modifica() {
            if (vistaProduccion.revisaReceta()) {
                Produccion produ = new Produccion();

                produ.setCodigoProdu(vistaProduccion.getTablaReceta());
                int codproducto = listapro.get(vistaProduccion.getProducto2()).getCodigoPro();
                produ.setProducto(codproducto);
                produ.setMateriaPrima(vistaProduccion.getCodMatPriReceta());
                produ.setCantidadMatPrima(vistaProduccion.getCuantos());

                if (modeloProdu.modificarProduccion(produ) == 1) {
                    vistaProduccion.gestionMensajes("Actualización exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                    vistaProduccion.cancelarAction();
                    vistaProduccion.cargarReceta(modeloProdu.listadoProducciones(codproducto), listamatpri);
                } else {
                    vistaProduccion.gestionMensajes("Actualización Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public void producir() {
            if (vistaProduccion.revisaProduccion()) {
                int x = vistaProduccion.getProducto1();
                int pro = listapro.get(x).getCodigoPro();
                vistaProduccion.calcular();

                int cantidad = vistaProduccion.getCantidad();

                Producidos producidos = new Producidos();
                producidos.setProducto(pro);
                producidos.setCantidadProducida(cantidad);

                if (modeloPr.grabarProducidos(producidos) == 1) {
                    vistaProduccion.gestionMensajes("Produccion exitosa",
                            "Confirmación ", JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    vistaProduccion.gestionMensajes("Produccion Falida",
                            "Confirmación ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
