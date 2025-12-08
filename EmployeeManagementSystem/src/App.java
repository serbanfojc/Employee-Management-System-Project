import model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App 
{
    public static void main(String[] args) 
    {
        System.out.println("=== Employee Management System - Stage 2 ===\n");
        
        // Load employees from 1000-row CSV
        List<Employee> employees = EmployeeCSVLoader.loadEmployees("data/dataset_1000.csv");
        
        System.out.println("\n--- Sample: First 10 Employees sorted by ID ---");
        Collections.sort(employees);
        printEmployees(employees.subList(0, Math.min(10, employees.size())));
        
        System.out.println("\n--- Sample: First 10 Employees sorted by Name ---");
        Collections.sort(employees, new EmployeeNameComparator());
        printEmployees(employees.subList(0, Math.min(10, employees.size())));
        
        // Advanced Query 1: Date Range
        System.out.println("\n--- Query 1: Employees hired in 2023 ---");
        List<Employee> hired2023 = EmployeeQueries.getEmployeesHiredBetween(
            employees, 
            LocalDate.of(2023, 1, 1), 
            LocalDate.of(2023, 12, 31)
        );
        System.out.println("Found " + hired2023.size() + " employees hired in 2023");
        printEmployees(hired2023.subList(0, Math.min(5, hired2023.size())));
        
        // Advanced Query 2: Top N Salary
        System.out.println("\n--- Query 2: Top 10 Highest Paid Employees ---");
        List<Employee> topPaid = EmployeeQueries.getTopNBySalary(employees, 10);
        printEmployees(topPaid);
        
        // CSV Export
        System.out.println("\n--- Exporting top paid employees to CSV ---");
        EmployeeQueries.exportToCSV(topPaid, "data/top_paid_export.csv");

        // HashSet/HashMap Demonstrations
        System.out.println("\n--- Duplicate Detection (HashSet) ---");
        List<Employee> duplicates = DuplicateDetector.findDuplicates(employees);
        System.out.println("Found " + duplicates.size() + " duplicate employees");
        
        System.out.println("\n--- Unique Employees (HashSet) ---");
        Set<Employee> uniqueEmps = DuplicateDetector.getUniqueEmployees(employees);
        System.out.println("Total unique employees: " + uniqueEmps.size());
        
        System.out.println("\n--- Employee Count by Department (HashMap) ---");
        Map<String, Integer> deptCounts = DuplicateDetector.countByDepartment(employees);
        for (Map.Entry<String, Integer> entry : deptCounts.entrySet()) 
        {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " employees");
        }
    }
    
    private static void printEmployees(List<Employee> employees) 
    {
        for (Employee emp : employees) 
        {
            System.out.println("ID: " + emp.getEmployeeID() + 
                             " | Name: " + emp.getName() + 
                             " | Dept: " + emp.getDepartment() + 
                             " | Salary: $" + emp.getSalary());
        }
    }
}