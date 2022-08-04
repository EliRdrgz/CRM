package com.ironhack.demo;

import com.github.javafaker.Faker;
import com.ironhack.classes.Lead;
import com.ironhack.classes.LeadList;

public class DemoData {

    public LeadList createDemoLeads(int numberLead) {
        LeadList demoLeadList = new LeadList();
        Faker faker = new Faker();
        for (int i = 0; i < numberLead; i++) {
            Lead demoLead = new Lead(faker.name().fullName(), faker.phoneNumber().cellPhone(),
                    faker.internet().safeEmailAddress(), faker.company().name());
            demoLeadList.addLead(demoLead);
        }
        return demoLeadList;
    }
}