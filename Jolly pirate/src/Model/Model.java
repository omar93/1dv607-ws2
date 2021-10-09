package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


public class Model {
    
    private List <Member> memberList = new ArrayList<Member>();

    /**
     * step 1, create new user
     * step 2, read jsonFile to list
     * step 3, add new user to list
     * step 4, write to jsonFile
     */
    public void createNewUser(String name, String pn,int counter) {
      createJsonFile();
      Member member = new Member(name,pn,counter);
      readDataFromJson();
      this.memberList.add(member);
      writeToJsonFile();
    }
    
    private void createJsonFile() {
      try {
          File myObj = new File("data.json");
          if (myObj.createNewFile()) {
            FileWriter myWriter = new FileWriter("data.json");
            myWriter.write("[{}]");
            myWriter.close();
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    public void readDataFromJson() {
      try {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("data.json"));
        Member[] list = gson.fromJson(reader, Member[].class);
        this.memberList = new ArrayList<Member>(Arrays.asList(list));
      } catch (Exception e) {
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
