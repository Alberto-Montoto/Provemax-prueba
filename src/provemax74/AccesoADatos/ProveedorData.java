/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax74.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import provemax74.Entidades.Producto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import provemax74.Entidades.Proveedor;

/**
 *
 * @author maria
 */
public class ProveedorData {
    
    private Connection con = null;

    public ProveedorData() {

        con = Conexion.getConexion();

    }
    
    public void guardarProveedor(Proveedor proveedor) {

        String sql = "INSERT INTO proveedor(razonSocial,domicilio,telefono)"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,proveedor.getRazonSocial());
            ps.setString(2,proveedor.getDomicilio());
            ps.setString(3,proveedor.getTelefono());
                  
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proveedor guardado");
            }

            ps.close();
  

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el proveedor" + ex.getMessage());
        }

    
}
    
    public void modificarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET razonSocial=?,domicilio=?,telefono=?"
                + "WHERE idProveedor=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getTelefono());
            ps.setInt(4, proveedor.getIdProveedor());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Proveedor modificado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor" + ex.getMessage());
        }
    }
    
        public void RazonSocialModificado(String razonSociall) {
        String sql = "DELETE FROM proveedor WHERE razonSocial = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, razonSociall);

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }

    }

    public void eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedor WHERE idProveedor=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            
            int exito = ps.executeUpdate(); //ps.executeUpdate() se hace 1 si encuentra una fila a modificar
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El proveedor ha sido eliminado");
            }else {
                JOptionPane.showMessageDialog(null, "El proveedor no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor" + ex.getMessage());
        }
    }
    
    public void eliminarProveedorPorRazonSocial(String razonSocial) {
        String sql = "DELETE FROM proveedor WHERE razonSocial = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, razonSocial);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El proveedor ha sido eliminado");
            } else {             
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor" + ex.getMessage());
        }
    }


    public Proveedor buscarProveedor(int id) {
        
        String sql="SELECT razonSocial, domicilio, telefono FROM proveedor WHERE idProveedor=?";
        
        Proveedor proveedor=null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                proveedor =new Proveedor();
                
                proveedor.setIdProveedor(id);
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
            
            } else {
                
                JOptionPane.showMessageDialog(null, "No existe un proveedor con ese ID");
            }
            
            ps.close();   
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor");
        }
        
        return proveedor;
    }
    
    
    public List<Proveedor> listarProveedor() {
        List<Proveedor> proveedores = new ArrayList<>();

        String sql = "SELECT idProveedor, razonSocial, domicilio, telefono FROM proveedor ";

        try (PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                pro.setIdProveedor(rs.getInt("idProveedor"));
                pro.setRazonSocial(rs.getString("razonSocial"));
                pro.setDomicilio(rs.getString("domicilio"));
                pro.setTelefono(rs.getString("telefono"));
                
                 proveedores.add(pro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto"+ ex.getMessage());
        }
        return proveedores;
    }
    
public int obtenerIdProveedorPorRazonSocial(String razonSocial) {
    int idProveedor = -1; // Valor predeterminado en caso de no encontrar el proveedor

    try {
        String query = "SELECT idProveedor FROM proveedor WHERE razonSocial = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, razonSocial);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            idProveedor = resultSet.getInt("idProveedor");
        }

        statement.close();
    } catch (SQLException e) {
        // Maneja cualquier excepción de SQL aquí
        e.printStackTrace();
    }

    return idProveedor;
}

     public Proveedor buscarProveedorPorId(int id) {
        
        String sql="SELECT idProveedor FROM proveedor WHERE idProveedor=?";
        
        Proveedor proveedor=null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
             
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                proveedor =new Proveedor();
                
                proveedor.setIdProveedor(id);

            }
            
            ps.close();   
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor" + ex.getMessage());
        }
        
        return proveedor;
    }
  
}  



