package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.IOException;


public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;
    /**
     *
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try  {
            FileWriter writer = new FileWriter(filepath);
            for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                writer.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
