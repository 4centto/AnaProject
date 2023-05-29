package frames;

import clases.Conexion;
import javax.swing.WindowConstants;
import clases.Cotizacion;
import clases.ProductoTicket;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class InfoRemision extends javax.swing.JFrame {
    
    private int ID_COTIZACION = Remisiones.ID_COTIZACION;
    private Cotizacion cotizacion = null;
    ArrayList<ProductoTicket> productos = null;

    public InfoRemision() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Informacion de la remision");
        this.setSize(600, 400);
        
        Conexion c = new Conexion();
        cotizacion = c.getCotizacion(ID_COTIZACION);
        
        jLabel1.setText(cotizacion.getFecha());
        
        formatData();
        fillTable();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 300, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 580, 290));
        jScrollPane1.getAccessibleContext().setAccessibleDescription("");

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
            java.util.logging.Logger.getLogger(InfoRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoRemision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoRemision().setVisible(true);
            }
        });
    }
    
    //Funcion que formatea los datos de la base de datos
    private void formatData(){
        String[] cods = cotizacion.getCodigos().split("@~@");
        String[] prods = cotizacion.getProductos().split("@~@");
        String[] cants = cotizacion.getCantidades().split("@~@");
        String[] precs = cotizacion.getPrecios().split("@~@");
        String[] tots = cotizacion.getTotales().split("@~@");
        
        productos = new ArrayList<>();
        
        for(int i = 0; i < cods.length; i++){
            productos.add(new ProductoTicket(cods[i], Integer.parseInt(cants[i]),prods[i], Float.parseFloat(precs[i]), Float.parseFloat(tots[i])));
        }
        
        
    }

    //Metodo para completar la tabla de las cotizaciones
    private void fillTable(){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Id");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Total");

        for (int i = 0; i < productos.size(); i++) {
            Object[] object = new Object[5];
            ProductoTicket p = productos.get(i);

            object[0] = p.getId();
            object[1] = p.getProducto();
            object[2] = p.getCantidad();
            object[3] = p.getPrecio();
            object[4] = p.getTotal();

            model.addRow(object);
        }

        this.jTable1.setModel(model);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
