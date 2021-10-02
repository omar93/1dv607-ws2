package Model;

import java.util.Scanner;

public class Menu {

    private String borderStyle;
    
    private String greeting = "Welcome to the jolly pirate.";
    
    private String instructions = 
    "Use the numbers 1-9 to navigate. After entering a number, press Enter.";
    
    private String alternatives = 
    "1) Create a new memeber\n"+
    "2) Show compact list\n"+
    "3) Show verbose list\n"+
    "4) Delete a member\n"+
    "5) Register a boat\n";

    private String createMember = "member creation";
    
    Scanner sc = new Scanner(System.in);
    
    public Menu() {

    }

    public String getGreeting() {
        return this.greeting;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public String getAlternatives() {
        return this.alternatives;
    }

    public String getMemberMenu() {
        return this.createMember;
    }


    public void setBorderStyle(String style) {
        this.borderStyle = style;
    }

    public String getBorderStyle() {
        return this.borderStyle;
    }
}
