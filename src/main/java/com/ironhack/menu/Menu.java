package com.ironhack.menu;


import com.ironhack.classes.*;
import com.ironhack.console.ConsoleBuilder;
import com.ironhack.demo.DemoData;
import com.ironhack.enums.Industry;
import com.ironhack.enums.OpportunityStatus;
import com.ironhack.enums.TypeOfProduct;

import java.util.*;

import com.ironhack.classes.Lead;

import static com.ironhack.enums.OpportunityStatus.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    ConsoleBuilder consoleBuilder = new ConsoleBuilder(scanner);

    private String option;
    LeadList leadList = new LeadList();

    OpportunityList opportunityList = new OpportunityList();


    public void start() {

        scanner = new Scanner(System.in);

        while (!exit) {
            List<String> options = Arrays.asList("New lead", "Show leads", "Lookup Lead id", "Convert id", "Search opportunity by company name", "Load demo data", "Edit opportunity", "Exit");
            option = consoleBuilder.listConsoleInput( "Welcome to CRM. What would you like to do?", options);
            switch (option) {
                case "NEW LEAD" -> newLeadInfo(leadList);
                case "SHOW LEADS" -> showLeads(leadList);
                case "LOOKUP LEAD ID" -> searchLead(leadList);
                case "CONVERT ID" -> convertId(leadList);
//                case "SEARCH OPPORTUNITY BY COMPANY NAME" -> System.out.println("===");
                case "EDIT OPPORTUNITY" -> editOpportunity(opportunityList);
                case "LOAD DEMO DATA" -> loadDemoData();
                case "EXIT" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }
    }


    private void newLeadInfo(LeadList leadList) {
        System.out.println("Enter lead details");
        System.out.println("------------------");

        String name = consoleBuilder.textConsoleInput( "Name:");
        String phoneNumber = consoleBuilder.textConsoleInput( "Phone number:");
        String email = consoleBuilder.textConsoleInput( "Email:");
        String companyName = consoleBuilder.textConsoleInput( "Company name:");

        if (!name.isBlank() && !phoneNumber.isBlank() && !email.isBlank() && !companyName.isBlank()) {
            Lead lead = new Lead(name, phoneNumber, email, companyName);
            leadList.addLead(lead);
            System.out.println("Lead created: " + lead);
        } else {
            System.out.println("ERROR!! Enter all details");
        }
    }

    private void showLeads(LeadList leadList) {
        if (leadList.size() > 0) {
            System.out.println("Total leads at the data base: " + leadList.size());
            Map<Integer, String> allLeads = leadList.showAllLeads();
            System.out.println(allLeads);
        } else {
            System.out.println("No existing leads to show");
        }
        System.out.println("-----------------------------");
    }

    private void searchLead(LeadList leadList) {
        if (leadList.size() > 0) {
            int id = consoleBuilder.numberConsoleInput( "Enter lead Id:", leadList.getAllIds());
            System.out.println(leadList.getLeadById(id));
        } else {
            System.out.println("No existing leads to search");
        }
    }

    private void convertId(LeadList leadList) {
        if (leadList.size() > 0) {
            System.out.println(" ");
            int id = consoleBuilder.numberConsoleInput( "Enter lead id to convert to opportunity:", leadList.getAllIds());
            Lead leadConvert = leadList.getLeadById(id);
            Contact contact = new Contact(leadConvert, leadList);
            System.out.println("-----------------------------------------");
            System.out.println("Now the lead with id " + id + " is a new contact.");
            System.out.println("-----------------------------------------");
            ArrayList<Product> productList = new ArrayList<>();
            boolean doneOrder = false;
            while (!doneOrder) {
                List<String> options = Arrays.asList("HYBRID","FLATBED","BOX","DONE");
                option = consoleBuilder.listConsoleInput("In which type of product are you interested?", options);
                if (option.equals("DONE")) {
                    doneOrder = true;
                } else {
                    TypeOfProduct type = TypeOfProduct.valueOf(option);
                    int quantity = consoleBuilder.numberConsoleInput("How many of those?", 1,999);
                    Product product = new Product(type, quantity);
                    productList.add(product);
                    System.out.println(productList);
                }
            }
            Opportunity opportunity = new Opportunity(productList, contact);
            opportunityList.addOpportunity(opportunity);

            List<String> options = Arrays.asList("PRODUCE","ECOMMERCE","MANUFACTURING","MEDICAL","OTHER");
            option = consoleBuilder.listConsoleInput("The opportunity has been created successfully.", options);
            Industry industry = Industry.valueOf(option);

            int numberSelected = consoleBuilder.numberConsoleInput("Number of employees of the company:");
            String citySelected = consoleBuilder.textConsoleInput("Company city: ");
            String countrySelected = consoleBuilder.textConsoleInput("Company country: ");

            Account account = new Account(industry, numberSelected, citySelected, countrySelected);
            account.addContactToList(contact);
            account.addOpportunityToList(opportunity);
            System.out.println("Account saved successfully.");
            System.out.println("-----------------------------------------");
            System.out.println(account);
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("No existing leads to convert");
        }
    }

//    private void searchOpportunityByCompanyName(){
//        System.out.println("Please enter company name to search opportunities: ");
//        String name = scanner.nextLine();
////        System.out.println(opportunityList.searchByCompanyName(name));
//    }

    private void editOpportunity(OpportunityList opportunityList) {
        System.out.println(opportunityList.showAllOpportunities());
        System.out.println("---------------------");
        System.out.print("Select opportunity id: ");
        int id = consoleBuilder.numberConsoleInput("Select opportunity id: ",opportunityList.getAllOpportunitiesId());
        Opportunity chosenOpportunity = opportunityList.getOpportunityById(id);
        System.out.println(chosenOpportunity);
        System.out.println("What should be the new status?");
        System.out.println("---------------------");
        List<String> options = Arrays.asList(CLOSED_LOST.toString(), CLOSED_WON.toString());
        String newStatus = consoleBuilder.listConsoleInput("What should be the new status?",options);
        if (newStatus.equals(CLOSED_LOST.toString())) {
            chosenOpportunity.setStatus(CLOSED_LOST);
        } else{
            chosenOpportunity.setStatus(CLOSED_WON);
        }
        System.out.println("New status: " + chosenOpportunity.getStatus());
    }

    private void loadDemoData() {
        System.out.print("How many leads? ");
        int leadsToCreate = scanner.nextInt();
        DemoData demo = new DemoData();
        leadList = demo.createDemoLeads(leadsToCreate);
        if (leadList.size() > 0) {
            System.out.println("Data loaded correctly");
        } else {
            System.out.println("Failed to load data");
        }
    }

}
