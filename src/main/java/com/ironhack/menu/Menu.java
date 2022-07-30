package com.ironhack.menu;

import com.ironhack.classes.Lead;
import com.ironhack.classes.LeadList;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    private String option;

    public void showMenu(LeadList leadList) {
        scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("Welcome to CRM. What would you like to do?");
            System.out.println("------------------------------------------");
            System.out.println("New lead");
            System.out.println("Show leads");
            System.out.println("Lookup Lead id");
            System.out.println("Convert id");
            System.out.println("Exit");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "NEW LEAD" -> newLeadInfo(leadList);
                case "SHOW LEADS" -> showLeads(leadList);
                case "LOOKUP LEAD ID" -> searchLead(leadList);
                case "CONVERT ID" -> System.out.println("option 4");
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
        for (Lead lead : allLeads
        ) {
            System.out.println(lead.toString());
        }
    }

    private void searchLead(LeadList leadList) {
        System.out.println("Enter lead id");
        System.out.println("-------------");
        int id = scanner.nextInt();
        leadList.get(id);
    }

}
