/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaVentRea;
import Vista.VistaDetalleVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Vendedor;
import modelo.VendedorDAO;
import modelo.VentaDAO;
import modelo.VentaDetalleDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlVentRea {

    private VentanaVentRea vistaVentRea;
    private VentaDAO modeloVenta;
    private VentaDetalleDAO modeloVentDet;
    private VistaDetalleVenta vistaDet;

    private ArrayList<Producto> listaprodu;
    private ArrayList<Cliente> listacli;
    private ArrayList<Vendedor> listaven;

    public CtrlVentRea(VentanaVentRea vistaVentRea, VentaDAO modeloVenta, VentaDetalleDAO modeloVentDet, VistaDetalleVenta vistaDet) {
        this.vistaVentRea = vistaVentRea;
        this.modeloVenta = modeloVenta;
        this.modeloVentDet = modeloVentDet;
        this.vistaDet = vistaDet;

        this.vistaVentRea.addListenerVer(new Listen());

        ClienteDAO mCli = new ClienteDAO();
        ProductoDAO mProducto = new ProductoDAO();
        VendedorDAO mVen = new VendedorDAO();
        

        this.listacli = mCli.listadoClientes(0);
        this.listaprodu = mProducto.listadoProductos(0);
        this.listaven = mVen.listadoVendedores(0);
        
        this.vistaVentRea.cargarVentasRealizadas(modeloVenta.listadoVentas(0), listaven, listacli);
    }

    class Listen implements ActionListener {
        // sobrecarga la funcion que se le entrega

        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("ver detalle")) {
                ver();
            }
        }
        
        
        public void ver(){
            vistaDet.toFront();
            vistaDet.setVisible(true);
            vistaDet.cargarTabla(modeloVentDet.listadoVentaDetalles(vistaVentRea.getcodigoVenta()), listaprodu);
        }

    }
}
