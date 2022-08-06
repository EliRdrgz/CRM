package com.ironhack.gui;

import com.ironhack.classes.LeadList;

import javax.swing.*;
import java.awt.*;

public class LeadListPanel extends JPanel {
    private JTable table;
    private JLabel title;
    private JPanel panel;
    PanelSwitcher panelSwitcher;

    private final String[][] data = {
            {"Jose", "666555444", "jose@mail.com", "Pepigri123"},
            {"Loli", "667887998", "lolailoli@mail.com", "Lolipop123"},
            {"Manuel", "666555444", "manu@mail.com", "Pepigri123"},
            {"Carlo", "667887998", "carlito@mail.com", "Lolipop123"},
            {"Amparo", "666555444", "amparito@mail.com", "Pepigri123"},
            {"Manuela", "667887998", "manoli@mail.com", "Lolipop123"},
    };

    private final String[] columnNames = {"Name", "Phone number", "mail", "company name"};

    public LeadListPanel() {
        initializeComponent();
        setBackground(Color.PINK);
        setLayout(null);
    }

    private void initializeComponent() {
        panel = new JPanel();
        panel.setBounds(20, 10, 700, 400);

        title = new JLabel("List of active leads");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(5,0, 250, 30);
        panel.add(title);

       table = new JTable(data, columnNames);
       table.setBounds(20, 60, 600, 250);
       panel.add(table);

        panel.setOpaque(false);
        panel.setLayout(null);

        add(panel);
    }

    public void setPanelSwitcher(PanelSwitcher thisPanelSwitcher) {
        panelSwitcher = thisPanelSwitcher;
    }


}
