package com.ironhack.persistData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ironhack.data.CrmData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class StoreData {

    CrmData crm;

    public StoreData(CrmData crm) {
        this.crm = crm;
    }

    public void save() {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            BufferedWriter writer = new BufferedWriter(new FileWriter("./backup/data.json"));
            Gson gson = gsonBuilder.create();
            writer.write(gson.toJson(crm));
            writer.close();

        } catch (IOException e) {
            System.out.println("File not found.");
        }

    }

    public CrmData readData() {
        {
            try {
                GsonBuilder gsonBuilder = new GsonBuilder();
                String data = Files.readString(Path.of("./backup/data.json"), StandardCharsets.UTF_8);
                if(data.equals("")){
                    return this.crm;
                }
                Gson gson = gsonBuilder.create();
                return gson.fromJson(data, crm.getClass());

            } catch (IOException e) {
                System.out.println("File not found.");
            }

        }
        return this.crm;
    }


}
