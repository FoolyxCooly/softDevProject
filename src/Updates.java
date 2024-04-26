import java.sql.*;

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
        String sqlcom1="UPDATE employees"+
        "SET Fname = "+ empfName +" , Lname = "+emplName+
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
    public void updateEmpEmail(int empID, String empEmail){
        String sqlcom1="UPDATE employees"+
        "SET email = "+ empEmail +
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
    public void updateEmpSalary(int empID, String empSalary){
        String sqlcom1="UPDATE employees"+
        "SET Salary = "+ empSalary +
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
    public void updateEmpHireDate(int empID, String empHireDate){
        String sqlcom1="UPDATE employees"+
        "SET HireDate = "+ empHireDate +
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
}
