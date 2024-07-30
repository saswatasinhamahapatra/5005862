import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private int size;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.size = 0;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        size++;
    }

    public Employee searchEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmployeeId() == employeeId) {
                iterator.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(new Employee(id, name, position, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee emp = ems.searchEmployee(searchId);
                    if (emp != null) {
                        System.out.println(emp);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.println("List of Employees:");
                    ems.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean deleted = ems.deleteEmployee(deleteId);
                    if (deleted) {
                        System.out.println("Employee deleted successfully!");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}

