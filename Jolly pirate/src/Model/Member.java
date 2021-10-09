package Model;
public class Member {
    
    private String name;
    private String pn;
	private int boats = 5;
    private int id;
    // private List<Boat> boatList = new ArrayList<Boat>();
    private Boat [] boatList = new Boat[3];

    public Member(String name, String pn,int id) {
		this.name = name;
		this.pn = pn;
        this.boats = 6;
        this.id = id;
	}

    public Member() {
        this.name = "Namn";
        this.pn = "123456";
        this.boats = 0;
    }

    public void set(Member m) {
        this.name = m.name;
		this.pn = m.pn;
        this.boats = m.getBoats();
        this.id = m.getId();
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
	public void setBoats(int newBoatAmmount) { this.boats = newBoatAmmount; }

    // Get & Set Boatlist
    public Boat[] getBoat() { return this.boatList; }

    // Get & Set Boatlist
    // public List<Boat> getBoat() { return this.boatList; }
    // public void addBoat(Boat b) { boatList.add(b); }
}
