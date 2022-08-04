package com.ironhack.classes;

import com.ironhack.enums.Industry;

import java.util.ArrayList;

public class Account {

    private String id;

    private String companyName;
    private static int counter = 1000;
    private Industry industry;
    private String employees;
    private String city;
    private String country;
    private ArrayList<Contact> contactList = new ArrayList<Contact>();


    public Account(Industry industry, String employees, String city, ArrayList<Contact> contactList) {
        setId();
        this.industry = industry;
        this.employees = employees;
        this.city = city;
        this.contactList = contactList;
    }

    public Account(Industry industry, String employees, String city, ArrayList<Contact> contactList, String country) {
        this.industry = industry;
        this.employees = employees;
        this.city = city;
        this.contactList = contactList;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Account(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = counter++ + "";
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


    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void addContactToList(Contact contact) {

        contactList.add(contact);

    }

    @Override
    public String toString() {
        return "Account:" + '\n' +
                "Industry:" + industry + '\n' +
                "Employees='" + employees + '\n' +
                "City='" + city + '\n' +
                "ContactList=" + contactList + '\n' ;
    }

}
