package com.ironhack.classes;

import java.util.ArrayList;

public class LeadList {

    private ArrayList<Lead> leads;

    public void removeLead(Lead lead) {
        leads.remove(lead);
    }
    public void addLead(Lead lead) {
        leads.add(lead);
    }

    public Lead LeadFindById(String id) {
        Lead lead = null;
        for (Lead lead1 : this.leads) {
            if (lead1.getId().equals(id)) {
                lead = lead1;
            }
        }
        return lead;
    }

    public Lead LeadFindByName(String name) {
        Lead lead = null;
        for (Lead lead1 : this.leads) {
            if (lead1.getName().equals(name)) {
                lead = lead1;
            }
        }
        return lead;
    }

    public Lead LeadFindByPhoneNumber(String phoneNumber) {
        Lead lead = null;
        for (Lead lead1 : this.leads) {
            if (lead1.getPhoneNumber().equals(phoneNumber)) {
                lead = lead1;
            }
        }
        return lead;
    }

    public Lead LeadFindByEmail(String email) {
        Lead lead = null;
        for (Lead lead1 : this.leads) {
            if (lead1.getEmail().equals(email)) {
                lead = lead1;
            }
        }
        return lead;
    }

    public Lead LeadFindByCompanyName(String companyName) {
        Lead lead = null;
        for (Lead lead1 : this.leads) {
            if (lead1.getCompanyName().equals(companyName)) {
                lead = lead1;
            }
        }
        return lead;
    }



    public ArrayList<Lead> showAllLeads(){
      return this.leads;
    }

}


