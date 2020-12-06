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
import modelo.ProducidosDAO;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 *
 * @author Amelia Wolf
 */
public class CtrlProduRea {
    private VentanaProduRea vistaProduRea;
    private ProducidosDAO modeloProducidos;


    private ArrayList<Producto> listaprodu;

    public CtrlProduRea(VentanaProduRea vistaProduRea, ProducidosDAO modeloProducidos) {
        this.vistaProduRea = vistaProduRea;
        this.modeloProducidos = modeloProducidos;

        //this.vistaProduRea.addListenerVer(new Listen());

        ProductoDAO mPro = new ProductoDAO();        

        this.listaprodu = mPro.listadoProductos(0);
        
        this.vistaProduRea.cargarProduccionesRealizadas(modeloProducidos.listadoProducidos(0), listaprodu);
    }
    
}
