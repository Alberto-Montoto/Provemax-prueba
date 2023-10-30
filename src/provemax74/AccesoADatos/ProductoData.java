package provemax74.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import provemax74.Entidades.Producto;
import provemax74.Entidades.Proveedor;
import provemax74.Entidades.Compra;

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
            ps.setBoolean(6, producto.estado());

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
            ps.setBoolean(5, producto.estado());
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
                producto.setestado(true);
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
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setestado(true);

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
                    producto.setestado(true);

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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////// metodo listar los productos de compra
    public List<Producto> obtenerProductosDeCompra(int idCompra) throws SQLException {
        List<Producto> productosDeCompra = new ArrayList<>();

        // Consulta SQL para obtener los productos de una compra en particular.
        String sql = "SELECT p.idProducto, p.nombreProducto, p.descripcion, p.precioActual, p.stock "
                + "FROM Producto p "
                + "INNER JOIN detalleCompra dc ON p.idProducto = dc.idProducto "
                + "WHERE dc.idCompra = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCompra);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setNombreProducto(rs.getString("nombreProducto"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecioActual(rs.getDouble("precioActual"));
                    producto.setStock(rs.getInt("stock"));

                    productosDeCompra.add(producto);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de excepciones en caso de un error SQL.
        }

        return productosDeCompra;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////// metodo listar los productos de ultima compra

    public int obtenerIdUltimaCompra() throws SQLException {
        String sql = "SELECT idCompra FROM Compra ORDER BY fecha DESC LIMIT 1";

        try (PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("idCompra");
            } else {
                // No se encontraron compras en la base de datos.
                return -1; // O cualquier otro valor que indique que no hay compras.
            }
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////METODOS NUEVOS QUE AGREGUE////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void eliminarProductoPorNombre(String nombreProducto) {
        String sql = "DELETE FROM producto WHERE nombreProducto = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreProducto);

            ps.executeUpdate();
//        int exito = ps.executeUpdate();
//        if (exito == 0) {
//            JOptionPane.showMessageDialog(null, "El producto se ha eliminado");
//        } else {
            JOptionPane.showMessageDialog(null, "El producto se ha eliminado");
//        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
    }

    public void agregarProductoSinID(Producto producto) {

        String sql = "INSERT INTO Producto (NombreProducto, Descripcion, PrecioActual, Stock, estado ) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.estado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

//            if (rs.next()) {
//                producto.setIdProducto(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "El producto ha sido guardado");
//            }

            ps.close();

        } catch (SQLException ex) {
            // Manejo de excepciones en caso de error
            JOptionPane.showMessageDialog(null, "Error al guardar el producto" + ex.getMessage());
        }

    }

    public void modificarProductoSinId(Producto producto) {
        String sql = "UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=?, estado=? "
                + " WHERE idproducto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.estado());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El producto se ha modificado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto desde el metodo modificarProducto" + ex.getMessage());
        }
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=?, estado=? WHERE idProducto=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.estado());
//        ps.setInt(6, producto.getIdProducto()); // Asume que tienes un método getIdProducto en la clase Producto

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + ex.getMessage());
        }
    }

    public List<Producto> listarProducotosEstado() {

        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, estado FROM producto ";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setestado(rs.getBoolean("estado")); // Recupera el estado real

                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }
        return productos;

    }

    public void eliminarProductoModificado(String nombreProducto) {
        String sql = "DELETE FROM producto WHERE nombreProducto = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreProducto);

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
    }
    
    public List<Producto> listarProductosPorFecha() { //LocalDate utilDate
//        LocalDate fechaUltimaCompra = obtenerFechaUltimaCompra();

        String sql = "SELECT p.nombreProducto, p.descripcion, p.precioActual, p.stock "
                + "FROM producto p "
                + "JOIN detalleCompra dc ON p.idProducto = dc.idProducto "
                + "JOIN compra c ON dc.idCompra = c.idCompra "
                + "WHERE c.fecha = ?";

        List<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(obtenerFechaInicio()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                productos.add(producto);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }

        return productos;
    }

    public List<Producto> listarProductosDeUltimaCompra() { //LocalDate utilDate
        LocalDate fechaUltimaCompra = obtenerFechaUltimaCompra();

        String sql = "SELECT p.nombreProducto, p.descripcion, p.precioActual, p.stock "
                + "FROM producto p "
                + "JOIN detalleCompra dc ON p.idProducto = dc.idProducto "
                + "JOIN compra c ON dc.idCompra = c.idCompra "
                + "WHERE c.fecha = ?";

        List<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaUltimaCompra));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                productos.add(producto);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }

        return productos;
    }

    public LocalDate obtenerFechaUltimaCompra() {
        LocalDate fechaUltimaCompra = null;

        String sql = "SELECT MAX(fecha) AS ultimaFecha FROM compra";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                fechaUltimaCompra = rs.getDate("ultimaFecha").toLocalDate();
            } //    LocalDate fechaSeleccionada = jdchFecha1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra: " + ex.getMessage());
        }

        return fechaUltimaCompra;
    }

    public Map<Integer, Integer> sumarCantidadProductosCompradosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {

        String sql = "SELECT p.idProducto, SUM(dc.cantidad) AS totalComprado "
                + "FROM producto p "
                + "JOIN detalleCompra dc ON p.idProducto = dc.idProducto "
                + "JOIN compra c ON dc.idCompra = c.idCompra "
                + "WHERE c.fecha BETWEEN ? AND ? "
                + "GROUP BY p.idProducto";

        Map<Integer, Integer> productosComprados = new HashMap<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaInicio));
            ps.setDate(2, Date.valueOf(fechaFin));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                int totalComprado = rs.getInt("totalComprado");
                productosComprados.put(idProducto, totalComprado);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falta ingresar una fecha", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

        return productosComprados;
    }

    
    public List<Producto> listarProductosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
    // Crear la consulta SQL
            String sql = "SELECT p.nombreProducto, p.descripcion, p.precioActual, p.stock, SUM(dc.cantidad) AS totalComprado "
             + "FROM producto p "
             + "JOIN detalleCompra dc ON p.idProducto = dc.idProducto "
             + "JOIN compra c ON dc.idCompra = c.idCompra "
             + "WHERE c.fecha BETWEEN ? AND ? "
             + "GROUP BY p.nombreProducto ";

    List<Producto> productos = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, Date.valueOf(fechaInicio));
        ps.setDate(2, Date.valueOf(fechaFin));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Producto producto = new Producto();
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                productos.add(producto);
        }

        ps.close();
    } catch (SQLException ex) {
        // Manejar errores de SQL
        ex.printStackTrace();
    }

    return productos;
}

    public LocalDate obtenerFechaInicio() {
    LocalDate fechaInicio = null;
    String sql = "SELECT fecha FROM compra";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            fechaInicio = rs.getDate("fecha").toLocalDate();
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la fecha de inicio: " + ex.getMessage());
    }

    return fechaInicio;
}

    public LocalDate obtenerFechaFin() {
    LocalDate fechaFin = null;
    String sql = "SELECT fecha FROM compra";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            fechaFin = rs.getDate("fecha").toLocalDate();
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la fecha de final: " + ex.getMessage());
    }

    return fechaFin;

}
    
    public TreeSet<Producto> listaDeProductos() {

        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto ";
        TreeSet<Producto> productos = new TreeSet<>();

        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));

                productos.add(producto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }
        return productos;

    }
    
    public void actualizarStockMenos(int cantidad, String nombreProducto, String descripcion, double precioActual, int stock) {
    String sql = "UPDATE Producto SET stock = stock - ? WHERE nombreProducto = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, cantidad);
        ps.setString(2, nombreProducto);
        ps.executeUpdate();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el stock del producto");
    }
    
}

    public void actualizarStockMas(double cantidad, String nombreProducto) {
    String sql = "UPDATE Producto SET stock = stock + ? WHERE nombreProducto = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, cantidad);
        ps.setString(2, nombreProducto);
        ps.executeUpdate();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el stock del producto");
    }
    
    }
    
    
    public Producto obtenerProductoPorNombre(String nombreProducto, String descripcion, double precioActual) {
    String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto WHERE nombreProducto = ? AND descripcion = ? AND precioActual = ?";
    Producto producto = null;
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreProducto);
        ps.setString(2, descripcion);
        ps.setDouble(3, precioActual);
        
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            producto = new Producto();
            producto.setIdProducto(rs.getInt("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecioActual(rs.getDouble("precioActual"));
        } else {
            JOptionPane.showMessageDialog(null, "No existe un producto con los criterios especificados.");
        }
        
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto desde obtenerProducto.");
    }
    
    return producto;
}

}

