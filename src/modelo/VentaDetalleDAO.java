/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Servicios.Fachada;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Amelia Wolf
 */
public class VentaDetalleDAO {

    public VentaDetalleDAO() {
    }
    /**
     * 
     * @param vtd Objeto de la clase VentaDetalle a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarVentaDetalle(VentaDetalle vtd){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO ventadetalle (venta, producto, precio, cantidad, total) values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, vtd.getVenta());
            pstm.setInt(2, vtd.getProducto());
            pstm.setDouble(3, vtd.getPrecio());
            pstm.setInt(4, vtd.getCantidad());
            pstm.setDouble(5, vtd.getTotal());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     /**
     * 
     * @param vtd Objeto de la clase VentaDetalle a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarVentaDetalle(VentaDetalle vtd){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE ventadetalle " +
                         "SET venta = ?, producto = ?, precio = ?, cantidad = ?, total = ?"
                    +    "WHERE codigocli = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, vtd.getVenta());
            pstm.setInt(2, vtd.getProducto());
            pstm.setDouble(3, vtd.getPrecio());
            pstm.setInt(4, vtd.getCantidad());
            pstm.setDouble(5, vtd.getTotal());
            pstm.setInt(6, vtd.getCodigoVentaDet());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
            
    /**
     * 
     * @param codigoventadet código del VentaDetalle a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarVentaDetalle(int codigoventadet){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM ventadetalle WHERE codigoventadet = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigoventadet);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    /**
     * 
     * @param codigoventadet codigo del VentaDetalle a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<VentaDetalle> listadoVentaDetalles(int codigoventadet){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VentaDetalle> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigoventadet == 0){
                sql = "SELECT * FROM ventadetalle ORDER BY codigoventadet";            
            }else{
                sql = "SELECT * FROM ventadetalle where venta = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigoventadet != 0){
                pstm.setInt(1, codigoventadet);
            }
            
            rs = pstm.executeQuery();
                        
            VentaDetalle ventaDetalle = null;
            while(rs.next()){
                ventaDetalle = new VentaDetalle();
                ventaDetalle.setCodigoVentaDet(rs.getInt("codigoventadet"));
                ventaDetalle.setVenta(rs.getInt("venta"));
                ventaDetalle.setProducto(rs.getInt("producto"));
                ventaDetalle.setPrecio(rs.getDouble("precio"));
                ventaDetalle.setCantidad(rs.getInt("cantidad"));  
                ventaDetalle.setTotal(rs.getDouble("total"));
                listado.add(ventaDetalle);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }

}
