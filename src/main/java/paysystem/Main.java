package paysystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n===== PAYROLL SYSTEM =====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Show Total Payroll");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choiceInput = sc.nextLine();
            if(!choiceInput.matches("\\d+")) {
                System.out.println("❌ Invalid input! Enter 1-6.");
                continue;
            }

            int choice = Integer.parseInt(choiceInput);

            switch(choice) {
                case 1 -> addFullTimeEmployee(payroll, sc);
                case 2 -> addPartTimeEmployee(payroll, sc);
                case 3 -> removeEmployee(payroll, sc);
                case 4 -> payroll.displayEmployees();
                case 5 -> payroll.showTotalPayroll();
                case 6 -> {
                    System.out.println("👋 Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Enter 1-6.");
            }
        }
    }

    // Helper methods to safely add employees
    private static void addFullTimeEmployee(PayrollSystem payroll, Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if(!name.matches("[a-zA-Z ]+")) {
            System.out.println("❌ Invalid name.");
            return;
        }
        int id = readPositiveInt(sc, "Enter ID: ");
        if(payroll.employeeExists(id)) return;
        double salary = readPositiveDouble(sc, "Enter Monthly Salary: ");
        payroll.addEmployee(new FullTimeEmployee(name, id, salary));
    }

    private static void addPartTimeEmployee(PayrollSystem payroll, Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if(!name.matches("[a-zA-Z ]+")) {
            System.out.println("❌ Invalid name.");
            return;
        }
        int id = readPositiveInt(sc, "Enter ID: ");
        if(payroll.employeeExists(id)) return;
        int hours = readPositiveInt(sc, "Enter Hours Worked: ");
        double rate = readPositiveDouble(sc, "Enter Hourly Rate: ");
        payroll.addEmployee(new PartTimeEmployee(name, id, hours, rate));
    }

    private static void removeEmployee(PayrollSystem payroll, Scanner sc) {
        int id = readPositiveInt(sc, "Enter Employee ID to remove: ");
        payroll.removeEmployee(id);
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        while(true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                int val = Integer.parseInt(input);
                if(val <= 0) throw new NumberFormatException();
                return val;
            } catch(NumberFormatException e) {
                System.out.println("❌ Enter a positive integer.");
            }
        }
    }

    private static double readPositiveDouble(Scanner sc, String prompt) {
        while(true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                double val = Double.parseDouble(input);
                if(val <= 0) throw new NumberFormatException();
                return val;
            } catch(NumberFormatException e) {
                System.out.println("❌ Enter a positive number.");
            }
        }
    }
}



