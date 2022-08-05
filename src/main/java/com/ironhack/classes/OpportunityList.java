package com.ironhack.classes;

import com.ironhack.enums.OpportunityStatus;

import java.sql.SQLOutput;
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
    public String showOpenOpportunities(){
        String response = "";
        for (Opportunity opportunity : opportunities) {
            if (opportunity.getStatus() == OpportunityStatus.OPEN) {
                response += opportunity.toString();
            }
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

    public int[] getAllOpportunitiesId(){
        int[] ids = new int[opportunities.size()];
        for (int i = 0; i < opportunities.size(); i++) {
            ids[i] = opportunities.get(i).getId();
        }
        return ids;
    }

    public ArrayList<Opportunity> searchByCompanyName(String name){
        ArrayList<Opportunity> opporunitiesCompany = new ArrayList<>();
        for(Opportunity opportunity : opportunities){
            if(opportunity.getAccount().getCompanyName().equalsIgnoreCase(name)){
                opporunitiesCompany.add(opportunity);
            }
        }
        System.out.println(opporunitiesCompany.size());
        return opporunitiesCompany;
    }
}
