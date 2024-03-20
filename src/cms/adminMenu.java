
package cms;

import Users.Administrator;
import Users.Lecturer;
import Users.Office;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class adminMenu {
    
    private Office officeAccount;     
    private ArrayList<Lecturer> lecturers = new ArrayList<>();

    //Method created in order to check if any lecturers username and password match with entry data
    public boolean lecturerValidator(String username, String password) {
        //Iteratin our ArrayList
        Iterator<Lecturer> itr = lecturers.iterator();
        //boolean finder used to show whether lecturer exists or not.
            boolean finder = false;
            
            while (itr.hasNext()) {
                Lecturer lecturer = itr.next();
                //if lecturer username and password match with entry data it return true.
                if (lecturer.getUsername().equals(username) && lecturer.getPassword().equals(password)) {
                    finder = true;
                    return true;
                } 

            }
        return false;
    }
    public Lecturer lecturerInfo(String username, String password){
        //Iteratin our ArrayList
        Iterator<Lecturer> itr = lecturers.iterator();
        //boolean finder used to show whether lecturer exists or not.
            boolean finder = false;
            
            while (itr.hasNext()) {
                Lecturer lecturer = itr.next();
                //if lecturer username and password match with entry data it return true.
                if (lecturer.getUsername().equals(username) && lecturer.getPassword().equals(password)) {
                    finder = true;
                    return lecturer;
                } 

            }
        return null;
    }
    public void searchLecturer(String username, String data, int operation){
        //Iteratin our ArrayList
        Iterator<Lecturer> itr = lecturers.iterator();
        //boolean finder used to show whether lecturer exists or not.
            boolean finder = false;
            
            while (itr.hasNext()) {
                Lecturer lecturer = itr.next();
                //if lecturer username and password match with entry data it return true.
                if (lecturer.getUsername().equals(username)) {
                    switch(operation){
                        case 1:
                            lecturer.setName(data);
                            finder = true;
                            break;
                        case 2:
                            lecturer.setUsername(data);
                            finder = true;
                            break;
                        case 3:
                            lecturer.setPassword(data);
                            finder = true;
                            break;
                        case 4:
                            System.out.println("Lecturer " + lecturer.getName() + " has been deleted");
                            itr.remove();
                            finder = true;
                            break;
                        default:
                            break;
                    }
                } 
            }
    }

    public void setOfficeAccount(Office officeAccount) {
        this.officeAccount = officeAccount;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        
        this.lecturers = lecturers;
    }
    
    public void menu(){
        try{
            //Registering admin account
            Administrator admin = new Administrator();
            //Using Scanner in order to get all information from the user
            Scanner sc = new Scanner(System.in);
            //Creation of a trigger boolean variable in order to break the main while loop below.
            boolean triggerLayout1 = false;
     
            while(triggerLayout1 == false){
                //Creation of two more trigger boolean variables in order to break each layout while loop below.
                boolean triggerLayout2 = false;
                boolean triggerLayout3 = false;
                System.out.println("Welcome to Content Management System \n\n Press 1 - to connect an Admin Account \n Press 2 - to connect an Office Account \n Press 3 - to connect a Lecturer Account\n Press 4 - to exit the system");
                //variable userConnection in order to store data provided by user
                String userConnection = sc.nextLine();
                
                switch(userConnection){
                    //-------------------------------------------ADMIN SESSION-----------------------------------------------//
                    case "1":
                        while(triggerLayout2 == false){
                            System.out.println();
                            System.out.println("Please introduce your admin username with capital letter if needed.");
                            //Variable username to compare administrator username
                            String username = sc.nextLine();
                            System.out.println();
                            System.out.println("Please introduce your admin password with capital letter if needed.");
                            //Variable password to compare administrator password
                            String password = sc.nextLine();
                            //Comparing data introduced by user in order to log in admin account
                            if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
                                while(triggerLayout3 == false){
                                    System.out.println();
                                    System.out.println("Welcome " + admin.getName() + "\n Press 1 - to add user \n Press 2 - to modify user \n Press 3 - to delete user \n Press 4 - to change your username \n Press 5 - to change your password \n Press 6 - to log out");
                 
                                    //String optionSelected has been created in order to store user entry
                                    String optionSelected = sc.nextLine();
                                    switch(optionSelected){
                                        case "1":
                                            System.out.println();
                                            System.out.println(" Press 1 - to add an office user \n Press 2 - to add lecturer user \n Press any other button to cancel operation");
                                            String dataEntry = sc.nextLine();
                                            if(dataEntry.equals("1")){
                                                if(officeAccount == null){
                                                   System.out.println();
                                                   System.out.println("Please, introduce an username for the office account, must be longer than 4 letters");
                                                   String officeUsername = sc.nextLine();
                                                   System.out.println("Please, introduce a password for the office account, must be longer than 8 characteres");
                                                   String officePassword = sc.nextLine();
                                                   officeAccount = new Office("office",officeUsername,officePassword);   
                                                }else{
                                                    System.out.println("Sorry, there is an Office Account already created");
                                                }
                                            }else if(dataEntry.equals("2")){
                                                System.out.println();
                                                System.out.println("Please, introduce the name of the lecturer, must be longer than 4 letters");
                                                String lecturerName = sc.nextLine();
                                                System.out.println();
                                                System.out.println("Please, introduce an username for the lecturer account, must be longer than 4 letters");
                                                String lecturerUsername = sc.nextLine();
                                                System.out.println("Please, introduce a password for the lecturer account, must be longer than 8 characteres");
                                                String lecturerPassword = sc.nextLine();
                                                Lecturer lecturer = new Lecturer(lecturerName,lecturerUsername,lecturerPassword);
                                                lecturers.add(lecturer);
                                            }else {
                                                System.out.println();
                                                System.out.println("Cancelling Operation!!");
                                            }
                                            //Calling our DB and adding a new user
                                            break;
                                        //-------------------------------------------Modification section------------------------------------------------------//
                                        case "2":
                                            System.out.println();
                                            System.out.println("Press 1 - to modify an office user \n Press 2 - to modify lecturer user \n Press any button to cancel operation");
                                            String userModify = sc.nextLine();
                                            //----------------------------Modifying office user--------------------------------//
                                            if(userModify.equals("1")){
                                                if(officeAccount != null){
                                                   System.out.println();
                                                   System.out.println("Press 1 - to modify an office name \n Press 2 - to modify an office username \n Press 3 - to modify office password \n Press any other button to cancelling operation");
                                                   switch(sc.nextLine()){
                                                       case "1":
                                                           System.out.println();
                                                           System.out.println("Please, introduce a name for the office account, must be longer than 4 letters");
                                                           String officeName = sc.nextLine();
                                                           officeAccount.setName(officeName);
                                                           break;
                                                       case "2":
                                                           System.out.println();
                                                           System.out.println("Please, introduce an username for the office account, must be longer than 4 letters");
                                                           String officeUsername = sc.nextLine();
                                                           officeAccount.setUsername(officeUsername);
                                                           break;
                                                       case "3":
                                                           System.out.println();
                                                           System.out.println("Please, introduce a password for the office account, must be longer than 8 characteres");
                                                           String officePassword = sc.nextLine();
                                                           officeAccount.setPassword(officePassword);
                                                           break;
                                                       default:
                                                           System.out.println("Cancelling Operation!!");
                                                           break;
                                                   }
                                                }else{
                                                    System.out.println("Sorry, there is not an Office Account already created");
                                                }
                                             //------------------------------modifying lecturer user-----------------------------------//   
                                            }else if(userModify.equals("2")){
                                                if(!(lecturers.isEmpty())){
                                                   System.out.println();
                                                   System.out.println("Press 1 - to modify an lecturer name \n Press 2 - to modify an lecturer username \n Press 3 - to modify lecturer password \n Press any other button to cancelling operation");
                                                   String lecturerUsername;
                                                   switch(sc.nextLine()){
                                                       case "1":
                                                           System.out.println();
                                                           System.out.println("Please, introduce lecturer username");
                                                           lecturerUsername = sc.nextLine();
                                                           System.out.println();
                                                           System.out.println("Please, introduce a name for the lecturer " + lecturerUsername + " account, must be longer than 4 letters");
                                                           String lecturerName = sc.nextLine();
                                                           searchLecturer(lecturerUsername,lecturerName,1);
                                                           break;
                                                       case "2":
                                                           System.out.println();
                                                           System.out.println("Please, introduce lecturer username");
                                                           lecturerUsername = sc.nextLine();
                                                           System.out.println();
                                                           System.out.println("Please, introduce a new username for the lecturer " + lecturerUsername + " account, must be longer than 4 letters");
                                                           String lecturerNewUsername = sc.nextLine();
                                                           searchLecturer(lecturerUsername,lecturerNewUsername,2);
                                                           break;
                                                       case "3":
                                                           System.out.println();
                                                           System.out.println("Please, introduce lecturer username");
                                                           lecturerUsername = sc.nextLine();
                                                           System.out.println();
                                                           System.out.println("Please, introduce a new username for the lecturer " + lecturerUsername + " account, must be longer than 4 letters");
                                                           String lecturerNewPassword = sc.nextLine();
                                                           searchLecturer(lecturerUsername,lecturerNewPassword,3);
                                                           break;
                                                       default:
                                                           System.out.println("Cancelling Operation!!");
                                                           break;
                                                   }
                                                }else{
                                                  System.out.println();
                                                  System.out.println("Sorry, there is not any lecturers registered on the system");  
                                                }
                                            }else {
                                                System.out.println();
                                                System.out.println("Cancelling Operation");
                                            }
                                            //Calling our DB and modify an user
                                            break;
                                        case "3":
                                            //Calling our DB and delete an user
                                            System.out.println();
                                            System.out.println("Press 1 - to delete the office user \n Press 2 - to delete lecturer user \n Press any button to cancel operation");
                                            String deleteUser = sc.nextLine();
                                            switch(deleteUser){
                                                case "1":
                                                    if(officeAccount != null){
                                                        officeAccount = null;
                                                        System.out.println();
                                                        System.out.println("office Account has been deleted");
                                                    } else{
                                                        System.out.println();
                                                        System.out.println("Sorry, there is no office Account already created");
                                                    }
                                                    break;
                                                case "2":
                                                    System.out.println();
                                                    System.out.println("Please, introduce lecturer username in order to delete it");
                                                    String lecturerUsername = sc.nextLine();
                                                    searchLecturer(lecturerUsername,"",4);
                                            }
                                            break;
                                        case "4":
                                            //Changing our username
                                            System.out.println();
                                            System.out.println("Please introduce your new username");
                                            String adminUsername = sc.nextLine();
                                            admin.setUsername(adminUsername);
                                            break;
                                        case "5":
                                            //Changing our password
                                            System.out.println();
                                            System.out.println("Please introduce your new password");
                                            String adminPassword = sc.nextLine();
                                            admin.setPassword(adminPassword);
                                            break;
                                        case "6":
                                            // Logging out
                                            System.out.println("You have been loged out");
                                            triggerLayout2 = true;
                                            triggerLayout3 = true;
                                            break;
                                        default:
                                            System.out.println("Sorry, you must enter a valid option");
                                    }
                                }  
                            }else{
                                System.out.println();
                                System.out.println("Sorry, username or password is not correct or invalid");
                                triggerLayout2 = true;
                            }
                        }
                        break;
                    //----------------------------------------------------------------------------------------------------------//
                    //---------------------------------------------OFFICE SESSION-----------------------------------------------//
                    case "2":
                        while(triggerLayout2 == false){
                            System.out.println();
                            System.out.println("Please introduce your office username with capital letter if needed.");
                            //Variable username to compare office username
                            String username = sc.nextLine();
                            System.out.println();
                            System.out.println("Please introduce your office password with capital letter if needed.");
                            //Variable password to compare office password
                            String password = sc.nextLine();
                            //Comparing data introduced by user in order to log in office account
                            if(username.equals(officeAccount.getUsername()) && password.equals(officeAccount.getPassword())){
                                while(triggerLayout3 == false){
                                    System.out.println();
                                    System.out.println("Welcome " + officeAccount.getName() + "\n Press 1 - to generate a Course Report \n Press 2 - to generate a Students Report \n Press 3 - to generate a Lecturers Report \n Press 4 - to change your username \n Press 5 - to change your password \n Press 6 - to log out");
                                    //String optionSelected has been created in order to store user entry
                                    String optionSelected = sc.nextLine();
                                    switch(optionSelected){
                                        case "1":
                                            //Calling our DB to generate a course report
                                            System.out.println();
                                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                                            switch(sc.nextLine()){
                                                case "1":
                                                    officeAccount.getReport(1,"txt");
                                                    break;
                                                case "2":
                                                    officeAccount.getReport(1,"csv");
                                                    break;
                                                case "3":
                                                    officeAccount.getReport(1,"console");
                                                    break;
                                                default:
                                                    break;
                                            }
                                            break;
                                        case "2":
                                            //Calling our DB to generate a student report
                                            System.out.println();
                                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                                            switch(sc.nextLine()){
                                                case "1":
                                                    officeAccount.getReport(2,"txt");
                                                    break;
                                                case "2":
                                                    officeAccount.getReport(2,"csv");
                                                    break;
                                                case "3":
                                                    officeAccount.getReport(2,"console");
                                                    break;
                                                default:
                                                    break;
                                            }
                                            break;
                                        case "3":
                                            //Calling our DB to generate a lecturer report
                                            System.out.println();
                                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                                            switch(sc.nextLine()){
                                                case "1":
                                                    officeAccount.getReport(3,"txt");
                                                    break;
                                                case "2":
                                                    officeAccount.getReport(3,"csv");
                                                    break;
                                                case "3":
                                                    officeAccount.getReport(3,"console");
                                                    break;
                                                default:
                                                    break;
                                            }
                                            break;
                                        case "4":
                                            //Changing our username
                                            System.out.println();
                                            System.out.println("Please introduce your new username");
                                            String officeNewUsername = sc.nextLine();
                                            officeAccount.setUsername(officeNewUsername);
                                            break;
                                        case "5":
                                            //Changing our password
                                            System.out.println();
                                            System.out.println("Please introduce your new password");
                                            String officeNewPassword = sc.nextLine();
                                            officeAccount.setPassword(officeNewPassword);
                                            break;
                                        case "6":
                                            // Logging out
                                            System.out.println("You have been loged out");
                                            triggerLayout2 = true;
                                            triggerLayout3 = true;
                                            break;
                                        default:
                                            System.out.println("Sorry, you must enter a valid option");
                                    }
                                }  
                            }else{
                                System.out.println();
                                System.out.println("Sorry, username or password is not correct or invalid");
                                triggerLayout2 = true;
                            }
                        }
                        break;
                    //----------------------------------------------------------------------------------------------------------//
                    //-------------------------------------------LECTURER SESSION-----------------------------------------------//
                    case "3":
                        while(triggerLayout2 == false){
                            System.out.println();
                            System.out.println("Please introduce your lecturer username with capital letter if needed.");
                            //Variable username to compare office username
                            String username = sc.nextLine();
                            System.out.println();
                            System.out.println("Please introduce your lecturer password with capital letter if needed.");
                            //Variable password to compare office password
                            String password = sc.nextLine();
                            //Comparing data introduced by user in order to log in office account
                            if(lecturerValidator(username,password)){
                                //Lecturer instance has been created in order to work with his/her data and processes
                                Lecturer lecturerTransactor = lecturerInfo(username,password);
                                while(triggerLayout3 == false){
                                    System.out.println();
                                    System.out.println("Welcome " + lecturerTransactor.getName() + "\n Press 1 - to generate a Lecturers Report \n Press 2 - to change your username \n Press 3 - to change your password \n Press 4 - to log out");
                                    //String optionSelected has been created in order to store user entry
                                    String optionSelected = sc.nextLine();
                                    switch(optionSelected){
                                        case "1":
                                            //Calling our DB to generate a course report
                                            System.out.println();
                                            System.out.println("Please select the file format for the report \n Press 1 - TXT format \n Press 2 - CSV Format \n Press 3 - to display it in console");
                                            switch(sc.nextLine()){
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
                                            triggerLayout2 = true;
                                            triggerLayout3 = true;
                                            break;
                                        default:
                                            System.out.println("Sorry, you must enter a valid option");
                                    } 
                                }  
                            }else{
                                System.out.println();
                                System.out.println("Sorry, username or password is not correct or invalid");
                                triggerLayout2 = true;
                            }
                        }
                        break;
                    //----------------------------------------------------------------------------------------------------------//
                    case "4":
                        System.out.println();
                        System.out.println("Thank you for using this system");
                        triggerLayout1 = true;
                        break;
                    default:
                        System.out.println();
                        System.out.println("Sorry, you must enter a valid option");
                        break;
                }
            }
            //Closing our scanner.
            sc.close();
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }  
    }
}
