/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modificable;

import java.time.LocalDate;
import org.mariadb.jdbc.Connection;
import provemax74.AccesoADatos.CompraData;
import provemax74.AccesoADatos.Conexion;
import provemax74.AccesoADatos.DetalleCompraData;
import provemax74.AccesoADatos.ProductoData;
import provemax74.AccesoADatos.ProveedorData;
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

//        DetalleCompra detalle = new DetalleCompra(2, 7, pro); //2, 56, pro.getPrecioActual(), pro.getIdProducto(), pro.getNombreProducto()
        DetalleCompraData detalleData = new DetalleCompraData();

//        DetalleCompra detalle = detalleData.buscarDetalle1(6);

        DetalleCompra detalle = new DetalleCompra(5, 7, pro);

        Proveedor proveedor3 = new Proveedor(8, "Humberto Primo", "Electro Mar", "Av Colón 967", "45678979");
        ProveedorData provedat = new ProveedorData();

//        provedat.guardarProveedor(proveedor3);

        CompraData comdat = new CompraData();

//        Compra compra = new Compra(1, proveedor3, LocalDate.now(), detalle);

//        comdat.nuevaCompra(compra);
//        comdat.eliminarCompra(23);
        comdat.buscarCompra(22);
        System.out.println("detalle " + comdat.buscarCompra(22).getIdCompra());
        System.out.println("detalle " + comdat.buscarCompra(22).getFecha());
        System.out.println("detalle " + comdat.buscarCompra(22).getProveedor());
        System.out.println("detalle " + comdat.buscarCompra(22).getDetalleCompra());



//        for (Compra comp: comdat.listarCompra()) {
//            
//       
//        System.out.println("IdCompra - "+ comp.getIdCompra());
//        System.out.println("Fecha - " + comp.getFecha());
//        System.out.println("idProveedor - " + comp.getProveedor().getIdProveedor());
//        System.out.println("idDelalle - " + comp.getDetalleCompra());
//            System.out.println("-----------------");
//        }
        
        
        
        
//        detalleData.guardarDetalle(detalle);
//        detalleData.borrarDetalle(3);
//        detalleData.modificarDetalle(detalle);
        
        
        //////metodo agregarProducto//////
//                                  idpro/nombreP/descrip/precioAct/Stok/estado
//        Producto arroz = new Producto(111, "azucar", "morena", 123, 50, true);
//        ProductoData pro = new ProductoData(con);

//        Producto arroz = new Producto(333, "azucar", "morena", 123, 50, true);
//        ProductoData pro = new ProductoData(con);
//        pro.agregarProducto(arroz);

        //////metodo eliminarProducto////// 
        //  pro.eliminarProducto(333);
        
        //////metodo modificarProducto////// 
        //   pro.modificarProducto(arroz);
        
        //////metodo obtenerProducto////// 
//              Producto obtenerProducto =pro.obtenerProducto(111);
//               if (obtenerProducto!=null) {    
//        System.out.println("nombreProducto " + obtenerProducto.getNombreProducto());
//        System.out.println("descripcion "+ obtenerProducto.getDescripcion());
//        }

        //////metodo listarProductos////// 
//                 for (Producto producto: pro.listarProducotos()) {
//            System.out.println("idProducto: " + producto.getIdProducto());
//            System.out.println("nombreProducto: " + producto.getNombreProducto());
//            System.out.println("descripcion: " + producto.getDescripcion());
//            System.out.println("precioActual: " + producto.getPrecioActual());
//            System.out.println("stock: " + producto.getStock());
//            System.out.println("------------------------------");
//        } 

        //////metodo listarProductosStockMinimo////// 
//          int stockMinimo = 10; 
//          List<Producto> productos = pro.listarProductosStockMinimo(stockMinimo);
        

        


    }
}
