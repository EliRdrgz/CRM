package com.ironhack.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JDialog implements ActionListener {

    JScrollPane scrollPanels;
    PanelSwitcher panelSwitcher;
    public JButton exitBtn, newLeadBtn, convertLead, listOfLeads;


    JLabel title;

    public MainWindow() {
        initializeComponents();
        setSize(800, 600);
        setTitle("Hooligans CRM");
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initializeComponents() {
        scrollPanels = new JScrollPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.ORANGE);

        // Main title
        title = new JLabel("Hooligans SalesForce CRM");
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setBounds(20, 20, 500, 50);
        getContentPane().add(title);


        //Exit button
        exitBtn = new JButton();
        exitBtn.setBounds(680, 20, 100, 40);
        exitBtn.setText("Exit");
        exitBtn.addActionListener(this);
        getContentPane().add(exitBtn);

/*        initialView = new JButton();
        initialView.setBounds(680, 20, 100, 40);
        initialView.setText("Home");
        initialView.addActionListener(this);
        getContentPane().add(initialView);*/

        newLeadBtn = new JButton();
        newLeadBtn.setText("New Lead");
        newLeadBtn.setBounds(20, 80, 140, 50);
        newLeadBtn.addActionListener(this);
        getContentPane().add(newLeadBtn);

        listOfLeads = new JButton();
        listOfLeads.setText("List of leads");
        listOfLeads.setBounds(180, 80, 160, 50);
        listOfLeads.addActionListener(this);
        getContentPane().add(listOfLeads);

        convertLead = new JButton();
        convertLead.setText("Convert a lead");
        convertLead.setBounds(360, 80, 160, 50);
        convertLead.addActionListener(this);
        getContentPane().add(convertLead);

        scrollPanels.setAutoscrolls(true);
        scrollPanels.setWheelScrollingEnabled(false);
        getContentPane().add(scrollPanels);
        scrollPanels.setBounds(20, 150, 760, 350);
        pack();

    }

    public void setViewedPanel(JPanel panel) {
        scrollPanels.setViewportView(panel);
    }

    public void setPanelSwitcher(PanelSwitcher thisPanelSwitcher) {
        panelSwitcher = thisPanelSwitcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newLeadBtn) {
            panelSwitcher.loadPanels(Panels.ADD_LEAD.ordinal());
        }
        if (e.getSource() == listOfLeads) {
            panelSwitcher.loadPanels(Panels.LIST_LEAD.ordinal());
        }
        if (e.getSource() == convertLead) {
            panelSwitcher.loadPanels(Panels.CONVERT_LEAD.ordinal());
        }

        if (e.getSource() == exitBtn) {
            int answer = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to leave?", "Confirm exit",
                    JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_NO_OPTION) {
                System.exit(0);
            }
        }
    }
    /*
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);

        JLabel title = new JLabel("Hooligans SalesForce CRM");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setBounds(20,20, 500, 50);
        title.setForeground(Color.GREEN);

        pane.add(title);
        pane.setBackground(Color.BLACK);

    }


    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Hooligans CRM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Size and display the window.
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    */

}
