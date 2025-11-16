package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee implements Comparable<Employee>
{
    // Fields
    private String name;
    private String department;
    private int employeeID;
    private double salary;
    private boolean isActive;
    private LocalDate hireDate;
    private LocalDateTime lastUpdated;
    private String email;
    private String jobTitle;
    private int yearsOfExperience;

    // Constructors

    // no-argument Constructor
    public Employee() 
    {
        this.name = "";
        this.department = "";
        this.employeeID = 0;
        this.salary = 0.0;
        this.isActive = false;
        this.hireDate = LocalDate.now();
        this.lastUpdated = LocalDateTime.now();
        this.email = "";
        this.jobTitle = "";
        this.yearsOfExperience = 0;
    }

    // partial-argument Constructor
    public Employee(String name, int employeeID, String department, double salary, LocalDate hireDate) 
    {
        setName(name);
        setDepartment(department);
        setEmployeeID(employeeID);
        setSalary(salary);
        this.isActive = true; 
        setHireDate(hireDate);
        this.lastUpdated = LocalDateTime.now();
        this.email = "";
        this.jobTitle = "";
        this.yearsOfExperience = 0;
    }

    // full-argument Constructor
    public Employee(String name, String department, int employeeID, double salary, boolean isActive, LocalDate hireDate,
            LocalDateTime lastUpdated, String email, String jobTitle, int yearsOfExperience) 
    {
        setName(name);
        setDepartment(department);
        setEmployeeID(employeeID);
        setSalary(salary);
        this.isActive = isActive;
        setHireDate(hireDate);
        setLastUpdated(lastUpdated);
        setEmail(email);
        setJobTitle(jobTitle);
        setYearsOfExperience(yearsOfExperience);
    }

    // Getters & Setters

    // Name
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if(name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name.trim();
    }

    // Department
    public String getDepartment()
    {
        return this.department;
    }

    public void setDepartment(String department)
    {
        if(department == null || department.trim().isEmpty())
        {
            throw new IllegalArgumentException("Department cannot be blank");
        }
        this.department = department.trim();
    }

    // EmployeeID
    public int getEmployeeID()
    {
        return this.employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        if(employeeID <= 0)
        {
            throw new IllegalArgumentException("Employee ID must be a positive number");
        }
        this.employeeID = employeeID;
    }

    // Salary
    public double getSalary()
    {
        return this.salary;
    }

    public void setSalary(double salary)
    {
        if(salary < 0)
        {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    // IsActive
    public boolean getIsActive()
    {
        return this.isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    // HireDate
    public LocalDate getHireDate()
    {
        return this.hireDate;
    }

    public void setHireDate(LocalDate hireDate)
    {
        if(hireDate == null)
        {
            throw new IllegalArgumentException("Hire Date cannot be empty");
        }

        if(hireDate.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("Hire Date is invalid.");
        }

        this.hireDate = hireDate;
    }

    // LastUpdated
    public LocalDateTime getLastUpdated()
    {
        return this.lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated)
    {
        if(lastUpdated == null)
        {
            throw new IllegalArgumentException("Last updated cannot be empty");
        }
        this.lastUpdated = lastUpdated;
    }

    // Email
    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if(email == null || email.trim().isEmpty())
        {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        this.email = email.trim();
    }

    // JobTitle
    public String getJobTitle()
    {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        if(jobTitle == null || jobTitle.trim().isEmpty())
        {
            throw new IllegalArgumentException("Job Title cannot be blank");
        }
        this.jobTitle = jobTitle.trim();
    }

    // Years of Experience
    public int getYearsOfExperience()
    {
        return this.yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience)
    {
        if(yearsOfExperience < 0)
        {
            throw new IllegalArgumentException("Years of Experience cannot be a negative");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    // Comparable method - order by employeeID
    @Override
    public int compareTo(Employee other)
    {
        return Integer.compare(this.employeeID, other.employeeID);
    }
}
