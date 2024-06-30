package com.hemebiotech.analytics;

import java.util.*;

/**
 * The AnalyticsCounter class provides methods to read symptoms from a file, count their occurrences,
 * sort them, and write the results to an output file.
 */

public class AnalyticsCounter {

    ISymptomReader reader;
    ISymptomWriter writer;

    /**
     * Constructs an AnalyticsCounter with the specified symptom reader and writer.
     *
     * @param reader the reader to read symptoms from
     * @param writer the writer to write the symptom counts to
     */

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomCounts = new HashMap<>();

        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

        return new TreeMap<>(symptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

}
