import java.sql.*;
public class AddEmployee {
    String url = "jdbc:mysql://localhost:3306/employeeData";
    String user = "root";
    String password = "";

    public void setEmployee(String empfName, String emplName, String empEmail, String empHireDate, int empSalary){
        String sqlcom1 =
        "INSERT INTO employees (Fname, Lname, email, HireDate, Salary) "+ 
        "VALUES ('"+ empfName +"', '"+ emplName + "', '"+ empEmail + "', '"+ empHireDate + "', '"+ empSalary + "'); ";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
    
            myStmt.executeUpdate(sqlcom1);
    
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
    
    /**
     * 
     */
    public void addingColumn(){
        String sqlcom1=" IF COL_LENGTH('employees','snn') IS NOT NULL"+
        "   PRINT 'Column exists' "+
        "ELSE "+
        "   ALTER TABLE employees "+ 
        "   ADD snn INT(9) ;";

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();

            myStmt.executeUpdate(sqlcom1);
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }

}