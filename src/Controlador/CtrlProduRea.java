/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaProduRea;
import java.util.ArrayList;
import modelo.MateriaPrima;
import modelo.MateriaPrimaDAO;
import modelo.ProduccionDAO;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlProduRea {
    private VentanaProduRea vistaProduRea;
    private ProduccionDAO modeloProduccion;


    private ArrayList<Producto> listaprodu;
    private ArrayList<MateriaPrima> listamatpri;

    public CtrlProduRea(VentanaProduRea vistaProduRea, ProduccionDAO modeloProduccion) {
        this.vistaProduRea = vistaProduRea;
        this.modeloProduccion = modeloProduccion;

        //this.vistaProduRea.addListenerVer(new Listen());

        ProductoDAO mPro = new ProductoDAO();
        MateriaPrimaDAO mMatPri = new MateriaPrimaDAO();
        

        this.listaprodu = mPro.listadoProductos(0);
        this.listamatpri = mMatPri.listadoMateriasPrimas(0);
        
        this.vistaProduRea.cargarProduccionesRealizadas(modeloProduccion.listadoProducciones(0), listaprodu, listamatpri);
    }
    
}
