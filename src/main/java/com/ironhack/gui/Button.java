package com.ironhack.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JFrame implements ActionListener {
    JButton button;
    JLabel text;

    public Button() {
        setLayout(null);
        button = new JButton("CLOSE");
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) System.exit(0);
    }
}

