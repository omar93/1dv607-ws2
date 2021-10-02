package Model;

public class Menu {
    
    private String greeting = 
    "Welcome to the jolly pirate \n"+
    "use the number below to navigate the menu";

    private String menu = "1-9";
    
    public Menu() {

    }

    public String getGreeting() {
        return this.greeting;
    }

    public String getMenu() {
        return this.menu;
    }
}
