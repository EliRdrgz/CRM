package com.ironhack.classes;

import java.util.ArrayList;

public class OpportunityList {
    private ArrayList<Opportunity> opportunities;

    public void addOpportunity(Opportunity opportunity) {
        opportunities.add(opportunity);
    }

    public void removeOpportunity(Opportunity opportunity) {
        opportunities.remove(opportunity);
    }
}
