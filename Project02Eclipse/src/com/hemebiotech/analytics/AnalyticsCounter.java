package com.hemebiotech.analytics;

import java.util.*;

/**
 * The AnalyticsCounter class provides methods to read symptoms from a file, count their occurrences,
 * sort them, and write the results to an output file.
 */

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

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

    /**
     * Reads and returns a list of symptoms using the reader.
     *
     * @return a list of symptoms
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the occurrences of each symptom in the provided list.
     *
     * @param symptoms a list of symptoms
     * @return a map where the keys are symptoms and the values are their occurences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();

        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

    /**
     * Sorts the symptoms in alphabetical order.
     *
     * @param symptoms a map of symptoms and their counts
     * @return a sorted map of symptoms
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

        return new TreeMap<>(symptoms);
    }

    /**
     * Writes the symptoms and their counts to an output file using the writer.
     *
     * @param symptoms a map of symptoms and their counts
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

}
