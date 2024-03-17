
package cms;

public class Administrator {
    private String name;
    private String username;
    private String password;
    
    public Administrator() {
        this.name = "Admin-support";
        this.username = "admin2";
        this.password = "java2";
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
            System.out.println("Your username has been successfully changed");
        }
    }

    public void setPassword(String password) {
        if(username.length() >= 8) {
            this.password = password;
            System.out.println("Your passsword has been successfully changed");
        }
    }
    
    public void addUser(){
        
    }
    public void modifyUser(){
        
    }
    public void deleteUser(){
        
    }
}
