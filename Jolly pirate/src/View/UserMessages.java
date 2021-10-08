package View;

public class UserMessages {
    
    private String userMenuInstructions = "Member: Use the numbers 1-9 to navigate. After entering a number, press Enter.";
    private String alternatives = 
    "1) Create a new memeber\n"+
    "2) Show compact list\n"+
    "3) Show verbose list\n"+
    "4) Delete a member\n"+
    "5) Register a boat\n";
    

    public String getUserMenuInstrctions() {
        return this.userMenuInstructions;
    }

    public String getUserAlternatives() {
        return this.alternatives;
    }
}
