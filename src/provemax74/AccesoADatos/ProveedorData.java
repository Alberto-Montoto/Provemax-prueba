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
import provemax74.Entidades.Compra;
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

        String sql = "INSERT INTO proveedor(nombreCompleto, razonSocial,domicilio,telefono)"
                + "VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,proveedor.getNombreCompleto());
            ps.setString(2,proveedor.getRazonSocial());
            ps.setString(3,proveedor.getDomicilio());
            ps.setString(4,proveedor.getTelefono());
                  
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
        String sql = "UPDATE proveedor SET nombreCompleto=?,razonSocial=?,domicilio=?,telefono=?"
                + "WHERE idProveedor=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, proveedor.getNombreCompleto());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getDomicilio());
            ps.setString(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getIdProveedor());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Proveedor modificado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor" + ex.getMessage());
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
    
    public Proveedor buscarProveedor(int id) {
        Proveedor proveedor = null;
        try {
            String busqueda = "SELECT * FROM proveedor WHERE idProveedor = ? ";
            
            PreparedStatement ps = con.prepareStatement(busqueda);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(id); // Setea el id que recibe por parametro
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el proveedor.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor. " + ex.getMessage());
        }
        return proveedor;
    }
    
    
    
    
}