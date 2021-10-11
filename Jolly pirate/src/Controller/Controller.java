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
    Member member;
    Boat boat;
    String userID;
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
        try {
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
        } catch (Exception e) {
            view.wrongInputError();
        }
    }

    private void registerNewBoat() {
        try {
            member = getUserById();
            if(member == null) {
                view.noUserError();
                view.showMainMenu();
            } else {
                userList = model.getAllMembers();
                boat = boatView.showNewBoatForm();
                Member newMember = member;
                newMember.addBoat(boat);
                for (int i = 0; i < userList.size(); i++) {
                    if(userList.get(i).getId().compareTo(member.getId()) == 0) {
                        userList.set(i , newMember);
                        model.updateJsonData(userList);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void changeBoat() {
        Member member = getUserById();
        userList = model.getAllMembers();
        if(userList.size() == 0) {
            view.noUserError();
            view.showMainMenu();
        } else {
            List <Boat> boatList = member.getBoats();
            Boat oldBoat = model.getDesiredBoat(boatList,boatView.printBoats(boatList));
            boatList = model.updateBoatList(oldBoat,boatList,boatView.showNewBoatForm());
            Member newMember = member;
            newMember.updateBoatInfo(boatList);
            model.changeMember(member, newMember);
        }

        
    }

    private void deleteBoat() {
        member = getUserById();
        if(member == null) {
            view.noUserError();
            view.showMainMenu();
        } else {
            model.removeBoat(member,boatView.printBoats(member.getBoats()));
            view.showMainMenu();
        }

    }

    private void showMemberInfo() {
        try {
            view.printVerbose(getUserById());

        } catch (Exception e) {
            view.noUserError();
        }
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

    private void createNewMember() {
        model.createNewUser(view.showNewMemberInput(String.valueOf(io.getNewMemberID())));
        view.showMainMenu();
    }

    private void changeMemberInfo() {
        Member member = getUserById();
        if(member == null) {
            view.noUserError();
            view.showMainMenu();
        } else {
            model.changeMember(member,view.showNewMemberInput(member.getId()));
            view.showMainMenu();
        }

    }

    private void deleteUser() {
        Member member = getUserById();
        if(member == null) {
            view.noUserError();
            view.showMainMenu();
        } else {
            model.removeUser(member.getId());
            view.showMainMenu();
        }
    }

}
