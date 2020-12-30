package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Plecy extends JPanel implements ActionListener {

    public final int szerokosc_ekran = 1300;
    public final int wysokosc_ekran = 750;
    public final int opoznienie = 75;
    Timer timer;

    boolean zasilanie = false;
    public int x_pocz=100;
    public int y_pocz=100;
    public int x_postac;
    public int y_postac;
    public int predkosc_y=0;
    boolean skok=false;


    Plecy(){
        this.setPreferredSize(new Dimension(szerokosc_ekran,wysokosc_ekran));
        this.setBackground(Color.black);
        this.addKeyListener(new AdapterKlawiatury());
        this.setFocusable(true);

        StartGry();

    }

    public void StartGry(){
        x_postac=x_pocz;
        y_postac=y_pocz;
        zasilanie=true;
        timer = new Timer(opoznienie,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if (zasilanie){
            g.setColor(Color.red);
            g.fillRect(x_postac,y_postac,10,10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (zasilanie){
            poruszanie();
        }


        repaint();
    }

    public void Skok(){
        if (y_postac==y_pocz){
            predkosc_y+=15;
        }
    }

    public void grawitacja(){
        if (y_postac>y_pocz){
            predkosc_y-=5;
        }
        if (y_postac<y_pocz){
            y_postac=y_pocz;
            predkosc_y=0;
        }
    }

    public void poruszanie(){
        x_postac+=1;
        y_postac+=predkosc_y;
        grawitacja();
        if (skok){
            Skok();
            skok=false;
        }
    }

    public class AdapterKlawiatury extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode()==KeyEvent.VK_UP){
                skok=true;
            }
        }
    }



}



