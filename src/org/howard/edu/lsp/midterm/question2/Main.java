/* Author: Fikir Demeke
 * Course: Large Scale Programming 
 * Date: October 20 2025
 * Midterm Exam
 * Main class
 */

package org.howard.edu.lsp.midterm.question2;

//main class
public class Main {
    public static void main(String[] args) {
        // Expected output for each circle, rectangle, triangle and square acc to instructions
        //circle
        System.out.println("Circle radius 3.0 → area = " + AreaCalculator.area(3.0));
        //rectangle
        System.out.println("Rectangle 5.0 x 2.0 → area = " + AreaCalculator.area(5.0, 2.0));
        //triangle
        System.out.println("Triangle base 10, height 6 → area = " + AreaCalculator.area(10, 6));
        //square
        System.out.println("Square side 4 → area = " + AreaCalculator.area(4));

        // For exception demo using try/catch block
        try {
            System.out.println("Circle radius -2.0 → area = " + AreaCalculator.area(-2.0));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * Some Notes
     * Method overloading keeps all area calculations under one clear concept "area".
     * Using separate names like circleArea() or rectangleArea() would fragment the design
     * and reduce cohesion. 
     * Overloading improves readability and organization because the compiler distinguishes 
     * methods by their parameter lists.
     */
}

