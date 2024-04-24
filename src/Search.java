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
        String sqlcom1="SELECT * FROM employees"+
        "WHERE snn = "+empSNN+" ; ";
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
    public void getEmpName(String empfName, String emplName){
        String sqlcom1="SELECT * FROM employees"+
        "WHERE FName = "+empfName+", "+ emplName+" ; ";
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
    public void getEmpEmail(String empEmail){
        String sqlcom1="SELECT * FROM employees"+
        "WHERE email= "+empEmail+" ; ";
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
    public void getEmpSalary(int empSalary){
        String sqlcom1="SELECT * FROM employees"+
        "WHERE Salary = "+empSalary+" ; ";
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
    public void getEmpHireDate(String empHireDate){
        String sqlcom1="SELECT * FROM employees"+
        "WHERE HireDate = "+empHireDate+" ; ";
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
}
