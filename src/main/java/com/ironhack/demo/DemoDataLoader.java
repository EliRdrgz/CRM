package com.ironhack.demo;

import com.ironhack.classes.*;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public final class DemoDataLoader {
    static DemoDataConstructor demoData = new DemoDataConstructor();
    public static LeadList demoLeads = new LeadList();
    static ArrayList<Contact> demoContacts = new ArrayList<>();
//    static ArrayList<Product> productList = new ArrayList<>();
    public static OpportunityList demoOpportunities = new OpportunityList();
    static ArrayList<Account> demoAccounts = new ArrayList<>();

    public static void loadAllDemo() throws InterruptedException {
        System.out.println("Loading demo data...");
        demoLeads = demoData.createDemoLeads();
        demoContacts = demoData.createDemoContacts(demoLeads);
        demoOpportunities = demoData.createDemoOpportunities(demoContacts);
        demoAccounts = demoData.createDemoAccounts(demoLeads, demoContacts, demoOpportunities);

        sleep(1500L);
        System.out.println("Data loaded correctly!");
    }
}