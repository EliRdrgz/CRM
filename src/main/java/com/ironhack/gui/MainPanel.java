package com.ironhack.gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    PanelSwitcher panelSwitcher;
    private JPanel panel;
    private JLabel title;


    public MainPanel() {
        initializeComponent();
        setBackground(Color.CYAN);
        //setPreferredSize(new Dimension(300,100));
        setLayout(null);
    }
    private void initializeComponent() {
        panel = new JPanel();
        panel.setBounds(20, 10, 700, 200);

        title = new JLabel("Add new lead");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(5,0, 250, 30);
        panel.add(title);

        /*JButton b1 = new JButton("Add new Lead");
        JButton b2 = new JButton("Add new Oportunity");
        JButton b3 = new JButton("Add new Contact");
        Dimension size = b1.getPreferredSize();
        b1.setBounds(10, 10, size.width + 30, size.height + 20);
        size = b2.getPreferredSize();
        b2.setBounds(10, 40,size.width + 20, size.height + 20);
        size = b3.getPreferredSize();
        b3.setBounds(40 , 10,size.width + 20, size.height + 20);

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);*/

        panel.setOpaque(false);
        panel.setLayout(null);

        add(panel);


    }

    public void setPanelSwitcher(PanelSwitcher thisPanelSwitcher) {
        panelSwitcher = thisPanelSwitcher;
    }
}
