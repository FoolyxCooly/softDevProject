import java.sql.*;
public class showEmployees {
    String url = "jdbc:mysql://localhost:3306/employeedata";
    String user = "root";
    String password = "Ap$129212";
    public void displayEmp(){
        String sqlcom1= "SELECT * FROM employees "+
        "ORDER BY empid ; ";
        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();

            System.out.println("\nEMPLOYEE REPORT \n");
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
    public void empPayRoll(){
        String sqlcommand = "SELECT e.Fname, e.Lname, e.email, jt.job_title, e.empid " +
        "FROM employees e  " +
        "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
        "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id  " +
        "ORDER BY e.empid ; ";

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();

            System.out.println("\nEMPLOYEE PAYROLL REPORT by Alexander Diaz\n");
            ResultSet myRS = myStmt.executeQuery(sqlcommand);
            Payroll p1 = new Payroll();
            while (myRS.next()) {
                System.out.println("Name= " + myRS.getString("e.Fname") + " " + myRS.getString("e.Fname") + "\t");
                System.out.println("Title=" + myRS.getString("jt.job_title") + "     " + myRS.getString("e.email") + "\n");
                
                System.out.println(p1.getPayByMonth(myRS.getInt("e.empid"), myConn));
            }
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
}
