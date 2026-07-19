import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println(" EMPLOYEE MANAGEMENT SYSTEM ");
            System.out.println("======================================");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Company Hierarchy");
            System.out.println("4. Count Employees");
            System.out.println("5. Update Employee");
            System.out.println("6. Delete Employee");
            System.out.println("7. Display Employees Under Manager");
            System.out.println("8. Display Reporting Chain");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Designation: ");
                    String designation = scanner.nextLine();

                    System.out.print("Manager ID (0 for CEO): ");
                    int managerId = scanner.nextInt();

                    system.addEmployee(id, name, designation, managerId);
                    break;

                case 2:

                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();

                    system.searchEmployee(searchId);
                    break;

                case 3:

                    system.displayHierarchy();
                    break;

                case 4:

                    system.countEmployees();
                    break;

                case 5:

                    System.out.print("Employee ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("New Designation: ");
                    String newDesignation = scanner.nextLine();

                    system.updateEmployee(updateId, newName, newDesignation);
                    break;

                case 6:

                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = scanner.nextInt();

                    system.deleteEmployee(deleteId);
                    break;

                case 7:

                    System.out.print("Enter Manager ID: ");
                    int managerIdForDisplay = scanner.nextInt();

                    system.displaySubordinates(managerIdForDisplay);
                    break;

                case 8:
                     System.out.print("Enter Employee ID: ");
                     int employeeId = scanner.nextInt();
                     
                     system.displayReportingChain(employeeId);
                      break;

                case 9:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 9);

        scanner.close();
    }
}