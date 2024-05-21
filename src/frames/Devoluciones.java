package frames;

import clases.Conexion;
import java.util.ArrayList;
import javax.swing.WindowConstants;

import clases.Cotizacion;
import clases.Devolucion;
import javax.swing.table.DefaultTableModel;

public class Devoluciones extends javax.swing.JFrame {
    
    private ArrayList<Cotizacion> cotizaciones = null;
    private ArrayList<Devolucion> devoluciones = null;
    public static int ID_COTIZACION;
    
    public Devoluciones() {
        initComponents();
        
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Remisiones");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        Conexion c = new Conexion();
        cotizaciones = c.getCotizaciones();
        devoluciones = c.getDevoluciones();
        
        fillTable();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCotizaciones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCotizaciones1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DEVOLUCIONES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(175, 10, 150, 17);

        jTableCotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableCotizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCotizacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCotizaciones);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 460, 180);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HISTORIAL DE DEVOLUCIONES");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(125, 220, 250, 17);

        jTableCotizaciones1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableCotizaciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCotizaciones1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCotizaciones1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 240, 460, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para cuando el usuario seleccione una cotizacion
    private void jTableCotizacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCotizacionesMouseClicked
        int index = jTableCotizaciones.getSelectedRow();
        ID_COTIZACION = cotizaciones.get(index).getId();
        
        InfoDevolucion id = new InfoDevolucion();
        id.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_jTableCotizacionesMouseClicked

    private void jTableCotizaciones1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCotizaciones1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCotizaciones1MouseClicked

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
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Devoluciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        Devoluciones re = new Devoluciones();
        re.setVisible(true);
        
    }

    //Metodo para completar la tabla de las cotizaciones
    private void fillTable(){
        DefaultTableModel model = null;
        
        //Modelo de las cotizaciones
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Fecha");
        for (int i = 0; i < cotizaciones.size(); i++) {
            Object[] object = new Object[2];
            Cotizacion c = cotizaciones.get(i);

            object[0] = c.getId();
            object[1] = c.getFecha();

            model.addRow(object);
        }

        this.jTableCotizaciones.setModel(model);
        
        //Modelo de las cotizaciones
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Fecha");
        for (int i = 0; i < devoluciones.size(); i++) {
            Object[] object = new Object[2];
            Devolucion d = devoluciones.get(i);

            object[0] = d.getId();
            object[1] = d.getFecha();

            model.addRow(object);
        }

        this.jTableCotizaciones1.setModel(model);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCotizaciones;
    private javax.swing.JTable jTableCotizaciones1;
    // End of variables declaration//GEN-END:variables
}
