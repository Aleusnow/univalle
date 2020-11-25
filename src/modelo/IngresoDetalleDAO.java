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
public class IngresoDetalleDAO {
    
    public IngresoDetalleDAO() {
    }
    /**
     * 
     * @param id Objeto de la clase IngresoDetalle a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarIngresoDetalle(IngresoDetalle id){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO ingresodetalle (ingreso, matprima, costouni, cantidad, total) values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id.getIngreso());
            pstm.setInt(2, id.getMatPrima());
            pstm.setDouble(3, id.getCostoUni());
            pstm.setInt(4, id.getCantidad());
            pstm.setDouble(5, id.getTotal());
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
     * @param id Objeto de la clase IngresoDetalle a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarIngresoDetalle(IngresoDetalle id){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE ingresodetalle " +
                         "SET ingreso = ?, matprima = ?, costouni = ?, cantidad = ?, total = ?"
                    +    "WHERE codigoingdet = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, id.getIngreso());
            pstm.setInt(2, id.getMatPrima());
            pstm.setDouble(3, id.getCostoUni());
            pstm.setInt(4, id.getCantidad());
            pstm.setDouble(5, id.getTotal());
            pstm.setInt(6, id.getCodigoIngDet());
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
     * @param codigoingdet código del ingresodetalle a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarIngresoDetalle(int codigoingdet){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM ingresodetalle WHERE codigoingdet = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigoingdet);
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
     * @param codigoingdet codigo del ingresodetalle a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<IngresoDetalle> listadoIngresoDetalle(int codigoingdet){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<IngresoDetalle> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigoingdet == 0){
                sql = "SELECT * FROM ingresodetalle ORDER BY codigoingdet";            
            }else{
                sql = "SELECT * FROM ingresodetalle where codigoingdet = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigoingdet != 0){
                pstm.setInt(1, codigoingdet);
            }
            
            rs = pstm.executeQuery();
                        
            IngresoDetalle ingresoDetalle = null;
            while(rs.next()){
                ingresoDetalle = new IngresoDetalle();
                ingresoDetalle.setCodigoIngDet(rs.getInt("codigoingdet"));
                ingresoDetalle.setIngreso(rs.getInt("ingreso"));
                ingresoDetalle.setMatPrima(rs.getInt("matprima"));
                ingresoDetalle.setCostoUni(rs.getDouble("costouni"));
                ingresoDetalle.setCantidad(rs.getInt("cantidad"));  
                ingresoDetalle.setTotal(rs.getDouble("total"));
                listado.add(ingresoDetalle);
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
