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
public class IngresoDAO {

    public IngresoDAO() {
    }
    /**
     * 
     * @param i Objeto de la clase Ingreso a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarIngreso(Ingreso i){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO ingreso (distribuidor, total) values (?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, i.getDistribuidor());
            pstm.setDouble(2, i.getTotal());
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
     * @param i Objeto de la clase Ingreso a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarIngreso(Ingreso i){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE ingreso " +
                         "SET distribuidor = ?, total = ?"
                    +    "WHERE codigoing = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, i.getDistribuidor());
            pstm.setDouble(2, i.getTotal());
            pstm.setInt(3, i.getCodigoIng());
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
     * @param codigoing código del cliente a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarIngreso(int codigoing){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM ingreso WHERE codigoing = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigoing);
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
     * @param codigoing codigo del ingreso a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Ingreso> listadoIngresos(int codigoing){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Ingreso> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigoing == 0){
                sql = "SELECT * FROM ingreso ORDER BY codigoing";            
            }else{
                sql = "SELECT * FROM ingreso where codigoing = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigoing != 0){
                pstm.setInt(1, codigoing);
            }
            
            rs = pstm.executeQuery();
                        
            Ingreso ingreso = null;
            while(rs.next()){
                ingreso= new Ingreso();
                ingreso.setCodigoIng(rs.getInt("codigoing"));
                ingreso.setDistribuidor(rs.getInt("distribuidor"));
                ingreso.setTotal(rs.getDouble("total"));          
                listado.add(ingreso);
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
