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
import modelo.MateriaPrima;
import modelo.MateriaPrimaDAO;
import modelo.Produccion;
import modelo.ProduccionDAO;
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
                //modifica();
            } else if (e.getActionCommand().equalsIgnoreCase("eliminar")) {
                //eliminar();
            } else if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
                vistaProduccion.cancelarAction();
            } else if (e.getActionCommand().equalsIgnoreCase("cmbproducto1")) {
                cargarProduccion();
            }else if (e.getActionCommand().equalsIgnoreCase("cmbproducto2")) {
                cargarReceta();
            }

        }
        
        
        public void cargarProduccion(){
            int x = vistaProduccion.getProducto1();
            int pro = listapro.get(x).getCodigoPro();
            
            ArrayList<Produccion> produ = modeloProdu.listadoProducciones(pro);
            vistaProduccion.cargarProduccion(produ,listamatpri);
        }
        
        public void cargarReceta(){
            int y = vistaProduccion.getProducto2();
            int rece = listapro.get(y).getCodigoPro();
            
            ArrayList<Produccion> produ = modeloProdu.listadoProducciones(rece);
            vistaProduccion.cargarReceta(produ,listamatpri);
        }
        
        public void agregar(){
            if(vistaProduccion.revisaReceta()){
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
                vistaProduccion.cargarReceta(produ,listamatpri);
            }
        }



        /*public void finiquitado() {
            if (vistaProduccion.revisartabla()) {
                int disindice = vistaProduccion.getDistribuidor();
                int dis = listadis.get(disindice).getCodigoDis();
                double total = vistaIngreso.getTotal();

                Produccion producito = new Produccion();
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
                    }
                    vistaIngreso.limpiarDatos();
                    vistaIngreso.limpiarTabla();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese minimo 1 materia prima thx ;)");
            }
        }*/
    }
    
    
    
    
}
