package com.ironhack.menu;


import com.ironhack.classes.*;
import com.ironhack.demo.DemoData;
import com.ironhack.demo.LoadDemoData;
import com.ironhack.enums.Industry;
import com.ironhack.enums.TypeOfProduct;

import java.util.ArrayList;

import com.ironhack.classes.Lead;

import java.util.Map;
import java.util.Scanner;

import static com.ironhack.enums.OpportunityStatus.*;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    private String option;
    LeadList leadList = new LeadList();

    OpportunityList opportunityList = new OpportunityList();


    public void start() throws InterruptedException {

        scanner = new Scanner(System.in);
        while (!exit) {
            showMenu();
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "NEW LEAD" -> newLeadInfo(leadList);
                case "SHOW LEADS" -> showLeads(leadList);
                case "LOOKUP LEAD ID" -> searchLead(leadList);
                case "CONVERT ID" -> convertId(leadList);
                case "EDIT OPPORTUNITY" -> editOpportunity(opportunityList);
                case "LOAD DEMO DATA" -> LoadDemoData.loadAllDemo();
                case "EXIT" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }
    }

    private void showMenu() {
        System.out.println("------------------------------------------");
        System.out.println("Welcome to CRM. What would you like to do?");
        System.out.println("------------------------------------------");
        System.out.println("New lead");
        System.out.println("Show leads");
        System.out.println("Lookup Lead id");
        System.out.println("Convert id");
        System.out.println("Load demo data");
        System.out.println("Edit opportunity");
        System.out.println("Exit");
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

        if (!name.isBlank() && !phoneNumber.isBlank() && !email.isBlank() && !companyName.isBlank()) {
            Lead lead = new Lead(name, phoneNumber, email, companyName);
            leadList.addLead(lead);
            System.out.println("Lead created: " + lead);
        }
        else{
            System.out.println("ERROR!! Enter all details");
        }
    }

    private void showLeads(LeadList leadList) {
        if(leadList.size() > 0) {
            System.out.println("Total leads at the data base: " + leadList.size());
            Map<Integer, String> allLeads = leadList.showAllLeads();
            System.out.println(allLeads);
        }
        else{
            System.out.println("No existing leads to show");
        }
        System.out.println("-----------------------------");
    }

    private void searchLead(LeadList leadList) {
        if(leadList.size() > 0) {
            System.out.println("Enter lead id: ");
            System.out.println("-------------");
            int id = scanner.nextInt();
            System.out.println(leadList.get(id));
        }
        else{
            System.out.println("No existing leads to search");
        }
    }

    private void convertId(LeadList leadList) {
        if (leadList.size() > 0) {
            System.out.println("Enter lead id to convert to opportunity: ");
            System.out.println("--------------------");
            int id = scanner.nextInt();
            Lead leadConvert = leadList.getLeadById(id);
            Contact contact = new Contact(leadConvert, leadList);
            System.out.println("-----------------------------------------");
            System.out.println("Now the lead with id " + id + " is a new contact.");
            System.out.println("-----------------------------------------");
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
                }
            }
            Opportunity opportunity = new Opportunity(productList, contact);
            opportunityList.addOpportunity(opportunity);
            System.out.println("-----------------------------------------");
            System.out.println("The opportunity has been created successfully.");
            System.out.println("-----------------------------------------");
            System.out.println("What type of industry is the company?");
            System.out.println("PRODUCE");
            System.out.println("ECOMMERCE");
            System.out.println("MANUFACTURING");
            System.out.println("MEDICAL");
            System.out.println("OTHER");
            option = scanner.next().toUpperCase();
            Industry industry = Industry.valueOf(option);

            System.out.println("Number of employees of the company: ");
            int numberSelected = scanner.nextInt();

            System.out.println("Company city: ");
            String citySelected = scanner.next();

            System.out.println("Company country: ");
            String countrySelected = scanner.next();

            Account account = new Account(industry,numberSelected,citySelected,countrySelected);
            account.addContactToList(contact);
            account.addOpportunityToList(opportunity);
            System.out.println("Account saved successfully.");
            System.out.println("-----------------------------------------");
            System.out.println(account);
            System.out.println("-----------------------------------------");
        }
        else{
            System.out.println("No existing leads to convert");
        }
    }

    private void editOpportunity(OpportunityList opportunityList) {
        System.out.println(opportunityList.showAllOpportunities());
        System.out.println("---------------------");
        System.out.print("Select opportunity id: ");
        int id = scanner.nextInt();
        Opportunity chosenOpportunity = opportunityList.getOpportunityById(id);
        System.out.println(chosenOpportunity);
        System.out.println("What should be the new status?");
        System.out.println("---------------------");
        System.out.println("close-lost id");
        System.out.println("close-won id");
        String newStatus = scanner.next();
        if (newStatus.contains("lost")) {
            chosenOpportunity.setStatus(CLOSED_LOST);
            opportunityList.removeOpportunity(chosenOpportunity);

        } else if (newStatus.contains("won")) {
            chosenOpportunity.setStatus(CLOSED_WON);
            opportunityList.removeOpportunity(chosenOpportunity);
        } else {
            System.out.println("Incorrect option");
        }
        System.out.println("New status: " + chosenOpportunity.getStatus());
    }
}
