package com.ironhack.classes;

import com.fasterxml.uuid.Generators;

public class Lead {

    private String id;

    private Contact contact;
    public Lead( String name, Contact contact) {
        setId();
        setContact(contact);
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = Generators.randomBasedGenerator().generate().toString();
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


    @Override
    public String toString() {
        return "Lead{" + "id='" + id + '\'' + ", name='" + contact.getName() + '\'' + ", phoneNumber='" + contact.getPhoneNumber() + '\'' + ", email='" + contact.getEmail() + '\'' + ", companyName='" + contact.getCompanyName()+ '\'' + '}';
    }
}
