package com.ironhack;


import com.ironhack.classes.LeadList;
import com.ironhack.classes.OpportunityList;
import com.ironhack.menu.Menu;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        LeadList leadList = new LeadList();
        OpportunityList opportunityList = new OpportunityList();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner, leadList, opportunityList);
        menu.start();

    }
}