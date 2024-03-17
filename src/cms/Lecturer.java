
package cms;

public class Lecturer {
    private String name;
    private String username;
    private String password;
    
    public Lecturer() {
        this.name = "Lecturer";
        this.username = "lecturer";
        this.password = "java";
    }
    public Lecturer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
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
    public void getReport(int reportType){
        //Will get a report for themselves
    }
}
