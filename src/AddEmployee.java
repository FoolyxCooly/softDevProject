import java.sql.*;
public class AddEmployee {
    String url = "jdbc:mysql://localhost:3306/employeedata";
    String user = "root";
    String password = "";

    public void setEmployee(int empID, String empfName, String emplName, String empEmail, String empHireDate, int empSalary){
        String sqlcom1=
        "INSERT INTO employees (empid,Fname,Lname,email,HireDate,Salaray)"+ 
        "VALUES ('"+empfName +"', '"+emplName+", '"+empEmail+", '"+empHireDate+", '"+empSalary+"'); ";
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
