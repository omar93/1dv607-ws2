package Controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

import com.google.gson.Gson;

import Model.Member;
import Model.Model;
import View.ConsoleView;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    View.ConsoleView view = new ConsoleView();
    View.BoatView boatView = new View.BoatView();
    List <Member> userList;
    Member member;

    public void startMenu(Model model) {
        initializeFiles();
        view.showGreeting();
        view.showInstructions();
        view.showMainMenu();
        getUserInput(model);
    }

    private void getUserInput(Model model) {
        int choice = scanner.nextInt();
            switch (choice) {
                case 1:  createNewMember(model);break;
                case 2:  showList(model,false);break;
                case 3:  showList(model,true);break;
                case 4:  deleteUser(model);break;
                case 5:  changeMemberInfo(model);break;
                case 6:  showMemberInfo(model);break;
                case 7:  registerNewBoat(model);break;
                case 8:  deleteBoat(model);break;
                case 9:  changeBoat(model);break;
                case 0:  System.exit(0);break;
            }
            getUserInput(model);
    }

    private void createNewMember(Model model) {
        member = view.showNewMemberInput();
        model.createNewUser(member);
        view.showMainMenu();
    }

    private void showList(Model model, boolean isVerbose) {
        userList = model.getAllMembers();
        for (int i = 0; i < userList.size(); i++) {
            Member member = userList.get(i);
            if(isVerbose) {
                view.printVerbose(member);
            } else {
                view.printCompact(member);
            }
        }
        view.showMainMenu();
    }

    private void registerNewBoat(Model model) {
        Member selecedMember = new Member();
        view.showIdInput();
        List <Member> list = model.getAllMembers();
        boatView.showInputForm();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == view.getId()) {
                selecedMember = list.get(i);
            }
        }
        model.registerBoat(boatView.getLength(),boatView.getType(),boatView.getBoatId(),selecedMember);
    }

    private void showMemberInfo(Model model) {
        try {
            view.printVerbose(getUserById(model));

        } catch (Exception e) {
            System.out.println("No user found");
        }
        view.showMainMenu();
    }

    private void changeMemberInfo(Model model) {
        try {
            member = getUserById(model);
            userList = model.getAllMembers();
            Member newMember = view.showNewMemberInput();
            userList.set((userList.indexOf(member)+1) , newMember);
            model.updateJsonData(userList);
        } catch (Exception e) {
            System.out.println("No user with the id: " + view.getId());
            System.out.println("No changes done");
        }
        view.showMainMenu();
    }

    private void deleteUser(Model model) {
        view.showIdInput();
        model.readDataFromJson();
        List <Member> list = model.getAllMembers();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == view.getId()) {
                list.remove(i);
            }
        }
        model.removeMember(list);
        view.showMainMenu();
    }


    private Member getUserById(Model model) {
        view.showIdInput();
        model.readDataFromJson();
        userList = model.getAllMembers();
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId().compareTo(view.getId()) == 0) {
                return userList.get(i);
            }
        }
        return null;
    }

    private void changeBoat(Model model) {
    }

    private void deleteBoat(Model model) {
    }

    private void initializeFiles() {
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
