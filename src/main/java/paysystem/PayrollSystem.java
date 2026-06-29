package paysystem;

import java.util.*;
import java.sql.*;

public class PayrollSystem {

    // Add employee
    public void addEmployee(Employee emp) {
        if(emp == null) return;

        if(employeeExists(emp.getId())) {
            System.out.println("X Employee ID " + emp.getId() + " already exists.");
            return;
        }

        String sql = "INSERT INTO pay_db(id, name, type, monthlySalary, hoursWorked, hourlyRate) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());

            if(emp instanceof FullTimeEmployee fte) {
                ps.setString(3, "FULL");
                ps.setDouble(4, fte.getMonthlySalary());
                ps.setNull(5, Types.INTEGER);
                ps.setNull(6, Types.DOUBLE);
            } else if(emp instanceof PartTimeEmployee pte) {
                ps.setString(3, "PART");
                ps.setNull(4, Types.DOUBLE);
                ps.setInt(5, pte.getHoursWorked());
                ps.setDouble(6, pte.getHourlyRate());
            }

            ps.executeUpdate();
            System.out.println("✔ Employee added successfully!");

        } catch(SQLException e) {
            System.out.println("X Error adding employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Remove employee
    public void removeEmployee(int id) {
        if(!employeeExists(id)) {
            System.out.println("X Employee ID " + id + " does not exist.");
            return;
        }

        String sql = "DELETE FROM pay_db WHERE id=?";
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("✔ Employee removed successfully.");
            } else {
                System.out.println("X Employee not found.");
            }

        } catch(SQLException e) {
            System.out.println("X Error removing employee: " + e.getMessage());
        }
    }

    // Display employees
    public void displayEmployees() {
        String sql = "SELECT * FROM pay_db ORDER BY id";

        try(Connection conn = DBConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasEmp = false;
            System.out.println("\n--- Employee List ---");
            while(rs.next()) {
                hasEmp = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                
                if("FULL".equals(type)) {
                    double salary = rs.getDouble("monthlySalary");
                    System.out.printf("%d - %s (Full-Time) Salary: $%.2f%n", id, name, salary);
                } else if("PART".equals(type)) {
                    int hours = rs.getInt("hoursWorked");
                    double rate = rs.getDouble("hourlyRate");
                    double salary = hours * rate;
                    System.out.printf("%d - %s (Part-Time) Salary: $%.2f (Hours: %d, Rate: $%.2f)%n", 
                                    id, name, salary, hours, rate);
                }
            }

            if(!hasEmp) System.out.println("X No employees to display.");

        } catch(SQLException e) {
            System.out.println("X Error fetching employees: " + e.getMessage());
        }
    }

    // Show total payroll
    public void showTotalPayroll() {
        String sql = "SELECT SUM(CASE WHEN type='FULL' THEN monthlySalary ELSE hoursWorked * hourlyRate END) AS total FROM pay_db";

        try(Connection conn = DBConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            if(rs.next()) {
                double total = rs.getDouble("total");
                if(rs.wasNull()) {
                    System.out.println("\n💰 Total Payroll: $0.00");
                } else {
                    System.out.printf("\n💰 Total Payroll: $%.2f%n", total);
                }
            }

        } catch(SQLException e) {
            System.out.println("X Error calculating total payroll: " + e.getMessage());
        }
    }

    // Check if employee exists
    public boolean employeeExists(int id) {
        String sql = "SELECT id FROM pay_db WHERE id=?";
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch(SQLException e) {
            System.out.println("X Error checking employee: " + e.getMessage());
            return true; // prevent duplicate insertion on error
        }
    }
}


