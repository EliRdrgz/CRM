package com.ironhack.DataStorage;

import com.ironhack.classes.Contact;
import com.ironhack.classes.Lead;
import com.ironhack.classes.LeadList;
import com.ironhack.classes.OpportunityList;

import java.util.ArrayList;

public class MemoryData {
    public static ArrayList<Contact> contacts = new ArrayList<>();
    public static ArrayList<Lead> leads = new ArrayList<>();
    public static ArrayList<LeadList> leadLists = new ArrayList<>();
    public static ArrayList<OpportunityList> opportunityLists = new ArrayList<>();

}

