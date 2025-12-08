# ETL-Pipeline-Assignment2
## **Course:** Large Scale Programming 
## **Student:** Fikir Demeke  
## **Date:** October 2025  

# Overview and Assumptions of Assignment
This project implements an ETL (Extract-Transform-Load) pipeline in Java. The main point was to read product data from a CSV file, make specific changes based on business rules, and then save the updated results to a new CSV file.
The project helped me practice how to handle files in Java, work with string data, and apply logic. I designed the program so that it first extracts the data from the input file, then transforms it by applying the given discount, changing product names to uppercase, adjusting categories, and adding a price range. Finally, it loads the cleaned data into an output file called transformed_products.csv.
Overall, this assignment gave me a better understanding of how real-world data pipelines work reading, cleaning, and outputting data in a structured way.  
- The input file products.csv always has a header row, and that header should not be changed or transformed.
- The CSV file uses a comma (,) as the delimiter, and there are no quoted fields or commas inside values.
- The program is run from the project root directory which is the folder that contains both the src/ and data/ folders.
- If the input file is missing, the program will print a clear error message and exit.
- If the input file is empty (only the header is present), the program will still create an output file that includes just the header.
- Rounding for prices is always done to two decimal places, using the “round half up”.
- Each row in the CSV follows the same structure and contains valid data types (integer, string, double, etc.).
# Project Structure
ETL-Pipeline-Assignment2/
├── src/
│ └── org/howard/edu/lsp/assignment2/ETLPipeline.java
├── data/
│ ├── products.csv
│ └── transformed_products.csv
└── README.md

The assignment demonstrates:
- Reading structured data using Java I/O (`BufferedReader` and `FileReader`).
- Performing conditional transformations (discounts, recategorization, uppercase conversion).
- Writing structured data using `BufferedWriter`.
- Error handling for missing or empty input files.
- Printing a run summary (rows read, transformed, skipped, output path).

# Brief Design Notes
## 1. **Extract**
- The extract() method reads the input file `data/products.csv` using a BufferedReader. It skips the header and loads each valid row into a Product object. The data is stored in a list of products for processing. If the file is missing or empty, the program handles it.

## 2. **Transform**
- The transform() method applies the business rules step by step:
Converts product names to UPPERCASE.
Applies a 10% discount for all items in the "Electronics" category and rounds the result.
If an electronic item’s discounted price exceeds $500, the category changes to “Premium Electronics.”
Adds a new column called PriceRange, which is based on the final price.
- A new field, **PriceRange**, is added based on the final price:  
  - `$0.00–$10.00 → Low`  
  - `$10.01–$100.00 → Medium`  
  - `$100.01–$500.00 → High`  
  - `$500.01+ → Premium`

## 3. **Load**  
- The load() method writes the final results to `data/transformed_products.csv` using a BufferedWriter. It always writes the header first, then the transformed data in the required order. It also prints a summary at the end, showing how many rows were read and transformed.
Rows read: X
Rows transformed: X
Rows skipped: 0
Output file: data/transformed_products.csv

# How to Run
1. Open a terminal (or use an IDE’s terminal) which is the ETL-Pipeline-Assignment2.
        **cd path/to/JavaProjectRoot**
2. Navigate to the project root directory (the folder that contains both src and data):
3. Compile the Java file:
        **javac src/org/howard/edu/lsp/assignment2/ETLPipeline.java**
4. Run the program from the project root using the full package path:
        **java -cp src org.howard.edu.lsp.assignment2.ETLPipeline**
5. After the program runs, we check the data/ folder and will see a new file named transformed_products.csv which contains the transformed results.

# AI Usage Disclosure
I used AI (ChatGPT) and Google Gemini for:
- Refining my code structure and error handling.
- Clarifying ETL logic and rounding implementation.
- I also used it to review my code for errors, and confirm that it met all assignment requirements..

Example Prompt I Used
“I already wrote my extract() and transform() methods for a Java ETL pipeline, but I’m not sure if my discount and rounding logic are correct. Can you review my approach and explain how to ensure the 10% discount applies only to Electronics and rounds half up to two decimals?”

Excerpt of AI Response
“Your approach looks solid — just make sure the rounding happens after applying the discount. You can use Math.round(price * 0.9 * 100.0) / 100.0 to ensure two-decimal precision. Also verify the transform order: uppercase first, then discount, then category recategorization, and finally compute PriceRange.”

How I Used or Modified the Response
- I used the AI’s structure suggestion as a reference for how to separate my code into methods. I then rewrote the logic, adjusted variable names, added error handling, and made sure everything matched the project’s grading rubric and relative path requirement.

# External Source Usage
1. Baeldung (Java CSV Reading & Writing)
Link: https://www.baeldung.com/java-csv
Usage: used approach to handle CSV reading and writing in Java using BufferedReader and BufferedWriter.
Adapt: simplified the code to match the assignment’s “no external libraries” rule.

2. Stack Overflow (Rounding to Two Decimals)
Link: https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
Usage: used approach as an example showing how to round to two decimal places using Math.round(value * 100.0) / 100.0.
Adapt: integrated that approach into my transform() method for consistent rounding behavior.