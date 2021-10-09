package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;



public class Model {

  
    private List <Member> memberList = new ArrayList<Member>();
    
    public void createNewUser(String name, String pn,int counter) {
      Member member = new Member(name,pn,counter);
      readDataFromJson();
      updateJsonData(member);
      writeToJsonFile();
    }

    public void registerBoat(double length, String type, int id, Member m) {
      // Boat boat = new Boat(length, type);
      // m.addBoat(boat);
    }

    private void updateJsonData(Member member) {
      this.memberList.add(member);
    }

    public void readDataFromJson() {
      try {
        System.out.println("inne i try");
        Gson gson = new Gson();
        System.out.println("nytt gson klart");
        JsonReader reader = new JsonReader(new FileReader("data.json"));
        System.out.println("read file");
        Member[] list = gson.fromJson(reader, Member[].class); // this crashes for some
        System.out.println("läsa frm json till array");
        this.memberList = new ArrayList<Member>(Arrays.asList(list));
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    private void writeToJsonFile() {
      try {
        FileWriter myWriter = new FileWriter("data.json");
        Gson gson = new Gson();
        String json = gson.toJson(this.memberList.toArray());
        myWriter.write(json);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
    
    public List<Member> getAllMembers() {
      return this.memberList;
    }

    public void removeMember(List<Member> list) {
      this.memberList = list;
      writeToJsonFile();
    }

}
