package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static Connection conn;
    private Statement st;
    private ResultSet rs;
    
    //Constructor de la clase que realiza la conexion a la base de datos
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e.toString());
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/Tienda", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo que obtiene todos los productos de la tienda
    public ArrayList<Producto> getProducts(){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM PRODUCTO ORDER BY nombre_producto ASC");
            
            ArrayList<Producto> productos = new ArrayList<>();
            
            if(rs != null){
                while(rs.next()){
                    Producto p = new Producto(rs.getString("codigo"), rs.getString("nombre_producto"), 
                            rs.getFloat("precio_venta_producto"), rs.getFloat("costo_producto"), 
                            rs.getInt("existencias_producto"));
                    
                    productos.add(p);
                }
                
                return productos;
            }
            
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        
        return null;
    }
    
    //Metodo que inserta un nuevo producto a la tienda
    public static void insertProduct(Producto p){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO PRODUCTO VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getExistencia());
            ps.setFloat(4, p.getPrecioVenta());
            ps.setFloat(5, p.getCosto());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente!", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch(SQLException e){
            System.out.println(e.toString());
            if(Pattern.compile("Duplicate entry").matcher(e.getMessage()).find() == true){
                JOptionPane.showMessageDialog(null, "El codigo de producto ya esta registrado", "Producto duplicado", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error de conexion", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    //Metodo que elimina un producto de la tienda
    public static void deleteProduct(String id, String productoSel){
        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM PRODUCTO WHERE codigo = ?");
            pst.setString(1, id);
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, productoSel + " eliminado correctamente", "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error de conexion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Metodo que actualiza los productos
    public static void updateProducts(ArrayList<Producto> productos){
        int cant = 0;
        for(int i = 0; i < productos.size(); i++){
            try {
                Producto p = productos.get(i);
                PreparedStatement pst = conn.prepareStatement("UPDATE PRODUCTO SET existencias_producto = ?," +
                        " precio_venta_producto = ?, costo_producto = ? WHERE codigo = ?");
                
                
                
                pst.setInt(1, p.getExistencia());
                pst.setFloat(2, p.getPrecioVenta());
                pst.setFloat(3, p.getCosto());
                pst.setString(4, p.getCodigo());
                

                pst.execute();
                cant ++;
            } catch(SQLException e){
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Error de conexion", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        if(cant == productos.size()){
            JOptionPane.showMessageDialog(null, "Productos modificados correctamente", "Productos modificados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
          
    //Metodo que añade los productos de ujn excel
    public static void fillDatabase(ArrayList<Producto> productos){
        ArrayList<Producto> restProducts = new ArrayList<>();
        for(int i = 0; i < productos.size(); i++){
            try {
                Producto p = productos.get(i);
                PreparedStatement pst = conn.prepareStatement("INSERT INTO PRODUCTO VALUES(?,?,?,?,?)");
                
                pst.setString(1, p.getCodigo());
                pst.setString(2, p.getNombre());
                pst.setInt(3, p.getExistencia());
                pst.setFloat(4, Float.parseFloat(String.format("%.2f", p.getPrecioVenta())));
                pst.setFloat(5, Float.parseFloat(String.format("%.2f", p.getCosto())));

                pst.execute();
            } catch(SQLException e){
                System.out.println(e.getMessage());
                if(Pattern.compile("Duplicate entry").matcher(e.getMessage()).find() == false){
                    if(Pattern.compile("Data truncation").matcher(e.getMessage()).find() == false){
                        JOptionPane.showMessageDialog(null, "Error de conexion", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        restProducts.add(productos.get(i));
                    }
                } else {
                    restProducts.add(productos.get(i));
                }
            }
            
        }
        
        if(restProducts.size() == productos.size()){
            JOptionPane.showMessageDialog(null, "No se agregaron los productos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(!restProducts.isEmpty()){
            
            String productosFaltantes = "";
            for(int i = 0; i < restProducts.size(); i++){
                productosFaltantes += "\t" + (i+1) + ". Codigo: " + restProducts.get(i).getCodigo() + ", Nombre: " + 
                        restProducts.get(i).getNombre() + "\n";
            }
            
            String message = "Se agregaron los productos...\nPero faltaron: " + restProducts.size() + ":\n" + productosFaltantes;
            
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Metodo que agrega las cotizaciones
    public static boolean addCotizacion(ArrayList<ProductoTicket> productos, float descuento, String fecha, String hora){
        String codigos = "", products = "", cantidades = "", precios = "", totales = "";
        
        for(ProductoTicket p : productos){
            if(products.compareTo("") == 0){
                codigos = p.getId();
                products = p.getProducto();
                cantidades = String.valueOf(p.getCantidad());
                precios = String.valueOf(p.getPrecio());
                totales = String.valueOf(p.getTotal());
            } else {
                codigos += "@~@" + p.getId();
                products += "@~@" + p.getProducto();
                cantidades += "@~@" + String.valueOf(p.getCantidad());
                precios += "@~@" + String.valueOf(p.getPrecio());
                totales += "@~@" + String.valueOf(p.getTotal());
            }
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO COTIZACIONES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, 0);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            ps.setString(4, codigos);
            ps.setString(5, products);
            ps.setString(6, cantidades);
            ps.setString(7, precios);
            ps.setString(8, totales);
            ps.setFloat(9, descuento);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cotizacion generada con exito!", "Cotizacion creada", JOptionPane.INFORMATION_MESSAGE);
            
            return true;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error de conexion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
        
    }
    
    public ArrayList<Cotizacion> getCotizaciones(){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM COTIZACIONES ORDER BY id DESC");
            
            ArrayList<Cotizacion> cotizaciones = new ArrayList<>();
            
            if(rs != null){
                while(rs.next()){
                    Cotizacion c = new Cotizacion(rs.getInt("id"), rs.getString("fecha"), 
                            rs.getString("hora"), rs.getString("codigos"), rs.getString("productos"), 
                            rs.getString("cantidades"), rs.getString("precios"), rs.getString("totales"), 
                            rs.getFloat("descuento"));
                    
                    cotizaciones.add(c);
                }
                return cotizaciones;
            }
            
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        
        return null;
    }
    
}
