package com.ironhack.demo;

import com.ironhack.classes.*;
import com.ironhack.enums.TypeOfProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.ironhack.enums.TypeOfProduct.HYBRID;
import static org.junit.jupiter.api.Assertions.*;

class DemoDataTest {
    DemoData demoData = new DemoData();
    LeadList leadList = new LeadList();

    @BeforeEach
    void setUp() {
        leadList = demoData.createDemoLeads();
    }

    @Test
    void test_createDemoLeads_ok() {
        assertEquals(50, leadList.size());
    }

    @Test
    void test_createDemoContacts_ok() {
        ArrayList<Contact> contactList = demoData.createDemoContacts(leadList);
        assertEquals(34, contactList.size());
    }


    @Test
    void test_createDemoProductList_ok() {
        ArrayList<Product> productList = demoData.createDemoProductList();
        assertEquals(34, productList.size());
    }

    @Test
    void test_createDemoOpportunities_ok() {
        ArrayList<Contact> contactList = demoData.createDemoContacts(leadList);
        ArrayList<Product> productList = demoData.createDemoProductList();
        OpportunityList opportunitiesList = demoData.createDemoOpportunities(contactList);
        assertEquals(34, opportunitiesList.opportunities.size());
    }
//
//    @Test
//    void test_createDemoProductList_containsHYBRID_ok() {
//        ArrayList<Product> productList = demoData.createDemoProductList();
//        String hybridProduct;
//        for (Product product : productList) {
//            if (product.getProduct().equals("HYBRID")) String hybridProduct = product.getProduct().toString();
//        }
//        assertEquals("HYBRID", hybridProduct);
//    }
//
//    @Test
//    void test_createDemoProductList_containsFLATBED_ok() {
//        ArrayList<Product> productList = demoData.createDemoProductList();
//        assertEquals(34, productList.size());
//    }
//
//    @Test
//    void test_createDemoProductList_containsBOX_ok() {
//        ArrayList<Product> productList = demoData.createDemoProductList();
//        assertEquals(34, productList.size());
//    }
}