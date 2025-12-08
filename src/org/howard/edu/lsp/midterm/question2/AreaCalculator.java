/* Author: Fikir Demeke
 * Course: Large Scale Programming 
 * Date: October 20 2025
 * Midterm Exam
 * Area calculator class
 */

 //package order
package org.howard.edu.lsp.midterm.question2;

// class name
public class AreaCalculator {

    // Area of the circle
    public static double area(double radius) {
        //
        if (radius <= 0) {
            //error handling
            throw new IllegalArgumentException("The radius must be greater than zero.");
        }
        //
        return Math.PI * radius * radius;
    }

    // Area of the rectangle
    public static double area(double width, double height) {
        //
        if (width <= 0 || height <= 0) {
            //error handling
            throw new IllegalArgumentException("The width and height must be greater than zero.");
        }
        //
        return width * height;
    }

    // Area of a triangle
    public static double area(int base, int height) {
        //
        if (base <= 0 || height <= 0) {
            //Error handling
            throw new IllegalArgumentException("The base and height must be greater than zero.");
        }
        //
        return 0.5 * base * height;
    }

    // Area of a square
    public static double area(int side) {
        //
        if (side <= 0) {
            //error handling
            throw new IllegalArgumentException("The side must be greater than zero.");
        }
        //
        return side * side;
    }
}
