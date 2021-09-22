package Model;

public class Boat {

    // Members
    private String boatID = "0";
    private double length = 0;
    private Type type;

    // Enum for boat types
    enum Type {
        SAILBOAT, 
        MOTORSAILER, 
        KAYAK,
        CANOE, 
        OTHER
    }

    // Constructor
    public Boat(Type type){
        this.type = type;
    }

    // Getters and setters for the boat class
    public String getId() { return this.boatID; }
    public Type getType() { return this.type; }
    public double getLength() { return this.length; }
}
