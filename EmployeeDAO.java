import java.sql.*;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() {
        conn = DBConnection.getConnection();
    }

    // Add Employee
    public void addEmployee(String name, String position, double salary) {
        String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove Employee
    public void removeEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0)
                System.out.println("Employee removed successfully!");
            else
                System.out.println("Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Promote Employee (increase salary)
    public void promoteEmployee(int id, double increment) {
        String sql = "UPDATE employees SET salary = salary + ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, increment);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0)
                System.out.println("Employee promoted successfully!");
            else
                System.out.println("Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display Employees
    public void displayEmployees() {
        String sql = "SELECT * FROM employees";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("ID\tName\t\tPosition\t\tSalary");
            while (rs.next()) {
                System.out.printf("%d\t%s\t\t%s\t\t%.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
