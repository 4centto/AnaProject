package frames;

import clases.Conexion;
import clases.Producto;
import clases.ProductoTicket;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Cotizaciones extends javax.swing.JFrame {

    private ArrayList<Producto> productos = null;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();

    //Varioables para el ticket
    
    private String fecha = "";
    private String horaB = "";
    
    private String ticket = "";
    private String ticketHeader = "<p style='text-align: center;'>Distribuidora Mundo Hogar</p>"
            + "<p></p>"
            + "<p style='text-align: center;'>" + formatDate() + "</p>"
            + "<p></p>"
            + "<p></p>";
    private String ticketTable = "";

    private ArrayList<ProductoTicket> productosTicket = new ArrayList<>();
    private String id = "";
    private float precio = 0;
    private float descuento = 0;
    private float total = 0;
    private float subtotal = 0;

    public Cotizaciones() {
        initComponents();

        this.setTitle("Cotizaciones");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(800, 530);

        Conexion cn = new Conexion();
        productos = cn.getProducts();

        fillCombo();
        initTicket();

    }

    private void fillCombo() {
        for (int i = 0; i < productos.size(); i++) {
            model.addElement(productos.get(i).getNombre());
        }
        jComboBoxProductos.setModel(model);
    }

    private void initTicket() {
        ticket = ticketHeader;

        //Crear la tabla de los productos
        ticket += ticketTable;

        //Añadir al final el ticket
        jLabelTicket.setText(strToHtml(ticket));
    }

    private String formatDate() {
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
        int hora = date.getHours();
        int minutes = date.getMinutes();
        
        fecha = dia + " " + num + " de " + mes + " del " + "20" + (year - 100);
        horaB = hora + ":" + minutes;

        return "" + dia + " " + num + " de " + mes + " del " + "20" + (year - 100) + " | " + hora + ":" + minutes;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTicket = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelTicket = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescuento = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonTerminar = new javax.swing.JButton();
        jButtonQuitar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldProducto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTicket.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTicket.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanelTicket.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelTicket.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 16)); // NOI18N
        jLabelTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTicket.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(jLabelTicket);

        jPanelTicket.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 430));

        getContentPane().add(jPanelTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, 450));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOTA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, -1));

        getContentPane().add(jComboBoxProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 360, 40));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        jTextFieldCantidad.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 360, 30));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descuento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 200, -1));

        jTextFieldDescuento.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDescuento.setText("0");
        getContentPane().add(jTextFieldDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 215, 360, 30));

        jButtonAgregar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButtonAgregar.setText("AGREGAR PRODUCTO");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 280, 330, 50));

        jButtonTerminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButtonTerminar.setText("TERMINAR");
        jButtonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 440, 330, 50));

        jButtonQuitar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButtonQuitar.setText("QUITAR PRODUCTO");
        jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 350, 330, 50));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel4.setText("Buscar producto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jTextFieldProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldProductoKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 360, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para agregar una nueva cotizacion
    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed

        if (jTextFieldCantidad.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad de producto", "CANTIDAD INVALIDA", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String producto = jComboBoxProductos.getSelectedItem().toString();
                if(productExists(producto)){
                    JOptionPane.showMessageDialog(null, "El producto ya esta en la lista", "Producto en lista", JOptionPane.WARNING_MESSAGE);
                } else {
                    buscarDatosProducto(producto);

                    int cant = Integer.parseInt(jTextFieldCantidad.getText());

                    productosTicket.add(new ProductoTicket(id, cant, producto, precio, precio * cant));

                    actualizarTicket();
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad de producto valida", "CANTIDAD INVALIDA", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonAgregarActionPerformed

    //Metodo que busca si el producto ya esta agregado en la lista
    private boolean productExists(String p){
        for(int i = 0; i < productosTicket.size(); i++){
            if(productosTicket.get(i).getProducto().compareTo(p) == 0){
                return true;
            }
        }
        return false;
    }
    
    //Boton para quitar un producto de la lista
    private void jButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarActionPerformed
        if (!productosTicket.isEmpty()) {
            productosTicket.remove(productosTicket.size() - 1);
            actualizarTicket();
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista", "Lista vacia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonQuitarActionPerformed

    //Boton que finaliza la cotizacion
    private void jButtonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarActionPerformed
        if (!productosTicket.isEmpty()) {
            if(JOptionPane.showConfirmDialog(null, "¿Deseas generar una nueva cotizacion?", "Generar cotizacion", JOptionPane.YES_NO_OPTION) == 0){
                if(Conexion.addCotizacion(productosTicket, descuento, fecha, horaB)){
                    imprimirTicket();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al generar la cotizacion", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista", "Lista vacia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonTerminarActionPerformed

    //Metodo que imprime el ticket
    private void imprimirTicket(){
        
        //Metodo para iomprimir el ticket
        System.out.println("Ticket impreso...");
    }
    
    //Metodo que actualiza el combo box de los items
    private void jTextFieldProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProductoKeyPressed
        String p = jTextFieldProducto.getText().strip().toLowerCase();

        Pattern patron = Pattern.compile(p);
        for (int i = 0; i < productos.size(); i++) {
            Matcher m = patron.matcher(productos.get(i).getNombre().toLowerCase().strip());
            if (m.find()) {
                jComboBoxProductos.setSelectedIndex(i);
                return;
            }
        }
        

    }//GEN-LAST:event_jTextFieldProductoKeyPressed

    //Metodo que actualiza el ticket cada vez que se hace un cambio
    private void actualizarTicket() {
        if (jTextFieldDescuento.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un descuento", "DESCUENTO INVALIDO", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //Damos el valor del descuento si es que lo hay
                descuento = Float.parseFloat(jTextFieldDescuento.getText().strip());

                //Damos el header al ticket
                ticket = "<p style='text-align: center;'>Distribuidora Mundo Hogar</p>"
                        + "<p></p>"
                        + "<p style='text-align: center;'>" + formatDate() + "</p>"
                        + "<p></p>"
                        + "<p></p>";

                //Ahora actualizamos la tabla con los datos que se vayan agregando
                ticketTable = "<div style='padding-left: 15px;'><table>"
                        + "<tr>"
                        + "<th>Cantidad</th>"
                        + "<th>Producto</th>"
                        + "<th>Precio</th>"
                        + "<th>Total</th>"
                        + "</tr>";

                for (int i = 0; i < productosTicket.size(); i++) {
                    ProductoTicket p = productosTicket.get(i);

                    ticketTable += "<tr>"
                            + "<th>" + p.getCantidad() + "</th>"
                            + "<th>" + p.getProducto() + "</th>"
                            + "<th>" + p.getPrecio() + "</th>"
                            + "<th>" + p.getTotal() + "</th>"
                            + "</tr>";

                }

                ticketTable += "</table></div>";

                ticket += ticketTable;

                calcularTotal();

                ticket += "<p></p>"
                        + "<p></p>"
                        + "<p style='padding-right: 20px; text-align: right;'>Descuento: " + descuento + "%</p>"
                        + "<p></p>"
                        + "<p style='padding-right: 20px; text-align: right;'>Subtotal: $" + subtotal + "</p>"
                        + "<p style='padding-right: 20px; text-align: right;'>Total: $" + total + "</p>";

                //Añadir al final el ticket
                jLabelTicket.setText(strToHtml(ticket));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Debes ingresar un descuento valido", "DESCUENTO INVALIDO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void calcularTotal() {
        float t = 0;
        for (int i = 0; i < productosTicket.size(); i++) {
            t += productosTicket.get(i).getTotal();
        }
        float d = (descuento * t) / 100;
        subtotal = t;
        total = t - d;
    }

    private void buscarDatosProducto(String producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().compareTo(producto) == 0) {
                id = productos.get(i).getCodigo();
                precio = productos.get(i).getPrecioVenta();
            }
        }
    }

    private String strToP(String s) {
        return "<p>" + s + "</p>";
    }

    private String strToHtml(String text) {
        return "<html>" + text + "</html>";
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
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Cotizaciones c = new Cotizaciones();
        c.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonQuitar;
    private javax.swing.JButton jButtonTerminar;
    private javax.swing.JComboBox<String> jComboBoxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTicket;
    private javax.swing.JPanel jPanelTicket;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldDescuento;
    private javax.swing.JTextField jTextFieldProducto;
    // End of variables declaration//GEN-END:variables
}
