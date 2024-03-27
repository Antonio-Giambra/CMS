package Menu;

import static Menu.mainMenu.lecturers;
import static Menu.mainMenu.officeAccount;
import static Menu.mainMenu.sc;
import Users.Lecturer;
import Users.Office;
import java.util.Iterator;

public class adminMenu extends mainMenu {

    //Starting Admin Menu
    public void start() {
        //Creating triggers in order to break the while loops below
        boolean mainWhileTrigger = false;
        boolean secondWhileTrigger = false;

        //Starting adminMenu
        while (mainWhileTrigger == false) {
            System.out.println();
            System.out.println("Please introduce your admin username with capital letter if needed.");
            //Variable username to compare administrator username
            String username = sc.nextLine();
            System.out.println();
            System.out.println("Please introduce your admin password with capital letter if needed.");
            //Variable password to compare administrator password
            String password = sc.nextLine();
            //Comparing data introduced by user in order to log in admin account
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                while (secondWhileTrigger == false) {
                    System.out.println();
                    System.out.println("Welcome " + admin.getName() + "\n Press 1 - to add user \n Press 2 - to modify user \n Press 3 - to delete user \n Press 4 - to change your username \n Press 5 - to change your password \n Press 6 - to log out");

                    //String optionSelected has been created in order to store user entry
                    String optionSelected = sc.nextLine();
                    switch (optionSelected) {
                        case "1":
                            //ACCOUNT CREATION SECTION
                            System.out.println();
                            System.out.println(" Press 1 - to add an office user \n Press 2 - to add lecturer user \n Press any other button to cancel operation");
                            String dataEntry = sc.nextLine();
                            //Calling createAccount Method
                            createAccount(dataEntry);
                            break;
                        //-------------------------------------------Modification section------------------------------------------------------//
                        case "2":
                            //MODIFICATION SECTION
                            System.out.println();
                            System.out.println("Press 1 - to modify an office user \n Press 2 - to modify lecturer user \n Press any button to cancel operation");
                            String userToModify = sc.nextLine();
                            //Calling modifierUserSection Method
                            userSelectedToModify(userToModify);
                            break;
                        case "3":
                            //DELETING SECTION
                            //Calling deleteUser Method in order delete an user
                            System.out.println();
                            System.out.println("Press 1 - to delete the office user \n Press 2 - to delete lecturer user \n Press any button to cancel operation");
                            String userToDelete = sc.nextLine();
                            //Calling deleteUser Method
                            deleteUser(userToDelete);
                            break;
                        case "4":
                            //Changing our username
                            System.out.println();
                            System.out.println("Please introduce your new username, it needs to be longer than 3 letters");
                            String adminNewUsername = sc.nextLine();
                            if (adminNewUsername.length() >= 4) {
                                admin.setUsername(adminNewUsername);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the username does not comply with requirements");
                            }
                            break;
                        case "5":
                            //Changing our password
                            System.out.println();
                            System.out.println("Please introduce your new password, it needs to be longer than 8 letters");
                            String adminNewPassword = sc.nextLine();
                            if (adminNewPassword.length() >= 8) {
                                admin.setPassword(adminNewPassword);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the password does not comply with requirements");
                            }
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

    //Method created in order to create either office account or lecturers account
    //Param office or lecturer ("1" or "2")
    public void createAccount(String dataEntry) {
        switch (dataEntry) {
            case "1":
                //Creating Office account
                //If officeAccount has not been created yet, then it can be created.
                if (officeAccount == null) {
                    System.out.println();
                    System.out.println("Please, introduce a name for the office account, must be equal or longer than 4 letters");
                    String officeName = sc.nextLine();
                    System.out.println();
                    System.out.println("Please, introduce an username for the office account, must be equal or longer than 4 letters");
                    String officeUsername = sc.nextLine();
                    System.out.println("Please, introduce a password for the office account, must be equal or longer than 8 characteres");
                    String officePassword = sc.nextLine();

                    //validating all the entried data
                    if (createAccountValidator(officeName, officeUsername, officePassword)) {
                        //if data is correct, office account can be created
                        officeAccount = new Office(officeName, officeUsername, officePassword);
                    }
                    break;
                } else {
                    System.out.println("Sorry, there is an Office Account already created");
                }
                break;
            case "2":
                //Creating lecturer account
                System.out.println();
                System.out.println("Please, introduce the name of the lecturer, must be equal or longer than 4 letters");
                //Storing lecturer name
                String lecturerName = sc.nextLine();
                System.out.println();
                System.out.println("Please, introduce an username for the lecturer account, must be equal or longer than 4 letters");
                //storing lecturer username
                String lecturerUsername = sc.nextLine();
                System.out.println("Please, introduce a password for the lecturer account, must be equal or longer than 8 characteres");
                //Storing lecturer password
                String lecturerPassword = sc.nextLine();
                if (createAccountValidator(lecturerName, lecturerUsername, lecturerPassword)) {
                    //instancing new lecturer if data is correct
                    Lecturer lecturer = new Lecturer(lecturerName, lecturerUsername, lecturerPassword);
                    //adding the lecturer to ArrayList
                    lecturers.add(lecturer);
                }
                break;
            default:
                System.out.println();
                System.out.println("Cancelling Operation!!");
                break;
        }
    }

    //Method to modify office account or lecturers accounts
    //Param office or lecturer ("1" or "2")
    public void userSelectedToModify(String userToModify) {
        switch (userToModify) {
            case "1":
                //Checking if officeAccount exists. Otherwise we are not able to modify it
                if (officeAccount != null) {
                    System.out.println();
                    System.out.println("Press 1 - to modify an office name \n Press 2 - to modify an office username \n Press 3 - to modify office password \n Press any other button to cancelling operation");
                    switch (sc.nextLine()) {
                        case "1":
                            //Modifying Office name
                            System.out.println();
                            System.out.println("Please, introduce a name for the office account, must be equal or longer than 4 letters");
                            String officeNewName = sc.nextLine();
                            if (officeNewName.length() >= 4) {
                                //Calling office class setter
                                officeAccount.setName(officeNewName);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the name does not comply with requirements");
                            }
                            break;
                        case "2":
                            //Modifying Office username
                            System.out.println();
                            System.out.println("Please, introduce an username for the office account, must be equal or longer than 4 letters");
                            String officeNewUsername = sc.nextLine();
                            if (officeNewUsername.length() >= 4) {
                                //Calling office class setter
                                officeAccount.setUsername(officeNewUsername);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the username does not comply with requirements");
                            }
                            break;
                        case "3":
                            //Modifying Office Password    
                            System.out.println();
                            System.out.println("Please, introduce a password for the office account, must be equal or longer than 8 characteres");
                            String officeNewPassword = sc.nextLine();
                            if (officeNewPassword.length() >= 8) {
                                //Calling office class setter
                                officeAccount.setPassword(officeNewPassword);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the password does not comply with requirements");
                            }
                            break;
                        default:
                            System.out.println("Cancelling Operation!!");
                            break;
                    }
                } else {
                    System.out.println("Sorry, there is not an Office Account already created");
                }
                break;
            case "2":
                //Checking if arrayList is not empty, otherwise we are not able to modify lecturers
                if (!(lecturers.isEmpty())) {
                    System.out.println();
                    System.out.println("Press 1 - to modify an lecturer name \n Press 2 - to modify an lecturer username \n Press 3 - to modify lecturer password \n Press any other button to cancelling operation");
                    //lecturerUsername has been created to handle all choices within switch conditional
                    String lecturerUsername;
                    switch (sc.nextLine()) {
                        case "1":
                            //Modifying Lecturer name
                            System.out.println();
                            System.out.println("Please, introduce lecturer username");
                            lecturerUsername = sc.nextLine();
                            System.out.println();
                            System.out.println("Please, introduce a name for the lecturer " + lecturerUsername + " account, must be equal or longer than 4 letters");
                            String lecturerNewName = sc.nextLine();
                            //Calling modifyLecturer Method to modify lecturer name
                            if (lecturerNewName.length() >= 4) {
                                modifyLecturer(lecturerUsername, lecturerNewName, 1);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the name does not comply with requirements");
                            }
                            break;
                        case "2":
                            //Modifying Lecturer username
                            System.out.println();
                            System.out.println("Please, introduce lecturer username");
                            lecturerUsername = sc.nextLine();
                            System.out.println();
                            System.out.println("Please, introduce a new username for the lecturer " + lecturerUsername + " account, must be equal or longer than 4 letters");
                            String lecturerNewUsername = sc.nextLine();
                            if (lecturerNewUsername.length() >= 4) {
                                //Calling modifyLecturer Method to modify lecturer username
                                modifyLecturer(lecturerUsername, lecturerNewUsername, 2);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the username does not comply with requirements");
                            }
                            break;
                        case "3":
                            //Modifying Lecturer password
                            System.out.println();
                            System.out.println("Please, introduce lecturer username");
                            lecturerUsername = sc.nextLine();
                            System.out.println();
                            System.out.println("Please, introduce a new password for the lecturer " + lecturerUsername + " account, must be equal or longer than 8 letters");
                            String lecturerNewPassword = sc.nextLine();
                            if (lecturerNewPassword.length() >= 8) {
                                //Calling modifyLecturer Method to modify lecturer password
                                modifyLecturer(lecturerUsername, lecturerNewPassword, 3);
                            } else {
                                System.out.println();
                                System.out.println("Sorry, the password does not comply with requirements");
                            }
                            break;
                        default:
                            System.out.println("Cancelling Operation!!");
                            break;
                    }
                } else {
                    System.out.println();
                    System.out.println("Sorry, there is not any lecturers registered on the system");
                }
                break;
            default:
                System.out.println();
                System.out.println("Cancelling Operation");
                break;
        }
    }

    //Method to delete office  or lecturers accounts.
    //Param office or lecturer ("1" or "2")
    public void deleteUser(String user) {
        switch (user) {
            case "1":
                //Checking if officeAccount exists
                if (officeAccount != null) {
                    //Deleting officeAccount
                    officeAccount = null;
                    System.out.println();
                    System.out.println("office Account has been deleted");
                } else {
                    System.out.println();
                    System.out.println("Sorry, there is no office Account already created");
                }
                break;
            case "2":
                //Asking to user to introduce lecturer username in order to delete it
                System.out.println();
                System.out.println("Please, introduce lecturer username in order to delete it");
                String lecturerUsername = sc.nextLine();
                //Calling modifyLecturer Method giving lecturer username, no data and operation 4 for deleting
                modifyLecturer(lecturerUsername, "", 4);
                break;
            default:
                break;
        }
    }

    //Method to validate office or lecturers accounts which will be created.
    //Param office or lecturer name, username and password
    public boolean createAccountValidator(String name, String username, String password) {
        //Creating boolean variables in order to handle validator
        boolean nameValidator;
        boolean usernameValidator;
        boolean passwordValidator;

        //name must be longer than 3 letters
        if (name.length() >= 4) {
            nameValidator = true;
        } else {
            nameValidator = false;
        }
        //username must be longer than 3 letters
        if (username.length() >= 4) {
            usernameValidator = true;
        } else {
            usernameValidator = false;
        }
        //password must be longer than 7 letters
        if (password.length() >= 8) {
            passwordValidator = true;
        } else {
            passwordValidator = false;
        }

        //Return true when all validators are true
        if (nameValidator == true && usernameValidator == true && passwordValidator == true) {
            return true;
        }
        System.out.println();
        System.out.println("Sorry, the account does not comply with requirements. Therefore It has not been created");
        return false;
    }

    //Method Lecturer modifyier to change lecturer name, username or password. Also can delete the lecturer account
    //Param lecturer username, data to be implemented and operation choice
    public void modifyLecturer(String username, String data, int operation) {
        //Iteratin our ArrayList
        Iterator<Lecturer> itr = lecturers.iterator();
        //trigger created if an account does not exist
        boolean lecturerFound = false;

        while (itr.hasNext()) {
            Lecturer lecturer = itr.next();
            //if lecturer username and password match with entry data it return true.
            if (lecturer.getUsername().equals(username)) {
                lecturerFound = true;
                switch (operation) {
                    case 1:
                        //Changing lecturer name
                        lecturer.setName(data);
                        break;
                    case 2:
                        //Changing lecturer username
                        lecturer.setUsername(data);
                        break;
                    case 3:
                        //Changing lecturer password
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
        //If Lecturer is not in the list, a helpful message will show up
        if (!lecturerFound) {
            // Print message if lecturer with provided username is not found
            System.out.println("Sorry, username invalid or does not exist");
        }
    }
}
