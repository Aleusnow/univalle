/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Producto;
import modelo.Vendedor;
import modelo.VentaDetalle;

/**
 *
 * @author Amelia Wolf
 */
public class VentanaVenta extends javax.swing.JInternalFrame {

    private DefaultTableModel mTabla;
    private DefaultComboBoxModel mCli;
    private DefaultComboBoxModel mVen;
    private DefaultComboBoxModel mProducto;

    /**
     * Creates new form VentanaVenta
     */
    public VentanaVenta() {
        initComponents();
        mTabla = (DefaultTableModel) tbldetventa.getModel();
        mCli = (DefaultComboBoxModel) cmbcli.getModel();
        mVen = (DefaultComboBoxModel) cmbven.getModel();
        mProducto = (DefaultComboBoxModel) cmbproducto.getModel();
        cmbproducto.setActionCommand("cmbprod");
        System.out.println(cmbproducto.getActionCommand());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    //Haciendo Listeners de los txt y btn
    public int getCliente() {
        return cmbcli.getSelectedIndex();
    }

    public int getVendedor() {
        return cmbven.getSelectedIndex();
    }

    public double getTotal() {
        return Double.parseDouble(txttotal.getText().trim());
    }

    public String getTipoVenta() {
        return String.valueOf(cmbtipoven.getSelectedItem());
    }

    public int getProducto() {
        return cmbproducto.getSelectedIndex();
    }

    public String getNombre() {
        return txttotal.getText().trim();
    }

    public int getPrecio() {
        return cmbprecio.getSelectedIndex();
    }

    public int getCodigo() {
        return Integer.getInteger(txtcodigo.getText().trim());
    }

    public int getCantidad() {
        return Integer.getInteger(txtcantidad.getText().trim());
    }

    public void addListenerAgregar(ActionListener listen) {
        btnagregar.addActionListener(listen);
    }
    
    public void addListenerSelectPro(ActionListener listen) {
        cmbproducto.addActionListener(listen);
    }

    /*public void addListenerActualizar(ActionListener listen) {
        btnactualizar.addActionListener(listen);
    }*/

    public void addListenerEliminar(ActionListener listen) {
        btneliminar.addActionListener(listen);
    }
    
    

    //Vaciar la tabla 
    public void limpiarTabla() {
        for (int i = mTabla.getRowCount() - 1; i >= 0; i--) {
            mTabla.removeRow(i);

        }
    }

    //"Crear" tabla de Venta detalle
    public void cargarVentDet() {
        
        int cantidad = Integer.parseInt(txtcantidad.getText());
        double precio = (Double) cmbprecio.getSelectedItem();
        double total = cantidad * precio;
        String nombre = txtnombre.getText();
        int codigo = Integer.parseInt(txtcodigo.getText());
        double totaldefenitivo = Double.parseDouble(txttotal.getText())+ total;
        
        txttotal.setText(String.valueOf(totaldefenitivo));
        
        mTabla.addRow(new Object[]{
            codigo,
            nombre,
            precio,
            cantidad,
            total});
    }

    //Cargar los datos de les ComboBox
    public void cargarCliente(ArrayList<Cliente> listaCli) {
        mCli.removeAllElements();
        for (int i = 0; i < listaCli.size(); i++) {
            mCli.addElement(listaCli.get(i).getNombreCli());
        }
    }

    public void cargarProducto(ArrayList<Producto> listaProductos) {
        mProducto.removeAllElements();
        for (int i = 0; i < listaProductos.size(); i++) {
            mProducto.addElement(listaProductos.get(i).getNombrePro());
        }
    }

    public void cargarVendedor(ArrayList<Vendedor> listaVen) {
        mVen.removeAllElements();
        for (int i = 0; i < listaVen.size(); i++) {
            mVen.addElement(listaVen.get(i).getNombreVen());
        }
    }
    
    public void cargarDatosPro(Producto pro){
        txtnombre.setText(pro.getNombrePro());
        txtcodigo.setText(String.valueOf(pro.getCodigoPro()));
        DefaultComboBoxModel cmb = new DefaultComboBoxModel();
        cmb.addElement(pro.getPrecioUni());
        cmb.addElement(pro.getPrecioMeDoce());
        cmb.addElement(pro.getPrecioDoce());
        cmbprecio.setModel(cmb);
        
    }
    
    public boolean revisaDatos() {
        if (txtcantidad.getText().replaceAll(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Datos incompletos, por favor ingrese una cantidad");
            return false;
        }
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlventa = new javax.swing.JPanel();
        lblcliente = new javax.swing.JLabel();
        lblvende = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        lbltipoventa = new javax.swing.JLabel();
        cmbcli = new javax.swing.JComboBox<>();
        cmbven = new javax.swing.JComboBox<>();
        cmbtipoven = new javax.swing.JComboBox<>();
        txttotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldetventa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblproducto = new javax.swing.JLabel();
        cmbproducto = new javax.swing.JComboBox<>();
        lblcantidad = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcantidad = new javax.swing.JTextPane();
        btnagregar = new javax.swing.JButton();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lblcodigo = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        lblprecio = new javax.swing.JLabel();
        cmbprecio = new javax.swing.JComboBox<>();
        btneliminar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Venta");

        pnlventa.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos venta"));

        lblcliente.setText("Cliente:");

        lblvende.setText("Vendedor:");

        lbltotal.setText("Total:");

        lbltipoventa.setText("Tipo de venta:");

        cmbtipoven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En negocio", "Por llamada" }));

        txttotal.setEditable(false);
        txttotal.setText("0");

        javax.swing.GroupLayout pnlventaLayout = new javax.swing.GroupLayout(pnlventa);
        pnlventa.setLayout(pnlventaLayout);
        pnlventaLayout.setHorizontalGroup(
            pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlventaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltotal)
                    .addComponent(lblcliente))
                .addGap(18, 18, 18)
                .addGroup(pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbcli, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblvende)
                    .addComponent(lbltipoventa))
                .addGap(27, 27, 27)
                .addGroup(pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbtipoven, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbven, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlventaLayout.setVerticalGroup(
            pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlventaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcliente)
                    .addComponent(cmbcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvende)
                    .addComponent(cmbven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotal)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbtipoven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltipoventa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbldetventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo ", "Producto", "Precio", "Cantidad", "Total"
            }
        ));
        tbldetventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldetventaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldetventa);
        if (tbldetventa.getColumnModel().getColumnCount() > 0) {
            tbldetventa.getColumnModel().getColumn(0).setMaxWidth(60);
            tbldetventa.getColumnModel().getColumn(2).setMaxWidth(60);
            tbldetventa.getColumnModel().getColumn(3).setMaxWidth(60);
            tbldetventa.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        lblproducto.setText("Producto:");

        lblcantidad.setText("Cantidad:");

        jScrollPane2.setViewportView(txtcantidad);

        btnagregar.setText("Agregar");

        lblnombre.setText("Nombre:");

        txtnombre.setEditable(false);

        lblcodigo.setText("Codigo:");

        txtcodigo.setEditable(false);

        lblprecio.setText("Precio:");

        btneliminar.setText("Eliminar");
        btneliminar.setEnabled(false);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblcantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblproducto)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblprecio)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(cmbprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(lblnombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(lblcodigo)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnagregar)
                        .addGap(31, 31, 31)
                        .addComponent(btneliminar)
                        .addGap(153, 153, 153))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblproducto)
                    .addComponent(cmbproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombre)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio)
                    .addComponent(cmbprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar)
                    .addComponent(btneliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(pnlventa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbldetventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldetventaMouseClicked
        int sel = tbldetventa.getSelectedRow();
        if(sel == -1){
            if(tbldetventa.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
        }else {
            txtcodigo.setText(tbldetventa.getValueAt(sel, 0).toString());
            txtnombre.setText(tbldetventa.getValueAt(sel, 1).toString());
            cmbprecio.setSelectedItem(tbldetventa.getValueAt(sel, 2).toString());
            txtcantidad.setText(tbldetventa.getValueAt(sel, 3).toString());
            //btnactualizar.setEnabled(true);
            btneliminar.setEnabled(true);
            btnagregar.setText("Cancelar");
            btnagregar.setActionCommand("cancelar");
        }
    }//GEN-LAST:event_tbldetventaMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int sel = tbldetventa.getSelectedRow();
        double can = Double.valueOf(tbldetventa.getValueAt(sel, 4).toString());
        double totaldefenitivo = Double.parseDouble(txttotal.getText())- can;
       
        txttotal.setText(String.valueOf(totaldefenitivo));
        mTabla.removeRow(sel);
        cancelarAction();
        
    }//GEN-LAST:event_btneliminarActionPerformed
public void cancelarAction() {
        btneliminar.setEnabled(false);
        //btnactualizar.setEnabled(false);
        btnagregar.setText("Agregar");
        btnagregar.setActionCommand("agregar");
        tbldetventa.clearSelection();
        limpiarDatos();
    }

    public void limpiarDatos() {
        txtcodigo.setText("");
        txtnombre.setText("");
        txtcantidad.setText("");
        cmbprecio.removeAll();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox<String> cmbcli;
    private javax.swing.JComboBox<String> cmbprecio;
    private javax.swing.JComboBox<String> cmbproducto;
    private javax.swing.JComboBox<String> cmbtipoven;
    private javax.swing.JComboBox<String> cmbven;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcantidad;
    private javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lblproducto;
    private javax.swing.JLabel lbltipoventa;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel lblvende;
    private javax.swing.JPanel pnlventa;
    private javax.swing.JTable tbldetventa;
    private javax.swing.JTextPane txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
