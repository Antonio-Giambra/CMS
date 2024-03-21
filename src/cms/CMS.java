
package cms;

import java.util.Scanner;

public class CMS {
    
    //-----------------------------------GITHUB REPOSITORY---------------------------------------//
    //------------------------- https://github.com/Antonio-Giambra/CMS --------------------------//
    //-------------------------------------------------------------------------------------------//
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        adminMenu menu = new adminMenu();
        menu.menu();
    }
    
}
