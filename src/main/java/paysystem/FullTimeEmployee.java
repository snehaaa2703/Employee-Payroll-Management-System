package paysystem;


public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        if (monthlySalary <= 0) {
            throw new IllegalArgumentException("Monthly salary must be positive.");
        }
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
}