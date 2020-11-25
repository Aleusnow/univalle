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
public class DistribuidorDAO {

    public DistribuidorDAO() {
    }
    /**
     * 
     * @param d Objeto de la clase Distribuidor a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarDistribuidor(Distribuidor d){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO distribuidor (nombredis, ccdis, direcciondis, telefonodis) values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, d.getNombreDis());
            pstm.setString(2, d.getcCDis());
            pstm.setString(3, d.getDireccionDis());
            pstm.setString(4, d.getTelefonoDis());
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
     * @param d Objeto de la clase Distribuidor a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarDistribuidor(Distribuidor d){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE distribuidor " +
                         "SET nombredis = ?, ccdis = ?, direcciondis = ?, telefonodis = ?"
                    +    "WHERE codigodis = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, d.getNombreDis());
            pstm.setString(2, d.getcCDis());
            pstm.setString(3, d.getDireccionDis());
            pstm.setString(4, d.getTelefonoDis());
            pstm.setInt(5, d.getCodigoDis());
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
     * @param codigodis código del distribuidor a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarDistribuidor(int codigodis){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM distribuidor WHERE codigodis = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigodis);
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
     * @param codigodis codigo del distribuidor a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Distribuidor> listadoDistribuidores(int codigodis){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Distribuidor> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigodis == 0){
                sql = "SELECT * FROM distribuidor ORDER BY codigodis";            
            }else{
                sql = "SELECT * FROM distribuidor where codigodis = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigodis != 0){
                pstm.setInt(1, codigodis);
            }
            
            rs = pstm.executeQuery();
                        
            Distribuidor distribuidor = null;
            while(rs.next()){
                distribuidor = new Distribuidor();              
                distribuidor.setCodigoDis(rs.getInt("codigodis"));
                distribuidor.setNombreDis(rs.getString("nombredis"));
                distribuidor.setcCDis(rs.getString("ccdis"));
                distribuidor.setDireccionDis(rs.getString("direcciondis"));
                distribuidor.setTelefonoDis(rs.getString("telefonodis"));          
                listado.add(distribuidor);
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
