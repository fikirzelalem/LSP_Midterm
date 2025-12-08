/** Author: Fikir Demeke
 * Course: Large Scale Programming (CSCI 363)
 * Assignment 3 - Object-Oriented ETL Pipeline Redesign 
 * Main Class
 */

package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * ETLPipelineApp class
 * 
 * This class is the main class that coordinates the Extract, Transform, and Loading stages.
 * It demonstrates object-oriented composition and modular program design.
 *
 *  Responsibilities are:
 *  1. Reads product data from a CSV file (Extract)
 *  2. Transforms the data according to business rules (Transform)
 *  3. Writes the transformed data to a new CSV file (Load)
 *  4. Prints a run summary at the end
 * 
 */

public class ETLPipelineApp {

    /**
     * Main method that drives the ETL process.
     * @param args command-line args
     */

     //main method
    public static void main(String[] args) {
        System.out.println("Starting ETL Pipeline App...");

        // Define file paths
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        // Initialize ETL components
        ExtractCSV reader = new ExtractCSV();
        TransformCSV transformer = new TransformCSV();
        LoadCSV writer = new LoadCSV();

        try {
            // Extract 
            List<Product> products = reader.read(inputPath);

            if (products.isEmpty()) {
                System.out.println("No data rows found.");
                writer.write(products, outputPath);
                printSummary(0, 0, 0, outputPath);
                return;
            }

            // Transform 
            List<Product> transformed = transformer.applyAll(products);

            // Load
            writer.write(transformed, outputPath);

            // Print run summary
            printSummary(products.size(), transformed.size(), 0, outputPath);

        } 
        //error handling
        catch (IOException e) {
            System.out.println("Error during ETL execution: " + e.getMessage());
        }

        System.out.println("ETL process completed!");
    }

    /**
     * Prints a summary of the ETL execution results.
     * @param rowsRead        number of rows extracted
     * @param rowsTransformed number of rows transformed
     * @param rowsSkipped     number of rows skipped (if any)
     * @param outputPath      path of the output file written
     */

     //summary like done in assignment 2
    private static void printSummary(int rowsRead, int rowsTransformed, int rowsSkipped, String outputPath) {
        System.out.println("Run Summary ");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output path: " + outputPath);
    }
}
