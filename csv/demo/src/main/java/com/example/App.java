package com.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try (
                Reader reader = new FileReader("input.csv");
                CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
                Writer writer = new FileWriter("output.csv");
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)
        ) {
            for (CSVRecord record : csvParser) {
                List<String> values = record.toJavaList();
                int sum = Integer.parseInt(values.get(0)) + Integer.parseInt(values.get(1));
                values.add(Integer.toString(sum));
                csvPrinter.printRecord(values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
