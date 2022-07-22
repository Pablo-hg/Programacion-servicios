
package pkg01_ejemploordenacion;


import java.awt.GridLayout;
import javax.swing.JButton;

public class Ventana extends javax.swing.JFrame {
    
    Hilo h1;
    Hilo h2;
    public int array1[];
    public int array2[];
    JButton boton1;
    JButton boton2;
    
    public Ventana() {
        initComponents();
        añadirBotonesJPanel1();
        añadirBotonesJPanel2();
        rellenarArray1();
        rellenarArray2();
    }

    
    private void añadirBotonesJPanel1() {
        //divimos el JPanel  en una 1 fila  y 20 colummnas
        Panel1.setLayout(new GridLayout(1,20));
        for (int i =0; i < 20; i++){
            //se crea en la memoria pero no se visualiza en el layout
            boton1 = new JButton("*");
            Panel1.add(boton1);
        }
    }
    
    
    private void añadirBotonesJPanel2() {
        //divimos todo en una 1 fila  y 20 colummnas
        Panel2.setLayout(new GridLayout(1,20));
        for (int i =0; i < 20; i++){
            boton2 = new JButton("*");
            Panel2.add(boton2);
        }
    }
    
    
    private void rellenarArray1() {
        array1 = new int [20];
        for (int i = 0; i < 20; i++){
            array1[i] = (int) (Math.random()*100)+1;
            //en el boton 1 quiero que salga 1 , en el 2 el 2 ,..... (pero salen aleatorios)
            ((JButton)Panel1.getComponent(i)).setText(String.valueOf(array1[i])); //nos devuelve un objeto
        }
    }
    
    
    private void rellenarArray2() {
        array2 = array1;
        for (int i = 0; i < 20; i++){
            //Pondrá los mismo numeros que el array1
            ((JButton)Panel2.getComponent(i)).setText(String.valueOf(array2[i])); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonOrdenar = new javax.swing.JButton();
        Panel1 = new javax.swing.JPanel();
        Panel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonOrdenar.setText("Ordenar");
        BotonOrdenar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonOrdenarMouseClicked(evt);
            }
        });
        BotonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOrdenarActionPerformed(evt);
            }
        });

        Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1189, Short.MAX_VALUE)
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(559, 559, 559)
                .addComponent(BotonOrdenar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonOrdenar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonOrdenarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOrdenarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonOrdenarMouseClicked

    private void BotonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOrdenarActionPerformed
        // TODO add your handling code here:
        h1 = new Hilo(array1,Panel1);
        h2 = new Hilo(array2,Panel2);
        h1.start();
        h2.start();
        
    }//GEN-LAST:event_BotonOrdenarActionPerformed

    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonOrdenar;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    // End of variables declaration//GEN-END:variables

    

    
}
