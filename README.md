# employee-management-system
OOP Java Data System - Employee Management

## Project Overview
This OOP Java System is meant to solve unorganized company and to help them to manage all types of employees. The main entities are as follows: Employee which is the parent class, FullTimeEmployee, PartTimeEmployee and Contractor which are child classes. The system manages employee details;
Employee's name
What department the employee works in
Salary of the employee
Wether or not the employee is active
The hire date of the employee
When they were last updated
The employee's email
The employee's job
The employee's years of experience

The data loads from the sample_10.csv file. The system reads the employee data and uses a method loadEmployees() located in the EmployeeCSVLoader class to read the file line by line and skipping the header row with column names. For each piece of info it calls the method parseEmployee() which makes the text into an Employee object. The system can sort by ID and by name.

##### Design Justification
We used inheritance with Employee as the parent class and the three child classes (FullTimeEmployee, PartTimeEmployee and Contractor) because we are managing different employee types. This lets us reuse code and handle different types.

We have ArrayLists because we need fast access and frequent sorting. Our system mainly sorts and displays, ArrayLists are more efficient.

We also have validation for each setter to prevent data errors and have a good data quality. This is very important because if we don't validate that would cause errors which wouldn't let methods work properly.

We chose to do natural ordering on the employeeID because every employee has a unique id. We also added a comparator for the sorting of the name alphabetically so it's easier for the company to find employees within the system.

##### Defensive Coding Examples
public void setName(String name) 
{
    if(name == null || name.trim().isEmpty()) 
    {
        throw new IllegalArgumentException("Name cannot be blank");
    }
    this.name = name.trim();
}

This setter validates that the name isn't null or empty before setting the name to the field. trim() removes whitespaces which prevents invalid data from being saved to the system.

public void setEmployeeID(int employeeID) 
{
    if(employeeID <= 0) 
    {
        throw new IllegalArgumentException("Employee ID must be a positive number");
    }
    this.employeeID = employeeID;
}

Checks that employee ids are positive numbers.


catch(Exception e) 
{
    skippedCount++;
    System.out.println("Skipped line " + lineNumber + ": " + e.getMessage());
}
When the CSV data is loading it checks that if a line has invalid data, the program catches the exception and logs it and then keeps loading the data instead of just crashing.

if(hireDate.isAfter(LocalDate.now())) 
{
    throw new IllegalArgumentException("Hire date cannot be in the future");
}

Checks that the date in which the employee was hired isn't in the future of the current time. This prevents logical errors from happening.


##### Serban Moldovan ( D00281364 ) - Personal Reflection
I learnt that there inheritance is key in a database that reuses the same fields for different classes and at different levels of hierarchy such as the parent class Employee and the child class FullTimeEmployee. I also learnt that validation and error handling is key because when I didn't have them there were many errors and crashes which were very frustrating. CSV parsing is also key to reading the data from the csv file and being able to properly use it with different functions. 

##### Md Nayem Molla  ( D00264235 ) - Personal Reflection
Working on this Employee Management System helped me understand the power of object-oriented programming. Using inheritance with a parent Employee class and child classes like FullTimeEmployee, PartTimeEmployee, and Contractor allowed me to reuse code and handle different employee types efficiently.
Working with CSV parsing taught me how to read and process external data, converting it into meaningful objects in Java. Adding JUnit tests for ordering and searching was a valuable experience, showing me how testing ensures program correctness and improves confidence in code quality. Seeing the coverage report highlighted which parts of my code were tested and areas for improvement.

##### Contribution - Stage 1

**Serban Moldovan (D00281364)**:
Designed and implemented Employee parent class with 10 validated fields
Created three child classes: FullTimeEmployee, PartTimeEmployee, Contractor with inheritance
Implemented all getters and setters with validation
Developed EmployeeCSVLoader class for CSV file reading and parsing
Implemented Comparable with natural ordering by employeeID
Created EmployeeNameComparator for alphabetical sorting
Built App.java to show sorting and data loading 
Created sample_10.csv with 10 test records including
Wrote all defensive coding examples and validation

## Stage 2 Enhancements

##### Extended Dataset
Successfully loads 1000 employee records from dataset_1000.csv with error handling and validation. The system processes all records efficiently and reports any skipped invalid rows.

##### Equality & Hashing Implementation
Implemented equals() and hashCode() methods in the Employee class based on employeeID as the unique identifier. Two employees with the same ID are considered equal. The hashCode is derived from the employeeID for consistency with equals().

##### Collections & Lookup (HashSet/HashMap)
**DuplicateDetector class** uses HashSet to identify duplicate employees based on employeeID
**HashMap for department grouping** - fast lookup of employees by department
**Department statistics** - counts employees per department using HashMap

##### Advanced Queries
Implemented two query methods in EmployeeQueries class:

1. **Date Range Query** (`getEmployeesHiredBetween`): Filters employees hired between two dates using Java Streams. Example: finding all 130 employees hired in 2023.

2. **Top-N Salary Query** (`getTopNBySalary`): Returns the top N highest-paid employees by sorting in descending order. Finds the highest earners for compensation analysis.

Both queries have functional programming with Streams for efficient filtering and sorting.

##### CSV Export
The `exportToCSV` method allows exporting filtered query results back to CSV format. Enables saving subsets of employee data.

##### Defensive Coding Examples - Stage 2
All validation from Stage 1 continues to apply. Additional coding defenses:
HashMap operations use `getOrDefault()` and `putIfAbsent()` to avoid null pointer exceptions
Stream operations include null checks and validation
equals() method checks for null and class type before casting.

##### Contribution - Stage 2

**Serban Moldovan (D00281364)**: 
Implemented equals() and hashCode() in Employee class
Created DuplicateDetector class with HashSet/HashMap functionality  
Developed EmployeeQueries class with date range and top-N salary queries
Implemented CSV export
Generated 1000-row dataset
Updated App.java to show all Stage 2 features



