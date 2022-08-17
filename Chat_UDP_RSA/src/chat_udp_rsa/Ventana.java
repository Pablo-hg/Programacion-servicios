
package chat_udp_rsa;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import udp.EnviaUDP;
import udp.RecibeUDP;

public class Ventana extends javax.swing.JFrame implements Runnable{
    
    public Ventana() {
        initComponents();
        //Creamos el hilo de escuchar
        Thread h = new Thread(this);
        h.start();
        //ejecutamos el metodo que crea las claves 
        cifrado();
    }
    
    int puertoAlQueEnvia1 = 5000;
    int puertoPorElQueRecibe= 6500;
    KeyPairGenerator kg;
    PublicKey pub;
    PublicKey pub2;
    PrivateKey priv;
    KeyPair par;
    Object objeto;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoaEnviar = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChatGlobal = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(TextoaEnviar);

        ChatGlobal.setColumns(20);
        ChatGlobal.setRows(5);
        jScrollPane2.setViewportView(ChatGlobal);
        ChatGlobal.setEditable(false);

        jLabel1.setText("Eres Jugador 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        if(!TextoaEnviar.getText().equals("")){
            try {
                //creo el mensaje
                String mensaje = "player 1 : " + this.TextoaEnviar.getText();
                //creo el encriptador
                Cipher c=Cipher.getInstance("RSA/ECB/PKCS1Padding");
                //hago que el encripatdor encripte con la clave publica dela Ventana 2
                c.init(Cipher.ENCRYPT_MODE, pub2);
                //Cifro el mensaje con la clave publica  del 2
                byte[] mensajeCifrado= c.doFinal(mensaje.getBytes());
                //Envio el mensaje crifrado
                EnviaObjetos.Envia(mensajeCifrado, "localhost", puertoAlQueEnvia1);
                //añado el mensaje a mi ventana
                this.ChatGlobal.append("Yo : "  + this.TextoaEnviar.getText() + '\n');
                //dejo vacio el hueco para escribir mensajes
                TextoaEnviar.setText("");
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
                
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ChatGlobal;
    private javax.swing.JEditorPane TextoaEnviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
        //Enviamos la clave(si se ejecuta esta ventana primero , se perderia este envia)
        EnviaObjetos.Envia(pub, "localhost", puertoAlQueEnvia1);
        //guardamos en un objeto tipo PuckiKey la clave publica de la otra ventana
        pub2 = (PublicKey) RecibeObjetos.recibe(puertoPorElQueRecibe);
        //Enviamos la clvae publica (si se habia perdido, este si llega al otro)
        EnviaObjetos.Envia(pub, "localhost", puertoAlQueEnvia1);
        
        while (true){
            objeto = RecibeObjetos.recibe(puertoPorElQueRecibe);
            //Si lo que me recibe es un array de bytes..
            if(objeto instanceof byte[]){
                try {
                    Cipher c=Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    c.init(Cipher.DECRYPT_MODE, priv);
                    //Comvertirmo en un array de byes el mensaje(descifrado con la clave)
                    byte[] desencriptado = c.doFinal((byte[]) objeto);
                    //guardamos en un string el mensaje completo descrifrado
                    String mensaje = new String(desencriptado);
                    //añadimos dicho mensaje a la chat
                    this.ChatGlobal.append(mensaje + '\n');
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Ventana2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(Ventana2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(Ventana2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(Ventana2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadPaddingException ex) {
                    Logger.getLogger(Ventana2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void cifrado() {
        try {
            kg=KeyPairGenerator.getInstance("RSA");
            kg.initialize(1024);
            par=kg.generateKeyPair();
            priv=par.getPrivate();
            pub=par.getPublic();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error al crear la claves");
        }

    }
}
