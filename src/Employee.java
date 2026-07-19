import java.util.ArrayList;

public class Employee {

    int employeeId;
    String name;
    String designation;

    Employee manager;
    ArrayList<Employee> subordinates;

    public Employee(int employeeId, String name, String designation) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }
}