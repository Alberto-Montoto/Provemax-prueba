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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemax74.Entidades.Producto;

/**
 *
 * @author maria
 */
public class ProductoData {
    private Connection con;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    public Connection getCon() {
        return con;
    }
//    
//    public Producto buscarProductoPorId(int idProducto) {
//        Producto producto = new Producto();
//        
//        String sql =  "SELECT * from producto WHERE idProducto = ?";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idProducto);
//            
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs.next()){
//                producto.setIdProducto(rs.getInt("idProducto"));
//                producto.setNombre(rs.getString("nombre"));
//                producto.setDescripcion(rs.getString("descripcion"));
//                producto.setPrecioActual(rs.getDouble("precioActual"));
//                producto.setStock(rs.getInt("stock"));
//                producto.setEstado(rs.getBoolean("estado"));
//                producto.setStockMinimo(rs.getInt("stockMinimo"));
//            }else {
//                JOptionPane.showMessageDialog(null, "No existe un producto con el ID " + idProducto);
//            }
//            ps.close();
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
//        }
//        return producto;
//    }
//    
//    public List<Producto> buscarProductoPorNombreCompleto(String nombre) {
//        
//        ArrayList<Producto> listaProductos = new ArrayList<>();
//        String sql =  "SELECT * from producto WHERE nombre = ?";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, nombre);
//            
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()){
//                Producto producto = new Producto();
//                producto.setIdProducto(rs.getInt("idProducto"));
//                producto.setNombre(rs.getString("nombre"));
//                producto.setDescripcion(rs.getString("descripcion"));
//                producto.setPrecioActual(rs.getDouble("precioActual"));
//                producto.setStock(rs.getInt("stock"));
//                producto.setEstado(rs.getBoolean("estado"));
//                producto.setStockMinimo(rs.getInt("stockMinimo"));
//                
//                listaProductos.add(producto);
//            }
//            ps.close();
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Producto");
//        }
//        return listaProductos;
//    }
//    
    
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
    
    public Producto obtenerProducto(int id) {
        String sql = "SELECT nombreProducto, descripcion, precioActual, stock FROM producto WHERE idProducto=? AND estado = 1 ";
        Producto producto = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id);
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe un producto con ese ID");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto desde obtenerProducto");
        }
        return producto;
    }
}