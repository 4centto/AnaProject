package frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.WindowConstants;

/**
 *
 * @author ivanm
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 800);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnInventario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnRemisiones = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnCotizaciones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BtnDevoluciones = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Elige una opcion...");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 25));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        BtnInventario.setBackground(new java.awt.Color(204, 204, 204));
        BtnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnInventario.setFocusable(false);
        BtnInventario.setPreferredSize(new java.awt.Dimension(420, 120));
        BtnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnInventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnInventarioMouseExited(evt);
            }
        });
        BtnInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventario.png"))); // NOI18N
        BtnInventario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INVENTARIO");
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 30));
        BtnInventario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 45, -1, -1));

        getContentPane().add(BtnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        BtnRemisiones.setBackground(new java.awt.Color(204, 204, 204));
        BtnRemisiones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRemisiones.setFocusable(false);
        BtnRemisiones.setPreferredSize(new java.awt.Dimension(420, 120));
        BtnRemisiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRemisionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnRemisionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnRemisionesMouseExited(evt);
            }
        });
        BtnRemisiones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ventas.png"))); // NOI18N
        BtnRemisiones.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REMISIONES");
        jLabel5.setPreferredSize(new java.awt.Dimension(200, 30));
        BtnRemisiones.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 45, -1, -1));

        getContentPane().add(BtnRemisiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        BtnCotizaciones.setBackground(new java.awt.Color(204, 204, 204));
        BtnCotizaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCotizaciones.setFocusable(false);
        BtnCotizaciones.setPreferredSize(new java.awt.Dimension(420, 120));
        BtnCotizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCotizacionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCotizacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCotizacionesMouseExited(evt);
            }
        });
        BtnCotizaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/precio.png"))); // NOI18N
        BtnCotizaciones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COTIZACIONES");
        jLabel7.setPreferredSize(new java.awt.Dimension(200, 30));
        BtnCotizaciones.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 45, -1, -1));

        getContentPane().add(BtnCotizaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        BtnDevoluciones.setBackground(new java.awt.Color(204, 204, 204));
        BtnDevoluciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDevoluciones.setFocusable(false);
        BtnDevoluciones.setPreferredSize(new java.awt.Dimension(420, 120));
        BtnDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnDevolucionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnDevolucionesMouseExited(evt);
            }
        });
        BtnDevoluciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/devolucion.png"))); // NOI18N
        BtnDevoluciones.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DEVOLUCIONES");
        jLabel9.setPreferredSize(new java.awt.Dimension(200, 30));
        BtnDevoluciones.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 45, -1, -1));

        getContentPane().add(BtnDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodos eventos del mouse con los botones del menu
    private void BtnInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInventarioMouseEntered
        hovered(evt.getComponent());
    }//GEN-LAST:event_BtnInventarioMouseEntered

    private void BtnInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInventarioMouseExited
        unhovered(evt.getComponent());
    }//GEN-LAST:event_BtnInventarioMouseExited

    private void BtnRemisionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRemisionesMouseEntered
        hovered(evt.getComponent());
    }//GEN-LAST:event_BtnRemisionesMouseEntered

    private void BtnRemisionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRemisionesMouseExited
        unhovered(evt.getComponent());
    }//GEN-LAST:event_BtnRemisionesMouseExited

    private void BtnCotizacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCotizacionesMouseEntered
        hovered(evt.getComponent());
    }//GEN-LAST:event_BtnCotizacionesMouseEntered

    private void BtnCotizacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCotizacionesMouseExited
        unhovered(evt.getComponent());
    }//GEN-LAST:event_BtnCotizacionesMouseExited

    //Boton para el inventario
    private void BtnInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInventarioMouseClicked
        Inventario inv = new Inventario();
        inv.setVisible(true);
    }//GEN-LAST:event_BtnInventarioMouseClicked

    private void BtnDevolucionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDevolucionesMouseEntered
        hovered(evt.getComponent());
    }//GEN-LAST:event_BtnDevolucionesMouseEntered

    private void BtnDevolucionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDevolucionesMouseExited
        unhovered(evt.getComponent());
    }//GEN-LAST:event_BtnDevolucionesMouseExited

    //Boton para las cotizaciones
    private void BtnCotizacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCotizacionesMouseClicked
        Cotizaciones c = new Cotizaciones();
        c.setVisible(true);
    }//GEN-LAST:event_BtnCotizacionesMouseClicked

    //Boton para las remisiones
    private void BtnRemisionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRemisionesMouseClicked
        Remisiones re = new Remisiones();
        re.setVisible(true);
    }//GEN-LAST:event_BtnRemisionesMouseClicked
        
    //Metodos para los hovers de los botones del menu
    private void hovered(Component component){
        component.setBackground(new Color(220, 220, 220));
    }
    
    private void unhovered(Component component){
        component.setBackground(new Color(204, 204, 204));
    }
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnCotizaciones;
    private javax.swing.JPanel BtnDevoluciones;
    private javax.swing.JPanel BtnInventario;
    private javax.swing.JPanel BtnRemisiones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
