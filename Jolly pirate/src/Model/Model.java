package Model;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;


public class Model {
    
    private List <Member> memberList = new ArrayList<Member>();
    // private List <Member> fileMemberList = new ArrayList<Member>();

      /**
       * step 1, create new user
       * step 2, read jsonFile to list
       * step 3, add new user to list
       * step 4, write to jsonFile
       */
    public void createNewUser(String name, String pn) {

        Member member = new Member(name,pn);
        // readData();
        memberList.add(member);
        createJsonFile();

        try {
          // read data to list before writing to the file
          FileWriter myWriter = new FileWriter("data.json");
          Gson gson = new Gson();
          String json = gson.toJson(member);
          // fileMemberList = readDataFromJson();
          myWriter.write(json);
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
          
    }

    private void createJsonFile() {
      try {
          File myObj = new File("data.json");
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }

    public List<Member> getAllMembers() {
        return this.memberList;
    }

    // create member objects from the available JSON data
    // save all data to 1 file?
    public void readDataFromJson() {
      try {
        Gson gson = new Gson();
        Member m = gson.fromJson(new FileReader("data.json"), Member.class);
        System.out.println(m.getName());
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
}
