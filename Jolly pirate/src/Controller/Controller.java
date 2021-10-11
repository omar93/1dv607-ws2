package Controller;

import java.util.List;
import java.util.Scanner;

import Model.Boat;
import Model.Member;
import Model.Model;
import View.ConsoleView;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    View.ConsoleView view = new ConsoleView();
    View.BoatView boatView = new View.BoatView();
    List <Member> userList;
    List <Boat> boatList;
    Member member;
    Boat boat;
    String boatNumber;
    String userID;
    int id;
    IO io;
    Model model;

    public void startMenu(Model m) {
        model = m;
        io = new IO(model);
        IO io = new IO(model);
        io.initializeFiles();
        view.showGreeting();
        view.showInstructions();
        view.showMainMenu();
        getUserInput(model);
    }

    private void getUserInput(Model model) {
        int choice = scanner.nextInt();
            switch (choice) {
                case 1:  createNewMember();break;
                case 2:  showList(false);break;
                case 3:  showList(true);break;
                case 4:  deleteUser();break;
                case 5:  changeMemberInfo();break;
                case 6:  showMemberInfo();break;
                case 7:  registerNewBoat();break;
                case 8:  deleteBoat();break;
                case 9:  changeBoat();break;
                case 0:  System.exit(0);break;
            }
            getUserInput(model);
    }

    private void deleteBoat() {
        member = getUserById();
        boatList = member.getBoats();
        for (int i = 0; i < boatList.size(); i++) {
            boatView.showBoatsInformation(boatList.get(i));
        }
        boatNumber = boatView.showBoatIdInput();
        int boatNumberInt = Integer.parseInt(boatNumber)-1;
        Boat currentBoat = boatList.get(boatNumberInt);
        // Boat newBoat = boatView.showInputForm();
        // boatList.set((boatList.indexOf(currentBoat)), newBoat);// change this row to delete
        boatList.remove(currentBoat);
        member.updateBoatInfo(boatList);
        Member newMember = member;
        userList.set((userList.indexOf(member)) , newMember); 
        model.updateJsonData(userList);
        view.showMainMenu();
    }

    private void changeBoat() {
        member = getUserById();
        boatList = member.getBoats();
        for (int i = 0; i < boatList.size(); i++) {
            boatView.showBoatsInformation(boatList.get(i));
        }
        boatNumber = boatView.showBoatIdInput();
        int boatNumberInt = Integer.parseInt(boatNumber)-1;
        Boat currentBoat = boatList.get(boatNumberInt);
        Boat newBoat = boatView.showInputForm();
        boatList.set((boatList.indexOf(currentBoat)), newBoat);
        member.updateBoatInfo(boatList);
        Member newMember = member;
        userList.set((userList.indexOf(member)) , newMember);
        model.updateJsonData(userList);
        view.showMainMenu();
    }

    private void createNewMember() {
        id = io.getNewMemberID();
        member = view.showNewMemberInput(String.valueOf(id));
        model.createNewUser(member);
        view.showMainMenu();
    }

    private void showList(boolean isVerbose) {
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

    private void registerNewBoat() {
        try {
            member = getUserById(); // correct user
            userList = model.getAllMembers(); // correct userlist
            boat = boatView.showInputForm(); // correct boat
            Member newMember = member;
            newMember.addBoat(boat);
            for (int i = 0; i < userList.size(); i++) {
                if(userList.get(i).getId().compareTo(member.getId()) == 0) {
                    userList.set(i , newMember);
                    model.updateJsonData(userList);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void changeMemberInfo() {
        try {
            member = getUserById();
            userList = model.getAllMembers();
            Member newMember = view.showNewMemberInput(member.getId());
            for (int i = 0; i < userList.size(); i++) {
                if(userList.get(i).getId().compareTo(member.getId()) == 0) {
                    userList.set(i , newMember);
                    model.updateJsonData(userList);
                }
            }
        } catch (Exception e) {
            System.out.println("No user with the id: " + member.getId());
            System.out.println("No changes done");
        }
        view.showMainMenu();
    }

    private void showMemberInfo() {
        try {
            view.printVerbose(getUserById());

        } catch (Exception e) {
            System.out.println("No user found");
        }
        view.showMainMenu();
    }

    private void deleteUser() {
        userID = view.showIdInput();
        userList = model.getAllMembers();
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId().compareTo(userID) == 0) {
                userList.remove(i);
            }
        }
        model.updateJsonData(userList);
        view.showMainMenu();
    }


    private Member getUserById() {
        userID = view.showIdInput();
        userList = model.getAllMembers();
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId().compareTo(userID) == 0) {
                return userList.get(i);
            }
        }
        return null;
    }

}
