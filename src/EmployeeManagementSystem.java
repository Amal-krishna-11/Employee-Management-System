import java.util.HashMap;

public class EmployeeManagementSystem {

    private HashMap<Integer, Employee> employeeMap;
    private Employee ceo;

    public EmployeeManagementSystem() {
        employeeMap = new HashMap<>();
        ceo = null;
    }

    // Add Employee
    public void addEmployee(int id, String name, String designation, int managerId) {

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee ID already exists.");
            return;
        }

        Employee newEmployee = new Employee(id, name, designation);

        if (managerId == 0) {

            if (ceo != null) {
                System.out.println("CEO already exists.");
                return;
            }

            ceo = newEmployee;
        } else {

            Employee manager = employeeMap.get(managerId);

            if (manager == null) {
                System.out.println("Manager not found.");
                return;
            }

            newEmployee.manager = manager;
            manager.addSubordinate(newEmployee);
        }

        employeeMap.put(id, newEmployee);

        System.out.println("Employee Added Successfully.");
    }

    // Search Employee
    public void searchEmployee(int id) {

        Employee employee = employeeMap.get(id);

        if (employee == null) {
            System.out.println("Employee Not Found.");
            return;
        }

        System.out.println("\nEmployee Details");
        System.out.println("-----------------------");
        System.out.println("ID : " + employee.employeeId);
        System.out.println("Name : " + employee.name);
        System.out.println("Designation : " + employee.designation);

        if (employee.manager != null)
            System.out.println("Manager : " + employee.manager.name);
        else
            System.out.println("Manager : None (CEO)");
    }

    // Display Hierarchy
    public void displayHierarchy() {

        if (ceo == null) {
            System.out.println("No Employees Available.");
            return;
        }

        System.out.println("\nCompany Hierarchy");
        System.out.println("-----------------------");

        displayTree(ceo, 0);
    }

    private void displayTree(Employee employee, int level) {

        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }

        System.out.println(employee.name + " (" + employee.designation + ")");

        for (Employee child : employee.subordinates) {
            displayTree(child, level + 1);
        }
    }

    // Count Employees
    public void countEmployees() {
        System.out.println("Total Employees : " + employeeMap.size());
    }

    // Update Employee
    public void updateEmployee(int id, String newName, String newDesignation) {

        Employee employee = employeeMap.get(id);

        if (employee == null) {
            System.out.println("Employee Not Found.");
            return;
        }

        employee.name = newName;
        employee.designation = newDesignation;

        System.out.println("Employee Updated Successfully.");
    }


// Delete Employee
public void deleteEmployee(int id) {

    Employee employee = employeeMap.get(id);

    if (employee == null) {
        System.out.println("Employee Not Found.");
        return;
    }

    if (employee == ceo) {
        System.out.println("CEO cannot be deleted.");
        return;
    }

    Employee manager = employee.manager;

    manager.removeSubordinate(employee);

    employeeMap.remove(id);

    System.out.println("Employee Deleted Successfully.");
}

// Display Employees Under a Manager
public void displaySubordinates(int managerId) {

    Employee manager = employeeMap.get(managerId);

    if (manager == null) {
        System.out.println("Manager Not Found.");
        return;
    }

    if (manager.subordinates.isEmpty()) {
        System.out.println(manager.name + " has no subordinates.");
        return;
    }

    System.out.println("\nEmployees under " + manager.name);
    System.out.println("------------------------------");

    for (Employee employee : manager.subordinates) {
        System.out.println(
            employee.employeeId + " - " +
            employee.name + " (" +
            employee.designation + ")"
        );
    }
}
// Display Reporting Chain
public void displayReportingChain(int employeeId) {

    Employee employee = employeeMap.get(employeeId);

    if (employee == null) {
        System.out.println("Employee Not Found.");
        return;
    }

    System.out.println("\nReporting Chain");
    System.out.println("-------------------------");

    while (employee != null) {
        System.out.println(employee.name);

        if (employee.manager != null) {
            System.out.println("↑");
        }

        employee = employee.manager;
    }
}
}