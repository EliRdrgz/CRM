package com.ironhack.menu;


import com.ironhack.classes.*;
import com.ironhack.console.ConsoleBuilder;
import com.ironhack.data.CrmData;
import com.ironhack.demo.DemoDataLoader;
import com.ironhack.enums.Industry;
import com.ironhack.enums.TypeOfProduct;
import com.ironhack.gui.GuiMain;
import com.ironhack.persistData.StoreData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.ironhack.enums.OpportunityStatus.CLOSED_LOST;
import static com.ironhack.enums.OpportunityStatus.CLOSED_WON;

public class Menu {
    Scanner scanner;
    ConsoleBuilder consoleBuilder;

    private String option;
    CrmData crm;
    StoreData storeData;

    public Menu(Scanner scanner, CrmData crm, StoreData store) {
        this.scanner = scanner;
        this.consoleBuilder = new ConsoleBuilder(scanner);
        this.crm = crm;
        this.storeData = store;

    }

    public void start() {
        crm = storeData.readData();
        boolean exit = false;
        while (!exit) {
            List<String> options = Arrays.asList("New lead", "Show leads", "Lookup Lead id", "Convert id",
                    "Search " + "opportunity by company name", "Edit opportunity", "Load demo data", "Open App", "Exit");
            option = consoleBuilder.listConsoleInput("Welcome to CRM. What would you like to do?", options);
            switch (option) {
                case "NEW LEAD" -> newLeadInfo();
                case "SHOW LEADS" -> showLeads();
                case "LOOKUP LEAD ID" -> searchLead();
                case "CONVERT ID" -> convertId();
                case "SEARCH OPPORTUNITY BY COMPANY NAME" -> searchOpportunityByCompanyName();
                case "EDIT OPPORTUNITY" -> editOpportunity();
                case "LOAD DEMO DATA" -> loadDemoData(crm);
                case "OPEN APP" -> GuiMain.main(crm.leadList, crm.opportunityList);
                case "EXIT" -> exit = true;
                default -> System.out.println("Choose a correct option.");
            }
        }
        storeData.save();
    }


    private void newLeadInfo() {
        System.out.println("Enter lead details");
        System.out.println("------------------");

        String name = consoleBuilder.textConsoleInput("Name:");
        String phoneNumber = String.valueOf(consoleBuilder.numberConsoleInput("Phone number:", 99999999, 1000000000));
        String email = consoleBuilder.emailConsoleInput("Email:");
        String companyName = consoleBuilder.textConsoleInput("Company name:");

        if (!name.isBlank() && !phoneNumber.isBlank() && !email.isBlank() && !companyName.isBlank()) {
            Lead lead = new Lead(name, phoneNumber, email, companyName);
            crm.leadList.addLead(lead);
            System.out.println("Lead created: " + lead);
        } else {
            System.out.println("ERROR!! Enter all details");
        }
    }

    private void showLeads() {
        if (crm.leadList.size() > 0) {
            System.out.println("Total leads at the data base: " + crm.leadList.size());
            String allLeads = crm.leadList.showAllLeads();

            System.out.println(allLeads);
        } else {
            System.out.println("No existing leads to show");
        }
        System.out.println("-----------------------------");
    }

    private void searchLead() {
        if (crm.leadList.size() > 0) {
            int id = consoleBuilder.numberConsoleInput("Enter lead Id:", crm.leadList.getAllIds());
            System.out.println(crm.leadList.getLeadById(id));
        } else {
            System.out.println("No existing leads to search");
        }
    }

    private void convertId() {
        if (crm.leadList.size() > 0) {
            System.out.println(" ");
            int id = consoleBuilder.numberConsoleInput("Enter lead id to convert to opportunity:",
                    crm.leadList.getAllIds());
            Account account = new Account(crm.leadList.getLeadById(id).getCompanyName());
            Contact contact = new Contact(crm.leadList.getLeadById(id), crm.leadList);
            ArrayList<Product> productList = new ArrayList<>();
            boolean doneOrder = false;
            int count = 0;
            while (!doneOrder) {
                count++;
                List<String> options = Arrays.asList("HYBRID", "FLATBED", "BOX", "DONE");
                if (count == 1) {
                    options = Arrays.asList("HYBRID", "FLATBED", "BOX");
                }
                option = consoleBuilder.listConsoleInput("In which type of product are you interested?", options);
                if (option.equals("DONE")) {
                    doneOrder = true;
                } else {
                    TypeOfProduct type = TypeOfProduct.valueOf(option);
                    int quantity = consoleBuilder.numberConsoleInput("How many of " + option + "?", 1, 999);
                    Product product = new Product(type, quantity);
                    productList.add(product);
                    System.out.println(productList);
                }
            }
            Opportunity opportunity = new Opportunity(productList, contact);


            List<String> options = Arrays.asList("PRODUCE", "ECOMMERCE", "MANUFACTURING", "MEDICAL", "OTHER");
            option = consoleBuilder.listConsoleInput("The opportunity has been created successfully.", options);
            account.setIndustry(Industry.valueOf(option));
            account.setNumberOfEmployees(consoleBuilder.numberConsoleInput("Number of employees of the company:"));
            account.setCity(consoleBuilder.textConsoleInput("Company city: "));
            account.setCountry(consoleBuilder.textConsoleInput("Company country: "));
            account.addContactToList(contact);
            opportunity.setAccount(account);
            crm.opportunityList.addOpportunity(opportunity);
            System.out.println("Opportunity created: " + opportunity);
        } else {
            System.out.println("No existing leads to convert");
        }
    }

    private void searchOpportunityByCompanyName() {
        System.out.println("Please enter company name to search opportunities: ");
        String name = scanner.nextLine();
        System.out.println(crm.opportunityList.searchByCompanyName(name));
    }

    private void editOpportunity() {
        System.out.println(crm.opportunityList.showAllOpportunities());
        System.out.println("---------------------");
        System.out.print("Select opportunity id: ");
        int id = consoleBuilder.numberConsoleInput("Select opportunity id: ", crm.opportunityList.getAllOpportunitiesId());
        Opportunity chosenOpportunity = crm.opportunityList.getOpportunityById(id);
        System.out.println(chosenOpportunity);
        System.out.println("What should be the new status?");
        System.out.println("---------------------");
        List<String> options = Arrays.asList(CLOSED_LOST.toString(), CLOSED_WON.toString());
        String newStatus = consoleBuilder.listConsoleInput("What should be the new status?", options);
        if (newStatus.equals(CLOSED_LOST.toString())) {
            chosenOpportunity.setStatus(CLOSED_LOST);
        } else {
            chosenOpportunity.setStatus(CLOSED_WON);
        }
        System.out.println("New status: " + chosenOpportunity.getStatus());
    }

    private void loadDemoData(CrmData data) {
        DemoDataLoader.loadAllDemo();
        data.addLeadsToList(DemoDataLoader.demoLeads);
        data.addOpportunitysToList(DemoDataLoader.demoOpportunities);
    }

}
