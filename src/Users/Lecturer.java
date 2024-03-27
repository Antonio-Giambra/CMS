package Users;

import dbConnector.dbConnector;
import java.sql.SQLException;

public class Lecturer {

    private String name;
    private String username;
    private String password;
    private String role;

    //Default Lecturer constructor
    public Lecturer() {
        this.name = "Lecturer";
        this.username = "lecturer";
        this.password = "java";
        this.role = "professor";
    }

    //Method Getter for lecturer username
    public String getUsername() {
        return username;
    }

    //Method Getter for lecturer name
    public String getName() {
        return name;
    }

    //Method Getter for lecturer password
    public String getPassword() {
        return password;
    }
    //Method Getter for lecturer role
    public String getRole() {
        return role;
    }

    //Lecturer cosntructor with parameters name, username and password
    public Lecturer(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        System.out.println("Your Lecturer Account has been successfully created");
    }

    //Method Setter for lecturer name
    public void setName(String name) {
        this.name = name;
        System.out.println("Lecturer name has been successfully changed");
    }

    //Method Setter for lecturer username
    public void setUsername(String username) {
        this.username = username;
        System.out.println("Your username has been successfully changed");

    }

    //Method Setter for lecturer password
    public void setPassword(String password) {
        this.password = password;
        System.out.println("Your passsword has been successfully changed");

    }
    
    //Method Setter for lecturer role
    public void setRole(String role) {
        this.role = role;
        System.out.println("Lecturer name has been successfully changed");
    }

    //Getting lecturers report
    public void getReport(dbConnector db, String reportFormat) throws SQLException {
        //Will get a report for themselves
        System.out.println("Course Report will be generated...");
        db.getLecturerReport(reportFormat);
    }
}
