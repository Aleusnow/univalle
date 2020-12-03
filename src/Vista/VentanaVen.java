/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Vendedor;

/**
 *
 * @author Amelia Wolf
 */
public class VentanaVen extends javax.swing.JInternalFrame {

    private DefaultTableModel mTabla;
    
    /**
     * Creates new form VentanaVen
     */
    public VentanaVen() {
        initComponents();
        mTabla = (DefaultTableModel) tblvendedores.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlvendedor = new javax.swing.JPanel();
        lblnombre = new javax.swing.JLabel();
        lblcc = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        lbldireccion = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtcc = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lblcodigo = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblvendedores = new javax.swing.JTable();

        setClosable(true);
        setTitle("Vendedores");

        pnlvendedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Datos Vendedor")));

        lblnombre.setText("Nombre:");

        lblcc.setText("CC:");

        lbltelefono.setText("Telefono:");

        lbldireccion.setText("Dirección:");

        btnagregar.setText("Agregar");

        btnactualizar.setText("Actualizar");
        btnactualizar.setEnabled(false);

        btneliminar.setText("Eliminar");
        btneliminar.setEnabled(false);

        lblcodigo.setText("Codigo:");

        txtcodigo.setEditable(false);
        txtcodigo.setEnabled(false);

        javax.swing.GroupLayout pnlvendedorLayout = new javax.swing.GroupLayout(pnlvendedor);
        pnlvendedor.setLayout(pnlvendedorLayout);
        pnlvendedorLayout.setHorizontalGroup(
            pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlvendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbltelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblcc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbldireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                    .addComponent(lblcodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcc)
                    .addComponent(txttelefono)
                    .addComponent(txtdireccion)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtcodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlvendedorLayout.setVerticalGroup(
            pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlvendedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlvendedorLayout.createSequentialGroup()
                        .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnombre)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcc)
                            .addComponent(txtcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltelefono)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlvendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldireccion)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlvendedorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)))
                .addContainerGap())
        );

        tblvendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "CC", "Telefono", "Direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblvendedores.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tblvendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblvendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblvendedores);
        if (tblvendedores.getColumnModel().getColumnCount() > 0) {
            tblvendedores.getColumnModel().getColumn(0).setMaxWidth(80);
            tblvendedores.getColumnModel().getColumn(2).setMinWidth(90);
            tblvendedores.getColumnModel().getColumn(2).setMaxWidth(100);
            tblvendedores.getColumnModel().getColumn(3).setMinWidth(90);
            tblvendedores.getColumnModel().getColumn(3).setMaxWidth(100);
            tblvendedores.getColumnModel().getColumn(4).setMinWidth(90);
            tblvendedores.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(pnlvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlvendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Haciendo Listeners de los txt y btn
    public int getCodigo() {
        return Integer.parseInt(txtcodigo.getText().trim());
    }

    public String getNombre() {
        return txtnombre.getText().trim();
    }

    public String getCc() {
        return txtcc.getText().trim();
    }

    public String getTelefono() {
        return txttelefono.getText().trim();
    }

    public String getDireccion() {
        return txtdireccion.getText().trim();
    }

    public void addListenerAgregar(ActionListener listen) {
        btnagregar.addActionListener(listen);
    }

    public void addListenerBtnActualizar(ActionListener listen) {
        btnactualizar.addActionListener(listen);
    }

    public void addListenerEliminar(ActionListener listen) {
        btneliminar.addActionListener(listen);
    }

    //Vaciar la tabla 
    public void limpiarTabla() {
        for (int i = mTabla.getRowCount() - 1; i >= 0; i--) {
            mTabla.removeRow(i);

        }
    }
    
    //"Crear" tabla de vendedores
    public void cargarVendedores(ArrayList<Vendedor> listaVen) {
        limpiarTabla();
        for (int i = 0; i < listaVen.size(); i++) {
            mTabla.addRow(new Object[]{
                listaVen.get(i).getCodigoVen(),
                listaVen.get(i).getNombreVen(),
                listaVen.get(i).getcCVen(),
                listaVen.get(i).getTelefonoVen(),
                listaVen.get(i).getDireccionVen(),});
        }
    }

    public boolean revisaDatos() {
        if (txtnombre.getText().replaceAll(" ", "").isEmpty() || txtcc.getText().replaceAll(" ", "").isEmpty()
                || txttelefono.getText().replaceAll(" ", "").isEmpty() || txtdireccion.getText().replaceAll(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Datos incompletos, por favor llene todos lo campos");
            return false;
        }
        return true;
    }
    
    public void cancelarAction() {
        btneliminar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btnagregar.setText("Agregar");
        btnagregar.setActionCommand("agregar");
        tblvendedores.clearSelection();
        limpiarDatos();
    }

    public void limpiarDatos() {
        txtcodigo.setText("");
        txtnombre.setText("");
        txtcc.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");
    }

    public void gestionMensajes(String mensaje, String titulo, int icono) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
    }
    
    private void tblvendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblvendedoresMouseClicked
        int sel = tblvendedores.getSelectedRow();
        if(sel == -1){
            if(tblvendedores.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
        }else {
            txtcodigo.setText(tblvendedores.getValueAt(sel, 0).toString());
            txtnombre.setText(tblvendedores.getValueAt(sel, 1).toString());
            txtcc.setText(tblvendedores.getValueAt(sel, 2).toString());
            txttelefono.setText(tblvendedores.getValueAt(sel, 3).toString());
            txtdireccion.setText(tblvendedores.getValueAt(sel, 4).toString());
            btnactualizar.setEnabled(true);
            btneliminar.setEnabled(true);
            btnagregar.setText("Cancelar");
            btnagregar.setActionCommand("cancelar");
        }
    }//GEN-LAST:event_tblvendedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcc;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JPanel pnlvendedor;
    private javax.swing.JTable tblvendedores;
    private javax.swing.JTextField txtcc;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
