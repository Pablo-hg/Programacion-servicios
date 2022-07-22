
package pkg01_práctica_cronómetro;



public class Ventana extends javax.swing.JFrame implements Runnable {
    
    /*El codigo es similar al de Diego fernandez porque hemos estado trabajando los dos 
    en resolver el trabajo*/
    
    
    Thread hilo = new Thread(this); 
    boolean running = false;
    int tiempo;
    int tiempo2;
    int seg;
    int segundos;
    int minutos;
    int horas;
    long tiempoInicio = System.currentTimeMillis();
     
    public Ventana() {
        initComponents();
        this.Reiniciar.setEnabled(false);
        this.Pausar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Iniciar = new javax.swing.JButton();
        Reiniciar = new javax.swing.JButton();
        Tiempo = new javax.swing.JLabel();
        Pausar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        Reiniciar.setText("Reiniciar");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });

        Tiempo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Tiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tiempo.setText("00:00:00");
        Tiempo.setToolTipText("");
        Tiempo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Pausar.setText("Pausar");
        Pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PausarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 260, Short.MAX_VALUE)
                .addComponent(Reiniciar)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(Tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Pausar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(Tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reiniciar)
                    .addComponent(Iniciar)
                    .addComponent(Pausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        
        hilo = new Thread(this);
        hilo.start();
        running = true;
        tiempo2 = (int) (tiempoInicio + 1000);
        this.Iniciar.setEnabled(false);
        this.Pausar.setEnabled(true);
        
    }//GEN-LAST:event_IniciarActionPerformed

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        
        
        segundos = 0;
        minutos = 0;
        horas = 0;
        this.Tiempo.setText("0"+(String.valueOf(horas))+":0"+(String.valueOf(minutos))+":0"+(String.valueOf(segundos)));
        this.Iniciar.setEnabled(true);
        this.Reiniciar.setEnabled(false);
        
    }//GEN-LAST:event_ReiniciarActionPerformed

    private void PausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PausarActionPerformed

        hilo.stop();
        this.Reiniciar.setEnabled(true);
        this.Pausar.setEnabled(false);

    }//GEN-LAST:event_PausarActionPerformed

    public static void main(String args[]) {
        
        

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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciar;
    private javax.swing.JButton Pausar;
    private javax.swing.JButton Reiniciar;
    private javax.swing.JLabel Tiempo;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void run() {
        
       while(running){
           tiempo = (int)System.currentTimeMillis();
           //dígito 6 empezano desde la iquierda
           
            if (tiempo>tiempo2){
               segundos++;
               tiempo2 = tiempo+1000;
                if (segundos <= 9){
                   this.Tiempo.setText("0"+(String.valueOf(horas))+":0"+(String.valueOf(minutos))+":0"+(String.valueOf(segundos)));
                } else 
                    this.Tiempo.setText("0"+(String.valueOf(horas))+":0"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));
                if (segundos>=60){
                   segundos = 0;
                   minutos++;
                   if (minutos <= 9){
                        this.Tiempo.setText((String.valueOf(horas))+":0"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));
                   } else 
                        this.Tiempo.setText((String.valueOf(horas))+":"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));     
               }
               if (minutos>60){
                   minutos =0;
                   horas++;
                   if (horas <= 9){
                        this.Tiempo.setText("0"+(String.valueOf(horas))+":"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));
                   } else 
                        this.Tiempo.setText((String.valueOf(horas))+":"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));     
               }
           }
       }
    }  
}
