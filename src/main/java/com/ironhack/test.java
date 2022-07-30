package com.ironhack;

import com.github.javafaker.Faker;
import com.ironhack.classes.*;
import com.ironhack.enums.Industry;
import com.ironhack.enums.OpportunityStatus;
import com.ironhack.menu.Menu;

public class test {
    public static void main(String[] args) {


        LeadList leadList = new LeadList();
        OpportunityList opportunityList = new OpportunityList();
        Faker faker = new Faker();
        //create TestLead
        for (int i = 0; i < 50; i++) {
            Lead testLead = new Lead(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.internet().safeEmailAddress(), faker.company().name());
            leadList.addLead(testLead);
        }
        //create TestOpportunity


        System.out.println("LeadList-->"+leadList.showAllLeads());
        System.out.println("leads size-->"+leadList.size());
        System.out.println("lead3-->"+leadList.get(3));
        Contact testContact = new Contact(leadList.get(3));

/*

        Account testAccount = new Account(Industry.ECOMMERCE, faker.number().toString(),faker.company().name(),faker.company().name(),testContact);
        Opportunity testOpportunity = new Opportunity(leadList.get(3), null, null, OpportunityStatus.OPEN, null);
        System.out.println("lead3-->"+leadList.get(3));
*/


    }
}