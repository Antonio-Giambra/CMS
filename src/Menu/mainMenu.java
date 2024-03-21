
package Menu;

import Users.Administrator;
import Users.Lecturer;
import Users.Office;
import cms.adminMenu;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class mainMenu {
    Administrator admin = new Administrator();
    public Office officeAccount;     
    public ArrayList<Lecturer> lecturers = new ArrayList<>();
    
    public void startMenu(){
        
        adminMenu adminmenu = new adminMenu();
        officeMenu office = new officeMenu();
        lecturerMenu lecturer = new lecturerMenu();
        
        boolean trigger = false;
        while(trigger == false) {
            System.out.println("Welcome to Content Management System \n\n Press 1 - to connect an Admin Account \n Press 2 - to connect an Office Account \n Press 3 - to connect a Lecturer Account\n Press 4 - to exit the system");
            String userConnection = getNextLine();
            switch(userConnection){
                case "1":
                    adminmenu.menu();
                    break;
                case "2":
                    office.start();
                    break;
                case "3":
                    lecturer.start();
                    break;
                case "4":
                    trigger = true;
                    System.out.println();
                    System.out.println("Thank you for using this system");
                    break;
                default:
                    break;
            }
        }
    }

    public String getNextLine() {
        
        String userSelection;
        Scanner sc = new Scanner(System.in);
        userSelection = sc.nextLine();
        return userSelection;
    }
 
}
