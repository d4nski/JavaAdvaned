package DefiningClasses;

public class Employees {
    public String name;
    public double salary;
    public String position;
    public String department;
    public String email;
    public int age;

    public Employees(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public double getSalary(){
        return  this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
