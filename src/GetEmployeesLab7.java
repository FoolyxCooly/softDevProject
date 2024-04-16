import java.sql.*;

public class GetEmployeesLab7 {
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

            output.append("\nEMPLOYEE PAYROLL REPORT by Alexander Diaz\n");
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
    }

    /* instead of calling the method 'getPayroll()' use the following code 
                 * once you have created the java class. Notice the parameters to the 
				 * method 'getPayByMonth...' in your new Payroll.java class.
                 * 
                 * CODE:
                 *  Payroll p1 = new Payroll();
                 *  output.append(p1.getPayByMonth(myRS.getInt("e.empid"), myConn)); */


    /* This method needs to be moved into its own class called Payroll.java 
     * Use an empty default constructor, no need to have private instance variables. 
     * 
     * You will pass the "myRS.getInt("e.empid")" and "myConn" into the method called
     * 'getPayByMonth()' It must return a StringBuilder object.
     * 
     * CODE HINT in Payroll.java:
     * public StringBuilder getPayByMonth(int empID, Connection myConn) {
     * 
     * 
     * DELETE THIS METHOD 'getPayroll(..' code BEFORE YOU TURN IN THIS JAVA FILE. */
     
   /* 
     public static void getPayroll(int empID, Connection myConn1) {
        StringBuilder output1 = new StringBuilder("");
        String sqlcommand1 = "SELECT e.empid, p.pay_date, p.earnings, p.fed_tax, " +
                "p.fed_med,p.fed_SS,p.state_tax,p.retire_401k,p.health_care  " +
                "FROM employees e " +
                "JOIN payroll p ON e.empid = p.empid " +
                "WHERE e.empid = " + empID + " " +
                "ORDER BY p.pay_date;";
        try {
            Statement myStmt = myConn1.createStatement();

            output1.append("\tEMP ID\tPAY DATE\tGROSS\tFederal\tFedMed\tFedSS\tState\t401K\tHealthCare\n");
            ResultSet myRS1 = myStmt.executeQuery(sqlcommand1);
            while (myRS1.next()) {
                output1.append("\t" + myRS1.getString("e.empid") + "\t");
                output1.append(myRS1.getDate("p.pay_date") + "\t" + myRS1.getDouble("p.earnings") + "\t");
                output1.append(myRS1.getDouble("p.fed_tax") + "\t" + myRS1.getDouble("p.fed_med") + "\t");
                output1.append(myRS1.getDouble("p.fed_SS") + "\t" + myRS1.getDouble("p.state_tax") + "\t");
                output1.append(myRS1.getDouble("p.retire_401K") + "\t" + myRS1.getDouble("p.health_care")+"\n" );
            }
            System.out.println(output1.toString());
            output1.setLength( 0 );
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
    */
}
