package DefiningClasses;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employees> employees;

    public Department(String name){
        this.name = name;
        this.employees = new ArrayList<>();
    }
    public double getAverageSalary(){
        double sumSalary = 0;
        for(Employees employee: employees){
            sumSalary += employee.getSalary();
        }
        return sumSalary / employees.size();
    }
    public List<Employees> getEmployees(){
        return this.employees;
    }
    public String getName(){
        return  this.name;
    }
}
