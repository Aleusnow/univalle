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
public class ProductoDAO {
    
    public ProductoDAO() {
    }
    /**
     * 
     * @param p Objeto de la clase Producto a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarProducto(Producto p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO producto (nombrepro, preciouni, preciomedoce, preciodoce, inventariopro) values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getNombrePro());
            pstm.setDouble(2, p.getPrecioUni());
            pstm.setDouble(3, p.getPrecioMeDoce());
            pstm.setDouble(4, p.getPrecioDoce());
            pstm.setInt(5, p.getInventarioPro());
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
     * @param p Objeto de la clase Producto  a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarProducto (Producto  p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto  " +
                         "SET nombrepro= ?, preciouni = ?, preciomedoce = ?, preciodoce = ?, inventariopro = ?"
                    +    "WHERE codigopro = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getNombrePro());
            pstm.setDouble(2, p.getPrecioUni());
            pstm.setDouble(3, p.getPrecioMeDoce());
            pstm.setDouble(4, p.getPrecioDoce());
            pstm.setInt(5, p.getInventarioPro());           
            pstm.setInt(6, p.getCodigoPro());
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
     * @param codigopro código del producto a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarProducto(int codigopro){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM producto WHERE codigopro = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigopro);
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
     * @param codigopro codigo del producto a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Producto> listadoProductos(int codigopro){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Producto> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigopro == 0){
                sql = "SELECT * FROM producto ORDER BY codigopro";            
            }else{
                sql = "SELECT * FROM producto where codigopro = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigopro != 0){
                pstm.setInt(1, codigopro);
            }
            
            rs = pstm.executeQuery();
                        
            Producto producto = null;
            while(rs.next()){
                producto = new Producto();
                producto.setCodigoPro(rs.getInt("codigopro"));
                producto.setNombrePro(rs.getString("nombrepro"));
                producto.setInventarioPro(rs.getInt("inventariopro"));
                producto.setPrecioUni(rs.getDouble("preciouni"));
                producto.setPrecioMeDoce(rs.getDouble("preciomedoce"));
                producto.setPrecioDoce(rs.getDouble("preciodoce"));          
                listado.add(producto);
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
