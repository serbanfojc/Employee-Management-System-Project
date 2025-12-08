import model.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeQueries 
{
    
    // Query 1: Get employees hired within a date range
    public static List<Employee> getEmployeesHiredBetween(List<Employee> employees, LocalDate startDate, LocalDate endDate) 
    {
        return employees.stream()
                .filter(e -> !e.getHireDate().isBefore(startDate) && !e.getHireDate().isAfter(endDate))
                .collect(Collectors.toList());
    }
    
    // Query 2: Get top N highest paid employees
    public static List<Employee> getTopNBySalary(List<Employee> employees, int n) 
    {
        return employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(n)
                .collect(Collectors.toList());
    }
    
    // CSV Export - export list of employees back to CSV
    public static void exportToCSV(List<Employee> employees, String filename) 
    {
        try (FileWriter writer = new FileWriter(filename)) 
        {
            // Write header
            writer.write("name,department,employeeID,salary,isActive,hireDate,lastUpdated,email,jobTitle,yearsOfExperience\n");
            
            // Write employee data
            for (Employee emp : employees) 
                {
                writer.write(String.format("%s,%s,%d,%.2f,%b,%s,%s,%s,%s,%d\n",
                    emp.getName(),
                    emp.getDepartment(),
                    emp.getEmployeeID(),
                    emp.getSalary(),
                    emp.getIsActive(),
                    emp.getHireDate(),
                    emp.getLastUpdated(),
                    emp.getEmail(),
                    emp.getJobTitle(),
                    emp.getYearsOfExperience()
                ));
            }
            System.out.println("Exported " + employees.size() + " employees to " + filename);
        } 
        
        catch (IOException e) 
        {
            System.out.println("Error exporting to CSV: " + e.getMessage());
        }
    }
}
