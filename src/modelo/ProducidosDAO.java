/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Amelia Wolf
 */
public class ProducidosDAO {
    
    public ProducidosDAO(){
    }
    
    /**
     * 
     * @param pr Objeto de la clase Produccion a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarProducidos(Producidos pr){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO producidos (producto, cantidadproducida) values (?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, pr.getProducto());
            pstm.setInt(2, pr.getCantidadProducida());
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
     * @param pr Objeto de la clase Producidos a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarProducidos(Producidos pr){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producidos " +
                         "SET  producto = ?, cantidadproducida = ?"
                    +    "WHERE idproducidos = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, pr.getProducto());
            pstm.setInt(2, pr.getCantidadProducida());
            pstm.setInt(3, pr.getIdProducidos());
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
     * @param idproducidos código del producidos a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarProducidos(int idproducidos){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM producidos WHERE idproducidos = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idproducidos);
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
     * @param idproducidos codigo del producidos a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Producidos> listadoProducidos(int idproducidos){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Producidos> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(idproducidos == 0){
                sql = "SELECT * FROM producidos ORDER BY idproducidos";            
            }else{
                sql = "SELECT * FROM producidos where producto = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(idproducidos != 0){
                pstm.setInt(1, idproducidos);
            }
            
            rs = pstm.executeQuery();
                        
            Producidos producidos = null;
            while(rs.next()){
                producidos = new Producidos();
                producidos.setIdProducidos(rs.getInt("idproducidos"));
                producidos.setProducto(rs.getInt("producto"));
                producidos.setCantidadProducida(rs.getInt("cantidadproducida"));         
                listado.add(producidos);
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
