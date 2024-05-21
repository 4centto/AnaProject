package frames;

import clases.Conexion;
import clases.Producto;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.WindowConstants;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Inventario extends javax.swing.JFrame {

    public static ArrayList<Producto> productos = new ArrayList<>();

    public Inventario() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("Inventario");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Conexion conexion = new Conexion();
        productos = conexion.getProducts();

        fillTable();
        jTableProductosSearch.setModel(new DefaultTableModel());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductosSearch = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(700, 700));

        jTableProductos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProductos.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 670, 220));

        jTextFieldBusqueda.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jTextFieldBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBusqueda.setPreferredSize(new java.awt.Dimension(670, 25));
        jTextFieldBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBusquedaKeyPressed(evt);
            }
        });
        getContentPane().add(jTextFieldBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 670, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(700, 700));

        jTableProductosSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jTableProductosSearch.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProductosSearch.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(jTableProductosSearch);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 670, 180));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS EN EXISTENCIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 670, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BUSCAR PRODUCTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 670, -1));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 50, 50));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("AGREGAR PRODUCTO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 160, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 680, 120, 20));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ACTUALIZAR INVENTARIO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 590, 200, -1));

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 620, 50, 50));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ELIMINAR PRODUCTO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, 160, -1));

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 620, 50, 50));

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/documento.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jLabel10.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ABRIR DOCUMENTO");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 26, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Codigo para la busqueda de productos
    private void jTextFieldBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaKeyPressed
        if (!productos.isEmpty()) {
            String busqueda = jTextFieldBusqueda.getText();
            if (busqueda.compareTo("") != 0) {
                ArrayList<Producto> pb = new ArrayList<>();
                DefaultTableModel newTableModel = new DefaultTableModel();

                newTableModel.addColumn("Codigo");
                newTableModel.addColumn("Producto");
                newTableModel.addColumn("Existencias/Piezas");
                newTableModel.addColumn("PrecioVenta/Pieza");
                newTableModel.addColumn("Costo");

                String palabra = busqueda.toLowerCase().strip();
                for (int j = 0; j < productos.size(); j++) {

                    Pattern patron = Pattern.compile(palabra);
                    Matcher m = patron.matcher(productos.get(j).getNombre().toLowerCase().strip());
                    Matcher m2 = patron.matcher(productos.get(j).getCodigo().toLowerCase().strip());

                    if (m.find() || m2.find()) {
                        pb.add(productos.get(j));
                    }

                }

                //Ahora que ya filtramos los datos, hay que llenar la tabla
                for (int i = 0; i < pb.size(); i++) {
                    Object[] object = new Object[5];
                    Producto p = pb.get(i);

                    object[0] = p.getCodigo();
                    object[1] = p.getNombre();
                    object[2] = p.getExistencia();
                    object[3] = p.getPrecioVenta();
                    object[4] = p.getCosto();

                    newTableModel.addRow(object);
                }

                this.jTableProductosSearch.setModel(newTableModel);

            } else {
                System.out.println("No hay nada para buscar!");
            }
        } else {
            System.out.println("No hay productos registrados!");
        }
    }//GEN-LAST:event_jTextFieldBusquedaKeyPressed

    //Boton agregar producto
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        AgregarProducto ap = new AgregarProducto();
        ap.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

    //boton actualizar inventario
    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        TableModel table = jTableProductos.getModel();
        
        try{
            for(int i = 0; i < table.getRowCount(); i++){
                int cant = 0;
                float precio = 0.0f, costo = 0.0f;
                
                //Verificamos si el campo de la cantidad esta vacio
                if(table.getValueAt(i, 2).toString().trim().compareTo("") != 0){
                    cant = Integer.parseInt(table.getValueAt(i, 2).toString().trim());
                } 
                
                if(table.getValueAt(i, 3).toString().trim().compareTo("") != 0){
                    costo = Float.parseFloat(table.getValueAt(i, 3).toString().trim());
                }
                
                if(table.getValueAt(i, 4).toString().trim().compareTo("") != 0){
                    precio = Float.parseFloat(table.getValueAt(i, 4).toString().trim());
                }
                
                productos.get(i).setExistencia(cant);
                productos.get(i).setCosto(costo);
                productos.get(i).setPrecioVenta(precio);
            }
            
            Conexion.updateProducts(productos);
            
            Conexion conexion = new Conexion();
            productos = conexion.getProducts();

            fillTable();
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Verifica que las existencias, precios y costos esten escritos correctamente", "ERROR DE CONVERSION", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jPanel2MouseClicked

    //Boton eliminar producto
    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        EliminarProducto ep = new EliminarProducto();
        ep.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    //Boton para leer archivo .xlsx
    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(jfc);

        try {
            String ruta = jfc.getSelectedFile().getAbsolutePath();
            FileInputStream file = new FileInputStream(ruta);

            readXLSXFile(file);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jPanel4MouseClicked

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Inventario inv = new Inventario();
        inv.setVisible(true);

    }

    private void fillTable() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Codigo");
        model.addColumn("Producto");
        model.addColumn("Existencias/Piezas");
        model.addColumn("Costo");
        model.addColumn("PrecioVenta/Pieza");

        for (int i = 0; i < productos.size(); i++) {
            Object[] object = new Object[5];
            Producto p = productos.get(i);

            object[0] = p.getCodigo();
            object[1] = p.getNombre();
            object[2] = p.getExistencia();
            object[3] = p.getPrecioVenta();
            object[4] = p.getCosto();

            model.addRow(object);
        }

        this.jTableProductos.setModel(model);
    }

    private void readXLSXFile(FileInputStream file) {
        try {
            XSSFWorkbook libro = new XSSFWorkbook(file);
            XSSFSheet hoja = libro.getSheetAt(0);

            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;

            Row fila;
            Cell celda;
            int f = 1;
            
            while (filas.hasNext()) {
                fila = filas.next();
                if(f != 1){
                    celdas = fila.cellIterator();

                    Producto p = new Producto();
                    int cell = 0;

                    while (celdas.hasNext()) {
                        celda = celdas.next();

                        switch (cell) {
                            case 0 -> p.setCodigo(celda.getStringCellValue());
                            case 2 -> p.setNombre(celda.getStringCellValue());
                            case 3 -> p.setPrecioVenta((float)celda.getNumericCellValue());
                            case 5 -> p.setCosto((float)celda.getNumericCellValue());
                            case 6 -> p.setExistencia((int)celda.getNumericCellValue());
                            default -> {
                            }
                        }

                        cell ++;

                    }
                    
                    productos.add(p);
                    
                }
                f ++;
            }
            libro.close();
            
            productos.remove(productos.size()-1);
            
            Conexion.fillDatabase(productos);
            productos.clear();
            
            Conexion cn = new Conexion();
            productos = cn.getProducts();
            
            fillTable();
            
        } catch (IOException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jTableProductosSearch;
    private javax.swing.JTextField jTextFieldBusqueda;
    // End of variables declaration//GEN-END:variables
}
