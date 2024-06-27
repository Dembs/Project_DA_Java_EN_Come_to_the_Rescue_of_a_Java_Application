package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	 ISymptomReader reader;
	 ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader,ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	public Map<String,Integer>countSymptoms(List<String>symptoms){

		Map<String,Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
        return symptomCounts;
    }

	public Map<String,Integer>sortSymptoms(Map<String,Integer>symptoms){

        return new TreeMap<>(symptoms);
    }

	public void writeSymptoms(Map<String,Integer>symptoms){
		writer.writeSymptoms(symptoms);
	}

}
