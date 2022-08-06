package com.ironhack.gui;


import com.ironhack.classes.LeadList;
import com.ironhack.classes.OpportunityList;

public class GuiMain {
    public static void main(LeadList leadList, OpportunityList opportunityList) {
        PanelSwitcher panelSwitcher = new PanelSwitcher();
        MainWindow mainWindow = new MainWindow();
        MainPanel mainPanel = new MainPanel();
        AddLeadPanel addLeadPanel = new AddLeadPanel(leadList);
        LeadListPanel listOfLeads = new LeadListPanel();
        ConvertLeadPanel convertLeadPanel = new ConvertLeadPanel();

        mainPanel.setPanelSwitcher(panelSwitcher);
        addLeadPanel.setPanelSwitcher(panelSwitcher);
        listOfLeads.setPanelSwitcher(panelSwitcher);
        convertLeadPanel.setPanelSwitcher(panelSwitcher);
        mainWindow.setPanelSwitcher(panelSwitcher);

        panelSwitcher.setMainPanel(mainPanel);
        panelSwitcher.setAddLeadPanel(addLeadPanel);
        panelSwitcher.setListOfLeads(listOfLeads);
        panelSwitcher.setConvertLeadPanel(convertLeadPanel);
        panelSwitcher.setMainWindow(mainWindow);

        mainWindow.setVisible(true);

    }
}