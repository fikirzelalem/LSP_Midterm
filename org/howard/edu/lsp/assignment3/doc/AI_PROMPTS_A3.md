# AI Prompts– Assignment 3: Object-Oriented ETL Pipeline Redesign  
**Name:** Fikir Demeke  
**Course:** Large Scale Programming  

---

## Overview of AI Usage
For this assignment, I used ChatGPT and Google Gemini as a learning and a planning tool to help me refactor my original ETL pipeline from Assignment 2 into a more object-oriented design.  
I mainly used it to clarify how to break the program into multiple classes, improve the java documentation, and format the reflection file in Markdown.  

---

## Example Prompt 1 – Class Design Brainstorm  
**Prompt:**  
“How can I redesign my Assignment 2's ETL pipeline into a more object oriented structure with multiple classes that follow OOP principles including encapsulation and abstraction”  

**Excerpt of AI Response:**  
“You can create one class for each stage of the pipeline — one for extraction, one for transformation, and one for loading — along with a model class to represent a product.  
Each should handle only one task: reading input, transforming data, or writing output.  
Then, a main class can coordinate the flow between them.”  

**How I Used It:**  
I used this general idea as a starting point but designed the full structure myself.  
I created the class names `ExtractCSV`, `TransformCSV`, `LoadCSV`, and `Product`, and organized the methods and logic for each one. I also structured the `ETLPipelineApp` main class on my own to manage the flow and summary reporting.  
The AI suggestion helped me think conceptually about separation of concerns.

---

## Example Prompt 2 – Transformation Logic Clarification  
**Prompt:**  
“How should I organize the transformation rules in a TransformCSV class so the methods are reusable”  

**Excerpt of AI Response:**  
“Create a method like `applyAll(List<Product>)` that loops through each product and calls a helper method `transformSingle(Product)`.  
Keep each step (uppercase conversion, discount, recategorization, price range) inside that helper method to maintain clarity.”  

**How I Used It:**  
I followed this structure, defining `applyAll()` and `transformSingle()` to keep the transformation logic organized and easy to test.

---

## Example Prompt 3 – Error Handling & Testing Strategy  
**Prompt:**  
“Whats the best way to handle missing or empty input files gracefully in my ETL app so it doesnt crash”  

**Excerpt of AI Response:**  
“Use a try-with-resources block when reading files.  
If the header is null or there are no lines, print a clear message like ‘Input file is empty’ and still create an output file with only the header row.”  

**How I Used It:**  
I added this check to my `ExtractCSV` class and confirmed that it worked by running a test with an empty `products.csv`.  
This kept the program from crashing while meeting the assignment’s error handling requirements.

---

## Example Prompt 4 – Reflection and Documentation Help  
**Prompt:**  
“Can you help me write my reflection file so it clearly compares A2 and A3, explains the OOP concepts, and follows Markdown standards?”  

**Excerpt of AI Response:**  
“It’s best to structure your reflection with sections for Overview, Differences, OOP Concepts, Testing, and Reflection.  
Use tables for class responsibilities and examples of OOP concepts to make it easy to read.”  

**How I Used It:**  
I followed this structure exactly for my final `REFLECTION_A3.md` file and reworded all explanations in my own words to make it sound personal.

---

## Reflection on AI Usage
Using AI for this assignment helped me plan the redesign and organize my documentation more effectively.  
I treated it as a reviewer rather than a code generator. I wrote and tested all Java files with the help of AI. 
This approach helped me understand why the OOP structure improves maintainability and readability, instead of just copying suggestions.  

---

