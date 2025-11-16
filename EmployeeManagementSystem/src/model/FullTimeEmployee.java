package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FullTimeEmployee extends Employee
{
    // Fields specific to full-time employees
    private String benefitsPackage;
    private int annualLeaveDays;

    // Constructors

    // no-argument Constructor
    public FullTimeEmployee()
    {
        super();
        this.benefitsPackage = "";
        this.annualLeaveDays = 0;
    }

    // partial-argument Constructor
    public FullTimeEmployee(String name, int employeeID, String department, double salary, LocalDate hireDate, String benefitsPackage, int annualLeaveDays)
    {
        super(name, employeeID, department, salary, hireDate);
        setBenefitsPackage(benefitsPackage);
        setAnnualLeaveDays(annualLeaveDays);
    }

    // full-argument Constructor
    public FullTimeEmployee(String name, String department, int employeeID, double salary, boolean isActive, LocalDate hireDate, LocalDateTime lastUpdated, String email, String jobTitle, int yearsOfExperience, String benefitsPackage, int annualLeaveDays) 
    {
        super(name, department, employeeID, salary, isActive, hireDate, lastUpdated, email, jobTitle, yearsOfExperience); 
        setBenefitsPackage(benefitsPackage);
        setAnnualLeaveDays(annualLeaveDays);
    }

    // Getters & Setters

    // Benefits Package
    public String getBenefitsPackage()
    {
        return this.benefitsPackage;
    }

    public void setBenefitsPackage(String benefitsPackage)
    {
        if(benefitsPackage == null || benefitsPackage.trim().isEmpty())
        {
            throw new IllegalArgumentException("Benefits Package cannot be empty");
        }
        this.benefitsPackage = benefitsPackage.trim();
    }

    // Annual Leave Days
    public int getAnnualLeaveDays()
    {
        return this.annualLeaveDays;
    }

    public void setAnnualLeaveDays(int annualLeaveDays)
    {
        if(annualLeaveDays < 0)
        {
            throw new IllegalArgumentException("Annual Leave Days cannot be negative");
        }
        this.annualLeaveDays = annualLeaveDays;
    }
}
