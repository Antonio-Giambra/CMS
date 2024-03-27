package Menu;

public class officeMenu extends mainMenu {
//Starting the menu for office account
    public void start() {
        try {
            //Creating triggers in order to break the while loops below
            boolean mainWhileTrigger = false;
            boolean secondWhileTrigger = false;
            //Starting main office's menu
            while (mainWhileTrigger == false) {
                System.out.println();
                System.out.println("Please introduce your office username with capital letter if needed.");
                //Variable username to compare office username
                String username = sc.nextLine();
                System.out.println();
                System.out.println("Please introduce your office password with capital letter if needed.");
                //Variable password to compare office password
                String password = sc.nextLine();
                //Comparing data introduced by user in order to log in office account
                if ((username.equals(officeAccount.getUsername()) && password.equals(officeAccount.getPassword())) && officeAccount !=null) {
                    while (secondWhileTrigger == false) {
                        System.out.println();
                        System.out.println("Welcome " + officeAccount.getName() + "\n Press 1 - to generate a Course Report \n Press 2 - to generate a Students Report \n Press 3 - to generate a Lecturers Report \n Press 4 - to change your username \n Press 5 - to change your password \n Press 6 - to log out");
                        //String optionSelected has been created in order to store user entry
                        String optionSelected = sc.nextLine();
                        switch (optionSelected) {
                            case "1":
                                //Calling our officeAccount methods to generate a course report
                                System.out.println();
                                System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                                switch (sc.nextLine()) {
                                    /*Caling office user method 
                                     *param 1 database
                                     *Param 2 reportType (1 means course report)
                                     *param 3 is the format
                                     */
                                    case "1":
                                        officeAccount.getReport(db, 1, "txt");
                                        break;
                                    case "2":
                                        officeAccount.getReport(db, 1, "csv");
                                        break;
                                    case "3":
                                        officeAccount.getReport(db, 1, "console");
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case "2":
                                //Calling our officeAccount methods to generate a student report
                                System.out.println();
                                System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                                switch (sc.nextLine()) {
                                    /*Caling office user method 
                                     *param 1 database
                                     *Param 2 reportType (2 means student report)
                                     *param 3 is the format
                                     */
                                    case "1":
                                        officeAccount.getReport(db, 2, "txt");
                                        break;
                                    case "2":
                                        officeAccount.getReport(db, 2, "csv");
                                        break;
                                    case "3":
                                        officeAccount.getReport(db, 2, "console");
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case "3":
                                //Calling our officeAccount methods to generate a lecturer report
                                System.out.println();
                                System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                                switch (sc.nextLine()) {
                                    /*Caling office user method 
                                     *param 1 database
                                     *Param 2 reportType (3 means lecturer report)
                                     *param 3 is the format
                                     */
                                    case "1":
                                        officeAccount.getReport(db, 3, "txt");
                                        break;
                                    case "2":
                                        officeAccount.getReport(db, 3, "csv");
                                        break;
                                    case "3":
                                        officeAccount.getReport(db, 3, "console");
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case "4":
                                //Changing office account's username
                                System.out.println();
                                System.out.println("Please introduce your new username, must be equal or longer than 4 characteres, white spaces are not admited");
                                String officeNewUsername = sc.nextLine();
                                changeUsername(officeNewUsername);
                                break;
                            case "5":
                                //Changing office account's password
                                System.out.println();
                                System.out.println("Please introduce your new password, must be equal or longer than 8 characteres, white spaces are not admited");
                                String officeNewPassword = sc.nextLine();
                                changePassword(officeNewPassword);
                                break;
                            case "6":
                                // Logging out
                                System.out.println("You have been logged out");
                                //Breaking the while loops
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
        } catch (Exception e) {
            System.out.println("Sorry, there is no Office Account on the system yet");
        }
    }
    //The method changeUsername takes a parameter officeNewUsername, which represents the new username to be assigned to the office account.
    //
    public void changeUsername(String officeNewUsername) {
        // Check if the length of the new username is at least 4 characters, no white spaces
        if (officeNewUsername.matches(regex4CharLength)) {
            officeAccount.setUsername(officeNewUsername);
        } else {
            System.out.println();
            System.out.println("Sorry, the username does not comply with requirements");
        }
    }
    //The method changePassword takes a parameter officeNewUsername, which represents the new password to be assigned to the office account.
    //
    public void changePassword(String officeNewPassword) {
        // Check if the length of the new username is at least 8 characters, no white spaces
        if (officeNewPassword.matches(regex8CharLength)) {
            officeAccount.setPassword(officeNewPassword);
        } else {
            System.out.println();
            System.out.println("Sorry, the password does not comply with requirements");
        }
    }
}
