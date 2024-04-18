import java.sql.*;
public class Change {

    public void changeTable(String column ) {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "";
        String name= column;
        System.out.println("your title "+ name + " is getting added into sql command");

        int i=1;
        String sqlcommand2 = "ALTER TABLE employees "+
            "ADD " + name +" int ;";

        

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Statement myStmt = myConn.createStatement();
            //myStmt.executeQuery(sqlcommand2);
            int myRS = myStmt.executeUpdate(sqlcommand2);
            //System.out.println(myRS);
           
           if(myRS == 0){
                System.out.println("Table has added new column");
            }else{
                System.out.println("Error occurped");
            }
            while (i<16) {
                
                String sqlcommand3 = "UPDATE employees "+
                "SET "+name+" = "+i+" "+
                "WHERE empid = "+ i+";";
                myStmt.executeUpdate(sqlcommand3);
                i++;
            }
        
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }

    }

}
