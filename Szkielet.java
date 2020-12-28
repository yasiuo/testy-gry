package com.company;

import javax.swing.*;

public class Szkielet extends JFrame {
    Szkielet(){
        this.add(new Plecy());
        this.setTitle("Gra i trombi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
