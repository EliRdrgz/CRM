package com.ironhack.demo;

import com.ironhack.classes.LeadList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoDataTest {
    DemoData demoData = new DemoData();

    @Test
    void test_create2DemoLeads_ok() {
        LeadList leadList = demoData.createDemoLeads(2);
        assertEquals(2,leadList.size());
    }
}