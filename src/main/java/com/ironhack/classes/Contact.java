package com.ironhack.classes;

public class Contact {
    private static int count = 1;
    private String contactId;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact() {
    }

    public Contact(Lead lead, LeadList leadList) {
        setContactId();
        setName(lead.getName());
        setPhoneNumber(lead.getPhoneNumber());
        setEmail(lead.getEmail());
        leadList.removeLead(lead);
    }

    public void setContactId() {
        this.contactId = "" + count++;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "ContactId: " + contactId + '\n' +
                "Name: " + name + '\n' +
                "PhoneNumber: " + phoneNumber + '\n' +
                "Email: " + email;
    }
}
