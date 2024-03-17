
package cms;

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
        switch(reportType){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Sorry, you must enter a valid option");
        }
    }
}
