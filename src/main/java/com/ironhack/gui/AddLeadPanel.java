package com.ironhack.gui;

import com.ironhack.classes.Lead;
import com.ironhack.classes.LeadList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLeadPanel extends JPanel implements ActionListener {


    PanelSwitcher panelSwitcher;
    private JPanel panel;
    private JLabel title, nameLabel, phoneNumberLabel, emailLabel, companyNameLabel;
    private JTextField name, phoneNumber, email, companyName;

    private JButton saveLead;
    private final LeadList leadList;

    public AddLeadPanel(LeadList leadList) {
        this.leadList = leadList;
        initializeComponent();
        setBackground(Color.CYAN);
        setLayout(null);
    }

    private void initializeComponent() {
        panel = new JPanel();
        panel.setBounds(20, 10, 700, 400);

        title = new JLabel("Add new lead");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(5, 0, 250, 30);
        panel.add(title);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(20, 60, 80, 40);

        name = new JTextField();
        name.setBounds(200, 60, 300, 40);

        phoneNumberLabel = new JLabel("Phone number: ");
        phoneNumberLabel.setBounds(20, 100, 300, 40);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(200, 100, 300, 40);

        emailLabel = new JLabel("e-mail: ");
        emailLabel.setBounds(20, 140, 80, 40);

        email = new JTextField();
        email.setBounds(200, 140, 300, 40);

        companyNameLabel = new JLabel("Company name: ");
        companyNameLabel.setBounds(20, 180, 120, 40);

        companyName = new JTextField();
        companyName.setBounds(200, 180, 300, 40);

        saveLead = new JButton();
        saveLead.setBounds(560, 10, 100, 40);
        saveLead.setText("Save lead");
        saveLead.addActionListener(this);

        panel.add(nameLabel);
        panel.add(name);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumber);
        panel.add(emailLabel);
        panel.add(email);
        panel.add(companyNameLabel);
        panel.add(companyName);
        panel.add(saveLead);

        panel.setOpaque(false);
        panel.setLayout(null);

        add(panel);
    }

    public void setPanelSwitcher(PanelSwitcher thisPanelSwitcher) {
        panelSwitcher = thisPanelSwitcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveLead) {
            int answer = JOptionPane.showConfirmDialog(this,
                    "Do you want to save this lead?", "Add new lead",
                    JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_NO_OPTION) {
                Lead lead = new Lead(name.getText(), phoneNumber.getText(), email.getText(), companyName.getText());
                leadList.addLead(lead);
                JOptionPane.showMessageDialog(null, "Lead created:  " + lead);
            }
        }
    }
}
