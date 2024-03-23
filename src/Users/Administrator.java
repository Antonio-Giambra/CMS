
package Users;

//Importing our dbConnector class which load all data from DB
import dbConnector.dbConnector;

public class Administrator extends dbConnector{
    
    private String name;
    private String username;
    private String password;
    
    //Default Admin constructor
    public Administrator() {
        this.name = "Administrator";
        this.username = "admin";
        this.password = "java";
    }
    //Method Getter for admin name
    public String getName() {
        return name;
    }
    //Method Getter for admin username
    public String getUsername() {
        return username;
    }
    //Method Getter for admin password
    public String getPassword() {
        return password;
    }
    //Admin constructor with parameters for name, username and password
    public Administrator(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    //Method Setter for admin name
    public void setName(String name) {
        //it must be longer than 3 letters
        if(name.length() > 3){
            this.name = name;
        }
    }
    //Method Setter for admin username
    public void setUsername(String username) {
        //it must be longer than 3 letters
        if(username.length() >= 4) {
            this.username = username;
            System.out.println();
            System.out.println("Your username has been successfully changed");
        }else {
            System.out.println("Sorry, your new username must be longer than 4 letters");
        }
    }
    //Method Setter for admin password
    public void setPassword(String password) {
        //it must be longer than 7 letters
        if(password.length() >= 8) {
            this.password = password;
            System.out.println();
            System.out.println("Your passsword has been successfully changed");
        } else {
            System.out.println("Sorry, your new password must be longer than 8 letters");
        }
    }
}

