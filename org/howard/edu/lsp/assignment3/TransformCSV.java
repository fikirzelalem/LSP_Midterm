/** Author: Fikir Demeke
 * Course: Large Scale Programming (CSCI 363)
 * Assignment 3 - Object-Oriented ETL Pipeline Redesign 
 * TransformCSV class
 */

package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * TransformCSV class
 * 
 * It handles the "Transform" step of the ETL pipeline.
 * Applies business transformation rules to each Product object:
 *  1. Converts product names to uppercase.
 *  2. Applies a 10% discount for Electronics.
 *  3. Recategorizes products above $500 post-discount as Premium Electronics.
 *  4. Determines the PriceRange label (Low, Medium, High, Premium).
 */

//Transform class
public class TransformCSV {

    /**
     * Applies all transformations to a list of products.
     * @param products the list of {@link Product} objects to transform
     * @return a new {@link List} containing transformed {@link Product} objects
     */

    public List<Product> applyAll(List<Product> products) {
        List<Product> transformed = new ArrayList<>();

        for (Product p : products) {
            Product updated = transformSingle(p);
            transformed.add(updated);
        }

        System.out.println("Transformation complete: " + transformed.size() + " products transformed.");
        return transformed;
    }

    /**
     * Applies all transformation rules to a single product.
     * @param p the {@link Product} to transform
     * @return a new, transformed {@link Product} object
     */

    private Product transformSingle(Product p) {
        String name = p.getName().toUpperCase();
        double price = roundToTwoDecimals(p.getPrice());
        String category = p.getCategory();

        // Apply 10% discount for Electronics
        if (category.equalsIgnoreCase("Electronics")) {
            price = roundToTwoDecimals(price * 0.9);
        }

        // Classify again as Premium Electronics if the price > 500 after discount
        if (category.equalsIgnoreCase("Electronics") && price > 500.00) {
            category = "Premium Electronics";
        }

        // Determine the Price Range
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

        Product transformed = new Product(p.getProductId(), name, price, category);
        transformed.setCategory(category); // Make sure that category updates
        transformed.setPriceRange(priceRange); // Store computed price range
        return transformed;
    }

    /**
     * This is a helper method to round a numeric value to two decimal places (half-up).
     * @param value the numeric value to round
     * @return the rounded value
     */

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
