package com.ironhack.classes;

import java.util.ArrayList;

public class LeadList {

    private ArrayList<Lead> leads = new ArrayList<>();

    public void removeLead(Lead lead) {
        leads.remove(lead);
    }

    public void addLead(Lead lead) {
        leads.add(lead);
    }

    public Lead get(int index) {
        return leads.get(index);
    }

    public ArrayList<Lead> showAllLeads() {
        return this.leads;
    }

    public int size() {
        return leads.size();
    }

    public Lead getLeadById(String id) {
        for (Lead lead : leads) {
            if (lead.getId().equals(id)) {
                return lead;
            }
        }
        return null;
    }

    //TODO: not work at call this method
    @Override
    public String toString() {
        String response = "";
        for (Lead lead : leads) {
            response += "Id: " + lead.getId() + " Name: " + lead.getName();
        }


        return response;
    }
}


