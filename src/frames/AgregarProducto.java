package frames;

import clases.Conexion;
import clases.Producto;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class AgregarProducto extends javax.swing.JFrame {
    
    private Producto p;

    public AgregarProducto() {
        initComponents();
        
        this.setTitle("Agregar Producto");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 360);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldExistencias = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCosto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setText("INGRESA LOS SIGUIENTES DATOS...");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jTextFieldCodigo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigo.setPreferredSize(new java.awt.Dimension(78, 25));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel3.setText("Piezas existentes:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextFieldExistencias.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldExistencias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldExistencias.setPreferredSize(new java.awt.Dimension(78, 25));
        getContentPane().add(jTextFieldExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel4.setText("Precio de venta:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jTextFieldPrecio.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrecio.setPreferredSize(new java.awt.Dimension(78, 25));
        getContentPane().add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 170, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel5.setText("Costo ultimo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jTextFieldCosto.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCosto.setPreferredSize(new java.awt.Dimension(78, 25));
        getContentPane().add(jTextFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 380, -1));

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton1.setText("AGREGAR");
        jButton1.setPreferredSize(new java.awt.Dimension(120, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel6.setText("Nombre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jTextFieldNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombre.setPreferredSize(new java.awt.Dimension(78, 25));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String codigo = jTextFieldCodigo.getText().toString().toUpperCase();
        String nombre = jTextFieldNombre.getText().toString();
        String existencias = jTextFieldExistencias.getText().toString();
        String precio = jTextFieldPrecio.getText().toString();
        String costo = jTextFieldCosto.getText().toString();
        
        if(codigo.compareTo("") != 0 && nombre.compareTo("") != 0 && existencias.compareTo("") != 0 && precio.compareTo("") != 0 &&
                costo.compareTo("") != 0){
            
            if(Pattern.compile("\\D").matcher(existencias).find()){
                JOptionPane.showMessageDialog(null, "Debes ingresar las existencias de un producto (Numero entero)", "Campo invalido", JOptionPane.ERROR_MESSAGE);
            } else {
                
                try{
                    
                    float newPrecio = Float.parseFloat(precio);
                    float newCosto = Float.parseFloat(costo);
                    p = new Producto(codigo, nombre, newPrecio, newCosto, Integer.parseInt(existencias));
                    
                    Conexion.insertProduct(p);
                    
                    this.dispose();
                    
                } catch(NumberFormatException e){
                    System.out.println(e.toString());
                    JOptionPane.showMessageDialog(null, "Debes ingresar un precio y/o costo validos", "Campo invalido", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos", "Completa todos los campos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        AgregarProducto ap = new AgregarProducto();
        ap.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCosto;
    private javax.swing.JTextField jTextFieldExistencias;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
