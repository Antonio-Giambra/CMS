package Menu;

import Users.Administrator;
import Users.Lecturer;
import Users.Office;
import dbConnector.dbConnector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class mainMenu {

    //Instancing an admin user in onder to start the process
    Administrator admin = new Administrator();
    //Instancing an Office class for future office account needed
    public static Office officeAccount;
    //ArrayList for lecturers to store lecturers accounts
    public static ArrayList<Lecturer> lecturers = new ArrayList<>();
    //Creating the scanner for the whole menu an its sub-classes
    public static Scanner sc = new Scanner(System.in);
    /*
        This regular expression ensures that the string:
        - Starts with a non-whitespace character (\\S) at the beginning (\\A).
        - Has at least two non-whitespace characters (\\S{2,}) following the initial character.
        - Ends with a non-whitespace character (\\S) at the end (\\z).
        */
    public static String regex4CharLength = "\\A\\S(?!\\s)\\S{2,}\\S\\z";
        
        /*This regular expression ensures that the string:
        - Starts with a non-whitespace character.
        - Has at least six characters following the initial non-whitespace character.
        - Ends with a non-whitespace character.
        - The total length of the string is at least 8 characters.
        */
    public static String regex8CharLength = "\\A\\S(?!\\s)\\S{6,}\\S\\z";

    /**
     * Creating dbConnector in order to open a connection with the database
     */
    public static dbConnector db = new dbConnector();

    //Starting Menu
    public void startMenu() throws SQLException {

        //Creating instances of the three diferent menus
        adminMenu adminmenu = new adminMenu();
        officeMenu office = new officeMenu();
        lecturerMenu lecturer = new lecturerMenu();

        //trigger to break teh while loop when is not needed anymore
        boolean trigger = false;

        //First part of menu
        while (trigger == false) {

            System.out.println("Welcome to Content Management System \n\n Press 1 - to connect an Admin Account \n Press 2 - to connect an Office Account \n Press 3 - to connect a Lecturer Account\n Press 4 - to exit the system");
            //Storing what user entered in the console
            String userConnection = sc.nextLine();
            switch (userConnection) {
                case "1":
                    //calling start method of adminMenu class
                    adminmenu.start();
                    break;
                case "2":
                    //calling start method of officeMenu class
                    office.start();
                    break;
                case "3":
                    //calling start method of lecturerMenu class
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
}
