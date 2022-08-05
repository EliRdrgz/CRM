package com.ironhack.classes;

import com.ironhack.enums.Industry;

import java.util.ArrayList;

public class Account {

    private static int counter = 1000;
    private int id;
    private Industry industry;
    private int numberOfEmployees;
    private String city;
    private String country;
    private ArrayList<Contact> contactList = new ArrayList<>();
    private ArrayList<Opportunity> opportunityList = new ArrayList<>();

    public Account(Industry industry, int numberOfEmployees, String city, String country) {
        setId();
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
        this.city = city;
        this.country = country;
    }

    public void setId() {
        this.id = counter++;
    }

    public ArrayList<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void addContactToList(Contact contact) {
        contactList.add(contact);
    }

    public void addOpportunityToList(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    @Override
    public String toString() {
        return "Account: " + id + '\n' +
                "Industry: " + industry + '\n' +
                "Employees: " + numberOfEmployees + '\n' +
                "City: " + city + '\n' +
                "Country: " + country + '\n' +
                "ContactList: " + contactList + '\n' +
                "OpportunityList: " + opportunityList;
    }
}
