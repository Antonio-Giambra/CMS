package Users;

import dbConnector.dbConnector;
import java.sql.SQLException;

public class Office {

    private String name;
    private String username;
    private String password;

    //Default Office constructor
    public Office() {
        this.name = "Office";
        this.username = "office";
        this.password = "java";
    }

    //Office constructor with parameters for name, username and password
    public Office(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        System.out.println("Your Office Account has been successfully created");
    }

    //Method Getter for office name
    public String getName() {
        return name;
    }

    //Method Getter for office username
    public String getUsername() {
        return username;
    }

    //Method Getter for office password
    public String getPassword() {
        return password;
    }

    //Method Setter for office name
    public void setName(String name) {
        this.name = name;
        System.out.println("Office Account name has been successfully changed");

    }

    //Method Setter for office username
    public void setUsername(String username) {
        this.username = username;
        System.out.println("Your username has been successfully changed");
    }

    //Method Setter for office password
    public void setPassword(String password) {
        this.password = password;
        System.out.println("Your passsword has been successfully changed");

    }

    //Getting all reports
    public void getReport(dbConnector db, int reportType, String reportFormat) throws SQLException {
        switch (reportType) {
            case 1:
                System.out.println("Course Report will be generated...");
                db.getCourseReport(reportFormat);
                break;
            case 2:
                System.out.println("Course Report will be generated...");
                db.getStudentReport(reportFormat);
                break;
            case 3:
                System.out.println("Course Report will be generated...");
                db.getLecturerReport(reportFormat);
                break;
            default:
                System.out.println("Sorry, you must enter a valid option");
        }
    }
}
