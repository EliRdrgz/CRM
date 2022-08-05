package com.ironhack.demo;

import com.ironhack.classes.Contact;
import com.ironhack.classes.LeadList;
import com.ironhack.classes.OpportunityList;
import com.ironhack.classes.Product;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public final class LoadDemoData {
    static DemoData demoData = new DemoData();
    static LeadList demoLeads = new LeadList();
    static ArrayList<Contact> contactList = new ArrayList<>();
    static ArrayList<Product> productList = new ArrayList<>();
    static OpportunityList opportunitiesList = new OpportunityList();
    public static void loadAllDemo() throws InterruptedException {
        System.out.println("Loading demo data...");
        demoLeads = demoData.createDemoLeads();
        contactList = demoData.createDemoContacts(demoLeads);
        productList = demoData.createDemoProductList();
        opportunitiesList = demoData.createDemoOpportunities(productList,contactList);

        sleep(1500L);
        System.out.println("Data loaded correctly!");
    }
}