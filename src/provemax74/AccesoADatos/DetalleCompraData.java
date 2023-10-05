/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax74.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemax74.Entidades.Compra;
import provemax74.Entidades.DetalleCompra;
import provemax74.Entidades.Producto;

/**
 *
 * @author maria
 */
public class DetalleCompraData {
    
       private Connection con = null;
       private CompraData compraData = new CompraData();
       private ProductoData prodData = new ProductoData();
       private DetalleCompra detalleData = new DetalleCompra();
       
    public DetalleCompraData() {

        con = Conexion.getConexion();
    }
    
    
    
    //Guardar Detalle
    public void guardarDetalle(DetalleCompra detalle){
        String sql =  "INSERT INTO detallecompra (cantidad, precioCosto, nombreProducto, idProducto)"//
                + "VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioCosto()* detalle.getCantidad());
//            JOptionPane.showMessageDialog(null, detalle.getNombreProducto());
            ps.setString(3, detalle.getNombreProducto());
            ps.setInt(4, detalle.getIdProducto());
            ps.executeUpdate();
            
            ResultSet rs =  ps.getGeneratedKeys();
            
            if (rs.next()) {
                detalle.setIdDetalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle agregado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
    }
    
    //Borrar Detalle
    public void borrarDetalle(int idDetalle) {
        String sql =  "DELETE FROM detallecompra WHERE idDetalle = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idDetalle);
            
            int borrado = ps.executeUpdate();
                                   
            if (borrado == 1) {
               JOptionPane.showMessageDialog(null, "Detalle borrado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
    }
    
    
    //Modificar Detalle
    public void modificarDetalle(DetalleCompra detalle) {
        String sql = "UPDATE detallecompra SET cantidad = ?, precioCosto = ?, nombreProducto = ?,"
                + " idProducto = ? WHERE idDetalle = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecioCosto());
            ps.setString(3, detalle.getProducto().getNombreProducto());
            ps.setInt(4, detalle.getProducto().getIdProducto());
            
            
            int modificado = ps.executeUpdate();
                                   
            if (modificado == 1) {
               JOptionPane.showMessageDialog(null, "Detalle modificado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla DetalleCompra");
        }
        
    }
    
    
    
   

    
    
    public DetalleCompra buscarDetalle1(int idDetalle) {
        String sql = "SELECT cantidad, precioCosto, idProducto FROM detallecompra WHERE idDetalleCompra = ?";
        DetalleCompra detalleCompra = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idDetalle);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            detalleCompra = new DetalleCompra();
            detalleCompra.setIdDetalle(idDetalle);
            detalleCompra.setCantidad(rs.getInt("cantidad"));
            detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));
            
            // Aquí necesitas obtener el idProducto del resultado y luego buscar el producto correspondiente
            int idProducto = rs.getInt("idProducto");
            Producto producto = buscarProductoPorId(idProducto); // Debes implementar este método
            detalleCompra.setProducto(producto);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese detalle de compra");
        }
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder al detalle de compra");
    }
    return detalleCompra;
}

    public Producto buscarProductoPorId(int idProducto) {
    String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE idProducto = ?";
    Producto producto = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idProducto);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            producto = new Producto();
            producto.setIdProducto(idProducto);
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecioActual(rs.getDouble("precioActual"));
            producto.setStock(rs.getInt("stock"));
            producto.setEstado(rs.getBoolean("estado"));
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese producto");
        }
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar el producto por ID: " + ex.getMessage());
    }
    return producto;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<DetalleCompra> listarDetalleCompra(){
        
        String sql = "SELECT idDetalle, cantidad, precioCosto, codigo FROM detalleCompra WHERE estado = 1";
        ArrayList<DetalleCompra> detalleCompras=new ArrayList<>();
        
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalle(rs.getInt("idDetalle"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));
                
                detalleCompras.add(detalleCompra);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al detalle de compra");
        }
            return detalleCompras;
        
    }

   
    
}
