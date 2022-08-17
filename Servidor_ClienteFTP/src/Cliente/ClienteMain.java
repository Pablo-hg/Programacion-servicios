
package Cliente;

import Servidor.EstructuraArchivosIO;
import javax.swing.tree.TreeSelectionModel;
import Servidor.EnviaObjetos;
import Cliente.RecibeObjetos;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ClienteMain extends javax.swing.JFrame implements Serializable{

  
    EstructuraArchivosIO estructuraArchivos;
    int PuertoServidor = 12346;
    int PuertoCliente = 12356;
    File archivo;
    String rutarchivo = "";
    String rutaCarpeta = "";
    byte[] bufferArchivo;
    String nombre = "";
    public static String mensaje;
    
    public ClienteMain() {
        
        initComponents();
        
        //constructor de la clase hilo, pasandole los atributos
        ClienteHilo hilo = new ClienteHilo(estructuraArchivos,PuertoCliente,this.jTree1);
        hilo.start();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jbSubir = new javax.swing.JButton();
        jbDescargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);
        jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        jbSubir.setText("Subir");
        jbSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubirActionPerformed(evt);
            }
        });

        jbDescargar.setText("Descargar");
        jbDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jbSubir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jbDescargar)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jbSubir)
                        .addGap(120, 120, 120)
                        .addComponent(jbDescargar)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubirActionPerformed
        
           
            //Selecionamos el/los archivos donde queremos subir mas archivos
            Object[] paths = this.jTree1.getSelectionPath().getPath();
            for (int i = 0; i < paths.length; i++) {
                rutaCarpeta += paths[i];
                rutaCarpeta += "\\";
            }
            
            //Creamos el chooser para seleccionar lo que quiero subir al servidor
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jfc.setCurrentDirectory(new File("c:\\"));
            jfc.setDialogTitle("Selecciona el archivo que quieres subir");
            //Si seleccionamos el archivo o le damos a cancelar
            if ((jfc.showDialog(jfc, "Guardar") == JFileChooser.CANCEL_OPTION)) {
                 JOptionPane.showMessageDialog(null, "Subida cancelada");
            } else {
                //guardamos el nombre del archivo y su ruta
                archivo = jfc.getSelectedFile();
                rutarchivo = archivo.getParent();
                nombre = archivo.getName();
            }
            try {
                //Creamos un buffer con los bytes de la ruta dle archivo y el nombre del archivo
                bufferArchivo = Files.readAllBytes(Paths.get(rutarchivo,nombre));
            } catch (IOException ex) {
                System.out.println("Error al crear un buffer basado en archivo");
            }
            //Objeto de la clase SubirArchivo que contiene el archivo que quiero subir ,
            //la direccion de donde lo quiero subir y el buffer de todo 
            SubirArchivo subir = new SubirArchivo(bufferArchivo,rutaCarpeta,nombre);
            //Enviamos el objeto al servidor
            EnviaObjetos.Envia(subir, "localhost", PuertoServidor);
    }//GEN-LAST:event_jbSubirActionPerformed

    private void jbDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDescargarActionPerformed
        
        mensaje = "descargar";
        //Cojer el nombre y la tuta del archivo que quiero descargar
        Object[] path = this.jTree1.getSelectionPath().getPath();
        for (int i = 0; i < path.length; i++) {
            if(i == path.length-1){
                nombre =  path[i].toString();
            }
            else if(i == path.length-2){
                rutarchivo += path[i];
            }
            else{
                rutarchivo += path[i];
                rutarchivo += "\\";
            }
        }
        //cojer la ruta de la carpeta donde lo quiero descargar
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setCurrentDirectory(new File("c:\\"));
            jfc.setDialogTitle("Selecciona la direccion donde quieres que se descarge");
            if ((jfc.showDialog(jfc, "Guardar") == JFileChooser.CANCEL_OPTION)) {
                 JOptionPane.showMessageDialog(null, "Descargar cancelada");
            } else {
                archivo = jfc.getSelectedFile();
                rutaCarpeta = archivo.getAbsolutePath() + "\\";
            }
        //buffer con la direccion del archivo y el nombre
        try {
            bufferArchivo = Files.readAllBytes(Paths.get(rutarchivo,nombre));
        } catch (IOException ex) {
            System.out.println("Error al crear un buffer basado en archivo");
        }
        //objeto tipo descargar con todos los datos
        DescargarArchivo descargar = new DescargarArchivo(bufferArchivo,rutaCarpeta,nombre);
        try {
            Files.write(Paths.get(descargar.getRuta(),descargar.getNombre()), descargar.getBufferArchivo());
            JOptionPane.showMessageDialog(null, "Archivo/s Descargado/s");
        } catch (IOException ex) {
           System.out.println("Error al crear un archivo basado en buffer");
        }
        
    }//GEN-LAST:event_jbDescargarActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbDescargar;
    private javax.swing.JButton jbSubir;
    // End of variables declaration//GEN-END:variables

   

}
