/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public void start(){
        
        adminMenu adminmenu = new adminMenu();
        officeMenu office = new officeMenu();
        
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
