package clases;

public class Devolucion {
    private int id;
    private String fecha;
    private String hora;
    private String codigos;
    private String productos;
    private String cantidades;
    private String precios;
    private String totales;

    public Devolucion() {
    }

    public Devolucion(int id, String fecha, String hora, String codigos, String productos, String cantidades, String precios, String totales) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.codigos = codigos;
        this.productos = productos;
        this.cantidades = cantidades;
        this.precios = precios;
        this.totales = totales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCodigos() {
        return codigos;
    }

    public void setCodigos(String codigos) {
        this.codigos = codigos;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getCantidades() {
        return cantidades;
    }

    public void setCantidades(String cantidades) {
        this.cantidades = cantidades;
    }

    public String getPrecios() {
        return precios;
    }

    public void setPrecios(String precios) {
        this.precios = precios;
    }

    public String getTotales() {
        return totales;
    }

    public void setTotales(String totales) {
        this.totales = totales;
    }

    @Override
    public String toString() {
        return "Cotizacion{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", codigos=" + codigos + ", productos=" + productos + ", cantidades=" + cantidades + ", precios=" + precios + ", totales=" + totales + "}";
    }
    
}
