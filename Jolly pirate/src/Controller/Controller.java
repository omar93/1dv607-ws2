package Controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;  // Import the IOException class to handle errors

import com.google.gson.Gson;

import Model.Member;
import Model.Model;
import View.ConsoleView;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    View.ConsoleView view = new ConsoleView();
    View.BoatView boatView = new View.BoatView();

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
                case 2:  showListCompact(model);break;
                case 3:  showListVerbose(model);break;
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
        view.createNewMember();
        model.createNewUser(view.getName(), view.getPn(), ConsoleView.counter);
        view.showMainMenu();
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

    private void changeBoat(Model model) {
    }

    private void deleteBoat(Model model) {
    }


    private void changeMemberInfo(Model model) {
    }

    // Look at a specific member’s information
    private void showMemberInfo(Model model) {
        view.showIdInput();
        model.readDataFromJson();
        List <Member> list = model.getAllMembers();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == view.getId()) {
                view.printVerbose(list.get(i));
            }
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



    private void showListCompact(Model model) {
        model.readDataFromJson();
        List <Member> list = model.getAllMembers();
        if(list.size() == 0) {
            System.out.println("No users");
        } else {
            for (int i = 0; i < list.size(); i++) {
                view.printCompact(list.get(i));
            }
        }
        view.showMainMenu();
    }

    private void showListVerbose(Model model) {
        model.readDataFromJson();
        List <Member> list = model.getAllMembers();
        if(list.size() == 0) {
            System.out.println("No users");
        } else {
            for (int i = 0; i < list.size(); i++) {
                view.printVerbose(list.get(i));
            }
        }
        view.showMainMenu();
    }

}
