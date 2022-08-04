package com.ironhack.menu;


import com.ironhack.classes.*;
import com.ironhack.demo.DemoData;
import com.ironhack.enums.Industry;
import com.ironhack.enums.OpportunityStatus;
import com.ironhack.enums.TypeOfProduct;
import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;

import com.ironhack.classes.Lead;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    private String option;
    LeadList leadList;


    public void showMenu() {

        scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("Welcome to CRM. What would you like to do?");
            System.out.println("------------------------------------------");
            System.out.println("New lead");
            System.out.println("Show leads");
            System.out.println("Lookup Lead id");
            System.out.println("Convert id");
            System.out.println("Load demo data");
            System.out.println("Exit");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "NEW LEAD" -> newLeadInfo(leadList);
                case "SHOW LEADS" -> showLeads(leadList);
                case "LOOKUP LEAD ID" -> searchLead(leadList);
                case "CONVERT ID" -> convertId(leadList);
                case "LOAD DEMO DATA" -> loadDemoData();

                case "EXIT" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }
    }


    private void newLeadInfo(LeadList leadList) {

        System.out.println("Enter lead details");
        System.out.println("------------------");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Company name: ");
        String companyName = scanner.nextLine();

        Lead lead = new Lead(name, phoneNumber, email, companyName);
        leadList.addLead(lead);
        System.out.println("Lead created: " + lead);
    }

    private void showLeads(LeadList leadList) {
        System.out.println("This is the list of all leads");
        System.out.println("-----------------------------");
        ArrayList<Lead> allLeads = leadList.showAllLeads();
        for (Lead lead : allLeads) {
            System.out.println(lead.toString());
        }
        System.out.println("-----------------------------");
        System.out.println("Total leads at the data base: " + allLeads.size());
    }

    private void searchLead(LeadList leadList) {
        System.out.println("Enter lead id: ");
        System.out.println("-------------");
        int id = scanner.nextInt();
//        leadList.get(id);
        System.out.println(leadList.get(id));
    }

    private void convertId(LeadList leadList) {
        System.out.println("Enter lead id to convert to opportunity: ");
        System.out.println("-------------");
        String id = scanner.nextLine();
        //System.out.println(leadList.getLeadById(id));
        Lead leadConvert = leadList.getLeadById(id);
        Contact contact = new Contact(leadConvert, leadList);
        System.out.println("Now the lead with id " + id + " is a new contact.");
        System.out.println(contact);
        ArrayList<Product> productList = new ArrayList<>();
        boolean doneOrder = false;
        while (!doneOrder) {
            System.out.println("In which type of product are you interested?");
            Scanner scanner = new Scanner(System.in);
            System.out.println("HYBRID");
            System.out.println("FLATBED");
            System.out.println("BOX");
            System.out.println("DONE");
            option = scanner.nextLine().toUpperCase();
            if (option.equals("DONE")) {
                doneOrder = true;
            } else {
                TypeOfProduct type = TypeOfProduct.valueOf(option);
                System.out.println("How many of those?");
                int quantity = scanner.nextInt();
                Product product = new Product(type, quantity);
                productList.add(product);
                System.out.println(productList);
            }
        }
        Opportunity opportunity = new Opportunity(productList, contact, OpportunityStatus.OPEN);
        System.out.println("The opportunity has been created successfully.");
        System.out.println(opportunity);
        System.out.println("What type of industry is the company?");
        System.out.println("PRODUCE");
        System.out.println("ECOMMERCE");
        System.out.println("MANUFACTURING");
        System.out.println("MEDICAL");
        System.out.println("OTHER");
        option = scanner.nextLine().toUpperCase();
        Account account = new Account();
        if (option.equals("PRODUCE")) {
            account.setIndustry(Industry.PRODUCE);
        } else if (option.equals("ECOMMERCE")) {
            account.setIndustry(Industry.ECOMMERCE);
        } else if (option.equals("MANUFACTURING")) {
            account.setIndustry(Industry.MANUFACTURING);
        } else if (option.equals("MEDICAL")) {
            account.setIndustry(Industry.MEDICAL);
        } else if (option.equals("OTHER")) {
            account.setIndustry(Industry.OTHER);
        } else {
            System.out.println("Choose a industry of the list. If the industry that you want does not appear in the " +
                    "list, choose OTHER.");
        }
        System.out.println("Number of employees of the company: ");
        option = scanner.nextLine();
        account.setEmployees(option);
        System.out.println("Company's city:");
        option = scanner.nextLine();
        account.setCity(option);
        System.out.println("Company's country:");
        option = scanner.nextLine();
        account.setCountry(option);
        System.out.println(account);

    }

    private void loadDemoData() {
        System.out.print("How many leads?");
        int leadsToCreate = scanner.nextInt();
        DemoData demo = new DemoData();
        leadList = demo.createDemoLeads(leadsToCreate);
    }
}
