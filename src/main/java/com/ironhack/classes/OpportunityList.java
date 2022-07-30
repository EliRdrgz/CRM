package com.ironhack.classes;

import java.util.ArrayList;

public class OpportunityList {
    public ArrayList<Opportunity> opportunities= new ArrayList<>();


    public Opportunity get(int index) {
        return opportunities.get(index);
    }


    public void addOpportunity(Opportunity opportunity,LeadList leadList) {
        opportunities.add(opportunity);


    }

    public void removeOpportunity(Opportunity opportunity) {
        opportunities.remove(opportunity);
    }
}
