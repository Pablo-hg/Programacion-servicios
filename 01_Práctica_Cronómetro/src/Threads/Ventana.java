
package Threads;

public class Ventana extends javax.swing.JFrame {
    
    /*El codigo es similar al de Diego fernandez porque hemos estado trabajando los dos 
    en resolver el trabajo*/
    
    
    Hilo hilo;
    int segundos;
    int minutos;
    int horas;
    boolean running = false;
    
   
    public Ventana() {
        initComponents();
        this.BotonReiniciar.setEnabled(false);
        this.BotonPausar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonIniciar = new javax.swing.JButton();
        BotonReiniciar = new javax.swing.JButton();
        TextoTiempo = new javax.swing.JLabel();
        BotonPausar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonIniciar.setText("Iniciar");
        BotonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarActionPerformed(evt);
            }
        });

        BotonReiniciar.setText("Reiniciar");
        BotonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReiniciarActionPerformed(evt);
            }
        });

        TextoTiempo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TextoTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoTiempo.setText("00:00:00");
        TextoTiempo.setToolTipText("");
        TextoTiempo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BotonPausar.setText("Pausar");
        BotonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPausarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(TextoTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(BotonIniciar)
                .addGap(36, 36, 36)
                .addComponent(BotonPausar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonReiniciar)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(TextoTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonIniciar)
                    .addComponent(BotonReiniciar)
                    .addComponent(BotonPausar))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarActionPerformed
        
        hilo = new Hilo(TextoTiempo);
        hilo.start();
        running = true;
        this.BotonIniciar.setEnabled(false);
        this.BotonPausar.setEnabled(true);
       
        
    }//GEN-LAST:event_BotonIniciarActionPerformed
        
    
    private void BotonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReiniciarActionPerformed
        
        segundos = 0;
        minutos = 0;
        horas = 0;
        this.TextoTiempo.setText("0"+(String.valueOf(horas))+":0"+(String.valueOf(minutos))+":0"+(String.valueOf(segundos)));
        this.BotonIniciar.setEnabled(true);
        this.BotonReiniciar.setEnabled(false);
    }//GEN-LAST:event_BotonReiniciarActionPerformed

    private void BotonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPausarActionPerformed
        
        hilo.stop();
        this.BotonReiniciar.setEnabled(true);
        this.BotonPausar.setEnabled(false);
    }//GEN-LAST:event_BotonPausarActionPerformed

    
    
    public static void main(String args[]){
        
         new Ventana().setVisible(true);
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIniciar;
    private javax.swing.JButton BotonPausar;
    private javax.swing.JButton BotonReiniciar;
    private javax.swing.JLabel TextoTiempo;
    // End of variables declaration//GEN-END:variables
}
