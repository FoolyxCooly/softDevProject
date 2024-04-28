import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Updates {
    String url = "jdbc:mysql://localhost:3306/employeedata";
    String user = "root";
    String password = "";

    public void updateEmpSNN(int empID,int empSnn){
        String sqlcom1="UPDATE employees"+
        "SET snn = "+ empSnn +
        "WHERE empid = "+empID+" ; ";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();

            myStmt.executeUpdate(sqlcom1);
        
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
    public void updateEmpName(int empID, String empfName, String emplName){
        String sqlcom1 = "UPDATE employees " +
                         "SET Fname = '" + empfName + "', Lname = '" + emplName + "' " +
                         "WHERE empid = " + empID + ";";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            myStmt.executeUpdate(sqlcom1);
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
    public void updateEmpEmail(int empID, String empEmail){
        String sqlcom1 = "UPDATE employees " +
                         "SET email = '" + empEmail + "' " +
                         "WHERE empid = " + empID + ";";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
    
            myStmt.executeUpdate(sqlcom1);
    
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
    public void updateEmpSalary(int empID, String empSalary){
        String sqlcom1 = "UPDATE employees " +
                         "SET Salary = '" + empSalary + "' " +
                         "WHERE empid = " + empID + ";";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
    
            myStmt.executeUpdate(sqlcom1);
    
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
    
    public void updateEmpHireDate(int empID, String empHireDate) {
        if (isValidDateFormat(empHireDate)) {
            String sqlcom1 = "UPDATE employees " +
                             "SET HireDate = '" + empHireDate + "' " +
                             "WHERE empid = " + empID + ";";
            try (Connection myConn = DriverManager.getConnection(url, user, password)) {
                Statement myStmt = myConn.createStatement();
    
                myStmt.executeUpdate(sqlcom1);
    
                myConn.close();
            } catch (Exception e) {
                System.out.println("ERROR " + e.getLocalizedMessage());
            }
        } else {
            System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
        }
    }

    private boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }  
}
