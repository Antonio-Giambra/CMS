
package cms;

import dbConnector.dbConnector;

public class Office extends dbConnector{
    private String name;
    private String username;
    private String password;
    
    public Office() {
        this.name = "Office";
        this.username = "office";
        this.password = "java";
    }
    
    public Office(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        System.out.println("Your Office Account has been successfully created");
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setName(String name) {
        this.name = name;
        System.out.println("Office Account name has been successfully changed");
    }
    public void setUsername(String username) {
        if(username.length() >= 4) {
            this.username = username;
            System.out.println("Your username has been successfully changed");
        }
    }

    public void setPassword(String password) {
        if(password.length() >= 8) {
            this.password = password;
            System.out.println("Your passsword has been successfully changed");
        }
    }
    
    //Getting all reports
    public void getReport(int reportType){
        switch(reportType){
            case 1:
                System.out.println("Course Report has been generated");
                break;
            case 2:
                System.out.println("Student Report has been generated");
                break;
            case 3:
                System.out.println("Lecturer Report has been generated");
                break;
            default:
                System.out.println("Sorry, you must enter a valid option");
        }
    }
}
