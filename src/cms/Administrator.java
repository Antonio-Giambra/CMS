
package cms;

import dbConnector.dbConnector;

public class Administrator extends dbConnector{
    private String name;
    private String username;
    private String password;
    
    public Administrator() {
        this.name = "Administrator";
        this.username = "admin";
        this.password = "java";
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
    public Administrator(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public void setName(String name) {
        if(name.length() > 3){
            this.name = name;
        }
    }

    public void setUsername(String username) {
        if(username.length() >= 4) {
            this.username = username;
            System.out.println();
            System.out.println("Your username has been successfully changed");
        }else {
            System.out.println("Sorry, your new username must be longer than 4 letters");
        }
    }

    public void setPassword(String password) {
        if(password.length() >= 8) {
            this.password = password;
            System.out.println();
            System.out.println("Your passsword has been successfully changed");
        } else {
            System.out.println("Sorry, your new password must be longer than 8 letters");
        }
    }
}
