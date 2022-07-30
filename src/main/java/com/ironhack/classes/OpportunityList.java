package com.ironhack.classes;

import java.util.ArrayList;

public class OpportunityList {
    public ArrayList<Opportunity> opportunities= new ArrayList<>();


    public Opportunity get(int index) {
        return opportunities.get(index);
    }


    public void addOpportunity(Opportunity opportunity) {
        opportunities.add(opportunity);
    }
    public String showAllOpportunities(){
        String response = "";
        for (Opportunity opportunity : opportunities) {
            response += opportunity.toString()+ "\n\r";
        }
        return response;
    }
    public void removeOpportunity(Opportunity opportunity) {
        opportunities.remove(opportunity);
    }
}
