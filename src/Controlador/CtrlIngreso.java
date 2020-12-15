/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaIngMatPri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ClienteDAO;
import modelo.Distribuidor;
import modelo.DistribuidorDAO;
import modelo.Ingreso;
import modelo.IngresoDAO;
import modelo.IngresoDetalle;
import modelo.IngresoDetalleDAO;
import modelo.MateriaPrima;
import modelo.MateriaPrimaDAO;



/**
 *
 * @author Amelia Wolf
 */
public class CtrlIngreso {
    private VentanaIngMatPri vistaIngreso;
    private IngresoDAO modeloIngreso;
    private IngresoDetalleDAO modeloIngDet;
    private MateriaPrimaDAO modeloMatPri;

    private ArrayList<Distribuidor> listadis;
    private ArrayList<MateriaPrima> listamatpri;

    public CtrlIngreso(VentanaIngMatPri vistaIngreso, IngresoDAO modeloIngreso, IngresoDetalleDAO modeloIngDet, MateriaPrimaDAO modeloMatPri) {
        this.vistaIngreso = vistaIngreso;
        this.modeloIngreso = modeloIngreso;
        this.modeloIngDet = modeloIngDet;
        this.modeloMatPri = modeloMatPri;
        
        this.vistaIngreso.addListenerAgregar(new Listen());
        this.vistaIngreso.addListenerTerminar(new Listen());
        this.vistaIngreso.addListenerEliminar(new Listen());
        this.vistaIngreso.addListenerSelectMatPri(new Listen());

        DistribuidorDAO mDis = new DistribuidorDAO();
        MateriaPrimaDAO mMatPri = new MateriaPrimaDAO();

        this.listadis = mDis.listadoDistribuidores(0);
        this.listamatpri = mMatPri.listadoMateriasPrimas(0);

        this.vistaIngreso.cargarDistribuidor(listadis);
        this.vistaIngreso.cargarMatPri(listamatpri);

        System.out.println(listadis.get(0).getNombreDis());
    }
    
    class Listen implements ActionListener {
        // sobrecarga la funcion que se le entrega

        @Override

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("agregar")) {
                agregar();
            } else if (e.getActionCommand().equalsIgnoreCase("terminar")) {
                finiquitado();
            } else if (e.getActionCommand().equalsIgnoreCase("cmbmatpri")) {
                cargarMatPri();
            }

        }

        public void cargarMatPri() {
            int x = vistaIngreso.getMatPri();
            MateriaPrima matpri = listamatpri.get(x);

            vistaIngreso.cargarDatosMatPri(matpri);
        }

        public void agregar() {
            if (vistaIngreso.revisaDatos()) {
                vistaIngreso.cargarIngDet();
            }
        }

        public void finiquitado() {
            if (vistaIngreso.revisartabla()) {
                int disindice = vistaIngreso.getDistribuidor();
                int dis = listadis.get(disindice).getCodigoDis();
                double total = vistaIngreso.getTotal();

                Ingreso ingresito = new Ingreso();
                ingresito.setDistribuidor(dis);
                ingresito.setTotal(total);

                int respuesta = 0;
                respuesta = modeloIngreso.grabarIngreso(ingresito);

                if (respuesta == 1) {
                    ArrayList<Ingreso> ingresos = modeloIngreso.listadoIngresos(0);
                    Ingreso ing = ingresos.get(ingresos.size() - 1);
                    ArrayList<IngresoDetalle> ingdet = new ArrayList();
                    ingdet = vistaIngreso.ingresodetalle();

                    for (int i = 0; i < ingdet.size(); i++) {
                        IngresoDetalle detallote = new IngresoDetalle();
                        detallote = ingdet.get(i);
                        detallote.setIngreso(ing.getCodigoIng());
                        modeloIngDet.grabarIngresoDetalle(detallote);
                        
                        aumentarMatPri(detallote.getCantidad(),detallote.getMatPrima());//
                    }
                    vistaIngreso.limpiarDatos();
                    vistaIngreso.limpiarTabla();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese minimo 1 materia prima thx ;)");
            }
        }
        
        public void aumentarMatPri(int cantidad, int matpri){
            
            MateriaPrima matprim = modeloMatPri.listadoMateriasPrimas(matpri).get(0);
            int aumentar = matprim.getInventarioMatPri() + cantidad;
            matprim.setInventarioMatPri(aumentar);
            
            modeloMatPri.modificarMateriaPrima(matprim);
        }
    }
    
}


