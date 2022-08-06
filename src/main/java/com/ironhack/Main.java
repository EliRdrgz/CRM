package com.ironhack;


import com.ironhack.data.CrmData;
import com.ironhack.menu.Menu;
import com.ironhack.persistData.StoreData;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        CrmData data = new CrmData();
        StoreData storeData = new StoreData(data);
        System.out.println("leads"+data.leadList.leads.size());
        System.out.println("opportunities"+ data.opportunityList.opportunities.size());
        storeData.readData();
        System.out.println("leads"+data.leadList.leads.size());
        System.out.println("opportunities"+ data.opportunityList.opportunities.size());
        StoreData store = new StoreData(data);
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner, data, store);
        menu.start();

    }
}