package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse/results.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        System.out.println("Starting processing.....");
        // Step 1: Read data from the file
        List<String> symptoms = counter.getSymptoms();

        // Step 2: Count the number of occurrences of each symptom present in the file
        Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms);

        // Step 3: Sort the symptoms in alphabetical order
        Map<String, Integer> sortSymptoms = counter.sortSymptoms(symptomCounts);

        // Step 4: Write the symptoms to the file
        counter.writeSymptoms(sortSymptoms);

        System.out.println("Process complete !");

    }
}
