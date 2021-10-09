package Model;

public class Member {
    
    private String name;
    private String pn;
	private int boats = 5;
    private int id;

    public Member(String name, String pn) {
		this.name = name;
		this.pn = pn;
        this.boats = 6;
        this.id = 1337;
	}

    public Member() {
        this.name = "Namn";
        this.pn = "123456";
        this.boats = 0;
    }

    // Setter and Getter for name
    public String getName() { return this.name; }
    public void setName(String newName) { this.name = newName; }

    // Get & Set Personal Number
	public String getPn() { return this.pn; }
	public void setPn(String newPn) { this.pn = newPn;}

    public int getId() { return this.id; }

    // Get & Set BoatAmmount
	public int getBoats() { return this.boats; }
	public void setBoats(int newBoatAmmount) { this.boats = newBoatAmmount;}
}
