package com.ironhack.classes;

import com.ironhack.enums.Industry;

public class Account {

    private Industry industry;
    private String employees;
    private String city;
    private String contact;
    private Contact contactList;
    private Opportunity opportunityList;

    public Account(Industry industry, String employees, String city, String contact, Contact contactList, Opportunity opportunityList) {
        this.industry = industry;
        this.employees = employees;
        this.city = city;
        this.contact = contact;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Contact getContactList() {
        return contactList;
    }

    public void setContactList(Contact contactList) {
        this.contactList = contactList;
    }

    public Opportunity getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(Opportunity opportunityList) {
        this.opportunityList = opportunityList;
    }
}

