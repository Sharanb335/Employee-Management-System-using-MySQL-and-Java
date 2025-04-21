The Employee Management System is a Java-based application designed to manage employee records.It connects to a MySQL database using JDBC (Java Database Connectivity) to perform operations such as adding new employees, removing existing employees, promoting employees (updating their position and salary), and displaying all employee details.
This system provides a command-line interface where users can interact with the system through a menu-driven approach.
All employee data is stored securely in the MySQL database, ensuring persistence and easy access even after the program is closed.

Implementation Details:

1. Database Setup (MySQL):
   - A database employee_db is created.
   - A table `employees` is created with columns: `id`, `name`, `position`, and `salary`.

2. Java Program:
   - Connects to the MySQL database using MySQL JDBC Driver (Connector/J).
   - DBConnection.java (for Database Connection)
   - EmployeeDAO.java(Employee Functions)
   - EmployeeManagementSystem.java(Main Class)
   - Menu-driven options are displayed for the user to:
     - Add a new employee
     - Remove an employee by ID
     - Promote an employee (update position and salary)
     - View all employees.

3. Technologies Used:
   - Java (IntelliJ IDEA)
   - MySQL Workbench.
   - MySQL Connector/J (JDBC driver).
