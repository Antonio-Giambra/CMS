package Users;

import dbConnector.dbConnector;

public class Office {
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
    public void getReport(int reportType, String reportFormat){
        switch(reportType){
            case 1:
                dbConnector db = new dbConnector();
                System.out.println("Course Report will be generated...");
                db.getCourseReport(reportFormat);
                break;
            case 2:
                dbConnector db2 = new dbConnector();
                System.out.println("Course Report will be generated...");
                db2.getStudentReport(reportFormat);
                break;
            case 3:
                dbConnector db3 = new dbConnector();
                System.out.println("Course Report will be generated...");
                db3.getLecturerReport(reportFormat);
                break;
            default:
                System.out.println("Sorry, you must enter a valid option");
        }
    }
}
