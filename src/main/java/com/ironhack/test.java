//package com.ironhack;
//
//import com.github.javafaker.Faker;
//import com.ironhack.classes.*;
//import com.ironhack.enums.Industry;
//import com.ironhack.enums.OpportunityStatus;
//import com.ironhack.enums.TypeOfProduct;
//
//import java.util.ArrayList;
//
//public class test {
//    public static void main(String[] args) {
//
//
//        LeadList leadList = new LeadList();
//        OpportunityList opportunityList = new OpportunityList();
//        Faker faker = new Faker();
//        //create TestLead
//        for (int i = 0; i < 50; i++) {
//            Lead testLead = new Lead(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.internet().safeEmailAddress(), faker.company().name());
//            leadList.addLead(testLead);
//        }
//        //create TestOpportunity
//
//
//        System.out.println("LeadList-->" + leadList.showAllLeads().toString());
//        System.out.println("leads size-->" + leadList.size());
//        System.out.println("lead3-->" + leadList.getLeadById("3").toString());
//
//        Contact testContact = new Contact(leadList.get(3),leadList);
//        System.out.println(testContact);
//        Account testAccount = new Account(Industry.ECOMMERCE, faker.number().toString(), faker.company().name(), faker.company().name(), testContact);
//        Product testProduct = new Product(TypeOfProduct.BOX, 22);
//        ArrayList<Product> products = new Product[2];
//        products.set(0, testProduct);
//        Opportunity testOpportunity = new Opportunity(products, testContact, OpportunityStatus.OPEN,testAccount);
//        opportunityList.addOpportunity(testOpportunity);
//        opportunityList.addOpportunity(testOpportunity);
//        System.out.println(testOpportunity.toString());
//        testOpportunity.setStatus(OpportunityStatus.CLOSED_WON);
//        System.out.println(testOpportunity.toString());
//        testOpportunity.setStatus(OpportunityStatus.CLOSED_LOST);
//        System.out.println(testOpportunity.toString());
//
//        System.out.println("OpportunityList-->\n" + opportunityList.showAllOpportunities());
//
//
//    }
//}