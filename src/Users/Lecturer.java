package Users;

import dbConnector.dbConnector;

public class Lecturer {

    private String name;
    private String username;
    private String password;

    //Default Lecturer constructor
    public Lecturer() {
        this.name = "Lecturer";
        this.username = "lecturer";
        this.password = "java";
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

    //Lecturer cosntructor with parameters name, username and password
    public Lecturer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        System.out.println("Your Lecturer Account has been successfully created");
    }

    //Method Setter for lecturer name
    public void setName(String name) {
        this.name = name;
        System.out.println("Lecturer name has been successfully changed");
    }

    //Method Setter for lecturer username
    public void setUsername(String username) {
        //it must be longer than 3 letters
        if (username.length() >= 4) {
            this.username = username;
            System.out.println("Your username has been successfully changed");
        }
    }

    //Method Setter for lecturer password
    public void setPassword(String password) {
        //it must be longer than 7 letters
        if (username.length() >= 8) {
            this.password = password;
            System.out.println("Your passsword has been successfully changed");
        }
    }

    //Getting lecturers report
    public void getReport(String reportFormat) {
        //Will get a report for themselves
        dbConnector db3 = new dbConnector();
        System.out.println("Course Report will be generated...");
        db3.getLecturerReport(reportFormat);
    }
}
