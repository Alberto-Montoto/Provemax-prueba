package provemax74.Entidades;

public class Proveedor {

    private int idProveedor;
    
    private String nombreCompleto;

    private String razonSocial;

    private String domicilio;
    
    private String telefono;
    
    private Compra compra;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombreCompleto, String razonSocial, String domicilio, String telefono) {
        this.nombreCompleto=nombreCompleto;
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.compra = compra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public Proveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombreCompleto=" + nombreCompleto + ", razonSocial=" + razonSocial + ", domicilio=" + domicilio + ", telefono=" + telefono + ", compra=" + compra + '}';
    }

    
}
