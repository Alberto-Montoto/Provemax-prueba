package provemax74.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import provemax74.Entidades.Producto;
import provemax74.Entidades.Proveedor;

public class ProductoData {

//    private Connection con = null;
//
//    public ProductoData(Connection conexion) {
//
//        con = Conexion.getConexion();
//    }
    private Connection con;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    public Connection getCon() {
        return con;
    }
    

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////// agregar un producto a la base de datos 
    public void agregarProducto(Producto producto) {

        String sql = "INSERT INTO Producto (idProducto, NombreProducto, Descripcion, PrecioActual, Stock, estado ) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, producto.getIdProducto());
            ps.setString(2, producto.getNombreProducto());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecioActual());
            ps.setInt(5, producto.getStock());
            ps.setBoolean(6, producto.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "producto guardado");
            }

            ps.close();

        } catch (SQLException ex) {
            // Manejo de excepciones en caso de error
            JOptionPane.showMessageDialog(null, "Error al guardar el producto" + ex.getMessage());
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////// metodo eliminar un producto por id
    public void eliminarProducto(int id) {
        String sql = "UPDATE producto set estado = 0 WHERE idProducto=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El producto ha sido eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());

        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////// metodomodificar un producto

    public void modificarProducto(Producto producto) {
        String sql = "UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=?, estado=? "
                + " WHERE idproducto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "producto modificado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto desde el metodo modificarProducto" + ex.getMessage());
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////// metodo obtener un producto

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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////// metodo listar los productos 
    public List<Producto> listarProducotos() {

        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto WHERE estado = 1 ";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getNString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);

                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }
        return productos;

    }
    
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////// metodo listar los productos del stock minimo  
    public List<Producto> listarProductosStockMinimo(int stockMinimo) {
        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto WHERE estado = 1 AND stock < ?";
        ArrayList<Producto> productos = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, stockMinimo);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setNombreProducto(rs.getString("nombreProducto"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecioActual(rs.getDouble("precioActual"));
                    producto.setStock(rs.getInt("stock"));
                    producto.setEstado(true);

                    productos.add(producto);

                    System.out.println("Producto agregado al stock minimo: " + producto.getNombreProducto());
                    System.out.println("idProducto: " + producto.getIdProducto());
                    System.out.println("descripcion: " + producto.getDescripcion());
                    System.out.println("precioActual: " + producto.getPrecioActual());
                    System.out.println("stock: " + producto.getStock());
                    System.out.println("------------------------------");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Agrega esto para ver si hay excepciones no manejadas
        }

        return productos;
    }
    
    
    public List<Producto> listarProducotosPorFecha(Date date) {

        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto WHERE estado = 1 ";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getNString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);

                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }
        return productos;

    }
    
    
    

}
