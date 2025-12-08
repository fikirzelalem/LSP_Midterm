/** Author: Fikir Demeke
 * Course: Large Scale Programming (CSCI 363)
 * Assignment 3 - Object-Oriented ETL Pipeline Redesign 
 * ExtractCSV class
 */

 package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Extract class
 * 
 * It handles the "Extract" step of the ETL pipeline.
 * Reads product data from a CSV file located under the data/ directory and converts each
 * valid line into a Product object.
 * It demonstrates encapsulation (private helper methods) and abstraction
 * The rest simply calls read() without worrying about how parsing or error handling works
 * internally.
 */

public class ExtractCSV {

    /**
     * ExtractCSV Class 
     * Reads a CSV file and extracts product information.
     * Each valid row in the CSV is parsed into a {@link Product} object.
     * Malformed lines are skipped, and invalid numeric data is reported.
     * 
     * @param filePath relative path to the CSV file (e.g. {@code "data/products.csv"})
     * @return a list of {@link Product} objects parsed from the CSV file
     * @throws IOException if the file cannot be found or read
     * 
     */

    public List<Product> read(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        int rowsRead = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            String header = br.readLine();
            if (header == null) {
                System.out.println("Input file is empty! Please enter content.");
                return products;
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 4) {
                    System.out.println("Skipping Invalid/Empty line: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String category = parts[3].trim();

                    Product product = new Product(id, name, price, category);
                    products.add(product);
                    rowsRead++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid numeric entered on line: " + line);
                }
            }

            System.out.println("Extraction is complete: " + rowsRead + " valid rows read.");
        }

        return products;
    }
}
