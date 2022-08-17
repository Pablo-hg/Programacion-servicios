
package chat_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaServidor extends javax.swing.JFrame implements Runnable{

    DataInputStream flujoDeEntrada;
    DataOutputStream flujoDeSalida;
    Socket socketCliente;
    ServerSocket socketServidor;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Thread h = new Thread(this);
    Thread h2;
    Date date = new Date();
    List<DataOutputStream> clientes = new ArrayList<DataOutputStream>();
    
    //Constructor que recibe el DataInpput y el List de DataOutput
    public VentanaServidor(DataInputStream flujoDeEntrada, List<DataOutputStream> clientes) {
        this.flujoDeEntrada = flujoDeEntrada;
        this.clientes = clientes;
    }
    
    public VentanaServidor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextoEnviar = new javax.swing.JEditorPane();
        BotonEncender = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ChatGlobal = new javax.swing.JTextArea();
        txtEspacios = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonEnviar.setText("Enviar");
        BotonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviarActionPerformed(evt);
            }
        });

        jLabel1.setText("Eres el Administrador");

        jScrollPane2.setViewportView(TextoEnviar);

        BotonEncender.setText("Encender");
        BotonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEncenderActionPerformed(evt);
            }
        });

        ChatGlobal.setColumns(20);
        ChatGlobal.setRows(5);
        jScrollPane1.setViewportView(ChatGlobal);
        ChatGlobal.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(BotonEncender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEspacios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(BotonEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(txtEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviarActionPerformed
    
        
        Date date = new Date();
        if (this.BotonEncender.getText().equals("Apagar")){
            if(!TextoEnviar.getText().equals("")){
                try {
                    this.ChatGlobal.append("Yo: " + this.TextoEnviar.getText() +
                            "   (" + dateFormat.format(date) +")" + '\n');
                    for(int i = 0; i < clientes.size();i++){
                        clientes.get(i).writeUTF("Admin: " + this.TextoEnviar.getText());
                    }
                } catch (IOException ex) {
                    System.out.println("Error de conexion");
                }
                this.TextoEnviar.setText("");
            }
        }
        
        
    }//GEN-LAST:event_BotonEnviarActionPerformed

    private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEncenderActionPerformed
        
        if (this.BotonEncender.getText().equals("Encender") ){
            this.ChatGlobal.setText("");
            this.ChatGlobal.append("                        El Administrador se unió al chat" + '\n');
            this.BotonEncender.setText("Apagar");
            try {  
                this.socketServidor = new ServerSocket(5000);
            } catch (IOException ex) {
                System.out.println("Error al crear la conexion");
            }
            h.start();
        }
        else{
            this.BotonEncender.setText("Encender");
            h.stop();
            this.ChatGlobal.append('\n' + "FIN DE LA CONEXION");
        }
    }//GEN-LAST:event_BotonEncenderActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonEncender;
    private javax.swing.JButton BotonEnviar;
    public static javax.swing.JTextArea ChatGlobal;
    private javax.swing.JEditorPane TextoEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel txtEspacios;
    // End of variables declaration//GEN-END:variables

   @Override
    public void run() {
        while (true){
            try {
                socketCliente = socketServidor.accept();
                flujoDeEntrada = new DataInputStream (socketCliente.getInputStream());
                flujoDeSalida = new DataOutputStream(socketCliente.getOutputStream());
                clientes.add(flujoDeSalida);
                h2.start();
                h2 = new Thread(){    
                    @Override
                    public void run() {   
                        while (true){
                            try {
                                String mensaje=flujoDeEntrada.readUTF();
                                ChatGlobal.append(mensaje + "    (" + dateFormat.format(date)  + ")" + '\n');
                                for(int i = 0; i < clientes.size();i++){
                                    clientes.get(i).writeUTF(mensaje);
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(VentanaServidor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
            } catch (IOException ex) {     
                Logger.getLogger(VentanaServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
