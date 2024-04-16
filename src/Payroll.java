import java.sql.*;

public class Payroll {

    public StringBuilder getPayByMonth(int empID, Connection myConn) {
        StringBuilder output1 = new StringBuilder("");
        String sqlcommand1 = "SELECT e.empid, p.pay_date, p.earnings, p.fed_tax, " +
                "p.fed_med,p.fed_SS,p.state_tax,p.retire_401k,p.health_care  " +
                "FROM employees e " +
                "JOIN payroll p ON e.empid = p.empid " +
                "WHERE e.empid = " + empID + " " +
                "ORDER BY p.pay_date;";
        try {
            Statement myStmt = myConn.createStatement();

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
        return output1;
    }
}
