package com.ironhack.gui;

public class PanelSwitcher {

    private MainPanel panelSwitcherMainPanel;

    private AddLeadPanel panelSwitcherAddLeadPanel;

    private MainWindow panelSwitcherMainWindow;

    private LeadListPanel panelSwitcherLeadListPanel;

    private ConvertLeadPanel panelSwitcherConvertLeadPanel;

    public void setMainPanel(MainPanel mainPanel) {
        panelSwitcherMainPanel = mainPanel;
    }

    public void setAddLeadPanel(AddLeadPanel addLeadPanel) {
        panelSwitcherAddLeadPanel = addLeadPanel;
    }

    public void setConvertLeadPanel(ConvertLeadPanel convertLeadPanel) { panelSwitcherConvertLeadPanel = convertLeadPanel; }

    public void setMainWindow(MainWindow mainWindow) {
        panelSwitcherMainWindow = mainWindow;
    }

    public void setListOfLeads(LeadListPanel listOfLeads) {
        panelSwitcherLeadListPanel = listOfLeads;
    }

    public void loadPanels(int panel) {
        switch (panel) {
            case 1:
                panelSwitcherMainWindow.setViewedPanel(panelSwitcherMainPanel);
                break;
            case 2:
                panelSwitcherMainWindow.setViewedPanel(panelSwitcherAddLeadPanel);
                break;
            case 3:
                panelSwitcherMainWindow.setViewedPanel(panelSwitcherLeadListPanel);
                break;
            case 4:
                panelSwitcherMainWindow.setViewedPanel(panelSwitcherConvertLeadPanel);
                break;
        }
    }
}

