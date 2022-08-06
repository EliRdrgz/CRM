package com.ironhack.data;

import com.ironhack.classes.Lead;
import com.ironhack.classes.LeadList;
import com.ironhack.classes.Opportunity;
import com.ironhack.classes.OpportunityList;

public class CrmData {
    public LeadList leadList = new LeadList();
    public OpportunityList opportunityList = new OpportunityList();

    public CrmData(LeadList leadList, OpportunityList opportunityList) {
        this.leadList = leadList;
        this.opportunityList = opportunityList;
    }

    public CrmData() {

    }

    public void addOpportunitysToList(OpportunityList opportunityList) {
        for (Opportunity actualOpportunity : opportunityList.opportunities) {
            Opportunity temp = new Opportunity(actualOpportunity.getProductList(), actualOpportunity.getDecisionMaker(), actualOpportunity.getStatus(), actualOpportunity.getAccount());
            opportunityList.addOpportunity(temp);
        }
    }

    public void addLeadsToList(LeadList tempList) {
        for (Lead actualLead : tempList.leads) {
            Lead tmp = new Lead(actualLead.getName(), actualLead.getPhoneNumber(), actualLead.getEmail(), actualLead.getCompanyName());
            leadList.addLead(tmp);
        }

    }




}
