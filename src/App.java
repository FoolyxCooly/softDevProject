import java.sql.*;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
      
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "";
        StringBuilder output = new StringBuilder("");
        String sqlcommand = "SELECT e.Fname, e.Lname, e.email, jt.job_title, e.empid " +
        "FROM employees e  " +
        "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
        "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id  " +
        "ORDER BY e.empid ; ";

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();

            output.append("\nEMPLOYEE PAYROLL REPORT by Job title \n");
            ResultSet myRS = myStmt.executeQuery(sqlcommand);
            Payroll p1 = new Payroll();
            while (myRS.next()) {
                output.append("Name= " + myRS.getString("e.Fname") + " " + myRS.getString("e.Fname") + "\t");
                output.append("Title=" + myRS.getString("jt.job_title") + "     " + myRS.getString("e.email") + "\n");
                System.out.print(output.toString());
                output.setLength(0);

                output.append(p1.getPayByMonth(myRS.getInt("e.empid"), myConn));
               // getPayroll(myRS.getInt("e.empid"), myConn);
                
            }
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
        String sqlcommand1 = "SELECT e.Fname, e.Lname, e.email, d.Name, e.empid " +
        "FROM employees e  " +
        "JOIN employee_division ediv ON e.empid = ediv.empid " +
        "JOIN division d ON ediv.div_ID = d.ID " +
        "ORDER BY e.empid ; ";

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt1 = myConn.createStatement();
            output.append("\nEMPLOYEE PAYROLL REPORT by Division \n");
            ResultSet myRS = myStmt1.executeQuery(sqlcommand1);
            Payroll p1 = new Payroll();
            while (myRS.next()) {
                output.append("Name= " + myRS.getString("e.Fname") + " " + myRS.getString("e.Lname") + "\t");
                output.append("Division=" + myRS.getString("d.Name") + "     " + myRS.getString("e.email") + "\n");
                System.out.print(output.toString());
                output.setLength(0);

                output.append(p1.getPayByMonth(myRS.getInt("e.empid"), myConn));
               // getPayroll(myRS.getInt("e.empid"), myConn);
                
            }
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
        Change ch1 = new Change();
        try (Scanner myObj = new Scanner(System.in)) {
            System.out.println(" would you like to add to the employee table?");
            String userResponse = myObj.nextLine();
            if(userResponse.equals("yes")|| userResponse.equals("Yes")){
                System.out.println("What column name would you like to add?");
                userResponse= myObj.nextLine();
                ch1.changeTable(userResponse);
            }
        }catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
}
