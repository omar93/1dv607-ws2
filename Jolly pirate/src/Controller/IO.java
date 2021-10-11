package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Model.Member;
import Model.Model;

public class IO {

    Model model;
    List <Member> userList;

    public IO (Model model) {
        this.model = model;
    }

    public int getNewMemberID() {
        userList = model.getAllMembers();
        int max = 0;
        for (int i = 0; i < userList.size(); i++) {
            Member member = userList.get(i);
            int userID = Integer.parseInt(member.getId());
            if(userID >= max) {
                max = userID;
            }
        }
        return max+1;
    }

    public void initializeFiles() {
        try {
            File myObj = new File("data.json");
            if (myObj.createNewFile()) { //if file gets created
              FileWriter myWriter = new FileWriter("data.json");
              Gson gson = new Gson();
              gson.toJson(new ArrayList<Member>(), myWriter);
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
    
}
