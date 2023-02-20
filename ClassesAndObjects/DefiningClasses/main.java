package DefiningClasses;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments= new HashMap<>();

        for (int i = 1; i <= n ; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            double salary = Double.parseDouble(inputArr[1]);
            String position = inputArr[2];
            String department = inputArr[3];
            String email = "n/a";
            int age = -1;
            Employees employees = null;
            if(inputArr.length == 6){
                email = inputArr[4];
                age = Integer.parseInt(inputArr[5]);
                employees = new Employees(name, salary, position, department, email, age);
            }else if(inputArr.length == 5){
                if(Character.isDigit(inputArr[4].charAt(0))){
                    age = Integer.parseInt(inputArr[4]);
                    employees = new Employees(name, salary, position, department, email, age);
                }else{
                    email = inputArr[4];
                    employees = new Employees(name, salary, position, department, email, age);
                }
            }else{
                employees = new Employees(name, salary, position, department, email, age);
            }
        if(!departments.containsKey(department)){
            departments.put(department, new Department(department));
        }
        departments.get(department).getEmployees().add(employees);
        }
        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
