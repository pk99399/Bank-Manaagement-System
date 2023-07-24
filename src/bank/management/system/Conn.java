
package bank.management.system;


/**         JDBC Connectivity steps:--
 *             1. Register the Driver              //here Driver is Auto Registered bcz we import a package mysqlConnector-j.jar
 *             2. Create Connection
 *             3. Create Statement                 //Writing is done in signup pages
 *             4.Execute Query                      //we use the object of Connection and Statement class for executing the query;
 *             5.Close Connection  
 * 
 *       In this Connection Class we also implements Exception Handling because 
 *         Mysql is External entity , so there is chances of getting Error at Run time (for catching exception at run time we use Exception Handling)
*/

import java.sql.*;


public class Conn {
    
    Connection c;                                              //  By using the obj of this Class we make/create Connection  
    Statement s;
    
    
    public Conn(){
    
        try{
        
           // Class.forName(com.mysql.cj.jdbc.Driver);     //Resistering the Driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","codepk_1");      //Creating Connection //bydefaut localhost:3306(no need to mension for local machine)
            s = c.createStatement();
           }
        
        catch(Exception e){
        
            System.out.println(e);
        
        }
        
    }

    
    public static void main(String args[]) {
        
    }
}
