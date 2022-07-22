
package Threads;

import javax.swing.JLabel;

public class Hilo extends Thread {
    
    JLabel BotonTiempo;
    boolean running = false;
    int tiempo;
    long tiempoInicio = System.currentTimeMillis();
    int tiempo2 = (int) (tiempoInicio + 1000);
    int segundos;
    int horas;
    int minutos;

    public Hilo(JLabel Tiempo) {
        this.BotonTiempo = Tiempo;
    }

    @Override
    public void run(){
       
       while(running){
           tiempo = (int)System.currentTimeMillis();
           //dígito 6 empezano desde la iquierda
           
            if (tiempo>tiempo2){
               segundos++;
               tiempo2 = tiempo+1000;
                if (segundos <= 9){
                   this.BotonTiempo.setText("0"+(String.valueOf(horas))+":0"+(String.valueOf(minutos))+":0"+(String.valueOf(segundos)));
                } else 
                    this.BotonTiempo.setText("0"+(String.valueOf(horas))+":0"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));
                if (segundos>=60){
                   segundos = 0;
                   minutos++;
                   if (minutos <= 9){
                        this.BotonTiempo.setText((String.valueOf(horas))+":0"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));
                   } else 
                        this.BotonTiempo.setText((String.valueOf(horas))+":"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));     
               }
               if (minutos>60){
                   minutos =0;
                   horas++;
                   if (horas <= 9){
                        this.BotonTiempo.setText("0"+(String.valueOf(horas))+":"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));
                   } else 
                        this.BotonTiempo.setText((String.valueOf(horas))+":"+(String.valueOf(minutos))+":"+(String.valueOf(segundos)));     
               }
           }
       }
    } 
 }
