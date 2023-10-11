package provemax74.Entidades;


import java.time.LocalDate;

public class Compra {

    private int idCompra;

    private Proveedor proveedor;
    
    private DetalleCompra detalleCompra;

    public Compra(int idCompra, Proveedor proveedor, LocalDate fecha, DetalleCompra detalleCompra) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.detalleCompra = detalleCompra;
    }

    public Compra() {
    }



    public DetalleCompra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }
    

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    private LocalDate fecha;

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", proveedor=" + proveedor + ", detalleCompra=" + detalleCompra + ", fecha=" + fecha + '}';
    }

  
    
    
}
