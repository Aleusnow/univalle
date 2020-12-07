/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaComi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Vendedor;
import modelo.VendedorDAO;
import modelo.Venta;
import modelo.VentaDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlComision {

    private VentanaComi vistaComi;
    private VentaDAO modeloVenta;
    private VendedorDAO modeloVendedor;

    private ArrayList<Vendedor> listaven;

    public CtrlComision(VentanaComi vistaComi, VentaDAO modeloVenta, VendedorDAO modeloVendedor) {
        this.vistaComi = vistaComi;
        this.modeloVenta = modeloVenta;
        this.modeloVendedor = modeloVendedor;

        this.vistaComi.addListenerBuscar(new Listen());
        this.vistaComi.addListenercmbVendedor(new Listen());

        this.listaven = this.modeloVendedor.listadoVendedores(0);

        this.vistaComi.cargarVendedor(listaven);
    }

    class Listen implements ActionListener {
        // sobrecarga la funcion que se le entrega
        

        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("buscar")) {
                cargarVentas();
            }
        }

        public void cargarVentas() {
            if(vistaComi.revisaDatos()){
                int x = vistaComi.getVendedor();
                Vendedor ven = listaven.get(x);

                vistaComi.cargarDatosVendedor(ven);
                ArrayList<Venta> ventita = modeloVenta.listadoVentasxVendedor(ven.getCodigoVen());
                vistaComi.cargarComisiones(ventita);
            }
        }
    }
}
