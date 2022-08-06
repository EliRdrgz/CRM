package com.ironhack.classes;


public class Lead {
    private static int counter = 1;
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setId();
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setId() {
        this.id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        int at = 0;
        boolean dot = false;
        boolean space = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                at++;
            }
            if (email.charAt(i) == '.') {
                dot = true;
            }
            if (email.charAt(i) == ' ') {
                space = true;
            }
        }
        if (at == 1 && dot && !space) {
            this.email = email;
        } else {
            System.out.println("Enter a valid email, please.");
        }
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "--------------------------------------------\n" +
                "LEAD ID: " + id + "\n" +
                "NAME: " + name + "\n" +
                "PHONE: " + phoneNumber + "\n" +
                "EMAIL: " + email + "\n" +
                "COMPANY: " + companyName;
    }
}