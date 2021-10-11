package Model;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class Model {
  
  private List <Member> memberList = new ArrayList<Member>();
  public void createNewUser(Member member) {
    readDataFromJson();
    memberList.add(member);
    updateJsonData(memberList);
  }

  public void registerBoat(double length, String type, int id, Member m) {
    // Boat boat = new Boat(length, type);
    // m.addBoat(boat);
    // updateJsonData(m);
    // writeToJsonFile();
  }

  public void updateJsonData(List <Member> members) {
    memberList = members;
    writeToJsonFile();
  }

  public void readDataFromJson() {
    try {
      Gson gson = new Gson();
      JsonReader reader = new JsonReader(new FileReader("data.json"));
      java.lang.reflect.Type userListType = new TypeToken<ArrayList<Member>>(){}.getType();
      this.memberList = gson.fromJson(reader, userListType);
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  private void writeToJsonFile() {
    try {
      FileWriter myWriter = new FileWriter("data.json");
      Gson gson = new Gson();
      gson.toJson(this.memberList,myWriter);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
    public List<Member> getAllMembers() {
      readDataFromJson();
      return memberList;
    }


  // klar
  public Boat getDesiredBoat(List <Boat> boatList, String boatChoice) {
    int choice = Integer.parseInt(boatChoice);
    return boatList.get(choice-1);
  }

  // Klar
  public List <Boat> updateBoatList(Boat oldBoat, List<Boat> boatList, Boat newBoat) {
    boatList.set((boatList.indexOf(oldBoat)), newBoat);
    return boatList;
  }

    // Klar
    public void removeBoat(Member member, String boatNumber) {
        List <Boat> boatList = member.getBoats();
        Boat currentBoat = boatList.get(Integer.parseInt(boatNumber)-1);
        boatList.remove(currentBoat);
        member.updateBoatInfo(boatList);
        Member newMember = member;
        memberList.set((memberList.indexOf(member)) , newMember); 
        updateJsonData(memberList);
    }

  // Klar
  public void changeMember(Member member, Member newMember) {
    memberList = getAllMembers();
    for (int i = 0; i < memberList.size(); i++) {
        if(memberList.get(i).getId().compareTo(member.getId()) == 0) {
            memberList.set(i , newMember);
            updateJsonData(memberList);
        }
    }
  }

  // Klar
  public void removeUser(String userID) {
    memberList = getAllMembers();
    for (int i = 0; i < memberList.size(); i++) {
        if(memberList.get(i).getId().compareTo(userID) == 0) {
          memberList.remove(i);
          updateJsonData(memberList);
        }
    }
    
  }





}
