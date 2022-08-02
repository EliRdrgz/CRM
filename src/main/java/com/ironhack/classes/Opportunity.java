package com.ironhack.classes;

import com.ironhack.enums.OpportunityStatus;

import java.util.ArrayList;
import java.util.Arrays;

public class Opportunity  {
    private String id;
    private static int counter = 0;
    private ArrayList<Product> productList;
    private Contact decisionMaker;
    private OpportunityStatus status;
    private Account account;


    public Opportunity(ArrayList<Product> productList, Contact decisionMaker, OpportunityStatus status, Account account) {
        setId();
        this.productList = productList;
        this.decisionMaker = decisionMaker;
        this.status = status;
        this.account = account;
    }

    public Opportunity(ArrayList<Product> productList, Contact decisionMaker, OpportunityStatus status) {
        this.productList = productList;
        this.decisionMaker = decisionMaker;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = counter ++ + "";
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
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
        return "Opportunity: "+'\n' + "ProductList: " + (productList == null ? "null" : Arrays.asList(productList).toString()) +'\n'+ "DecisionMaker: " + decisionMaker + '\n'+"Status: " + status + '\n'+"Account: " + account;
    }
}
