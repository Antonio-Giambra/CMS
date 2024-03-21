/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Users.Administrator;
import cms.adminMenu;
import java.util.Scanner;

/**
 *
 * @author anton
 */
public class mainMenu {
    Administrator admin = new Administrator();

    public void start(){
        boolean trigger = false;

        while(trigger == false) {
            System.out.println("Welcome to Content Management System \n\n Press 1 - to connect an Admin Account \n Press 2 - to connect an Office Account \n Press 3 - to connect a Lecturer Account\n Press 4 - to exit the system");
            String userConnection = getNextLine();
            switch(userConnection){
                case "1":
                    adminMenu adminmenu = new adminMenu();
                    adminmenu.menu();
                    break;
                case "2":
                    break;
                case "3":
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
