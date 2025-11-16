import model.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCSVLoader 
{
    
    public static List<Employee> loadEmployees(String filename) 
    {
        List<Employee> employees = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            boolean isFirstLine = true;
            int lineNumber = 0;
            int validCount = 0;
            int skippedCount = 0;

            while((line = br.readLine()) != null)
            {
                lineNumber++;

                if(isFirstLine)
                {
                    isFirstLine = false;
                    continue;
                }

                try
                {
                    Employee emp = parseEmployee(line);
                    if(emp != null)
                    {
                        employees.add(emp);
                        validCount++;
                    }
                }
                catch(Exception e)
                {
                    skippedCount++;
                    System.out.println("Skipped line " + lineNumber + ": " + e.getMessage());
                }
            }
            System.out.println("Loaded " + validCount + " valid employees.");
            System.out.println("Skipped " + skippedCount + " invalid rows.");
        }
        catch(IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return employees;
    }

    private static Employee parseEmployee(String line)
    {
        String[] parts = line.split(",");

        for(int i = 0; i < parts.length; i++)
        {
            parts[i] = parts[i].trim();
        }

        String name = parts[0];
        String department = parts[1];
        int employeeID = Integer.parseInt(parts[2]);
        double salary = Double.parseDouble(parts[3]);
        boolean isActive = Boolean.parseBoolean(parts[4]);
        LocalDate hireDate = LocalDate.parse(parts[5]);
        LocalDateTime lastUpdated = LocalDateTime.parse(parts[6]);
        String email = parts[7];
        String jobTitle = parts[8];
        int yearsOfExperience = Integer.parseInt(parts[9]);

        String employeeType = parts[10];

        if(employeeType.equals("FullTime"))
        {
            String benefitsPackage = parts[11];
            int annualLeaveDays = Integer.parseInt(parts[12]);
            return new FullTimeEmployee(name, department, employeeID, salary, isActive, hireDate, lastUpdated, email, jobTitle, yearsOfExperience, benefitsPackage, annualLeaveDays);
        }

        else if(employeeType.equals("PartTime"))
        {
            int hoursPerWeek = Integer.parseInt(parts[13]);
            double hourlyRate = Double.parseDouble(parts[14]);
            return new PartTimeEmployee(name, department, employeeID, salary, isActive, hireDate, lastUpdated, email, jobTitle, yearsOfExperience, hoursPerWeek, hourlyRate);
        }

        else if (employeeType.equals("Contractor")) 
        {
            LocalDate contractEndDate = LocalDate.parse(parts[15]);
            String agencyName = parts[16];
            return new Contractor(name, department, employeeID, salary, isActive, hireDate, lastUpdated, email, jobTitle, yearsOfExperience, contractEndDate, agencyName);
        }
        return null;
    }
}