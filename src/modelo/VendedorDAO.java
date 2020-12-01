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
public class VendedorDAO {
    
    public VendedorDAO() {
    }
    /**
     * 
     * @param v Objeto de la clase Vendedor a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarVendedor(Vendedor v){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO vendedor (nombreven, ccven,telefonoven, direccionven) values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, v.getNombreVen());
            pstm.setString(2, v.getcCVen());
            pstm.setString(3, v.getTelefonoVen());
            pstm.setString(4, v.getDireccionVen());
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
     * @param v Objeto de la clase Vendedor a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarVendedor(Vendedor v){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE vendedor " +
                         "SET nombreven = ?, ccven = ?, telefonoven = ?, direccionven = ?"
                    +    "WHERE codigoven = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, v.getNombreVen());
            pstm.setString(2, v.getcCVen());
            pstm.setString(3, v.getTelefonoVen());
            pstm.setString(4, v.getDireccionVen());
            pstm.setInt(5, v.getCodigoVen());
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
     * @param codigoven código del vendedor a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarVendedor(int codigoven){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM vendedor WHERE codigoven = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigoven);
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
     * @param codigoven codigo del vendedor a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Vendedor> listadoVendedores(int codigoven){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Vendedor> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigoven == 0){
                sql = "SELECT * FROM vendedor ORDER BY codigoven";            
            }else{
                sql = "SELECT * FROM vendedor where codigoven = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigoven != 0){
                pstm.setInt(1, codigoven);
            }
            
            rs = pstm.executeQuery();
                        
            Vendedor vendedor = null;
            while(rs.next()){
                vendedor = new Vendedor();
                vendedor.setCodigoVen(rs.getInt("codigoven"));
                vendedor.setNombreVen(rs.getString("nombreven"));
                vendedor.setcCVen(rs.getString("ccven"));
                vendedor.setTelefonoVen(rs.getString("telefonoven"));
                vendedor.setDireccionVen(rs.getString("direccionven"));
                listado.add(vendedor);
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
