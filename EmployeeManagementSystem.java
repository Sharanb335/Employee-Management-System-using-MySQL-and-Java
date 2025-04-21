import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Promote Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(name, position, salary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = sc.nextInt();
                    dao.removeEmployee(removeId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to promote: ");
                    int promoteId = sc.nextInt();
                    System.out.print("Enter increment amount: ");
                    double increment = sc.nextDouble();
                    dao.promoteEmployee(promoteId, increment);
                    break;
                case 4:
                    dao.displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
