# Reflection– Assignment 3: Object-Oriented ETL Pipeline Redesign  
**Name:** Fikir Demeke  
**Course:** Large Scale Programming 
---

## Overview
Assignment 3 required refactoring the ETL Pipeline from Assignment 2 into a design that applies object-oriented principles(OOP).  
The goal of this assignment was to improve code readability, and make each stage of the pipeline easier to maintain and extend to different classes.  
In Assignment 2, I had one large file where the `extract`, `transform`, and `load` steps were all inside the same class.  
It worked fine but every change required editing the same file and it was harder to test and extend.  
For Assignment 3, I applied **object-oriented programming (OOP) principles** such as encapsulation, abstraction, and modularity.  
In this, the pipeline is now divided into separate classes that each handle a single responsibility.  
This structure makes the code cleaner, easier to test, and more adaptable to future changes.

---

## Differences in Design between A2 and A3
In Assignment 2, the program used one large `ETLPipeline` class that performed extraction, transformation, and loading in sequence. While this design met the requirements, it lacked structure and clear boundaries between the responsibilities.
In Assignment 3, the design was completely reorganized into smaller, self contained classes, each of them representing an ETL stage. For this, I created five separate classes that each have their own role:

| Class | Responsibility |
|--------|----------------|
| **ETLPipelineApp** | Main class; acts as the controller of the entire pipeline. It coordinates the Extract, Transform, and Load processes, handles the error exceptions, and prints a summary report at the end. |
| **ExtractCSV** | Reads the data from the CSV file, `products.csv`, parses each row, and creates a list of `Product` objects. It also handles empty and malformed inputs. |
| **TransformCSV** | Applies business rules such as uppercasing names, applying discounts, updating categories, and determining price ranges. |
| **LoadCSV** | Writes the transformed list of products to the output CSV file `data/transformed_products.csv`. It also adds headers and counts the number of rows that are written. |
| **Product** | Represents a single record from the CSV file. It encapsulates product details (ID, name, price, and category) and provides getters and setters for each of them. |

This new structure replaces one long procedural flow and each class becomes responsible for its own logic.  
Public methods like `read()`, `applyAll()`, and `write()` now define clear interfaces for interactions between the components. This makes the code easier to extend.

---

## How A3 Is More Object-Oriented
- **Encapsulation:**  
  Each class contains its own data and behavior. The `Product` class hides its fields behind getters and setters, while the ETL classes keep their internal processings private.  
  This keeps each class self contained.  

- **Abstraction:**  
  The main `ETLPipelineApp` doesn’t need to know how the data is read or transformed and it only interacts through method calls such as `reader.read()` or `writer.write()`.  
  This separation allows changes in implementation without having an effect on the rest of the program.  

- **Separate/Single Responsibility:**  
  Every class handles one well defined task. This reduces the complexity of the program code and makes it more readable and testable.  

- **Reusability:**  
  Because each stage is isolated, classes like `TransformCSV` or `LoadCSV` could be reused in other ETL projects without changing it much.  

- **Scalability:**  
  New features, like exporting to a database or adding new transformation rules, can be added easily without modifying new code that isnt related to this one.  

- **Inheritance:**  
  This design allows extending `Product` into other subclasses such as or adding polymorphism through interfaces.

---

## Object-Oriented Concepts Applied
| *Object & Class* |
| *Encapsulation* | 
| *Abstraction* | 
| *Inheritance* | 
| *Polymorphism* | 

---

## Testing and Validation  
To confirm that A3's ETL Pipeline behaves exactly the same as Assignment 2, I ran multiple tests using the same input files.
### Test Cases  
1. **Normal Input:**  
   I used the same `products.csv` file I used in A2 with five entries. After I ran A3, the output matched exactly that of A2; the names were uppercase, discounts were correctly applied, and the price ranges were accurate.  

2. **Different input:**  
   I changed the contents of the CSV file in `products.csv` and ran the test for A3 and the contents changed which made me sure that the .java files in A3 are actually working.

3. **Empty Input:**  
   I deleted the contents in the header in `products.csv` and I ran A3 again. Since the input file contained only a header, the program generated an output file with only a header row. 

4. **Missing File:**  
   I removed the `products.csv` file and I ran the program. After that the program printed an error message and it didnt crash. 

5. **Invalid Data:**  
   I added an invalid line (missing values/empty line in between) to test the error handling and that line was skipped while the other lines were processed normally.  


The results confirmed that Assignment 3 produced **identical outputs** to Assignment 2 while having an improved modularity and code readability.

---

## Reflection  
This project gave me a deeper understanding on how to apply OOP concepts in designing softwares in the real world. Breaking the ETL pipeline into classes improved the program’s structure and readability and made each component easier to maintain and replace. Assignment 3 meets the functional requirements, including encapsulation and composition. This assignment helped me understand how object-oriented design is more clean, and more maintainable. 
Overall, Assignment 3 shows that the same functionality can be achieved with a much clearer design by applying object-oriented principles effectively.

---