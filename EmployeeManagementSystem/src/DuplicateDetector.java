import model.*;
import java.util.*;

public class DuplicateDetector 
{
    
    // Find duplicate employees based on employeeID using HashSet
    public static List<Employee> findDuplicates(List<Employee> employees) 
    {
        Set<Integer> seen = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();
        
        for (Employee emp : employees) 
            {
            // If employeeID already exists in set, its a duplicate
            if (!seen.add(emp.getEmployeeID())) 
            {
                duplicates.add(emp);
            }
        }
        
        return duplicates;
    }
    
    // Get unique employees using HashSet
    public static Set<Employee> getUniqueEmployees(List<Employee> employees) 
    {
        return new HashSet<>(employees);
    }
    
    // Count employees by department using HashMap
    public static Map<String, Integer> countByDepartment(List<Employee> employees) 
    {
        Map<String, Integer> departmentCounts = new HashMap<>();
        
        for (Employee emp : employees) 
        {
            String dept = emp.getDepartment();
            departmentCounts.put(dept, departmentCounts.getOrDefault(dept, 0) + 1);
        }
        
        return departmentCounts;
    }
    
    // Find employees by department using HashMap for fast lookup
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) 
    {
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        
        for (Employee emp : employees) 
        {
            String dept = emp.getDepartment();
            departmentMap.putIfAbsent(dept, new ArrayList<>());
            departmentMap.get(dept).add(emp);
        }
        
        return departmentMap;
    }
}