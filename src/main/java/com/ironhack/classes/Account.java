package com.ironhack.classes;

import com.ironhack.enums.Industry;

import java.util.ArrayList;

public class Account {

    private static int counter = 1000;
    private int id;

    private String companyName;
    private Industry industry;
    private int numberOfEmployees;
    private String city;
    private String country;
    private ArrayList<Contact> contactList = new ArrayList<>();


    public Account(Industry industry, int numberOfEmployees, String city, String country, String companyName) {
        setId();
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
        this.city = city;
        this.country = country;
        this.companyName = companyName;
    }
    public Account(String companyName){
        setId();
        this.companyName = companyName;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setId() {
        this.id = counter++;
    }


    public void addContactToList(Contact contact) {
        contactList.add(contact);
    }


    @Override
    public String toString() {
        return "Account: " + id + '\n' +
                "Industry: " + industry + '\n' +
                "Employees: " + numberOfEmployees + '\n' +
                "City: " + city + '\n' +
                "Country: " + country + '\n' +
                "ContactList: " + contactList + '\n' +
                "CompanyName: " + companyName + '\n';
    }
}
