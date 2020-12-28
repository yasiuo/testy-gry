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
    public int x_postac=100;
    public int y_postac=100;
    boolean skok=false;


    Plecy(){
        this.setPreferredSize(new Dimension(szerokosc_ekran,wysokosc_ekran));
        this.setBackground(Color.black);
        this.addKeyListener(new AdapterKlawiatury());

        StartGry();

    }

    public void StartGry(){
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
        y_postac+=5;
    }

    public void poruszanie(){
        x_postac+=1;
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



