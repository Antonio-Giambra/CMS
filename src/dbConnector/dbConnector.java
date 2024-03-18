
package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class dbConnector {
    // Database Url
    private final String DB_URL = "jdbc:mysql://localhost";
    // Database Username
    private final String USER = "root";
    //Database Password
    private final String PASSWORD = "Tuesday06062023";
    
    //Database Creation Method
    public void createDB(){
        try {
            // Establish connection within database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS cms;");
            System.out.println("Database sucessfully created;");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    public void createTable(String tableName, ArrayList[] rows) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE cms;");
            stmt.execute("CREATE TABLE " + tableName + " (accountNum INT, balance INT, name VARCHAR(30));");
            System.out.println("Table sucessfully created");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public void getCourseReport(String outputType){
        try{
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getStudentReport(String outputType){
        
    }
    public void getLecturerReport(String outputType){
        
    }
}
