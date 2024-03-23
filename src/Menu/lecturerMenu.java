package Menu;

import Users.Lecturer;
import java.util.Iterator;

/**
 *
 * @author anton
 */
public class lecturerMenu extends mainMenu {

    public boolean lecturerValidator(String username, String password) {
        //Iteratin our ArrayList
        Iterator<Lecturer> itr = lecturers.iterator();

        while (itr.hasNext()) {
            Lecturer lecturer = itr.next();
            //if lecturer username and password match with entry data it return true.
            if (lecturer.getUsername().equals(username) && lecturer.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }

    public Lecturer lecturerInfo(String username, String password) {
        //Iteratin our ArrayList
        Iterator<Lecturer> itr = lecturers.iterator();

        while (itr.hasNext()) {
            Lecturer lecturer = itr.next();
            //if lecturer username and password match with entry data it return true.
            if (lecturer.getUsername().equals(username) && lecturer.getPassword().equals(password)) {
                return lecturer;
            }

        }
        return null;
    }

    public void start() {
        //Creating triggers in order to break the while loops below
        boolean mainWhileTrigger = false;
        boolean secondWhileTrigger = false;
        while (mainWhileTrigger == false) {
            System.out.println();
            System.out.println("Please introduce your lecturer username with capital letter if needed.");
            //Variable username to compare office username
            String username = sc.nextLine();
            System.out.println();
            System.out.println("Please introduce your lecturer password with capital letter if needed.");
            //Variable password to compare office password
            String password = sc.nextLine();
            //Comparing data introduced by user in order to log in office account
            if (lecturerValidator(username, password)) {
                //Lecturer instance has been created in order to work with his/her data and processes
                Lecturer lecturerTransactor = lecturerInfo(username, password);
                while (secondWhileTrigger == false) {
                    System.out.println();
                    System.out.println("Welcome " + lecturerTransactor.getName() + "\n Press 1 - to generate a Lecturers Report \n Press 2 - to change your username \n Press 3 - to change your password \n Press 4 - to log out");
                    //String optionSelected has been created in order to store user entry
                    String optionSelected = sc.nextLine();
                    switch (optionSelected) {
                        case "1":
                            //Calling our DB to generate a course report
                            System.out.println();
                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                            switch (sc.nextLine()) {
                                case "1":
                                    lecturerTransactor.getReport("txt");
                                    break;
                                case "2":
                                    lecturerTransactor.getReport("csv");
                                    break;
                                case "3":
                                    lecturerTransactor.getReport("console");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case "2":
                            //Changing our username
                            System.out.println();
                            System.out.println("Please introduce your new username");
                            String lecturerNewUsername = sc.nextLine();
                            lecturerTransactor.setUsername(lecturerNewUsername);
                            break;
                        case "3":
                            //Changing our password
                            System.out.println();
                            System.out.println("Please introduce your new password");
                            String lecturerNewPassword = sc.nextLine();
                            lecturerTransactor.setPassword(lecturerNewPassword);
                            break;
                        case "4":
                            // Logging out
                            System.out.println("You have been loged out");
                            mainWhileTrigger = true;
                            secondWhileTrigger = true;
                            break;
                        default:
                            System.out.println("Sorry, you must enter a valid option");
                    }
                }
            } else {
                System.out.println();
                System.out.println("Sorry, username or password is not correct or invalid");
                mainWhileTrigger = true;
            }
        }
    }

}
