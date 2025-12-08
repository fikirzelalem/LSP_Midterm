/**
 * Author: Fikir Demeke
 * Course: Large Scale Programming (CSCI 363)
 * Assignment 3 - Object-Oriented ETL Pipeline Redesign
 * Product class
 */

package org.howard.edu.lsp.assignment3;

/**
 * The {@code Product} class represents a single product record used in the ETL pipeline.
 * <p>
 * It encapsulates product-specific data such as ID, name, price, and category.
 * This class demonstrates encapsulation by keeping fields private and exposing
 * public getter and setter methods for controlled access.
 * Each {@code Product} instance corresponds to a single row in the input or output CSV file.
 */


public class Product {
    // Unique identifier for the product ID
    private int productId;

    // Name of the product 
    private String name;

    // Price of the product
    private double price;

    // Product category (ie- Electronics, Stationery, etc.)
    private String category;

    // Price range (Low, Medium, High, Premium) 
    private String priceRange;

    /** 
     * This constructs a Product object with the specified attributes.
     * @param productId the unique product ID
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */

    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and setters for encapsulation
    /** 
     * Returns the unique product ID.
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /** 
     * Sets the product ID.
     * @param productId the new product ID
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /** 
     * Returns the product name.
     * @return the product name
     */
    
    public String getName() {
        return name;
    }

    //name sets the product name 
    public void setName(String name) {
        this.name = name;
    }

    // the product price
    public double getPrice() {
        return price;
    }

    //price sets the product price 
    public void setPrice(double price) {
        this.price = price;
    }

    // the product category 
    public String getCategory() {
        return category;
    }

    // category sets the product category 
    public void setCategory(String category) {
        this.category = category;
    }

    // the price range label (Low, Medium, High, Premium)
    public String getPriceRange() {
        return priceRange;
    }

    // priceRange sets the price range label 
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Override for double safety
     * Returns a formatted CSV style string representation of the products.
     * @return a string formatted as "ProductID,Name,Price,Category"
     */

    @Override
    public String toString() {
        return productId + "," + name + "," + String.format("%.2f", price) + "," + category;
    }
}
