//Fikir Demeke
//Large scale Programming
//Assignment #2- ETL Pipeline

package org.howard.edu.lsp.assignment2;

//Java I/O imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

//product class for each items
class Product {
    int productId;
    String name;
    double price;
    String category;

    Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

//Main method class
public class ETLPipeline {

    //Extract method
    public static List<Product> extract() {
        String filePath = "data/products.csv"; 
        List<Product> products = new ArrayList<>();
        int rowsRead = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); //skip header
            String line;

            if (header == null) { 
                System.out.println("Input file is empty. Creating output with header only...");
                return products;
            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue; //skip rows not formed

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String category = parts[3];

                products.add(new Product(id, name, price, category));
                rowsRead++;
            }
            //print rows read
            System.out.println("Rows read: " + rowsRead);
            //print rows extracted
            System.out.println("Extracted " + products.size() + " products.");
            
            //error handling
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return products;
    }

    //Transform
    public static void transform(List<Product> products) {
        System.out.println("Transformed Data: ");
        int transformed = 0;

        for (Product p : products) {
            //Change to Uppercase here 
            p.name = p.name.toUpperCase();

            //10% discount for Electronics and round with half up
            if (p.category.equalsIgnoreCase("Electronics")) {
                p.price = Math.round(p.price * 0.9 * 100.0) / 100.0;
            } else {
                p.price = Math.round(p.price * 100.0) / 100.0;  
            }

            if (p.category.equalsIgnoreCase("Electronics") && p.price > 500) {
                p.category = "Premium Electronics";
            }

            //price match with range
            String priceRange;
            if (p.price <= 10.00) priceRange = "Low";
            else if (p.price <= 100.00) priceRange = "Medium";
            else if (p.price <= 500.00) priceRange = "High";
            else priceRange = "Premium";

            transformed++;

            System.out.println(p.productId + "," + p.name + "," + String.format("%.2f", p.price)
                    + "," + p.category + "," + priceRange);
        }

        System.out.println("Rows transformed: " + transformed);
    }

    //Load csv file to transformed_products.csv file
    public static void load(List<Product> products) {
        String outputPath = "data/transformed_products.csv";
        int rowsWritten = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // write header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            // write each transformed record
            for (Product p : products) {
                String category = p.category;
                double price = p.price;

                // determine the price range
                String priceRange;
                if (price <= 10.00) priceRange = "Low";
                else if (price <= 100.00) priceRange = "Medium";
                else if (price <= 500.00) priceRange = "High";
                else priceRange = "Premium";

                //write the lines
                writer.write(p.productId + "," + p.name + "," + String.format("%.2f", price) + ","
                        + category + "," + priceRange);
                writer.newLine();
                rowsWritten++;
            }

            System.out.println("Rows written: " + rowsWritten); //summary count
            System.out.println("Output file: " + outputPath);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    //ETL pipeline
    public static void main(String[] args) {
        System.out.println("Starting ETL pipeline...");

        List<Product> products = extract(); //extract products

        if (products.isEmpty()) {
            System.out.println("No data rows found.");
            load(products);
            return;
        }
        transform(products); //transform products
        load(products); //load products

        //Run Summary for products
        System.out.println("\n-- Run Summary --");
        System.out.println("Rows read: " + products.size());
        System.out.println("Rows transformed: " + products.size());
        System.out.println("Rows skipped: 0");
        System.out.println("Output path: data/transformed_products.csv");
        System.out.println("\nETL process completed!");
    }
}