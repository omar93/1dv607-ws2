package View;

public class Messages {
        
    private String welcomeMessage = "Welcome to the jolly pirate.";
    private String InstructionsMessage = "Use the numbers 0-9 to navigate. After entering a number, press Enter.";
    private String alternatives = 
    "1) Create a new member\n"+
    "2) Show lists compact\n"+
    "3) Show lists verbose\n"+
    "4) Delete a member\n"+
    "5) Change a member’s information\n"+
    "6) Look at a specific member’s information\n"+
    "7) Register a new boat\n"+
    "8) Delete a boat\n"+
    "9) Change a boat’s information\n"+
    "0) Exit\n";
    


    public String getGreeting() {
        return this.welcomeMessage;
    }

    public String getInstructions() {
        return this.InstructionsMessage;
    }

    public String getMenuAlternatives() {
        return this.alternatives;
    }

}
