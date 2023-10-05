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
import javax.swing.JOptionPane;
import provemax74.Entidades.Compra;

/**
 *
 * @author maria
 */
public class CompraData {
    
    private Connection con = null;
//
//    public CompraData() {
//
//        con = Conexion.getConexion();
//    }
//    
//    //buscarCompraPorID
//    public Compra buscarCompraPorId(int idCompra) {
//        Compra compra = new Compra();
//        
//        String sql =  "SELECT * from compra WHERE idCompra = ?";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idCompra);
//            
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs.next()){
//                compra.setIdCompra(rs.getInt("idCompra"));
//                compra.setProveedor(provData.buscarProveedorPorId(rs.getInt("idProveedor")));
//                compra.setFecha(rs.getDate("fecha").toLocalDate());
//                
//            }else {
//                JOptionPane.showMessageDialog(null, "No existe una compra con el ID " + idCompra);
//            }
//            ps.close();
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla Compra");
//        }
//        return compra;
//    }
//    
}
