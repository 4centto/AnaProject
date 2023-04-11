package frames;

import clases.Conexion;
import clases.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class EliminarProducto extends javax.swing.JFrame {
    
    private ArrayList<Producto> productos = null;

    public EliminarProducto() {
        initComponents();
        
        this.setTitle("Eliminar producto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(400, 250);
        
        productos = Inventario.productos;
        
        fillList();
        
    }
    
    private void fillList(){
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        
        for(int i = 0; i < productos.size(); i++){
            modelo.addElement(productos.get(i).getNombre());
        }
        
        jComboBoxProductos.setModel(modelo);
        
        jComboBoxProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productoSel = jComboBoxProductos.getSelectedItem().toString();
                String codigo = productos.get(jComboBoxProductos.getSelectedIndex()).getCodigo();
                
                if(JOptionPane.showConfirmDialog(null, "¿Deseas eliminar " + productoSel + " permanentemente?", "Eliminar producto", 
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
                    
                    Conexion.deleteProduct(codigo, productoSel);
                    
                    cerrar();
                }
                
            }
        });
        
    }
    
    private void cerrar(){
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setText("ELIGE EL PRODUCTO A ELIMINAR");
        jLabel1.setPreferredSize(new java.awt.Dimension(310, 25));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 80, -1, -1));

        jComboBoxProductos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jComboBoxProductos.setPreferredSize(new java.awt.Dimension(250, 30));
        getContentPane().add(jComboBoxProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        EliminarProducto ep = new EliminarProducto();
        ep.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxProductos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
