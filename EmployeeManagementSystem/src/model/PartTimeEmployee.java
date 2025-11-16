package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PartTimeEmployee extends Employee 
{
    // Fields specific to part-time employees
    private int hoursPerWeek;
    private double hourlyRate;
    
    // Constructors

    // no-argument Constructor
    public PartTimeEmployee()
    {
        super();
        this.hoursPerWeek = 0;
        this.hourlyRate = 0.0;
    }

    // partial-argument Constructor
    public PartTimeEmployee(String name, int employeeID, String department, double salary, LocalDate hireDate, int hoursPerWeek, double hourlyRate) 
    {
        super(name, employeeID, department, salary, hireDate);
        setHoursPerWeek(hoursPerWeek);
        setHourlyRate(hourlyRate);
    }

    // full-argument Constructor
    public PartTimeEmployee(String name, String department, int employeeID, double salary, boolean isActive, LocalDate hireDate, LocalDateTime lastUpdated, String email, String jobTitle, int yearsOfExperience, int hoursPerWeek, double hourlyRate) 
    {
        super(name, department, employeeID, salary, isActive, hireDate, lastUpdated, email, jobTitle, yearsOfExperience);
        setHoursPerWeek(hoursPerWeek);
        setHourlyRate(hourlyRate);
    }

    // Getters & Setters

    // Hours Per Week
    public int getHoursPerWeek()
    {
        return this.hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek)
    {
        if(hoursPerWeek < 0 || hoursPerWeek > 40)
        {
            throw new IllegalArgumentException("Hours per week must be between 0 and 40 for a part time employee");
        }
        this.hoursPerWeek = hoursPerWeek;
    }

    // Hourly Rate
    public double getHourlyRate()
    {
        return this.hourlyRate;
    }

    public void setHourlyRate(double hourlyRate)
    {
        if(hourlyRate < 0)
        {
            throw new IllegalArgumentException("Hourly Rate cannot be negative");
        }
        this.hourlyRate = hourlyRate;
    }
}
