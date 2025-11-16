import model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main(String [] args)
    {
        System.out.println("=== Employee Management System ===\n");

        List<Employee> employees = EmployeeCSVLoader.loadEmployees("data/sample_10.csv");

        System.out.println("\n--- Employees sorted by ID ---");
        Collections.sort(employees);
        printEmployees(employees);

        System.out.println("\n--- Employees sorted by name ---");
        Collections.sort(employees, new EmployeeNameComparator());
        printEmployees(employees);
    }

    private static void printEmployees(List<Employee> employees)
    {
        for (Employee emp : employees)
        {
            System.out.println("ID: " + emp.getEmployeeID() +
            " | Name: " + emp.getName() + 
            " | Department: " + emp.getDepartment() +
            " | Salary: " + emp.getSalary());
        }
    }
}
