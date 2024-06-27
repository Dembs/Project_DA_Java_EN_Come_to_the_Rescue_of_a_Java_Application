package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

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
			Integer j = symptomCounts.get(symptom);
			symptomCounts.put(symptom, (j == null) ? 1 : j + 1);
		}
        return symptomCounts;
    }

	public Map<String,Integer>sortSymptoms(Map<String,Integer>symptoms){

        return new HashMap<>(new TreeMap<>(symptoms));
    }

	public void writeSymptoms(Map<String,Integer>symptoms){
		writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		

		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
