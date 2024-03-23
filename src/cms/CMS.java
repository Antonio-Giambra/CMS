
package cms;

import Menu.mainMenu;
import java.sql.SQLException;


public class CMS {
    
    //-----------------------------------GITHUB REPOSITORY---------------------------------------//
    //------------------------- https://github.com/Antonio-Giambra/CMS --------------------------//
    //-------------------------------------------------------------------------------------------//
    
    public static void main(String[] args) throws SQLException {
        //Creating a new instance of mainMenu
        mainMenu menu = new mainMenu();
        //Calling mainMenu main method in order to start the process
        menu.startMenu();
    }
    
}
