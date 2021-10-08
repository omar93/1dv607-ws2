package View;

public class Messages {
        
    private String welcomeMessage = "Welcome to the jolly pirate.";
    private String InstructionsMessage = "Use the numbers 1-9 to navigate. After entering a number, press Enter.";
    private String alternatives = 
    "1) Create a new memeber\n"+
    "2) Show compact list\n"+
    "3) Show verbose list\n"+
    "4) Delete a member\n"+
    "5) Register a boat\n";
    


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
