import java.sql.*;
public class Search {
    String url = "jdbc:mysql://localhost:3306/employeedata";
    String user = "root";
    String password = "";

    public void getEmpID(int empID){
        String sqlcom1="SELECT * FROM employees"+
        "WHERE empid = "+empID+" ; ";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();

            ResultSet myRS = myStmt.executeQuery(sqlcom1);
            while (myRS.next()) {
                System.out.println(myRS.getString("empid") + myRS.getString("Fname") + " " + myRS.getString("Lname") + 
                " " + myRS.getString("email")+" " + myRS.getString("HireDate")+" " + myRS.getString("Salary"));
            }
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
    public void getEmpSNN(int empSNN){
        
    }
    public void getEmpName(String empName){
        
    }
    public void getEmpEmail(String empEmail){

    }
    public void getEmpSalary(int empSalary){

    }
    public void getEmpHireDate(String empHireDate){

    }
}
