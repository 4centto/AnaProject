package clases;

public class ProductoTicket {
    
    private String id;
    private int cantidad;
    private String producto;
    private float precio;
    private float total;

    public ProductoTicket() {
    }

    public ProductoTicket(String id, int cantidad, String producto, float precio, float total) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.precio = precio;
        this.total = total;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoTicket{" + "id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + ", precio=" + precio + ", total=" + total + '}';
    }
    
    
    
}
