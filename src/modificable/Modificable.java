/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modificable;

import org.mariadb.jdbc.Connection;
import provemax74.AccesoADatos.CompraData;
import provemax74.AccesoADatos.Conexion;
import provemax74.AccesoADatos.DetalleCompraData;
import provemax74.AccesoADatos.ProductoData;
import provemax74.Entidades.Compra;
import provemax74.Entidades.DetalleCompra;
import provemax74.Entidades.Producto;
import provemax74.Entidades.Proveedor;

/**
 *
 * @author maria
 */
public class Modificable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Producto prod = new Producto(222, "fideos", "tirabuzon", 200, 100, true); //
        
        ProductoData prodat = new ProductoData();
//        prodat.obtenerProducto(1);
        
        Producto pro = prodat.obtenerProducto(111);
        
        DetalleCompra detalle = new DetalleCompra(3, 500, pro.getIdProducto(), pro.getNombreProducto());
        DetalleCompraData detalleData = new DetalleCompraData();
        
        detalleData.guardarDetalle(detalle);
    }
}
