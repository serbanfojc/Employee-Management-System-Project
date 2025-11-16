package model;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> 
{
    // Comparator method - sort employee by name alphabetically
    @Override
    public int compare(Employee e1, Employee e2) 
    {
        return e1.getName().compareToIgnoreCase(e2.getName());
    }
}