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

    public ArrayList<Lead> showAllLeads(){
      return this.leads;
    }
    public int size() {
        return leads.size();
    }

}


