package Model;

public class Boat {

    // Members
    private String boatID = "0";
    private double length = 0;
    private String type;

    // Constructor
    public Boat(String type, double length) {
        this.length = length;
        this.type = type;
    }

    public Boat() {
        this.length = 12.23;
        this.type = "default boat";
    }

    // Getters and setters for the boat class
    public String getId() { return this.boatID; }
    public String getType() { return this.type; }
    public double getLength() { return this.length; }
}