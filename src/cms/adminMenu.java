
package cms;

import java.util.Scanner;

public class adminMenu {
    
    public void menu(){
        try{
            //Registering admin account
            Administrator admin = new Administrator();
            //Using Scanner in order to get all information from the user
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Welcome to Content Management System \n\nPlease introduce your admin username with capital letter if needed:");
            //Variable username to compare administrator username
            String username = sc.nextLine();
            System.out.println();
            System.out.println("Please introduce your password with capital letter if needed:");
            //Variable password to compare administrator password
            String password = sc.nextLine();
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }  
    }
}
