/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaIngRea;
import Vista.VistaDetIng;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Distribuidor;
import modelo.DistribuidorDAO;
import modelo.IngresoDAO;
import modelo.IngresoDetalleDAO;
import modelo.MateriaPrima;
import modelo.MateriaPrimaDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlIngRea {
     private VentanaIngRea vistaIngRea;
    private IngresoDAO modeloIngreso;
    private IngresoDetalleDAO modeloIngDet;
    private VistaDetIng vistaDet;

    private ArrayList<Distribuidor> listadistri;
    private ArrayList<MateriaPrima> listamatpri;

    public CtrlIngRea(VentanaIngRea vistaIngRea, IngresoDAO modeloIngreso, IngresoDetalleDAO modeloIngDet, VistaDetIng vistaDet) {
        this.vistaIngRea = vistaIngRea;
        this.modeloIngreso = modeloIngreso;
        this.modeloIngDet = modeloIngDet;
        this.vistaDet = vistaDet;

        this.vistaIngRea.addListenerVer(new Listen());

        DistribuidorDAO mDis = new DistribuidorDAO();
        MateriaPrimaDAO mMatPri = new MateriaPrimaDAO();

        

        this.listadistri = mDis.listadoDistribuidores(0);
        this.listamatpri = mMatPri.listadoMateriasPrimas(0);
        
        this.vistaIngRea.cargarIngresosRealizados(modeloIngreso.listadoIngresos(0), listadistri);
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
            vistaDet.cargarTabla(modeloIngDet.listadoIngresoDetalle(vistaIngRea.getcodigoIngreso()),listamatpri);
        }

    }
}
