
package provemax74.AccesoADatos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import java.sql.*;
//import java.sql.DriverManager;


public class Conexion {
    
private static final String URL="jdbc:mariadb://localhost/";
private static final String DB="provemax74";
private static final String USUARIO="root";
private static final String PASSWORD="";
private static Connection connection;

private Conexion(){}

public static Connection getConexion(){
if(connection==null){
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
    //    JOptionPane.showMessageDialog(null,"Funciona todo");
        
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "No se cargaron los drivers");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "No se conecto a la base de datos");
    }
}
    return connection;
}
}
