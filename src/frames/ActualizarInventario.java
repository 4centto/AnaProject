package frames;

import clases.Conexion;
import clases.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class ActualizarInventario extends javax.swing.JFrame {
    
    private ArrayList<Producto> productos = null;
    private ArrayList<Producto> newProductos = null;

    public ActualizarInventario() {
        initComponents();
        
        this.setTitle("Modificar inventario");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, 380);
        
        productos = Inventario.productos;
        
        fillItems();
    }
    
    private void fillItems(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        for(int i = 0; i < productos.size(); i++){
            modelo.addElement(productos.get((i)).getNombre());
        }
        
        jComboBoxProductos.setModel(modelo);
        setData(productos.get(jComboBoxProductos.getSelectedIndex()));
        
        jComboBoxProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setData(productos.get(jComboBoxProductos.getSelectedIndex()));
            }
        });
        
    }
    
    private void setData(Producto p){
        jTextFieldPrecio.setText(String.valueOf(p.getPrecioVenta()));
        jTextFieldExistencias.setText(String.valueOf(p.getExistencia()));
        jTextFieldCosto.setText(String.valueOf(p.getCosto()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldExistencias = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCosto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actualiza los productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 480, -1));

        jComboBoxProductos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jComboBoxProductos.setPreferredSize(new java.awt.Dimension(400, 25));
        getContentPane().add(jComboBoxProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 25));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel2.setText("Precio de venta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel3.setText("Existencias");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jTextFieldPrecio.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jTextFieldPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrecio.setPreferredSize(new java.awt.Dimension(150, 23));
        getContentPane().add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 30));

        jTextFieldExistencias.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jTextFieldExistencias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldExistencias.setPreferredSize(new java.awt.Dimension(150, 23));
        getContentPane().add(jTextFieldExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, 30));

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton1.setText("AGREGAR A LISTA DE MODIFICADOS");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 300, 30));

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton2.setText("GUARDAR");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 300, 30));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 30, 20));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Costo ultimo");
        jLabel5.setPreferredSize(new java.awt.Dimension(90, 15));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 170, -1, -1));

        jTextFieldCosto.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jTextFieldCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCosto.setPreferredSize(new java.awt.Dimension(150, 23));
        getContentPane().add(jTextFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 190, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para agregar productos a la lista
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Primero validamos si la lista esta vacia
        if(newProductos == null){
            newProductos = new ArrayList<>();
        }
        
        try {
            int cant = Integer.parseInt(jTextFieldExistencias.getText().toString());
            float precio = Float.parseFloat(jTextFieldPrecio.getText().toString());
            float costo = Float.parseFloat(jTextFieldCosto.getText().toString());
            if(cant > 0 && precio > 0){
                newProductos.add(new Producto(productos.get(jComboBoxProductos.getSelectedIndex()).getCodigo(),
                        jComboBoxProductos.getSelectedItem().toString(), precio, costo, 
                cant));
                
                JOptionPane.showMessageDialog(null, "Producto agregado a la lista", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "Debes ingresar un precio y existencias validas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Debes ingresar un precio y existencias validas", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //Metodo para confirmar y actualizar el inventario
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(newProductos.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista de productos esta vacia", "Lista vacia", JOptionPane.WARNING_MESSAGE);
        } else {
            if(JOptionPane.showConfirmDialog(null, "¿Deseas modificar los productos pemanentemente?", 
                "Modificar productos", JOptionPane.YES_NO_OPTION) == 0){
                
                Conexion.updateProducts(newProductos);
                
                this.dispose();
                
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        ActualizarInventario ai = new ActualizarInventario();
        ai.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldCosto;
    private javax.swing.JTextField jTextFieldExistencias;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
