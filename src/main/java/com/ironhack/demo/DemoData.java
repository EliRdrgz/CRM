package com.ironhack.demo;

import com.github.javafaker.Faker;
import com.ironhack.classes.*;
import com.ironhack.enums.TypeOfProduct;

import java.util.ArrayList;
import java.util.Random;

import static com.ironhack.enums.TypeOfProduct.*;

public class DemoData {

    private final int MAX_LEADS = 60;
    private final int MAX_CONTACTS = 34;

    Faker faker = new Faker();

    public LeadList createDemoLeads() {
        LeadList demoLeadList = new LeadList();
        for (int i = 0; i < MAX_LEADS; i++) {
            Lead demoLead = new Lead(faker.name().fullName(), faker.phoneNumber().cellPhone(),
                    faker.internet().safeEmailAddress(), faker.company().name());
            demoLeadList.addLead(demoLead);
        }
        return demoLeadList;
    }

    public ArrayList<Contact> createDemoContacts(LeadList leadList) {
        ArrayList<Contact> demoContactList = new ArrayList<>();
        int[] randomIndex = {1, 2, 4, 5, 8, 9, 11, 12, 14, 15, 17, 19, 22, 23, 25, 27, 28, 29, 30, 31, 32, 33, 35, 36
                , 38, 39, 40, 41, 42, 43, 44, 45, 48, 49};
        for (int index : randomIndex) {
            Contact demoContact = new Contact(leadList.getLeadById(index), leadList);
            demoContactList.add(demoContact);
        }
        return demoContactList;
    }

    public ArrayList<Product> createDemoProductList() {
        ArrayList<Product> demoProductList = new ArrayList<>();
        int maxProducts = new Random().nextInt(1, 3);
        for (int i = 0; i < maxProducts; i++) {
            TypeOfProduct demoType = null;
            int productType = new Random().nextInt(1, 4);
            switch (productType) {
                case 1 -> demoType = HYBRID;
                case 2 -> demoType = FLATBED;
                case 3 -> demoType = BOX;
            }
            Product demoProduct = new Product(demoType, new Random().nextInt(20, 300));
            demoProductList.add(demoProduct);
        }
        return demoProductList;
    }

    public OpportunityList createDemoOpportunities(ArrayList<Contact> contactList) {
        OpportunityList demoOpportunityList = new OpportunityList();
        ArrayList<Product> demoProductList;
        for (int i = 0; i < MAX_CONTACTS; i++) {
            demoProductList = createDemoProductList();
            Opportunity demoOpportunity = new Opportunity(demoProductList, contactList.get(i));
            demoOpportunityList.addOpportunity(demoOpportunity);
        }
        return demoOpportunityList;
    }

    public ArrayList<Account> createDemoAccounts() {
        ArrayList<Account> demoAccountList = new ArrayList<>();
//        for (int i = 0; i < MAX_CONTACTS; i++) {
//            Address address = faker.address();
//            Industry demoIndustry = null;
//            int industryType = new Random().nextInt(1, 6);
//            switch (industryType) {
//                case 1 -> demoIndustry = PRODUCE;
//                case 2 -> demoIndustry = ECOMMERCE;
//                case 3 -> demoIndustry = MANUFACTURING;
//                case 4 -> demoIndustry = MEDICAL;
//                case 5 -> demoIndustry = OTHER;
//            }
//            Account demoAccount = new Account(demoIndustry, faker.number().randomDigit(), address.city(),
//                    address.country());
//            demoAccountList.add(demoAccount);
//        }
        return demoAccountList;
    }
}