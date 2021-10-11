package Model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    
    private String name;
    private String pn;
    private String id;
    private List<Boat> boatList = new ArrayList<Boat>();

    public Member(String name, String pn,String id) {
		this.name = name;
		this.pn = pn;
        this.id = id;
	}

    public Member() {
        this.name = "Namn";
        this.pn = "123456";
        this.id = "23";
    }

    public void setNewData(String name, String pn) {
        this.name = name;
		this.pn = pn;
        boatList.add(new Boat());
        boatList.add(new Boat());
    }

    public void set(Member m) {
        this.name = m.name;
		this.pn = m.pn;
    }

    // Setter and Getter for name
    public String getName() { return this.name; }
    public void setName(String newName) { this.name = newName; }

    // Get & Set Personal Number
	public String getPn() { return this.pn; }
	public void setPn(String newPn) { this.pn = newPn;}

    public String getId() { return this.id; }

    // Get BoatAmmount
	public int getBoatAmmount() { return this.boatList.size(); }

    // Get, Set & Add to Boatlist
    public List<Boat> getBoats() { return this.boatList; }
    public void addBoat(Boat b) { boatList.add(b); }
    public void updateBoatInfo(List <Boat> newBoatList) { boatList = newBoatList; }
}
