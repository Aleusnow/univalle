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
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlVenta {

    private VentanaVenta vistaVenta;
    private VentaDAO modeloVenta;
    private VentaDetalleDAO modeloVentDet;
    private ProductoDAO modeloPro;

    private ArrayList<Producto> listaprodu;
    private ArrayList<Cliente> listacli;
    private ArrayList<Vendedor> listaven;

    public CtrlVenta(VentanaVenta vistaVenta, VentaDAO modeloVenta, VentaDetalleDAO modeloVentDet, ProductoDAO modeloPro) {
        this.vistaVenta = vistaVenta;
        this.modeloVenta = modeloVenta;
        this.modeloVentDet = modeloVentDet;
        this.modeloPro = modeloPro;

        this.vistaVenta.addListenerAgregar(new Listen());
        this.vistaVenta.addListenerTerminar(new Listen());
        this.vistaVenta.addListenerEliminar(new Listen());
        this.vistaVenta.addListenerSelectPro(new Listen());

        ClienteDAO mCli = new ClienteDAO();
        ProductoDAO mProducto = new ProductoDAO();
        VendedorDAO mVen = new VendedorDAO();

        this.listacli = mCli.listadoClientes(0);
        this.listaprodu = mProducto.listadoProductos(0);
        this.listaven = mVen.listadoVendedores(0);

        this.vistaVenta.cargarCliente(listacli);
        this.vistaVenta.cargarProducto(listaprodu);
        this.vistaVenta.cargarVendedor(listaven);

        System.out.println(listacli.get(0).getNombreCli());

    }

    class Listen implements ActionListener {
        // sobrecarga la funcion que se le entrega

        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("agregar")) {
                agregar();
            } else if (e.getActionCommand().equalsIgnoreCase("terminar")) {
                finiquitado();
            } else if (e.getActionCommand().equalsIgnoreCase("cmbprod")) {
                cargarProdu();
            }

        }

        public void cargarProdu() {
            int x = vistaVenta.getProducto();
            Producto pro = listaprodu.get(x);

            vistaVenta.cargarDatosPro(pro);
        }

        public void agregar() {
            if (vistaVenta.revisaDatos() && validarDisponibilidad()) {
                vistaVenta.cargarVentDet();
            }
            
        }

        public void finiquitado() {
            if (vistaVenta.revisartabla()) {
                int cliindice = vistaVenta.getCliente();
                int cli = listacli.get(cliindice).getCodigoCli();
                int venindice = vistaVenta.getVendedor();
                int ven = listaven.get(venindice).getCodigoVen();
                String tipoventa = vistaVenta.getTipoVenta();
                double total = vistaVenta.getTotal();
                

                Venta ventita = new Venta();
                ventita.setCliente(cli);
                ventita.setVendedor(ven);
                ventita.setTipoVenta(tipoventa);
                ventita.setTotal(total);

                int respuesta = 0;
                respuesta = modeloVenta.grabarVenta(ventita);

                if (respuesta == 1) {
                    ArrayList<Venta> ventas = modeloVenta.listadoVentas(0);
                    Venta vent = ventas.get(ventas.size() - 1);
                    ArrayList<VentaDetalle> ventdet = new ArrayList();
                    ventdet = vistaVenta.ventadetalle();
                    
                    for (int i = 0; i < ventdet.size(); i++) {
                        VentaDetalle detallote = new VentaDetalle();
                        detallote = ventdet.get(i);
                        detallote.setVenta(vent.getCodigoVenta());
                        modeloVentDet.grabarVentaDetalle(detallote);
                        
                        descontarProdu(detallote.getCantidad(),detallote.getProducto());//
                    }
                    vistaVenta.limpiarDatos();
                    vistaVenta.limpiarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese minimo 1 producto thx ;)");
            }
        }

        public boolean validarDisponibilidad() {
            int x = vistaVenta.getProducto();
            int pro = listaprodu.get(x).getCodigoPro();

            int cantidad = vistaVenta.getCantidad() * vistaVenta.getCantidadCombo();
            String warning = "No hay suficiente ";
            
            ArrayList<VentaDetalle> detalles = vistaVenta.ventadetalle();
            for(int i = 0; i < detalles.size(); i++){
                if(detalles.get(i).getProducto()== pro){
                    cantidad = cantidad + detalles.get(i).getCantidad();
                }
            }

            boolean respuesta = true;
            Producto produ = modeloPro.listadoProductos(pro).get(0);
            int suficiente = produ.getInventarioPro() - cantidad;
            if (suficiente < 0) {
                respuesta = false;

                warning = warning + produ.getNombrePro() + " en el inventario";
            }
            if (!respuesta) {
                vistaVenta.gestionMensajes(warning,
                        "Sin Producto suficiente", JOptionPane.WARNING_MESSAGE);
            }
            return respuesta;
        }
        
        public void descontarProdu(int cantidad, int producto){
            
            Producto produ = modeloPro.listadoProductos(producto).get(0);
            int descontar = produ.getInventarioPro() - cantidad;
            produ.setInventarioPro(descontar);
            
            modeloPro.modificarProducto(produ);
        }

    }

}
