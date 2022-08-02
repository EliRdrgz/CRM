package com.ironhack;


import com.github.javafaker.Faker;
import com.ironhack.classes.Contact;
import com.ironhack.classes.Lead;
import com.ironhack.classes.LeadList;
import com.ironhack.classes.OpportunityList;
import com.ironhack.menu.Menu;

public class Main {
    public static void main(String[] args) {

        LeadList leadList = new LeadList();
        Faker faker = new Faker();
        //create TestLead
        for (int i = 0; i < 50; i++) {
            Lead testLead = new Lead(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.internet().safeEmailAddress(), faker.company().name());
            leadList.addLead(testLead);
        }
        new Menu().showMenu(leadList);
       /*

        LeadList leadList = new LeadList();
        OpportunityList opportunityList = new OpportunityList();
        Faker faker = new Faker();
        //create TestLead
        for (int i = 0; i < 50; i++) {
            Contact testContact = new Contact(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.internet().safeEmailAddress(), faker.company().name());
            Lead testLead = new Lead(faker.name().fullName(), testContact);
            leadList.addLead(testLead);
        }
        //create TestOpportunity


        System.out.println("LeadList-->"+leadList.showAllLeads());
        System.out.println("leads size-->"+leadList.size());
        System.out.println("lead3-->"+leadList.get(3));

        Contact testContact = new Contact(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.internet().safeEmailAddress(), faker.company().name());
        Account testAccount = new Account(Industry.ECOMMERCE, faker.number().toString(),faker.company().name(),faker.company().name(),testContact);
        Opportunity testOpportunity = new Opportunity(leadList.get(3), null, null, OpportunityStatus.OPEN, null);
        System.out.println("lead3-->"+leadList.get(3));
        */

        new Menu().showMenu();

    }
}