import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(String name, int age, String email) {
        Customer newCustomer = new Customer(name, age, email);
        customers.add(newCustomer);
        System.out.println("Customer added successfully!");
    }

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers to display.");
        } else {
            System.out.println("Customer List:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public void removeCustomer(String name) {
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                customers.remove(customer);
                System.out.println("Customer removed successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Customer not found.");
        }
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCustomer Management System:");
            System.out.println("1. Add Customer");
            System.out.println("2. Display Customers");
            System.out.println("3. Remove Customer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    manager.addCustomer(name, age, email);
                    break;
                case 2:
                    manager.displayCustomers();
                    break;
                case 3:
                    System.out.print("Enter customer name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    manager.removeCustomer(nameToRemove);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
