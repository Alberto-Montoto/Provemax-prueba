/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import provemax74.AccesoADatos.CompraData;
import provemax74.AccesoADatos.DetalleCompraData;
import provemax74.AccesoADatos.ProductoData;
import provemax74.AccesoADatos.ProveedorData;
import provemax74.Entidades.Compra;
import provemax74.Entidades.Producto;
import provemax74.Entidades.Proveedor;

/**
 *
 * @author maria
 */
public class GestionDeDetalle extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionDeDetalle
     */
    CompraData compDat = new CompraData();
    DetalleCompraData detalle = new DetalleCompraData();
    Compra compra = new Compra();
    Producto produ = new Producto();
    ProductoData prodDat = new ProductoData();
    Proveedor prove = new Proveedor();
    ProveedorData proveDat = new ProveedorData();
    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }

    };
    DefaultTableModel model2 = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }

    };

    public GestionDeDetalle() {
        initComponents();
        armarCabecera();
        armarCabecera2();
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Formatear la fecha en un formato deseado (por ejemplo, "dd/MM/yyyy")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        // Establecer la fecha formateada en el JLabel
        jLFecha.setText(fechaFormateada);

        double sumaTotal = 0.0;

        // Itera a través de las filas de la segunda tabla y suma los valores en la cuarta columna
        for (int i = 0; i < model2.getRowCount(); i++) {
            double total = (Double) model2.getValueAt(i, 3);
            sumaTotal += total;
            System.out.println(sumaTotal);
        }

        // Muestra la suma total en un JLabel
        jLTotal.setText(String.format("%.2f", sumaTotal)); // Formatea el número con dos decimales

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTProducto = new javax.swing.JTextField();
        jTCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCompra = new javax.swing.JTable();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBFinalizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaProductos = new javax.swing.JTable();
        jLFecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTProveedor = new javax.swing.JTextField();
        jBContinuar = new javax.swing.JButton();
        jLTotal = new javax.swing.JLabel();

        jLabel1.setText("Detalle de Compra");

        jLabel2.setText("Producto:");

        jLabel3.setText("Cantidad:");

        jLabel4.setText("Costo total:  $");

        jTProducto.setEnabled(false);
        jTProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProductoKeyReleased(evt);
            }
        });

        jTCantidad.setEnabled(false);
        jTCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCantidadActionPerformed(evt);
            }
        });

        jTCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTCompra);

        jBAgregar.setText("Agregar");
        jBAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBAgregarMouseClicked(evt);
            }
        });
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBFinalizar.setText("Finalizar Compra");
        jBFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFinalizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha de Compra:");

        jTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaProductos);

        jLFecha.setText("Fecha de hoy");

        jLabel6.setText("ID Proveedor:");

        jBContinuar.setText("Continuar");
        jBContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(44, 44, 44)
                                        .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 647, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jBAgregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBEliminar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBFinalizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(41, 41, 41)
                        .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(122, 122, 122)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jTProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(70, 70, 70)
                                            .addComponent(jBContinuar))
                                        .addComponent(jTProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBContinuar))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBAgregar)
                        .addComponent(jBEliminar)
                        .addComponent(jBFinalizar)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCantidadActionPerformed

    private void jTProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProductoKeyReleased
        // TODO add your handling code here:
        borrarFilas();
        TreeSet<Producto> producto = prodDat.listaDeProductos();
        for (Producto prod : producto) {
            if (prod.getNombreProducto().toLowerCase().startsWith(jTProducto.getText().toLowerCase())) {

                model.addRow(new Object[]{
                    prod.getNombreProducto(),
                    prod.getDescripcion(),
                    prod.getPrecioActual(),
                    prod.getStock()
                });
            }
        }
        jTCantidad.setEnabled(false);

    }//GEN-LAST:event_jTProductoKeyReleased

    private void jTablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProductosMouseClicked
        // TODO add your handling code here:

        int filaS = jTablaProductos.getSelectedRow();
        jTCantidad.setEnabled(true);

        if (filaS != -1) {

            Producto nuevoProducto = new Producto();
            // Agregar el nuevo producto a una lista de productos
            List<Producto> listaDeProductos = new ArrayList<>();
            listaDeProductos.add(nuevoProducto);
        }

    }//GEN-LAST:event_jTablaProductosMouseClicked

    private void jBAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAgregarMouseClicked
        // TODO add your handling code here:

        //Cargar Compra//
        try {
            int filaSeleccionada = jTablaProductos.getSelectedRow();

            double datoColumna3 = Double.parseDouble(jTablaProductos.getValueAt(filaSeleccionada, 3).toString());
            double valorDeTextField = Double.parseDouble(jTCantidad.getText());
            if (valorDeTextField <= datoColumna3) {
                
                //Bajar stock de productos
                // Obtener el valor del JLabel (jTCantidad)
                String cantidadStr = jTCantidad.getText();
                int cantidad = Integer.parseInt(cantidadStr); // Convierte a un valor numérico si es necesario

                // Obtener datos de la fila seleccionada en la JTable
                if (filaSeleccionada >= 0) {
                    String producto = jTablaProductos.getValueAt(filaSeleccionada, 0).toString();
                    String descripcion = jTablaProductos.getValueAt(filaSeleccionada, 1).toString();
                    double precio = Double.parseDouble(jTablaProductos.getValueAt(filaSeleccionada, 2).toString());
                    int stock = Integer.parseInt(jTablaProductos.getValueAt(filaSeleccionada, 3).toString());

                    // Llama al método para actualizar el stock
                    prodDat.actualizarStockMenos(cantidad, producto, descripcion, precio, stock);
                } else {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una fila en la JTable.");
                }

            } else {
                // Muestra un mensaje de error si el valor ingresado es mayor
                JOptionPane.showMessageDialog(null, "El valor ingresado supera el stock dispoible", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos de entrada");
        }

        try {

            int filaSeleccionada = jTablaProductos.getSelectedRow();

            if (filaSeleccionada != -1) {
                // Supongamos que deseas obtener datos de las columnas 0 y 2
                String datoColumna0 = jTablaProductos.getValueAt(filaSeleccionada, 0).toString();
                double datoColumna2 = Double.parseDouble(jTablaProductos.getValueAt(filaSeleccionada, 2).toString());
                double datoColumna3 = Double.parseDouble(jTablaProductos.getValueAt(filaSeleccionada, 3).toString());

                // Obtén el valor del JTextField
                double valorDeTextField = Double.parseDouble(jTCantidad.getText());

                // Verifica si el valor del JTextField es menor o igual al valor de la columna 2
                if (valorDeTextField <= datoColumna3) {
                    // Realiza el cálculo
                    double resultado = valorDeTextField * datoColumna2;

                    // Formatea los valores para mostrar dos dígitos después de la coma
                    String datoColumna2Formateado = String.format("%.2f", datoColumna2);
                    String valorDeTextFieldFormateado = String.format("%.2f", valorDeTextField);
                    String resultadoFormateado = String.format("%.2f", resultado);

                    // Agrega una fila a la segunda tabla
                    DefaultTableModel model2 = (DefaultTableModel) jTCompra.getModel();
                    model2.addRow(new Object[]{datoColumna0, valorDeTextFieldFormateado, datoColumna2Formateado, resultadoFormateado});

                    jTCantidad.setText("");
                    jTCantidad.setEnabled(false);
                    jTProducto.setText("");
                    borrarFilas();

                }
            } else {
                // Manejo si no se selecciona ninguna fila
                System.out.println("No se ha seleccionado ninguna fila.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número");
            jTCantidad.setText("");
        }

        double sumaTotal = 0.0;

// Itera a través de las filas de la segunda tabla y suma los valores en la cuarta columna
        for (int i = 0; i < model2.getRowCount(); i++) {
            String totalStr = model2.getValueAt(i, 3).toString();
            totalStr = totalStr.replace(",", "."); // Reemplaza la coma por un punto si es necesario
            try {
                double total = Double.parseDouble(totalStr);
                sumaTotal += total;
            } catch (NumberFormatException e) {
                // Maneja valores no válidos o errores de conversión
                JOptionPane.showMessageDialog(this, "El valor en la fila " + (i + 1) + " no es un número válido.");
            }
        }

// Muestra la suma total en un JLabel
        jLTotal.setText("Total: " + String.format("%.2f", sumaTotal)); // Formatea el número con dos decimales


    }//GEN-LAST:event_jBAgregarMouseClicked

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBContinuarActionPerformed
        // TODO add your handling code here:
        try {
            String idProveedorTexto = jTProveedor.getText();

            // Intentar convertir el texto en un valor numérico (el ID)
            int idProveedor = Integer.parseInt(idProveedorTexto);

            // Realizar la búsqueda en la base de datos
            Proveedor proveedor = proveDat.buscarProveedorPorId(idProveedor);

            if (proveedor != null) {
                jTProducto.setEnabled(true);
                jTProveedor.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No existe un proveedor con ese ID.");
                jTProveedor.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID de proveedor ingresado no es válido.");
        }
    }//GEN-LAST:event_jBContinuarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int selectedRow = jTCompra.getSelectedRow();

        //Agregar stock
        if (model2.getRowCount() > 0 && selectedRow >= 0 && selectedRow < model2.getRowCount()) {
            // Verifica si la fila seleccionada tiene al menos dos columnas
            DefaultTableModel model = (DefaultTableModel) jTCompra.getModel();
            int columnCount = model.getColumnCount();

            if (columnCount >= 2) {
                // La fila tiene al menos dos columnas
                String producto = jTCompra.getValueAt(selectedRow, 0).toString();
                String valorStr = jTCompra.getValueAt(selectedRow, 1).toString();
                valorStr = valorStr.replace(",", "."); // Reemplaza la coma por un punto
                double cantidad = Double.parseDouble(valorStr);

                // Realiza la eliminación y actualización del stock
                prodDat.actualizarStockMas(cantidad, producto);

                // Remueve la fila de la tabla
                model.removeRow(selectedRow);

                restarValorEliminado(model2, selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "La fila seleccionada no contiene suficientes columnas para eliminar.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
        }

        if (model2.getRowCount() >= 0) { // Verifica si se ha seleccionado una fila
            // Extrae los datos de la fila seleccionada
            int idCliente = Integer.parseInt(jTProveedor.getText());
            LocalDate localDate = LocalDate.now();
            Date sqlDate = Date.valueOf(localDate);

            // Llama al método para eliminar la compra
            compDat.eliminarCompraVista(idCliente, sqlDate);

            // Actualiza la JTable después de la eliminación
            DefaultTableModel model = (DefaultTableModel) jTCompra.getModel();
            model.removeRow(selectedRow);

        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar por fecha.");
        }

    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFinalizarActionPerformed
        // TODO add your handling code here:
        String fechaTexto = jLFecha.getText(); // Obtener el texto del JLabel que contiene la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de la fecha
        LocalDate fecha = LocalDate.parse(fechaTexto, formatter); // Convertir el texto en LocalDate

        // Obtener el ID del proveedor del JTextField 
        int idProveedor = Integer.parseInt(jTProveedor.getText());

        // Crear una instancia de Compra
        Compra nuevaCompra = new Compra();
        nuevaCompra.setFecha(fecha);

        // Crear una instancia de Proveedor y asignarle el ID
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(idProveedor);
        nuevaCompra.setProveedor(proveedor);

        // Llamar al método para agregar la compra
        compDat.agregarCompra(nuevaCompra);
        int num = nuevaCompra.getIdCompra();

        double sumaTotal = 0.0;
        double totalCantidad = 0;
        double totalPrecioCosto = 0.0;

        // Sumar valores de la JTable (suponiendo que la JTable tiene dos columnas para cantidad y precio)
        for (int i = 0; i < model2.getRowCount(); i++) {
            String totalStr = model2.getValueAt(i, 3).toString();
            totalStr = totalStr.replace(",", "."); // Reemplaza la coma por un punto
            try {
                double total = Double.parseDouble(totalStr);
                sumaTotal += total;
            } catch (NumberFormatException e) {
                // Maneja valores no válidos o errores de conversión
                JOptionPane.showMessageDialog(this, "El valor en la fila " + (i + 1) + " no es un número válido.");
            }
        }

        // Ahora, itera a través de las filas de la tabla jTCompra
        for (int i = 0; i < jTCompra.getRowCount(); i++) {
        totalCantidad += Double.parseDouble(jTCompra.getValueAt(i, 1).toString().replace(",", "."));
        totalPrecioCosto += Double.parseDouble(jTCompra.getValueAt(i, 3).toString().replace(",", "."));


        }
       int filaSeleccionada = jTablaProductos.getSelectedRow();
    Producto producto = new Producto();
    
    if (filaSeleccionada >= 0) {
        String nombreProducto = jTablaProductos.getValueAt(filaSeleccionada, 0).toString();
        String descripcion = jTablaProductos.getValueAt(filaSeleccionada, 1).toString();
        double precioActual = Double.parseDouble(jTablaProductos.getValueAt(filaSeleccionada, 2).toString());
        producto =prodDat.obtenerProductoPorNombre(nombreProducto, descripcion, precioActual);
        int nume = producto.getIdProducto();
       int idProd = prodDat.obtenerProducto(nume).getIdProducto();
       
       detalle.cargarDetalle(totalCantidad, sumaTotal, num, idProd);
       JOptionPane.showMessageDialog(this, "Su detalle se ha cargado");
    }
       

       
       

//cantidad	
//precioCosto	
//idProducto	
//idCompra
    
    }//GEN-LAST:event_jBFinalizarActionPerformed

    private void armarCabecera() {
        model.addColumn("Producto");
        model.addColumn("Descripción");
        model.addColumn("Precio");
        model.addColumn("Stock");
        jTablaProductos.setModel(model);
    }

    private void armarCabecera2() {
        model2.addColumn("Producto");
        model2.addColumn("Cantidad");
        model2.addColumn("Precio unitario");
        model2.addColumn("Total");
        jTCompra.setModel(model2);
    }

    private void borrarFilas() {
        int fila = jTablaProductos.getRowCount() - 1;
        for (int f = fila; f >= 0; f--) {

            model.removeRow(f);
        }
    }

    private void restarValorEliminado(DefaultTableModel model, int filaEliminada) {
        String totalStr = model.getValueAt(filaEliminada, 3).toString();
        totalStr = totalStr.replace(",", "."); // Reemplaza la coma por un punto si es necesario
        try {
            double total = Double.parseDouble(totalStr);
            double sumaTotalActual = Double.parseDouble(jLTotal.getText().replace("Total: ", "").replace(",", "."));
            sumaTotalActual -= total;
            jLTotal.setText("Total: " + String.format("%.2f", sumaTotalActual));
        } catch (NumberFormatException e) {
            // Maneja valores no válidos o errores de conversión
            JOptionPane.showMessageDialog(this, "El valor en la fila " + (filaEliminada + 1) + " no es un número válido.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBContinuar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBFinalizar;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCantidad;
    private javax.swing.JTable jTCompra;
    private javax.swing.JTextField jTProducto;
    private javax.swing.JTextField jTProveedor;
    private javax.swing.JTable jTablaProductos;
    // End of variables declaration//GEN-END:variables
}