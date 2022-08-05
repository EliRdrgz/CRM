package com.ironhack.demo;

import com.github.javafaker.Faker;
import com.ironhack.classes.*;
import com.ironhack.enums.TypeOfProduct;

import java.util.ArrayList;
import java.util.Random;

import static com.ironhack.enums.TypeOfProduct.*;

public class DemoData {

    private final int MAX_LEADS = 50;
    private final int MAX_CONTACTS = 34;

    public LeadList createDemoLeads() {
        LeadList demoLeadList = new LeadList();
        Faker faker = new Faker();
        for (int i = 0; i < MAX_LEADS; i++) {
            Lead demoLead = new Lead(faker.name().fullName(), faker.phoneNumber().cellPhone(),
                    faker.internet().safeEmailAddress(), faker.company().name());
            demoLeadList.addLead(demoLead);
        }
        return demoLeadList;
    }

    public ArrayList<Contact> createDemoContacts(LeadList leadList) {
        ArrayList<Contact> demoContactList = new ArrayList<>();
        int[] randomIndex = {1, 2, 4, 5, 8, 9, 11, 12, 14, 15, 17, 19, 22, 23, 25, 27, 28, 29, 30, 31, 32, 33, 35, 36,
                             38, 39, 40, 41, 42, 43, 44, 45, 48, 49};
        for (int index : randomIndex) {
            Contact contact = new Contact(leadList.getLeadById(index), leadList);
            demoContactList.add(contact);
        }
        return demoContactList;
    }

    public ArrayList<Product> createDemoProductList(){
        ArrayList<Product> productList = new ArrayList<>();
        for (int i = 0; i < MAX_CONTACTS; i++) {
            TypeOfProduct type = null;
            int productType = new Random().nextInt(1,4);
            switch (productType){
                case 1 -> type = HYBRID;
                case 2 -> type = FLATBED;
                case 3 -> type = BOX;
            }
            Product product = new Product(type, new Random().nextInt(20,300));
            productList.add(product);
        }
        return productList;
    }

    public OpportunityList createDemoOpportunities(ArrayList<Product> productList, ArrayList<Contact> contactList){
        OpportunityList opportunityList = new OpportunityList();
        for (int i = 0; i < MAX_CONTACTS; i++) {
            Opportunity opportunity = new Opportunity(productList, contactList.get(i));
            opportunityList.addOpportunity(opportunity);
        }
        return opportunityList;
    }
}