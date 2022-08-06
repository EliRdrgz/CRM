package com.ironhack.classes;

import com.ironhack.enums.OpportunityStatus;

import java.util.ArrayList;

import static com.ironhack.enums.OpportunityStatus.OPEN;

public class Opportunity {
    private static int counter = 1;
    private int id;
    private ArrayList<Product> productList;
    private Contact decisionMaker;
    private OpportunityStatus status;

    private Account account;


    public Opportunity(ArrayList<Product> productList, Contact decisionMaker) {
        setId();
        this.productList = productList;
        this.decisionMaker = decisionMaker;
        this.status = OPEN;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public OpportunityStatus getStatus() {
        return status;
    }

    public void setId() {
        this.id = counter++;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity{" + "id=" + id + ", productList=" + productList + ", decisionMaker=" + decisionMaker.toString() + "," +
                " status=" + status + " account" + account.toString() + '}';
    }


}
