package com.ironhack.classes;

import java.sql.SQLOutput;
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
