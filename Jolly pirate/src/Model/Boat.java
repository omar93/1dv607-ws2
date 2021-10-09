package Model;

public class Boat {


    // Members
    private String boatID = "0";
    private double length = 0;
    private String type;


    // Constructor
    public Boat(double length, String type) {
        this.length = length;
        this.type = type;
    }

    // Getters and setters for the boat class
    public String getId() { return this.boatID; }
    public String getType() { return this.type; }
    public double getLength() { return this.length; }
}
