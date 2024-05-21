package frames;

import clases.Conexion;
import javax.swing.WindowConstants;
import clases.Cotizacion;
import clases.ProductoTicket;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InfoDevolucion extends javax.swing.JFrame {
    
    private final int ID_COTIZACION = Devoluciones.ID_COTIZACION;
    private Date date = new Date();
    
    private String fecha = "";
    private String hora = "";
    
    private Cotizacion cotizacion = null;
    private ArrayList<ProductoTicket> productos = null;

    public InfoDevolucion() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Informacion de la remision");
        this.setSize(600, 500);
        
        Conexion c = new Conexion();
        
        cotizacion = c.getCotizacion(ID_COTIZACION); //Obtenemos los datos de la cotizacion
        
        jLabel1.setText(cotizacion.getFecha());
        
        formatData();
        fillTable();
        calculateTotal();
        formatDate();
        
        jTable1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                TableModel table = jTable1.getModel();
                for(int i = 0; i < table.getRowCount(); i++){
                    productos.get(i).setCantidad(Integer.parseInt(table.getValueAt(i, 1).toString()));
                    productos.get(i).setTotal(productos.get(i).getCantidad() * productos.get(i).getPrecio());
                }
                
                calculateTotal();
            }
        });
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total ");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 350, 250, 30);

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton1.setText("DEVOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 380, 200, 50);

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton2.setText("IMPRIMIR TICKET");
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 380, 200, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Boton que actualiza la informacion de la cotizacion en funcion a los valores de la tabla
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
        
            
            if(Conexion.addDevolucion(productos, fecha, hora)){
                this.dispose();
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
            java.util.logging.Logger.getLogger(InfoDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoDevolucion().setVisible(true);
            }
        });
    }
    
    //Funcion que formatea los datos de la base de datos
    private void formatData(){
        String[] cods = cotizacion.getCodigos().split("@~@");
        String[] prods = cotizacion.getProductos().split("@~@");
        String[] precs = cotizacion.getPrecios().split("@~@");
        
        productos = new ArrayList<>();
        
        for(int i = 0; i < cods.length; i++){
            productos.add(new ProductoTicket(cods[i], 0, prods[i], Float.parseFloat(precs[i]), 0.0f));
        }
        
        
    }

    //Metodo para completar la tabla de las cotizaciones
    private void fillTable(){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");

        for (int i = 0; i < productos.size(); i++) {
            Object[] object = new Object[3];
            ProductoTicket p = productos.get(i);

            object[0] = p.getProducto();
            object[1] = p.getCantidad();
            object[2] = p.getPrecio();

            model.addRow(object);
        }

        this.jTable1.setModel(model);
    }
    
    //Funcion que calcula el total de la cotizacion
    private void calculateTotal(){
        try{
        
            float total = 0;
            for(int i = 0; i < productos.size(); i++){
                total += productos.get(i).getTotal();
            }
            
            jLabel3.setText("Total $" + String.valueOf(total));
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Verfiica que las cantidades y precios de los productos al igual que el descuento sean numeros o decimales", "Error en los numeros", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Metodo que formatea la fecha en formato legible
    private void formatDate() {
        Date date = new Date();

        //Dia
        String dia = "";
        switch (date.getDay()) {
            case 1 ->
                dia = "Lunes";
            case 2 ->
                dia = "Martes";
            case 3 ->
                dia = "Miercoles";
            case 4 ->
                dia = "Jueves";
            case 5 ->
                dia = "Viernes";
            case 6 ->
                dia = "Sabado";
            case 7 ->
                dia = "Domingo";
        }

        //Mes
        String mes = "";
        switch (date.getMonth() + 1) {
            case 1 ->
                mes = "Enero";
            case 2 ->
                mes = "Febrero";
            case 3 ->
                mes = "Marzo";
            case 4 ->
                mes = "Abril";
            case 5 ->
                mes = "Mayo";
            case 6 ->
                mes = "Junio";
            case 7 ->
                mes = "Julio";
            case 8 ->
                mes = "Agosto";
            case 9 ->
                mes = "Septiembre";
            case 10 ->
                mes = "Octubre";
            case 11 ->
                mes = "Noviembre";
            case 12 ->
                mes = "Diciembre";
        }

        //Numero dia
        int num = date.getDate();
        int year = date.getYear();

        //Hora
        int horaH = date.getHours();
        int minutes = date.getMinutes();
        
        fecha = dia + " " + num + " de " + mes + " del " + "20" + (year - 100);
        hora = horaH + ":" + minutes;

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
