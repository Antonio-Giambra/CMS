package Menu;

import Users.Lecturer;
import Users.Office;
import java.util.Iterator;

public class adminMenu extends mainMenu {
    
    public void modifyLecturer(String username, String data, int operation) {
        //Iteratin our ArrayList
        Iterator<Lecturer> itr = lecturers.iterator();

        while (itr.hasNext()) {
            Lecturer lecturer = itr.next();
            //if lecturer username and password match with entry data it return true.
            if (lecturer.getUsername().equals(username)) {
                switch (operation) {
                    case 1:
                        lecturer.setName(data);
                        break;
                    case 2:
                        lecturer.setUsername(data);
                        break;
                    case 3:
                        lecturer.setPassword(data);
                        break;
                    case 4:
                        System.out.println("Lecturer " + lecturer.getName() + " has been deleted");
                        itr.remove();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void start() {
        //Creating triggers in order to break the while loops below
        boolean mainWhileTrigger = false;
        boolean secondWhileTrigger = false;
        while (mainWhileTrigger == false) {
            System.out.println();
            System.out.println("Please introduce your admin username with capital letter if needed.");
            //Variable username to compare administrator username
            String username = getNextLine();
            System.out.println();
            System.out.println("Please introduce your admin password with capital letter if needed.");
            //Variable password to compare administrator password
            String password = getNextLine();
            //Comparing data introduced by user in order to log in admin account
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                while (secondWhileTrigger == false) {
                    System.out.println();
                    System.out.println("Welcome " + admin.getName() + "\n Press 1 - to add user \n Press 2 - to modify user \n Press 3 - to delete user \n Press 4 - to change your username \n Press 5 - to change your password \n Press 6 - to log out");

                    //String optionSelected has been created in order to store user entry
                    String optionSelected = getNextLine();
                    switch (optionSelected) {
                        case "1":
                            System.out.println();
                            System.out.println(" Press 1 - to add an office user \n Press 2 - to add lecturer user \n Press any other button to cancel operation");
                            String dataEntry = getNextLine();
                            if (dataEntry.equals("1")) {
                                if (officeAccount == null) {
                                    System.out.println();
                                    System.out.println("Please, introduce an username for the office account, must be longer than 4 letters");
                                    String officeUsername = getNextLine();
                                    System.out.println("Please, introduce a password for the office account, must be longer than 8 characteres");
                                    String officePassword = getNextLine();
                                    officeAccount = new Office("office", officeUsername, officePassword);
                                } else {
                                    System.out.println("Sorry, there is an Office Account already created");
                                }
                            } else if (dataEntry.equals("2")) {
                                System.out.println();
                                System.out.println("Please, introduce the name of the lecturer, must be longer than 4 letters");
                                String lecturerName = getNextLine();
                                System.out.println();
                                System.out.println("Please, introduce an username for the lecturer account, must be longer than 4 letters");
                                String lecturerUsername = getNextLine();
                                System.out.println("Please, introduce a password for the lecturer account, must be longer than 8 characteres");
                                String lecturerPassword = getNextLine();
                                Lecturer lecturer = new Lecturer(lecturerName, lecturerUsername, lecturerPassword);
                                lecturers.add(lecturer);
                            } else {
                                System.out.println();
                                System.out.println("Cancelling Operation!!");
                            }
                            //Calling our DB and adding a new user
                            break;
                        //-------------------------------------------Modification section------------------------------------------------------//
                        case "2":
                            System.out.println();
                            System.out.println("Press 1 - to modify an office user \n Press 2 - to modify lecturer user \n Press any button to cancel operation");
                            String userModify = getNextLine();
                            //----------------------------Modifying office user--------------------------------//
                            if (userModify.equals("1")) {
                                if (officeAccount != null) {
                                    System.out.println();
                                    System.out.println("Press 1 - to modify an office name \n Press 2 - to modify an office username \n Press 3 - to modify office password \n Press any other button to cancelling operation");
                                    switch (getNextLine()) {
                                        case "1":
                                            System.out.println();
                                            System.out.println("Please, introduce a name for the office account, must be longer than 4 letters");
                                            String officeName = getNextLine();
                                            officeAccount.setName(officeName);
                                            break;
                                        case "2":
                                            System.out.println();
                                            System.out.println("Please, introduce an username for the office account, must be longer than 4 letters");
                                            String officeUsername = getNextLine();
                                            officeAccount.setUsername(officeUsername);
                                            break;
                                        case "3":
                                            System.out.println();
                                            System.out.println("Please, introduce a password for the office account, must be longer than 8 characteres");
                                            String officePassword = getNextLine();
                                            officeAccount.setPassword(officePassword);
                                            break;
                                        default:
                                            System.out.println("Cancelling Operation!!");
                                            break;
                                    }
                                } else {
                                    System.out.println("Sorry, there is not an Office Account already created");
                                }
                                //------------------------------modifying lecturer user-----------------------------------//   
                            } else if (userModify.equals("2")) {
                                if (!(lecturers.isEmpty())) {
                                    System.out.println();
                                    System.out.println("Press 1 - to modify an lecturer name \n Press 2 - to modify an lecturer username \n Press 3 - to modify lecturer password \n Press any other button to cancelling operation");
                                    String lecturerUsername;
                                    switch (getNextLine()) {
                                        case "1":
                                            System.out.println();
                                            System.out.println("Please, introduce lecturer username");
                                            lecturerUsername = getNextLine();
                                            System.out.println();
                                            System.out.println("Please, introduce a name for the lecturer " + lecturerUsername + " account, must be longer than 4 letters");
                                            String lecturerName = getNextLine();
                                            modifyLecturer(lecturerUsername, lecturerName, 1);
                                            break;
                                        case "2":
                                            System.out.println();
                                            System.out.println("Please, introduce lecturer username");
                                            lecturerUsername = getNextLine();
                                            System.out.println();
                                            System.out.println("Please, introduce a new username for the lecturer " + lecturerUsername + " account, must be longer than 4 letters");
                                            String lecturerNewUsername = getNextLine();
                                            modifyLecturer(lecturerUsername, lecturerNewUsername, 2);
                                            break;
                                        case "3":
                                            System.out.println();
                                            System.out.println("Please, introduce lecturer username");
                                            lecturerUsername = getNextLine();
                                            System.out.println();
                                            System.out.println("Please, introduce a new username for the lecturer " + lecturerUsername + " account, must be longer than 4 letters");
                                            String lecturerNewPassword = getNextLine();
                                            modifyLecturer(lecturerUsername, lecturerNewPassword, 3);
                                            break;
                                        default:
                                            System.out.println("Cancelling Operation!!");
                                            break;
                                    }
                                } else {
                                    System.out.println();
                                    System.out.println("Sorry, there is not any lecturers registered on the system");
                                }
                            } else {
                                System.out.println();
                                System.out.println("Cancelling Operation");
                            }
                            //Calling our DB and modify an user
                            break;
                        case "3":
                            //Calling our DB and delete an user
                            System.out.println();
                            System.out.println("Press 1 - to delete the office user \n Press 2 - to delete lecturer user \n Press any button to cancel operation");
                            String deleteUser = getNextLine();
                            switch (deleteUser) {
                                case "1":
                                    if (officeAccount != null) {
                                        officeAccount = null;
                                        System.out.println();
                                        System.out.println("office Account has been deleted");
                                    } else {
                                        System.out.println();
                                        System.out.println("Sorry, there is no office Account already created");
                                    }
                                    break;
                                case "2":
                                    System.out.println();
                                    System.out.println("Please, introduce lecturer username in order to delete it");
                                    String lecturerUsername = getNextLine();
                                    modifyLecturer(lecturerUsername, "", 4);
                            }
                            break;
                        case "4":
                            //Changing our username
                            System.out.println();
                            System.out.println("Please introduce your new username");
                            String adminUsername = getNextLine();
                            admin.setUsername(adminUsername);
                            break;
                        case "5":
                            //Changing our password
                            System.out.println();
                            System.out.println("Please introduce your new password");
                            String adminPassword = getNextLine();
                            admin.setPassword(adminPassword);
                            break;
                        case "6":
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