/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author edas
 */
public class Graphics extends javax.swing.JFrame {
    File filename=null;
    LinkedList<Campo>campos=new LinkedList<>();
    /**
     * Creates new form Graphics
     */
    public Graphics() {
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

        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opcion_abrir = new javax.swing.JMenuItem();
        opcion_nuevo = new javax.swing.JMenuItem();
        opcion_salvar = new javax.swing.JMenuItem();
        opcion_cerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jFrame2.setLocationByPlatform(true);
        jFrame2.setSize(new java.awt.Dimension(200, 300));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jList1);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jLabel2);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jFrame2.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Manager");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        jMenu1.setText("archivo");

        opcion_abrir.setText("abrir");
        opcion_abrir.setAlignmentX(0.0F);
        opcion_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion_abrirActionPerformed(evt);
            }
        });
        jMenu1.add(opcion_abrir);

        opcion_nuevo.setText("nuevo");
        opcion_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion_nuevoActionPerformed(evt);
            }
        });
        jMenu1.add(opcion_nuevo);

        opcion_salvar.setText("salvar");
        opcion_salvar.setEnabled(false);
        opcion_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion_salvarActionPerformed(evt);
            }
        });
        jMenu1.add(opcion_salvar);

        opcion_cerrar.setText("cerrar");
        opcion_cerrar.setEnabled(false);
        opcion_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion_cerrarActionPerformed(evt);
            }
        });
        jMenu1.add(opcion_cerrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("campos");

        jMenuItem1.setText("crear");
        jMenuItem1.setEnabled(false);
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("listar");
        jMenuItem2.setEnabled(false);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("modificar");
        jMenuItem3.setEnabled(false);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("eliminar");
        jMenuItem5.setEnabled(false);
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("registros");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("indices");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("utilidades");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void opcion_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion_salvarActionPerformed
        // TODO add your handling code here:
        try{
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(filename));
            escribir.writeObject(campos);
            escribir.close();
            System.out.println("saved!");

        }catch(IOException e){

        }
        
    }//GEN-LAST:event_opcion_salvarActionPerformed

    private void opcion_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion_nuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcion_nuevoActionPerformed

    private void opcion_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion_abrirActionPerformed
        // TODO add your handling code here:
        //abre un archivo
        /*
        if(filename!=null){
            JOptionPane.showMessageDialog(null,"close existing file first");
            jFrame2.hide();
        }else{
            
        }*/
        jFrame2.setVisible(true);
        File ruta=new File("C:\\Users\\edas\\Documents\\NetBeansProjects\\fmanager");
        String[] archivos=ruta.list();
        for (String archivo : archivos) {
            jList1.setListData(archivos);
        }
        opcion_cerrar.setEnabled(true);
        
        opcion_salvar.setEnabled(true);
    }//GEN-LAST:event_opcion_abrirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        if(jList1.getSelectedValue()==null){
            jLabel2.setText("select an option");
        }else{
            try {
                filename=new File(jList1.getSelectedValue());
                opcion_abrir.setEnabled(false);
                ObjectInputStream leer=new ObjectInputStream(new FileInputStream(filename));
                campos=(LinkedList<Campo>)leer.readObject();
                leer.close();
                System.out.println("open!");
            } catch (IOException e) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            } 
            jFrame2.hide();
        }
        
         
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jFrame2.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void opcion_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion_cerrarActionPerformed
        // TODO add your handling code here:
        filename=null;
        campos.clear();
        System.out.println("closed!");
        opcion_cerrar.setEnabled(false);
        opcion_abrir.setEnabled(true);
        opcion_salvar.setEnabled(false);
    }//GEN-LAST:event_opcion_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem opcion_abrir;
    private javax.swing.JMenuItem opcion_cerrar;
    private javax.swing.JMenuItem opcion_nuevo;
    private javax.swing.JMenuItem opcion_salvar;
    // End of variables declaration//GEN-END:variables
}