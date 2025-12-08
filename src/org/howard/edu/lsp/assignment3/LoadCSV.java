/** Author: Fikir Demeke
 * Course: Large Scale Programming (CSCI 363)
 * Assignment 3 - Object-Oriented ETL Pipeline Redesign 
 * LoadCSV class
 * 
 */

package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * LoadCSV class
 * 
 * Handles the "Load" step of the ETL pipeline.
 * Writes transformed Product data to a CSV file located
 * under the data/ directory.
 * Demonstrates encapsulation and separation of concerns — 
 * this class handles only output writing logic.
 */

public class LoadCSV {

    /**
     * Writes the given list of products to the specified output file.
     * A header row is always written first. For each {@link Product}, this method computes
     * the appropriate price range category and writes the formatted row to the output file.
     *
     * @param products   the list of transformed {@link Product} objects to be written
     * @param outputPath the relative path to the output CSV file.
     * 
     */

    public void write(List<Product> products, String outputPath) {
        int rowsWritten = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            // Write the header row
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            // Write each of the product row
            for (Product p : products) {
                String category = p.getCategory();
                double price = p.getPrice();

                //set price range to either low, medium, high or premium
                String priceRange;
                if (price <= 10.00) {
                    priceRange = "Low";
                } else if (price <= 100.00) {
                    priceRange = "Medium";
                } else if (price <= 500.00) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                writer.write(
                    p.getProductId() + "," +
                    p.getName() + "," +
                    String.format("%.2f", price) + "," +
                    category + "," +
                    priceRange
                );
                writer.newLine();
                rowsWritten++;
            }

            System.out.println("Load complete: " + rowsWritten + " rows written to " + outputPath);

        } 
        //error handling
        catch (IOException e) {
            System.out.println("Error writing the output file: " + e.getMessage());
        }
    }
}