package Model;

import java.util.Scanner;

public class Menu {
    
    private String greeting = 
    "******************************* \n"+
    "* Welcome to the jolly pirate * \n"+
    "*******************************";

    private String menu = "use the numbers 1-9 to navigate";
    
    Scanner sc = new Scanner(System.in);
    
    public Menu() {

    }

    public String getGreeting() {
        return this.greeting;
    }

    public String getMenu() {
        return this.menu;
    }
}
