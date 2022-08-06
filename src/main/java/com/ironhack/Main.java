package com.ironhack;


import com.ironhack.classes.LeadList;
import com.ironhack.classes.OpportunityList;
import com.ironhack.menu.Menu;
import com.ironhack.persistData.StoreData;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        LeadList leadList =  StoreData.readDataLead();
        OpportunityList opportunityList =  StoreData.readDataOpportunity();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner, leadList, opportunityList);
        menu.start();

    }
}