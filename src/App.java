import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        System.out.println("We will be adding the column to the Employee table");
        AddEmployee addEmp = new AddEmployee();
        addEmp.addingColumn();

        System.out.println("Here are employee reports!");
        System.out.println("Type which option to use the function");
        String op1="|Search|";
        String op2="|Update|";
        String op3="|Add Employee|";
        String op4="|Show Employees|";
        String op5="|Payroll|";
        String op6="|Exit|";

        System.out.println(op1+" "+op2+" "+op3+" "+op4+" "+op5+" "+ op6);
        Scanner myObj = new Scanner(System.in);
        String userResponse = myObj.nextLine();
        int userResNum;
        boolean finished=true;
        while(finished){
            if(userResponse.equalsIgnoreCase(op1)){

            /*this line will be setting up search class */
                Search searchEmp= new Search();
                boolean searchFinished= true;
                while(searchFinished){

                    System.out.println("Search: EmpID, EmpName, EmpEmail, EmpSalary, or EmpHireDate ?");
                    userResponse=myObj.nextLine();
                    if(userResponse.equalsIgnoreCase("EmpID")){
                        System.out.println("What is the ID? ");
                        userResNum=myObj.nextInt();
                        searchEmp.getEmpID(userResNum);
                    }

                    else if(userResponse.equalsIgnoreCase("EmpName")){
                        System.out.println("What is the First name? ");
                        String fNameIn=myObj.nextLine();
                        System.out.println("What is the Last name? ");
                        String LNameIn=myObj.nextLine();
                        searchEmp.getEmpName(fNameIn, LNameIn);
                    }
                    
                    else if(userResponse.equalsIgnoreCase("EmpEmail")){
                        System.out.println("What is the employee email? ");
                        userResponse=myObj.nextLine();
                        searchEmp.getEmpEmail(userResponse);
                    }
                    
                    else if(userResponse.equalsIgnoreCase("EmpSalary")){
                        System.out.println("What is the employee salary? ");
                        userResNum=myObj.nextInt();
                        searchEmp.getEmpSalary(userResNum);
                    }
                    
                    else if(userResponse.equalsIgnoreCase("EmpHireDate")){
                        System.out.println("What is the employee hire date? (Format: YYYY-MM-DD)");
                        userResponse=myObj.nextLine();
                        searchEmp.getEmpHireDate(userResponse);
                    }
                }
                

            }else if (userResponse.equalsIgnoreCase(op2)) {
                Updates updates = new Updates();
                boolean searchFinished = true;
                while (searchFinished) {
                    System.out.println("Update: EmpName, EmpEmail, EmpSalary, or EmpHireDate ?");
                    userResponse = myObj.nextLine();
                    if (userResponse.equalsIgnoreCase("EmpName")) {
                        System.out.println("what is the EmpID? ");
                        int empID = myObj.nextInt();
                        myObj.nextLine();
                        System.out.println("What is the new First Name? ");
                        String fNameInNew = myObj.nextLine();
                        System.out.println("What is the new Last Name?");
                        String lNameInNew = myObj.nextLine();
                        
                        updates.updateEmpName(empID, fNameInNew, lNameInNew);
                        
                    } else if (userResponse.equalsIgnoreCase("EmpEmail")) {
                        System.out.println("What is the EmpID? ");
                        int empID = myObj.nextInt();
                        myObj.nextLine();
                        System.out.println("Enter new email: ");
                        String newEmail = myObj.nextLine();
                        updates.updateEmpEmail(empID, newEmail);
                    } else if (userResponse.equalsIgnoreCase("EmpSalary")) {
                        System.out.println("What is the EmpID? ");
                        int empID = myObj.nextInt();
                        myObj.nextLine();
                        System.out.println("Enter new salary: ");
                        String newSalary = myObj.nextLine();
                        updates.updateEmpSalary(empID, newSalary);
                    } else if (userResponse.equalsIgnoreCase("EmpHireDate")) {
                        System.out.println("What is the EmpID? ");
                        int empID = myObj.nextInt();
                        myObj.nextLine();
                        System.out.println("Enter new hire date (Format: YYYY-MM-DD): ");
                        String newHireDate = myObj.nextLine();
                        updates.updateEmpHireDate(empID, newHireDate);
                    } else {
                        System.out.println("Invalid option. Please choose from EmpSSN, EmpName, EmpEmail, EmpSalary, or EmpHireDate.");
                    }
                    System.out.println("Do you want to update more information? (yes/no)");
                    String continueUpdate = myObj.nextLine();
                    if (!continueUpdate.equalsIgnoreCase("yes")) {
                        searchFinished = false;
                    }
                }
                
            }else if (userResponse.equalsIgnoreCase(op3)) {
                
            }else if (userResponse.equalsIgnoreCase(op4)) {
                
            }else if (userResponse.equalsIgnoreCase(op5)) {
                
            }else if (userResponse.equalsIgnoreCase(op6)) {
                
            } else {
                System.out.println("Please choose one of the options!");
                System.out.println(op1 + " " + op2 + " " + op3 + " " + op4 + " " + op5 + " " + op6);
                userResponse = myObj.nextLine();
                continue;
            }

        

        }myObj.close();
    }
}
