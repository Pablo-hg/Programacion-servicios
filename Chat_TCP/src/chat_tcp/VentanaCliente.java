
package chat_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VentanaCliente extends javax.swing.JFrame  implements Runnable{

    private DataOutputStream flujoDeSalida;
    private DataInputStream flujoDeEntrada;
    private Socket socketCliente;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    VentanaServidor v = new VentanaServidor();
    
    
    public VentanaCliente() {
        try {
            initComponents();
            //Le paso al socket el nombre del equipo y el puerto.
            this.socketCliente = new Socket("localhost",5000);
        } catch (IOException ex) {
            this.ChatGlobalcliente.setText("EL SERVIDOR ESTÁ APAGADO O HAY UN ERROR DE CONEXION." + '\n' + "REINICIA E INTENTALO OTRA VEZ.");
        }
        //Creo un hilo con runnable para esuchar
        Thread h = new Thread(this);
        h.start();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextoaEnviar = new javax.swing.JEditorPane();
        BotonEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChatGlobalcliente = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(TextoaEnviar);

        BotonEnviar.setText("Enviar");
        BotonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviarActionPerformed(evt);
            }
        });

        jLabel1.setText("Eres el cliente 1");

        ChatGlobalcliente.setColumns(20);
        ChatGlobalcliente.setRows(5);
        jScrollPane2.setViewportView(ChatGlobalcliente);
        ChatGlobalcliente.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(39, 39, 39))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(61, 61, 61)
                    .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(293, 293, 293)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BotonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviarActionPerformed
       
        Date date = new Date();
        if(!TextoaEnviar.getText().equals("")){
            try {
                this.flujoDeSalida.writeUTF("Cliente 1: " + TextoaEnviar.getText());
                this.ChatGlobalcliente.append( "Yo: " + this.TextoaEnviar.getText() +
                        "     (" + dateFormat.format(date) +")" + '\n');
            } catch (IOException ex) {
                System.out.println("Error de conexion");
            }
            this.TextoaEnviar.setText("");
        }
    }//GEN-LAST:event_BotonEnviarActionPerformed

    
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
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEnviar;
    public javax.swing.JTextArea ChatGlobalcliente;
    private javax.swing.JEditorPane TextoaEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
            try {
                this.flujoDeEntrada = new DataInputStream(this.socketCliente.getInputStream());
                this.flujoDeSalida = new DataOutputStream(this.socketCliente.getOutputStream());
                //this.flujoDeSalida.writeUTF("Cliente1");
            } catch (IOException ex) {
                System.out.println("Error de conexion");
            }
            while (true){
                Date date = new Date();
                try {
                    if (!this.flujoDeEntrada.readUTF().contains("Cliente 1:")){
                        this.ChatGlobalcliente.append(this.flujoDeEntrada.readUTF() + 
                            "     (" + dateFormat.format(date) + ")" + '\n');
                    }
                } catch (IOException ex) {
                    this.ChatGlobalcliente.append('\n' + "EL SERVIDOR CERRÓ LA CONEXION");
                    break;
                }
            }
    }
}
