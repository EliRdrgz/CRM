package com.ironhack.classes;

import com.fasterxml.uuid.Generators;

public class Contact {

    private String contactId;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Contact(Lead lead,LeadList leadList) {
        setContactId();
        setName(lead.getName());
        setPhoneNumber(lead.getPhoneNumber());
        setEmail(lead.getEmail());
        setCompanyName(lead.getCompanyName());
        leadList.removeLead(lead);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId() {
        this.contactId = Generators.randomBasedGenerator().generate().toString();
    }

    @Override
    public String toString() {
        return  "ContactId: " + contactId + '\n' +
                "Name: " + name + '\n' +
                "PhoneNumber: " + phoneNumber + '\n' +
                "Email: " + email + '\n' +
                "CompanyName:" + companyName;

    }
}
