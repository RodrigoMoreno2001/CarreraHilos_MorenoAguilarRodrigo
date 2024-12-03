/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.carrerahilos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author rodri_2
 */
public class Carrera extends javax.swing.JFrame {

    
    private boolean revolver; // es la variable que gestiona la carrera
    private JLabel[] corredores;
    private int salida=24; // coordenada x de la posicion de salida

    public Carrera() {
        initComponents();
        revolver=true;
        corredores=new JLabel[]{jLabel1,jLabel2,jLabel3,jLabel4};
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new Fondo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iris.png"))); // NOI18N
        jLabel1.setName("Iris"); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mike.png"))); // NOI18N
        jLabel2.setName("Mike"); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rose.png"))); // NOI18N
        jLabel3.setName("Rose"); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clint.png"))); // NOI18N
        jLabel4.setName("Clint"); // NOI18N

        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/revolver.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(892, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(500, 500, 500))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5)
                                .addGap(79, 79, 79)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        if(!revolver) return;
        revolver=false;
        carrera();
    }

    public void carrera(){
        for(JLabel aux:corredores){

            new Thread(()->{
                int x=salida;
                int boost=25;
                try {
                    while(x<984&&!revolver){
                        Thread.sleep(20);
                        if((int)(Math.random()*1000)>990) boost=10;
                        if(boost>0){
                            boost--;
                            x+=4;
                        }else{
                          x+=(int)(Math.random()*2)+1;  
                        }
                        
                        if(x>984) x=984;
                        aux.setBounds(x, aux.getY(), aux.getWidth(), aux.getHeight());
                    }
                    ganadores();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();
        }
    }

    public synchronized void ganadores(){

        if(!revolver){
            ArrayList<JLabel> arrGanadores= new ArrayList<>(Arrays.asList(corredores));

            Collections.sort(arrGanadores,(e1,e2)->Integer.compare(e2.getX(), e1.getX()));
            String ganadores="";
            for(JLabel aux:arrGanadores) ganadores+=aux.getName()+" ("+aux.getX()+")\n";
            revolver=true;
            JOptionPane.showMessageDialog(this, ganadores);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carrera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration

    class Fondo extends JPanel{
        private Image fondo;

        @Override
        public void paint(Graphics g){
            fondo=new ImageIcon(getClass().getResource("/fondo.png")).getImage();

            g.drawImage(fondo,0,0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);

        }
    }

}