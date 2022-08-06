package com.ironhack.persistData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ironhack.classes.Lead;
import com.ironhack.classes.LeadList;
import com.ironhack.classes.OpportunityList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class StoreData {
    public static void WriteData(LeadList leadList, OpportunityList opportunityList) {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            BufferedWriter writer = new BufferedWriter(new FileWriter("./backup/data.json"));
            Gson gson = gsonBuilder.create();
            writer.write(gson.toJson(leadList) + "\n" + gson.toJson(opportunityList));
            writer.close();

        } catch (IOException e) {
            System.out.println("File not found.");
        }

    }

    public static LeadList readDataLead() {
        {
            try {
                GsonBuilder gsonBuilder = new GsonBuilder();
                String data = Files.readString(Path.of("./backup/data.json"), StandardCharsets.UTF_8);
                String leadData = data.split("\n")[0];
                Gson gson = gsonBuilder.create();
                return gson.fromJson(leadData, LeadList.class);

            } catch (IOException e) {
                System.out.println("File not found.");
            }

        }
        return new LeadList();
    }
    public static OpportunityList readDataOpportunity() {
        {
            try {
                GsonBuilder gsonBuilder = new GsonBuilder();
                String data = Files.readString(Path.of("./backup/data.json"), StandardCharsets.UTF_8);
                String opporunityData = data.split("\n")[1];
                Gson gson = gsonBuilder.create();
                return gson.fromJson(opporunityData, OpportunityList.class);


            } catch (IOException e) {
                System.out.println("File not found.");
            }

        }
        return new OpportunityList();
    }
}
