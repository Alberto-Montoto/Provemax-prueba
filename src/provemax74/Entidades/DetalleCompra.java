package provemax74.Entidades;


import provemax74.Entidades.Compra;
import provemax74.Entidades.Producto;

public class DetalleCompra {

    private int idDetalle;

    private int cantidad;

    private double precioCosto;

    private Compra compra;

    private Producto producto;
    
    private int idProducto;
    
    private String nombreProducto;
    
//    public DetalleCompra(int idDetalle, int cantidad, double precioCosto, Compra compra, Producto producto) {
//        this.idDetalle = idDetalle;
//        this.cantidad = cantidad;
//        this.precioCosto = precioCosto;
//        this.compra = compra;
//        this.producto = producto;
//    }

    public DetalleCompra() {
    }

    public DetalleCompra(int idDetalle, int cantidad, double precioCosto, String nombreProducto ,int idProducto ) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        nombreProducto = producto.getNombreProducto();
        idProducto = producto.getIdProducto();
    }

    public DetalleCompra(int cantidad, double precioCosto, int idProducto, String nombreProducto) { //, Producto producto
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
//        this.producto = producto;
    }

    public DetalleCompra(int cantidad, double precioCosto, Producto producto) {
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.producto = producto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

//    public DetalleCompra(int idDetalle, int cantidad, double precioCosto, String nombreProducto) {
//        this.idDetalle = idDetalle;
//        this.cantidad = cantidad;
//        this.precioCosto = precioCosto;
//        this.nombreProducto = nombreProducto;
//    }



    public DetalleCompra(int idDetalle, int cantidad, double precioCosto) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
    }

    public DetalleCompra(int cantidad, double precioCosto) {
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
    }

//    public DetalleCompra(int i, int i0, int i1, String string, int i2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "idDetalle=" + idDetalle + ", cantidad=" + cantidad + ", precioCosto=" + precioCosto + ", compra=" + compra + ", producto=" + producto + '}';
    }
}
