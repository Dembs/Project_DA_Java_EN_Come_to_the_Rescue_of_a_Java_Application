package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a destination.
 * The important part is, the input to the operation, which is a map of symptom names and their counts.
 *
 * The implementation does not need to order the output.
 */

public interface ISymptomWriter {

    /**
     * If no data is available, do not write anything.
     *
     * @param symptoms a Map where the keys are symptom names and the values are the number of occurrences of each symptom
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
