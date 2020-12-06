/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import modelo.*;

/**
 *
 * @author Amelia Wolf
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        admin = new javax.swing.JMenu();
        distribuidores = new javax.swing.JMenuItem();
        clientes = new javax.swing.JMenuItem();
        vendedores = new javax.swing.JMenuItem();
        comisiones = new javax.swing.JMenuItem();
        inventario = new javax.swing.JMenu();
        productos = new javax.swing.JMenuItem();
        materiaprima = new javax.swing.JMenuItem();
        procesos = new javax.swing.JMenu();
        produccion = new javax.swing.JMenuItem();
        ingresomatpri = new javax.swing.JMenuItem();
        venta = new javax.swing.JMenuItem();
        interno = new javax.swing.JMenu();
        listadoven = new javax.swing.JMenuItem();
        listadoingrea = new javax.swing.JMenuItem();
        listadoprodu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1600, 1000));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );

        admin.setText("Administración");

        distribuidores.setText("Distribuidores");
        distribuidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distribuidoresActionPerformed(evt);
            }
        });
        admin.add(distribuidores);

        clientes.setText("Clientes");
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        admin.add(clientes);

        vendedores.setText("Vendedores");
        vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedoresActionPerformed(evt);
            }
        });
        admin.add(vendedores);

        comisiones.setText("Comisiones");
        comisiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comisionesActionPerformed(evt);
            }
        });
        admin.add(comisiones);

        jMenuBar1.add(admin);

        inventario.setText("Inventario");

        productos.setText("Productos");
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });
        inventario.add(productos);

        materiaprima.setText("Materia Prima");
        materiaprima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiaprimaActionPerformed(evt);
            }
        });
        inventario.add(materiaprima);

        jMenuBar1.add(inventario);

        procesos.setText("Procesos");

        produccion.setText("Producción");
        produccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produccionActionPerformed(evt);
            }
        });
        procesos.add(produccion);

        ingresomatpri.setText("Ingreso Materia Prima");
        ingresomatpri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresomatpriActionPerformed(evt);
            }
        });
        procesos.add(ingresomatpri);

        venta.setText("Venta");
        venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaActionPerformed(evt);
            }
        });
        procesos.add(venta);

        jMenuBar1.add(procesos);

        interno.setText("Interno");

        listadoven.setText("Listado Ventas realizadas");
        listadoven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadovenActionPerformed(evt);
            }
        });
        interno.add(listadoven);

        listadoingrea.setText("Listado Ingreso Materias Primas");
        listadoingrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoingreaActionPerformed(evt);
            }
        });
        interno.add(listadoingrea);

        listadoprodu.setText("Listado Producidos");
        listadoprodu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoproduActionPerformed(evt);
            }
        });
        interno.add(listadoprodu);

        jMenuBar1.add(interno);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void distribuidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distribuidoresActionPerformed
        VentanaDistri distri = new VentanaDistri();
        DistribuidorDAO distriDao = new DistribuidorDAO();
        
        System.out.println("Le diste click a distribuidor");
        
        int x = (escritorio.getWidth() / 2) - distri.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - distri.getHeight() /2;

        if (distri.isShowing()){
            distri.setLocation(x,y);
        }
        else{
            escritorio.add(distri);
            distri.setLocation(x,y);
            distri.setVisible(true);
        }
        
        CtrlDistribuidor controlDis = new CtrlDistribuidor(distri,distriDao);
    }//GEN-LAST:event_distribuidoresActionPerformed

    private void vendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedoresActionPerformed
         VentanaVen ven = new VentanaVen();
         VendedorDAO venDao = new VendedorDAO();
        
        System.out.println("Le diste click a vendedor");
        
        int x = (escritorio.getWidth() / 2) - ven.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - ven.getHeight() /2;

        if (ven.isShowing()){
            ven.setLocation(x,y);
        }
        else{
            escritorio.add(ven);
            ven.setLocation(x,y);
            ven.setVisible(true);
        }
        
        CtrlVendedor controlVen = new CtrlVendedor(ven, venDao);
    }//GEN-LAST:event_vendedoresActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        VentanaCli cli = new VentanaCli();
        ClienteDAO cliDao = new ClienteDAO();
        
        System.out.println("Le diste click a cliente");
        
        int x = (escritorio.getWidth() / 2) - cli.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - cli.getHeight() /2;

        if (cli.isShowing()){
            cli.setLocation(x,y);
        }
        else{
            escritorio.add(cli);
            cli.setLocation(x,y);
            cli.setVisible(true);
        }
        
        CtrlCliente controlCli = new CtrlCliente(cli,cliDao);
        
    }//GEN-LAST:event_clientesActionPerformed

    private void comisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comisionesActionPerformed
        VentanaComi comi = new VentanaComi();
        
        System.out.println("Le diste click a comisión");
        
        int x = (escritorio.getWidth() / 2) - comi.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - comi.getHeight() /2;

        if (comi.isShowing()){
            comi.setLocation(x,y);
        }
        else{
            escritorio.add(comi);
            comi.setLocation(x,y);
            comi.setVisible(true);
        }
    }//GEN-LAST:event_comisionesActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
        VentanaProductos pro = new VentanaProductos();
        ProductoDAO proDao = new ProductoDAO();
        
        System.out.println("Le diste click a producto");
        
        int x = (escritorio.getWidth() / 2) - pro.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - pro.getHeight() /2;

        if (pro.isShowing()){
            pro.setLocation(x,y);
        }
        else{
            escritorio.add(pro);
            pro.setLocation(x,y);
            pro.setVisible(true);
        }
        
        CtrlProducto controlPro = new CtrlProducto(pro,proDao);
    }//GEN-LAST:event_productosActionPerformed

    private void materiaprimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaprimaActionPerformed
        VentanaMatPri matpri = new VentanaMatPri();
        MateriaPrimaDAO matpriDao = new MateriaPrimaDAO();
        
        System.out.println("Le diste click a materia prima");
        
        int x = (escritorio.getWidth() / 2) - matpri.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - matpri.getHeight() /2;

        if (matpri.isShowing()){
            matpri.setLocation(x,y);
        }
        else{
            escritorio.add(matpri);
            matpri.setLocation(x,y);
            matpri.setVisible(true);
        }
        CtrlMatPrima controlMatPri = new CtrlMatPrima(matpri,matpriDao);
    }//GEN-LAST:event_materiaprimaActionPerformed

    private void produccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produccionActionPerformed
        VentanaProduccion produ = new VentanaProduccion();
        ProduccionDAO produDao = new ProduccionDAO();
        ProducidosDAO prDao = new ProducidosDAO();
        
        System.out.println("Le diste click a produccion");
        
        int x = (escritorio.getWidth() / 2) - produ.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - produ.getHeight() /2;

        if (produ.isShowing()){
            produ.setLocation(x,y);
        }
        else{
            escritorio.add(produ);
            produ.setLocation(x,y);
            produ.setVisible(true);
        }
        CtrlProduccion controlProdu = new CtrlProduccion(produ,produDao,prDao);
    }//GEN-LAST:event_produccionActionPerformed

    private void ingresomatpriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresomatpriActionPerformed
        VentanaIngMatPri ing = new VentanaIngMatPri();
        IngresoDAO ingDao = new IngresoDAO();
        IngresoDetalleDAO ingDetDao = new IngresoDetalleDAO();
        
        System.out.println("Le diste click a ingreso materia prima");
        
        int x = (escritorio.getWidth() / 2) - ing.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - ing.getHeight() /2;

        if (ing.isShowing()){
            ing.setLocation(x,y);
        }
        else{
            escritorio.add(ing);
            ing.setLocation(x,y);
            ing.setVisible(true);
        }
        
        CtrlIngreso controlIng = new CtrlIngreso(ing, ingDao,  ingDetDao);

    }//GEN-LAST:event_ingresomatpriActionPerformed

    private void ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaActionPerformed
        VentanaVenta vent = new VentanaVenta();
        VentaDAO ventaDao = new VentaDAO();
        VentaDetalleDAO ventDetDao = new VentaDetalleDAO();
        
        System.out.println("Le diste click a venta");
        
        int x = (escritorio.getWidth() / 2) - vent.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - vent.getHeight() /2;

        if (vent.isShowing()){
            vent.setLocation(x,y);
        }
        else{
            escritorio.add(vent);
            vent.setLocation(x,y);
            vent.setVisible(true);
        }
        
        CtrlVenta controlVen = new CtrlVenta(vent,ventaDao,ventDetDao);
    }//GEN-LAST:event_ventaActionPerformed

    private void listadovenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadovenActionPerformed
        VentanaVentRea ventrea = new VentanaVentRea();
        VentaDAO ventaDao = new VentaDAO();
        VentaDetalleDAO ventDetDao = new VentaDetalleDAO();
        VistaDetalleVenta vistadet = new VistaDetalleVenta();
        
        System.out.println("Le diste click a venta");
        
        int x = (escritorio.getWidth() / 2) - ventrea.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - ventrea.getHeight() /2;

        if (ventrea.isShowing()){
            ventrea.setLocation(x,y);
        }
        else{
            escritorio.add(ventrea);
            escritorio.add(vistadet);
            ventrea.setLocation(x,y);
            vistadet.setLocation(x,y);
            ventrea.setVisible(true);
        }
        
        CtrlVentRea controlVentRea = new CtrlVentRea(ventrea,ventaDao,ventDetDao,vistadet);
    }//GEN-LAST:event_listadovenActionPerformed

    private void listadoingreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoingreaActionPerformed
        VentanaIngRea ingrea = new VentanaIngRea();
        IngresoDAO ingresoDao = new IngresoDAO();
        IngresoDetalleDAO ingDetDao = new IngresoDetalleDAO();
        VistaDetIng vistadet = new VistaDetIng();
        
        System.out.println("Le diste click a venta");
        
        int x = (escritorio.getWidth() / 2) - ingrea.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - ingrea.getHeight() /2;

        if (ingrea.isShowing()){
            ingrea.setLocation(x,y);
        }
        else{
            escritorio.add(ingrea);
            escritorio.add(vistadet);
            ingrea.setLocation(x,y);
            vistadet.setLocation(x,y);
            ingrea.setVisible(true);
        }
        
        CtrlIngRea controlIngRea = new CtrlIngRea(ingrea,ingresoDao,ingDetDao,vistadet);
    }//GEN-LAST:event_listadoingreaActionPerformed

    private void listadoproduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoproduActionPerformed
        VentanaProduRea produ = new VentanaProduRea();
        ProducidosDAO produDao = new ProducidosDAO();
        
        System.out.println("Le diste click a materia prima");
        
        int x = (escritorio.getWidth() / 2) - produ.getWidth() /2;
        int y = (escritorio.getHeight() / 2) - produ.getHeight() /2;

        if (produ.isShowing()){
            produ.setLocation(x,y);
        }
        else{
            escritorio.add(produ);
            produ.setLocation(x,y);
            produ.setVisible(true);
        }
        CtrlProduRea controlProduRea = new CtrlProduRea(produ,produDao);
    }//GEN-LAST:event_listadoproduActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu admin;
    private javax.swing.JMenuItem clientes;
    private javax.swing.JMenuItem comisiones;
    private javax.swing.JMenuItem distribuidores;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem ingresomatpri;
    private javax.swing.JMenu interno;
    private javax.swing.JMenu inventario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem listadoingrea;
    private javax.swing.JMenuItem listadoprodu;
    private javax.swing.JMenuItem listadoven;
    private javax.swing.JMenuItem materiaprima;
    private javax.swing.JMenu procesos;
    private javax.swing.JMenuItem produccion;
    private javax.swing.JMenuItem productos;
    private javax.swing.JMenuItem vendedores;
    private javax.swing.JMenuItem venta;
    // End of variables declaration//GEN-END:variables
}
