package com.ironhack.demo;

import com.ironhack.classes.*;
import com.ironhack.menu.Menu;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public final class LoadDemoData {
    static DemoData demoData = new DemoData();
    public static LeadList demoLeads = new LeadList();
    static ArrayList<Contact> contactList = new ArrayList<>();
    static ArrayList<Product> productList = new ArrayList<>();
    public static OpportunityList opportunitiesList = new OpportunityList();

    public static void loadAllDemo() throws InterruptedException {
        System.out.println("Loading demo data...");
        demoLeads = demoData.createDemoLeads();
        contactList = demoData.createDemoContacts(demoLeads);
//        productList = demoData.createDemoProductList();
        opportunitiesList = demoData.createDemoOpportunities(contactList);
        sleep(1500L);
        System.out.println("Data loaded correctly!");
    }
}