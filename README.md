# 💼 Employee Payroll Management System

A **Java-based Employee Payroll Management System** developed using **Core Java, JDBC, PostgreSQL, and Maven**. The application allows users to manage employee records, calculate salaries, and maintain payroll information through a menu-driven console interface.

---

## 📌 Features

- ➕ Add Full-Time Employees
- ➕ Add Part-Time Employees
- ❌ Remove Employees
- 👨‍💼 Display Employee Details
- 💰 Calculate Individual Employee Salary
- 📊 Show Total Payroll
- ✅ Input Validation
- 🔍 Prevent Duplicate Employee IDs
- 🗄️ PostgreSQL Database Integration
- ⚡ JDBC Connectivity
- 📂 Object-Oriented Design

---

## 🛠️ Tech Stack

| Technology | Used |
|------------|------|
| Java | Core Java |
| Database | PostgreSQL |
| Connectivity | JDBC |
| Build Tool | Maven |
| IDE | Eclipse |
| Version Control | Git & GitHub |

---

## 📁 Project Structure

```
Employee-Payroll-Management-System
│
├── src
│   └── main
│       └── java
│           └── paysystem
│               ├── Employee.java
│               ├── FullTimeEmployee.java
│               ├── PartTimeEmployee.java
│               ├── PayrollSystem.java
│               ├── DBConnect.java
│               ├── InputValidator.java
│               └── Main.java
│
├── pom.xml
└── README.md
```

---

## 🗃️ Database

Database Used:

```
PostgreSQL
```

Update the database credentials in:

```java
DBConnect.java
```

```java
private static final String URL = "jdbc:postgresql://localhost:5432/your-db-name";
private static final String USER = "your-username";
private static final String PASSWORD = "your-password";
```

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/snehaaa2703/Employee-Payroll-Management-System.git
```

### 2️⃣ Open in Eclipse

Import the project as an Existing Maven Project.

### 3️⃣ Configure PostgreSQL

- Create the required database.
- Create the employee table.
- Update the database credentials in `DBConnect.java`.

### 4️⃣ Run

Execute

```
Main.java
```

---

## 💻 Application Menu

```
===== PAYROLL SYSTEM =====

1. Add Full-Time Employee

2. Add Part-Time Employee

3. Remove Employee

4. Display Employees

5. Show Total Payroll

6. Exit
```

---

## 🧠 OOP Concepts Used

- Abstraction
- Inheritance
- Polymorphism
- Encapsulation
- Method Overriding
- Constructors
- Exception Handling

---

## 📊 Salary Calculation

### Full-Time Employee

```
Salary = Monthly Salary
```

### Part-Time Employee

```
Salary = Hours Worked × Hourly Rate
```

---

## ✅ Validations

- Employee Name Validation
- Positive Employee ID
- Positive Salary
- Positive Hourly Rate
- Positive Working Hours
- Duplicate Employee ID Check

---

## 📸 Sample Output

```
===== PAYROLL SYSTEM =====

1. Add Full-Time Employee
2. Add Part-Time Employee
3. Remove Employee
4. Display Employees
5. Show Total Payroll
6. Exit

Enter Choice :
```

---

## 🚀 Future Enhancements

- Employee Login System
- Admin Authentication
- GUI using JavaFX/Swing
- Payroll Reports (PDF/Excel)
- Employee Search
- Employee Update Module
- Attendance Management
- Leave Management
- Department Management
- REST API Integration

---

## 👨‍💻 Author

**Sneha Saldur**

Bachelor Of Engineering(IT)

---

## ⭐ If you like this project

Give this repository a ⭐ on GitHub.

---

## 📜 License

This project is developed for educational and learning purposes.
