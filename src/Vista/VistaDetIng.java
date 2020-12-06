/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.IngresoDetalle;
import modelo.MateriaPrima;

/**
 *
 * @author Amelia Wolf
 */
public class VistaDetIng extends javax.swing.JInternalFrame {

    private DefaultTableModel mTabla;

    /**
     * Creates new form VistaDetalleVenta
     */
    public VistaDetIng() {
        initComponents();
        mTabla = (DefaultTableModel) tbldeting.getModel();
    }

    public void cargarTabla(ArrayList<IngresoDetalle> deting, ArrayList<MateriaPrima> matpri) {
        for (int i = 0; i < deting.size(); i++) {

            int codMatPri = deting.get(i).getMatPrima();
            String nomMatPri = "";
            for (int x = 0; x < matpri.size(); x++) {
                if (matpri.get(x).getCodigoMatPri() == codMatPri) {
                    nomMatPri = matpri.get(x).getNombreMatPri();
                }
            }

            mTabla.addRow(new Object[]{
                deting.get(i).getMatPrima(),
                nomMatPri,
                deting.get(i).getCostoUni(),
                deting.get(i).getCantidad(),
                deting.get(i).getTotal(),});
        }
    }
    
    //Vaciar la tabla 
    public void limpiarTabla() {
        for (int i = mTabla.getRowCount() - 1; i >= 0; i--) {
            mTabla.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldeting = new javax.swing.JTable();

        setTitle("Detalle Ingreso");

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tbldeting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo MatPri", "Materia Prima", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbldeting);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnsalir)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        limpiarTabla();
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldeting;
    // End of variables declaration//GEN-END:variables
}