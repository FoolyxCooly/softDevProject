import java.sql.*;

public class Search {
    String url = "jdbc:mysql://localhost:3306/employeeData";
    String user = "root";
    String password = "";

    private void printEmployeeInfo(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println("Employee ID: " + resultSet.getString("empid"));
            System.out.println("Employee Name: " + resultSet.getString("Fname") + " " + resultSet.getString("Lname"));
            System.out.println("Email: " + resultSet.getString("email"));
            System.out.println("Hire Date: " + resultSet.getString("HireDate"));
            System.out.println("Salary: " + resultSet.getString("Salary"));
        }
    }

    public void getEmpID(int empID) {
        String sqlcom1 = "SELECT * FROM employees WHERE empid = " + empID;
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            ResultSet myRS = myStmt.executeQuery(sqlcom1);
            printEmployeeInfo(myRS);
            myConn.close();
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public void getEmpName(String empfName, String emplName) {
        String sqlcom1 = "SELECT * FROM employees WHERE Fname = '" + empfName + "' AND Lname = '" + emplName + "'";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            ResultSet myRS = myStmt.executeQuery(sqlcom1);
            printEmployeeInfo(myRS);
            myConn.close();
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public void getEmpEmail(String empEmail) {
        String sqlcom1 = "SELECT * FROM employees WHERE email = '" + empEmail + "'";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            ResultSet myRS = myStmt.executeQuery(sqlcom1);
            printEmployeeInfo(myRS);
            myConn.close();
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public void getEmpSalary(int empSalary) {
        String sqlcom1 = "SELECT * FROM employees WHERE Salary = " + empSalary;
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            ResultSet myRS = myStmt.executeQuery(sqlcom1);
            printEmployeeInfo(myRS);
            myConn.close();
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public void getEmpHireDate(String empHireDate) {
        String sqlcom1 = "SELECT * FROM employees WHERE HireDate = '" + empHireDate + "'";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            ResultSet myRS = myStmt.executeQuery(sqlcom1);
            printEmployeeInfo(myRS);
            myConn.close();
        } catch (SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
}
