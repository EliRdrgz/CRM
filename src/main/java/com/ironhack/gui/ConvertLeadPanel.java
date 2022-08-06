package com.ironhack.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertLeadPanel extends JPanel implements ActionListener {

    private JPanel panel;
    private JLabel title, quantityLabel, productLabel;
    private JList<String> productType;
    private JTextField quantity;
    private JTextPane intro;

    private JButton createOportunity;

    PanelSwitcher panelSwitcher;

    public ConvertLeadPanel() {
        initializeComponent();
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
    }

    private void initializeComponent() {
        panel = new JPanel();
        panel.setBounds(20, 10, 700, 400);

        title = new JLabel("Convert lead");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(5, 0, 250, 30);
        panel.add(title);

        intro = new JTextPane();
        intro.setText("Select a product from the list and the insert how many do you want to buy");
        intro.setFont(new Font("Tahoma", Font.BOLD, 12));
        intro.setBackground(Color.YELLOW);
        intro.setBounds(5, 40, 700, 30);
        panel.add(intro);

        productLabel = new JLabel();
        productLabel.setText("Available products:");
        productLabel.setBounds(5, 70, 400, 40);

        String[] products = {"HYBRID", "FLATBED", "BOX"};
        productType = new JList<>(products);
        productType.setSelectedIndex(0);
        productType.setBounds(5, 100, 200, 150);

        quantityLabel = new JLabel();
        quantityLabel.setText("Quantity: ");
        quantityLabel.setBounds(230, 90, 75, 40);

        quantity = new JTextField();
        quantity.setBounds(335, 90, 150, 40);

        createOportunity = new JButton();
        createOportunity.setText("Create Opportunity");
        createOportunity.setBounds(230, 200, 150, 50);
        createOportunity.addActionListener(this);
        panel.add(createOportunity);

        panel.add(productLabel);
        panel.add(productType);
        panel.add(quantityLabel);
        panel.add(quantity);

        panel.setOpaque(false);
        panel.setLayout(null);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createOportunity) {
            int answer = JOptionPane.showConfirmDialog(this,
                    "Do you want to create this opportunity?", "Create opportunity",
                    JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_NO_OPTION) {
                JOptionPane.showMessageDialog(null, "The opportunity has been created! Thanks for using Hooligans CRM");
                System.exit(0);
            }
        }
    }

    public void setPanelSwitcher(PanelSwitcher thisPanelSwitcher) {
        panelSwitcher = thisPanelSwitcher;
    }
}
