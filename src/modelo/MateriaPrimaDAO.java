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
public class MateriaPrimaDAO {
    
    public MateriaPrimaDAO() {
    }
    /**
     * 
     * @param mp Objeto de la clase MateriaPrima a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarMateriaPrima(MateriaPrima mp){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO materiaprima (nombrematpri, inventariomatpri) values (?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, mp.getNombreMatPri());
            pstm.setInt(2, mp.getInventarioMatPri());
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
     * @param mp Objeto de la clase MateriaPrima a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarMateriaPrima(MateriaPrima mp){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE materiaprima " +
                         "SET nombrematpri = ?, inventariomatpri = ?"
                    +    "WHERE codigomatpri = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, mp.getNombreMatPri());
            pstm.setInt(2, mp.getInventarioMatPri());
            pstm.setInt(3, mp.getCodigoMatPri());
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
     * @param codigomatpri código del materiaprima a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarMateriaPrima(int codigomatpri){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM materiaprima WHERE codigomatpri = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigomatpri);
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
     * @param codigomatpri codigo del materiaprima a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<MateriaPrima> listadoMateriasPrimas(int codigomatpri){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<MateriaPrima> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigomatpri == 0){
                sql = "SELECT * FROM materiaprima ORDER BY codigomatpri";            
            }else{
                sql = "SELECT * FROM materiaprima where codigomatpri = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigomatpri != 0){
                pstm.setInt(1, codigomatpri);
            }
            
            rs = pstm.executeQuery();
                        
            MateriaPrima materiaprima = null;
            while(rs.next()){
                materiaprima = new MateriaPrima();
                materiaprima.setCodigoMatPri(rs.getInt("codigomatpri"));
                materiaprima.setNombreMatPri(rs.getString("nombrematpri"));
                materiaprima.setInventarioMatPri(rs.getInt("inventariomatpri"));        
                listado.add(materiaprima);
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
