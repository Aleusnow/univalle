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
import modelo.MateriaPrima;

/**
 *
 * @author Amelia Wolf
 */
public class VentanaMatPri extends javax.swing.JInternalFrame {
 
    private DefaultTableModel mTabla;
    /**
     * Creates new form VentanaMatPri
     */
    public VentanaMatPri() {
        initComponents();
        mTabla = (DefaultTableModel) tblmatpris.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    //Haciendo Listeners de los txt y btn
    public int getCodigo() {
        return Integer.parseInt(txtcodigo.getText().trim());
    }

    public String getNombre() {
        return txtnombre.getText().trim();
    }

    public int getCantidad() {
        return Integer.parseInt(txtcantidad.getText().trim());
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

    //"Crear" tabla de productos
    public void cargarMateriasPrimas(ArrayList<MateriaPrima> listaMatPri) {
        limpiarTabla();
        for (int i = 0; i < listaMatPri.size(); i++) {
            mTabla.addRow(new Object[]{
                listaMatPri.get(i).getCodigoMatPri(),
                listaMatPri.get(i).getNombreMatPri(),
                listaMatPri.get(i).getInventarioMatPri(),});
        }
    }
    
    public boolean revisaDatos() {
        if (txtnombre.getText().replaceAll(" ", "").isEmpty() || txtcantidad.getText().replaceAll(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Datos incompletos, por favor llene todos lo campos");
            return false;
        }
        return true;
    }
    
    public void cancelarAction() {
        txtcantidad.setEditable(true); //
        btneliminar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btnagregar.setText("Agregar");
        btnagregar.setActionCommand("agregar");
        tblmatpris.clearSelection();
        limpiarDatos();
    }
    
    public void limpiarDatos() {
        txtcodigo.setText("");
        txtnombre.setText("");
        txtcantidad.setText("");
    }

    public void gestionMensajes(String mensaje, String titulo, int icono) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlbuscar = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lblcantidad = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        pnllistado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmatpris = new javax.swing.JTable();

        setClosable(true);
        setTitle("Materias Primas");

        pnlbuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Materia Prima"));

        lblcodigo.setText("Codigo: ");

        lblnombre.setText("Nombre:");

        lblcantidad.setText("Cantidad:");

        txtcodigo.setEditable(false);

        btnagregar.setText("Agregar");

        btneliminar.setText("Eliminar");
        btneliminar.setEnabled(false);

        btnactualizar.setText("Actualizar");
        btnactualizar.setEnabled(false);

        javax.swing.GroupLayout pnlbuscarLayout = new javax.swing.GroupLayout(pnlbuscar);
        pnlbuscar.setLayout(pnlbuscarLayout);
        pnlbuscarLayout.setHorizontalGroup(
            pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbuscarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcantidad)
                    .addGroup(pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblcodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtcodigo)
                    .addComponent(txtcantidad))
                .addGap(58, 58, 58)
                .addGroup(pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlbuscarLayout.setVerticalGroup(
            pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombre)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnllistado.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

        tblmatpris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblmatpris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmatprisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmatpris);

        javax.swing.GroupLayout pnllistadoLayout = new javax.swing.GroupLayout(pnllistado);
        pnllistado.setLayout(pnllistadoLayout);
        pnllistadoLayout.setHorizontalGroup(
            pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistadoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnllistadoLayout.setVerticalGroup(
            pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnllistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(pnlbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnllistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblmatprisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmatprisMouseClicked
        int sel = tblmatpris.getSelectedRow();
        if(sel == -1){
            if(tblmatpris.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
        }else {
            txtcodigo.setText(tblmatpris.getValueAt(sel, 0).toString());
            txtnombre.setText(tblmatpris.getValueAt(sel, 1).toString());
            txtcantidad.setText(tblmatpris.getValueAt(sel, 2).toString());
            btnactualizar.setEnabled(true);
            btneliminar.setEnabled(true);
            btnagregar.setText("Cancelar");
            btnagregar.setActionCommand("cancelar");
            
            txtcantidad.setEditable(false);
        }
    }//GEN-LAST:event_tblmatprisMouseClicked
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcantidad;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JPanel pnlbuscar;
    private javax.swing.JPanel pnllistado;
    private javax.swing.JTable tblmatpris;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
