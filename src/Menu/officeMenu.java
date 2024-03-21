package Menu;

public class officeMenu extends mainMenu {

    public void start() {
        //Creating triggers in order to break the while loops below
        boolean mainWhileTrigger = false;
        boolean secondWhileTrigger = false;
        //Starting main office's menu
        while (mainWhileTrigger == false) {
            System.out.println();
            System.out.println("Please introduce your office username with capital letter if needed.");
            //Variable username to compare office username
            String username = getNextLine();
            System.out.println();
            System.out.println("Please introduce your office password with capital letter if needed.");
            //Variable password to compare office password
            String password = getNextLine();
            //Comparing data introduced by user in order to log in office account
            if (username.equals(officeAccount.getUsername()) && password.equals(officeAccount.getPassword())) {
                
                while (secondWhileTrigger == false) {
                    System.out.println();
                    System.out.println("Welcome " + officeAccount.getName() + "\n Press 1 - to generate a Course Report \n Press 2 - to generate a Students Report \n Press 3 - to generate a Lecturers Report \n Press 4 - to change your username \n Press 5 - to change your password \n Press 6 - to log out");
                    //String optionSelected has been created in order to store user entry
                    String optionSelected = getNextLine();
                    switch (optionSelected) {
                        case "1":
                            //Calling our officeAccount methods to generate a course report
                            System.out.println();
                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                            switch (getNextLine()) {
                                /*Caling office user method 
                                     *Param 1 reportType (1 means course report)
                                     *param 2 is the format
                                    */
                                case "1":
                                    officeAccount.getReport(1, "txt");
                                    break;
                                case "2":
                                    officeAccount.getReport(1, "csv");
                                    break;
                                case "3":
                                    officeAccount.getReport(1, "console");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case "2":
                            //Calling our officeAccount methods to generate a student report
                            System.out.println();
                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                            switch (getNextLine()) {
                                /*Caling office user method 
                                     *Param 1 reportType (2 means student report)
                                     *param 2 is the format
                                    */
                                case "1":
                                    officeAccount.getReport(2, "txt");
                                    break;
                                case "2":
                                    officeAccount.getReport(2, "csv");
                                    break;
                                case "3":
                                    officeAccount.getReport(2, "console");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case "3":
                            //Calling our officeAccount methods to generate a lecturer report
                            System.out.println();
                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                            switch (getNextLine()) {
                                /*Caling office user method 
                                     *Param 1 reportType (3 means lecturer report)
                                     *param 2 is the format
                                    */
                                case "1":
                                    officeAccount.getReport(3, "txt");
                                    break;
                                case "2":
                                    officeAccount.getReport(3, "csv");
                                    break;
                                case "3":
                                    officeAccount.getReport(3, "console");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case "4":
                            //Changing office account's username
                            System.out.println();
                            System.out.println("Please introduce your new username");
                            String officeNewUsername = getNextLine();
                            officeAccount.setUsername(officeNewUsername);
                            break;
                        case "5":
                            //Changing office account's password
                            System.out.println();
                            System.out.println("Please introduce your new password");
                            String officeNewPassword = getNextLine();
                            officeAccount.setPassword(officeNewPassword);
                            break;
                        case "6":
                            // Logging out
                            System.out.println("You have been loged out");
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
    }
}
