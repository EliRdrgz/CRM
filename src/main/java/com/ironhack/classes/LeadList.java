package com.ironhack.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public Map<Integer, String> showAllLeads() {
        Map<Integer, String> leadsToShow = new HashMap<>();
        for (Lead lead : leads) {
            leadsToShow.put(lead.getId(), lead.getName());
        }
        return leadsToShow;
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


