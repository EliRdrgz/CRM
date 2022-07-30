package com.ironhack.classes;

import com.ironhack.enums.Industry;

public class Account {

    private String id;
    private static int counter = 0;
    private Industry industry;
    private String employees;
    private String city;
    private String contact;
    private Contact contactList;
    private OpportunityList opportunityList;

    public Account(Industry industry, String employees, String city, String contact, Contact contactList) {
        setId();
        this.industry = industry;
        this.employees = employees;
        this.city = city;
        this.contact = contact;
        this.contactList = contactList;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = counter ++ + "";
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

    public OpportunityList getOpportunityList() {
        return opportunityList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "industry=" + industry +
                ", employees='" + employees + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                '}';
    }

    public void setOpportunityList(OpportunityList opportunityList) {
        this.opportunityList = opportunityList;
    }
}

