
package cms;

import dbConnector.dbConnector;

public class Lecturer extends dbConnector{
    private String name;
    private String username;
    private String password;
    
    public Lecturer() {
        this.name = "Lecturer";
        this.username = "lecturer";
        this.password = "java";
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    public Lecturer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        System.out.println("Your Lecturer Account has been successfully created");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Lecturer name has been successfully changed");
    }

    public void setUsername(String username) {
        if(username.length() >= 4) {
            this.username = username;
            System.out.println("Your username has been successfully changed");
        }
    }

    public void setPassword(String password) {
        if(username.length() >= 8) {
            this.password = password;
            System.out.println("Your passsword has been successfully changed");
        }
    }
    
    //Getting all reports
    public void getReport(){
        //Will get a report for themselves
        System.out.println("Lecturer Report has been generated");
    }
}
