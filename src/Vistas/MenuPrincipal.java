/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author maria
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuBar1.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jMenu1.setBackground(new java.awt.Color(204, 255, 255));
        jMenu1.setForeground(new java.awt.Color(0, 0, 153));
        jMenu1.setText("  Productos  ");
        jMenu1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(204, 255, 255));
        jMenuItem1.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem1.setText("Registor de productos");
        jMenu1.add(jMenuItem1);

        jMenuItem5.setBackground(new java.awt.Color(204, 255, 255));
        jMenuItem5.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem5.setText("Productos mas vendidos");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setBackground(new java.awt.Color(204, 255, 255));
        jMenu3.setForeground(new java.awt.Color(0, 0, 153));
        jMenu3.setText("  Proveedores");
        jMenu3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        jMenuItem3.setBackground(new java.awt.Color(204, 255, 255));
        jMenuItem3.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem3.setText("Administrar proveedores");
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu2.setBackground(new java.awt.Color(204, 255, 255));
        jMenu2.setForeground(new java.awt.Color(0, 0, 153));
        jMenu2.setText("  Compras  ");
        jMenu2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        jMenuItem2.setBackground(new java.awt.Color(204, 255, 255));
        jMenuItem2.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem2.setText("Compras a proveedores");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setBackground(new java.awt.Color(204, 255, 255));
        jMenuItem4.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem4.setText("Compras por fecha");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu4.setBackground(new java.awt.Color(204, 255, 255));
        jMenu4.setForeground(new java.awt.Color(0, 0, 153));
        jMenu4.setText("  Detalles de compra  ");
        jMenu4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        jMenuItem9.setBackground(new java.awt.Color(204, 255, 255));
        jMenuItem9.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem9.setText("Cantidad de compras realizadas");
        jMenu4.add(jMenuItem9);

        jMenuItem8.setBackground(new java.awt.Color(204, 255, 255));
        jMenuItem8.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem8.setText("Ultimos productos vendidos");
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(204, 255, 255));
        jMenu5.setForeground(new java.awt.Color(0, 0, 153));
        jMenu5.setText("  Salir  ");
        jMenu5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
