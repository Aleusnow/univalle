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
public class ClienteDAO {

    public ClienteDAO() {
    }
    /**
     * 
     * @param c Objeto de la clase Cliente a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarCliente(Cliente c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO cliente (nombrecli, cccli, direccioncli, telefonocli) values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, c.getNombreCli());
            pstm.setString(2, c.getcCCli());
            pstm.setString(3, c.getDireccionCli());
            pstm.setString(4, c.getTelefonoCli());
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
     * @param c Objeto de la clase Cliente a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarCliente(Cliente c){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE cliente " +
                         "SET nombrecli = ?, cccli = ?, direccioncli = ?, telefonocli = ?"
                    +    "WHERE codigocli = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, c.getNombreCli());
            pstm.setString(2, c.getcCCli());
            pstm.setString(3, c.getDireccionCli());
            pstm.setString(4, c.getTelefonoCli());
            pstm.setInt(5, c.getCodigoCli());
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
     * @param codigocli código del cliente a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarCliente(int codigocli){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
                String sql = "DELETE FROM cliente WHERE codigocli = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigocli);
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
     * @param codigocli codigo del cliente a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Cliente> listadoClientes(int codigocli){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Cliente> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigocli == 0){
                sql = "SELECT * FROM cliente ORDER BY codigocli";            
            }else{
                sql = "SELECT * FROM cliente where codigocli = ? ";
                    //+ "ORDER BY codigocli";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigocli != 0){
                pstm.setInt(1, codigocli);
            }
            
            rs = pstm.executeQuery();
                        
            Cliente cliente = null;
            while(rs.next()){
                cliente = new Cliente();
                cliente.setCodigoCli(rs.getInt("codigocli"));
                cliente.setNombreCli(rs.getString("nombrecli"));
                cliente.setcCCli(rs.getString("cccli"));
                cliente.setDireccionCli(rs.getString("direccioncli"));
                cliente.setTelefonoCli(rs.getString("telefonocli"));          
                listado.add(cliente);
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
