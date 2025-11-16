package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contractor extends Employee 
{

    // Fields specific to contractors
    private LocalDate contractEndDate;
    private String agencyName;

    // Constructors

    // no-argument constructor
    public Contractor() 
    {
        super();
        this.contractEndDate = LocalDate.now();
        this.agencyName = "";
    }

    // partial-argument constructor
    public Contractor(String name, int employeeID, String department, double salary, LocalDate hireDate, LocalDate contractEndDate, String agencyName) 
    {
        super(name, employeeID, department, salary, hireDate);
        setContractEndDate(contractEndDate);
        setAgencyName(agencyName);
    }

    // full-argument constructor
    public Contractor(String name, String department, int employeeID, double salary, boolean isActive, LocalDate hireDate, LocalDateTime lastUpdated, String email, String jobTitle, int yearsOfExperience, LocalDate contractEndDate, String agencyName) 
    {
        super(name, department, employeeID, salary, isActive, hireDate, lastUpdated, email, jobTitle, yearsOfExperience);
        setContractEndDate(contractEndDate);
        setAgencyName(agencyName);
    }

    // Getters and Setters

    // Contract End Date
    public LocalDate getContractEndDate() 
    {
        return this.contractEndDate;
    }   

    public void setContractEndDate(LocalDate contractEndDate) 
    {
        if (contractEndDate == null) 
        {
            throw new IllegalArgumentException("Contract end date cannot be null");
        }

        if (contractEndDate.isBefore(LocalDate.now())) 
        {
            throw new IllegalArgumentException("Contract end date cannot be in the past");
        }
        this.contractEndDate = contractEndDate;
    }

    // Agency Name
    public String getAgencyName() 
    {
        return this.agencyName;
    }

    public void setAgencyName(String agencyName) 
    {
        if (agencyName == null || agencyName.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Agency name cannot be blank");
        }
        this.agencyName = agencyName.trim();
    }
}
