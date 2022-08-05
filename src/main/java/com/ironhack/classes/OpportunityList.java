package com.ironhack.classes;

import java.util.ArrayList;

public class OpportunityList {
    public ArrayList<Opportunity> opportunities= new ArrayList<>();

    public void addOpportunity(Opportunity opportunity) {
        opportunities.add(opportunity);
    }
    public String showAllOpportunities(){
        String response = "";
        for (Opportunity opportunity : opportunities) {
            response += opportunity.toString();
        }
        return response;
    }

    public Opportunity getOpportunityById(int id){
        for (Opportunity opportunity : opportunities) {
            if(opportunity.getId() == id) return opportunity;
        }
        return null;
    }
    public void removeOpportunity(Opportunity opportunity) {
        opportunities.remove(opportunity);
    }
}
