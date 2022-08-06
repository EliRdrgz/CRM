package com.ironhack.classes;

import java.util.ArrayList;

public class LeadList {

    public ArrayList<Lead> leads = new ArrayList<>();

    public void removeLead(Lead lead) {
        leads.remove(lead);
    }

    public void addLead(Lead lead) {
        leads.add(lead);
    }

    public Lead get(int index) {
        return leads.get(index);
    }

    public String showAllLeads() {
        String response = "-----------------";
        for (Lead lead : leads) {
            response += lead.ToTableString();
        }
        response += "-----------------";
        return response;
    }


    public int[] getAllIds() {
        int[] ids = new int[leads.size()];
        for (int i = 0; i < leads.size(); i++) {
            ids[i] = leads.get(i).getId();
        }
        return ids;
    }

    public int size() {
        return leads.size();
    }

    public Lead getLeadById(int id) {
        for (Lead lead : leads) {
            if (lead.getId() == id) {
                return lead;
            }
        }
        return null;
    }

    public String[][] getAllLeadsToList() {
        String[][] response = new String[leads.size()][4];
        for (int i = 0; i < leads.size(); i++) {
            Lead lead = leads.get(i);
            String[] temp = new String[]{lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()};
            response[i] = temp;
        }
        return response;
    }


}


