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
public class VentaDAO {
 
    public VentaDAO() {
    }
    /**
     * 
     * @param vt Objeto de la clase Venta a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarVenta(Venta vt){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO venta (cliente, total, vendedor, tipoventa) values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, vt.getCliente());
            pstm.setDouble(2, vt.getTotal());
            pstm.setInt(3, vt.getVendedor());
            pstm.setString(4, vt.getTipoVenta());
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
     * @param vt Objeto de la clase Venta a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarVenta(Venta vt){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE venta " +
                         "SET cliente = ?, total = ?, vendedor = ?, tipoventa = ?"
                    +    "WHERE codigoventa = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, vt.getCliente());
            pstm.setDouble(2, vt.getTotal());
            pstm.setInt(3, vt.getVendedor());
            pstm.setString(4, vt.getTipoVenta());
            pstm.setInt(5, vt.getCodigoVenta());
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
     * @param codigoventa código del venta a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarVenta(int codigoventa){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM venta WHERE codigoventa = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigoventa);
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
     * @param codigoventa codigo del venta a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Venta> listadoVentas(int codigoventa){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Venta> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigoventa == 0){
                sql = "SELECT * FROM venta ORDER BY codigoventa";            
            }else{
                sql = "SELECT * FROM venta where codigoventa = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigoventa != 0){
                pstm.setInt(1, codigoventa);
            }
            
            rs = pstm.executeQuery();
                        
            Venta venta = null;
            while(rs.next()){
                venta = new Venta();
                venta.setCodigoVenta(rs.getInt("codigoventa"));
                venta.setCliente(rs.getInt("cliente"));
                venta.setTotal(rs.getDouble("total"));
                venta.setVendedor(rs.getInt("vendedor"));
                venta.setTipoVenta(rs.getString("tipoventa"));          
                listado.add(venta);
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
