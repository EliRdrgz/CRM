package com.ironhack.classes;

import com.ironhack.enums.OpportunityStatus;

import java.util.Arrays;

public class Opportunity extends Lead{

    private Product productList [];
    private Contact decisionMaker;
    private OpportunityStatus status;
    private Account account;

    public Opportunity(String id, String name, String phoneNumber, String email, String companyName, Product[] productList, Contact decisionMaker, OpportunityStatus status, Account account) {
        super(name, phoneNumber, email, companyName);
        this.productList = productList;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.account = account;
    }

    public Product[] getProductList() {
        return productList;
    }

    public void setProductList(Product[] productList) {
        this.productList = productList;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public OpportunityStatus getStatus() {
        return status;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Opportunity{" + "productList=" + (productList == null ? "null" : Arrays.asList(productList).toString()) +
                ", decisionMaker=" + decisionMaker +
                ", status=" + status +
                ", account=" + account +
                '}';
    }
}