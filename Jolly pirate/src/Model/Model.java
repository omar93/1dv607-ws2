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

    public void removeMember(List<Member> list) {
      this.memberList = list;
      writeToJsonFile();
    }

}
