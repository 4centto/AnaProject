package frames;

import clases.Conexion;
import javax.swing.WindowConstants;
import clases.Cotizacion;
import clases.Producto;
import clases.ProductoTicket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.formula.ptg.Ptg;

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
        this.setSize(600, 500);
        
        Conexion c = new Conexion();
        cotizacion = c.getCotizacion(ID_COTIZACION);
        
        jLabel1.setText(cotizacion.getFecha());
        jTextField1.setText(String.valueOf(cotizacion.getDescuento()));
        
        formatData();
        fillTable();
        calculateTotal();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 300, 20);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 560, 290);
        jScrollPane1.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DESCUENTO (%)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 340, 200, 20);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(431, 340, 140, 25);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("jLabel3");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 370, 250, 30);

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 410, 200, 50);

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton2.setText("IMPRIMIR TICKET");
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 410, 200, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Boton que actualiza la informacion de la cotizacion en funcion a los valores de la tabla
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        TableModel model = jTable1.getModel();
        int rows = model.getRowCount();
        
        if(jTextField1.getText().compareToIgnoreCase("") == 0){
            jTextField1.setText("0.0");
        }
        
        try {
            float descuento = Float.parseFloat(jTextField1.getText());
        
            for(int i = 0; i < rows; i++){
                
                String codigo = productos.get(i).getId();
                String nombre = productos.get(i).getProducto();
                int cant = Integer.parseInt(model.getValueAt(i, 1).toString());
                float precio = Float.parseFloat(model.getValueAt(i, 2).toString());
                float total = cant * precio;

                ProductoTicket pt = new ProductoTicket(codigo, cant, nombre, precio, total);

                productos.set(i, pt);
            }

            if(Conexion.updateCotizacion(productos, descuento, cotizacion.getFecha(), cotizacion.getHora(), ID_COTIZACION)){
                fillTable();
                calculateTotal();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Verfiica que las cantidades y precios de los productos al igual que el descuento sean numeros o decimales", "Error en los numeros", JOptionPane.WARNING_MESSAGE);
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
        
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Total");

        for (int i = 0; i < productos.size(); i++) {
            Object[] object = new Object[4];
            ProductoTicket p = productos.get(i);

            object[0] = p.getProducto();
            object[1] = p.getCantidad();
            object[2] = p.getPrecio();
            object[3] = p.getTotal();

            model.addRow(object);
        }

        this.jTable1.setModel(model);
    }
    
    //Funcion que calcula el total de la cotizacion
    private void calculateTotal(){
        
        try{
            float descuento = Float.parseFloat(jTextField1.getText()) / 100;
        
            float total = 0;
            for(int i = 0; i < productos.size(); i++){
                total += productos.get(i).getTotal();
            }
            total = total - (total * descuento);
            jLabel3.setText("Total $" + String.valueOf(total));
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Verfiica que las cantidades y precios de los productos al igual que el descuento sean numeros o decimales", "Error en los numeros", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
