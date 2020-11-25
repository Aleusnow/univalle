/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Amelia Wolf
 */
public class Empresa {
    //ATRIBUTOS
    private String nombre;
            
    //public ArrayList<Clase> nombrePalVector;
    public ArrayList<Producto> inventario;
    public ArrayList<Vendedor> vendedores;
    public ArrayList<Distribuidor> distribuidores;
    public ArrayList<Cliente> clientes;
     
    //METODOS

    public Empresa() {
    }

    public Empresa(String nombre, ArrayList<Producto> inventario, ArrayList<Vendedor> vendedores, ArrayList<Distribuidor> distribuidores, ArrayList<Cliente> clientes) {
        this.nombre = nombre;
        this.inventario = inventario;
        this.vendedores = vendedores;
        this.distribuidores = distribuidores;
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
