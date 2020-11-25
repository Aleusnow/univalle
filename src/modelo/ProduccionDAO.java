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
public class ProduccionDAO {
    
    public ProduccionDAO() {
    }
    /**
     * 
     * @param pr Objeto de la clase Produccion a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarProduccion(Produccion pr){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO produccion (producto, materiaprima, cantidadmatprima) values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, pr.getProducto());
            pstm.setInt(2, pr.getMateriaPrima());
            pstm.setInt(3, pr.getCantidadMatPrima());
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
     * @param pr Objeto de la clase Produccion a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarProduccion(Produccion pr){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE produccion " +
                         "SET  = ?, materiaprima = ?, cantidadmatprima = ?"
                    +    "WHERE codigoprodu = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, pr.getProducto());
            pstm.setInt(2, pr.getMateriaPrima());
            pstm.setInt(3, pr.getCantidadMatPrima());
            pstm.setInt(5, pr.getCodigoProdu());
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
     * @param codigoprodu código del produccion a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarProduccion(int codigoprodu){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM produccion WHERE codigoprodu = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigoprodu);
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
     * @param codigoprodu codigo del produccion a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Produccion> listadoProducciones(int codigoprodu){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Produccion> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigoprodu == 0){
                sql = "SELECT * FROM produccion ORDER BY codigoprodu";            
            }else{
                sql = "SELECT * FROM cliente where codigoprodu = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigoprodu != 0){
                pstm.setInt(1, codigoprodu);
            }
            
            rs = pstm.executeQuery();
                        
            Produccion produccion = null;
            while(rs.next()){
                produccion = new Produccion();
                produccion.setCodigoProdu(rs.getInt("codigoprodu"));
                produccion.setProducto(rs.getInt("producto"));
                produccion.setMateriaPrima(rs.getInt("materiaprima"));
                produccion.setCantidadMatPrima(rs.getInt("cantidadmatprima"));          
                listado.add(produccion);
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
