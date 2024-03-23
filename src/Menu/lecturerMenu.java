package Menu;

import Users.Lecturer;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author Antonio
 */
public class lecturerMenu extends mainMenu {

    public void start() throws SQLException {
        //Creating triggers in order to break the while loops below
        boolean mainWhileTrigger = false;
        boolean secondWhileTrigger = false;

        //Starting lecturer's menu
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
                //Lecturer lecturerTransactor instance has been created in order to work with his/her data and processes
                Lecturer lecturerTransactor = lecturerInfo(username, password);
                while (secondWhileTrigger == false) {
                    System.out.println();
                    System.out.println("Welcome " + lecturerTransactor.getName() + "\n Press 1 - to generate a Lecturers Report \n Press 2 - to change your username \n Press 3 - to change your password \n Press 4 - to log out");
                    //String optionSelected has been created in order to store user entry
                    String optionSelected = sc.nextLine();
                    switch (optionSelected) {
                        case "1":
                            //Calling lecturer getReport method in order to obtain the report
                            System.out.println();
                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                            switch (sc.nextLine()) {
                                case "1":
                                    //Look for obtain report in txt format
                                    lecturerTransactor.getReport(db, "txt");
                                    break;
                                case "2":
                                    //Look for obtain report in csv format
                                    lecturerTransactor.getReport(db, "csv");
                                    break;
                                case "3":
                                    //Look for obtain report in console format
                                    lecturerTransactor.getReport(db, "console");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case "2":
                            //Changing lecturer username
                            System.out.println();
                            System.out.println("Please introduce your new username, it needs to be longer than 3 letters");
                            String lecturerNewUsername = sc.nextLine();
                            if (lecturerNewUsername.length() >= 4) {
                                lecturerTransactor.setUsername(lecturerNewUsername);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the username does not comply with requirements");
                            }
                            break;
                        case "3":
                            //Changing lecturer password
                            System.out.println();
                            System.out.println("Please introduce your new password, it needs to be longer than 7 letters");
                            String lecturerNewPassword = sc.nextLine();
                            if (lecturerNewPassword.length() >= 8) {
                                lecturerTransactor.setPassword(lecturerNewPassword);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the password does not comply with requirements");
                            }
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

    //lecturerValidator Method to check if lecturer account concur with lecturer account inside the ArrayList.
    //Method return True or False
    //Param lecturer username, lecturer password
    public boolean lecturerValidator(String username, String password) {
        try {
            //Iteratin our ArrayList
            Iterator<Lecturer> itr = lecturers.iterator();

            while (itr.hasNext()) {
                Lecturer lecturer = itr.next();
                //if lecturer username and password match with entry data it return true.
                if (lecturer.getUsername().equals(username) && lecturer.getPassword().equals(password)) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //lecturerInfo Method to check if the lecturer account matches the lecturer account within the ArrayList to get the properties of the lecturer user.
    //Method return the lecturer selected or null type
    //Param lecturer username, lecturer password
    public Lecturer lecturerInfo(String username, String password) {
        try {
            //Iteratin our ArrayList
            Iterator<Lecturer> itr = lecturers.iterator();
            //trigger created if an account does not exist
            boolean lecturerFound = false;
            while (itr.hasNext()) {
                Lecturer lecturer = itr.next();
                //if lecturer username and password match with entry data it return true.
                if (lecturer.getUsername().equals(username) && lecturer.getPassword().equals(password)) {
                    lecturerFound = true;
                    return lecturer;
                } else {
                    System.out.println();
                    System.out.println("Sorry, lecturer invalid or does not exist.");
                }

            }
            if (!lecturerFound) {
                // Print message if lecturer with provided username is not found
                System.out.println("Sorry, username invalid or does not exist");
            }
            //Prints the stack trace if an error occurs
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
