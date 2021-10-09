package Controller;

import java.util.List;
import java.util.Scanner;

import Model.Member;
import Model.Model;
import View.ConsoleView;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    View.ConsoleView view = new ConsoleView();
    public void startMenu(Model model) {
        view.showMainMenu();
        getUserInput(model);
    }

    private void getUserInput(Model model) {
        int choice = scanner.nextInt();
            switch (choice) {
                case 1:  createNewMember(model);break;
                case 2:  showListCompact(model);break;
                case 3:  showListVerbose(model);break;
                case 4:  readData(model);break;
                case 0:  System.exit(0);break;
            }
            getUserInput(model);
    }

    private void readData(Model model) {
        model.readDataFromJson();
    }

    private void createNewMember(Model model) {
        view.createNewMember();
        model.createNewUser(view.getName(), view.getPn());
    }

    private void showListCompact(Model model) {
        List <Member> list = model.getAllMembers();
        if(list.size() == 0) {
            System.out.println("No users");
        } else {
            for (int i = 0; i < list.size(); i++) {
                view.printCompact(list.get(i));
            }
        }
    }

    private void showListVerbose(Model model) {
        List <Member> list = model.getAllMembers();
        if(list.size() == 0) {
            System.out.println("No users");
        } else {
            for (int i = 0; i < list.size(); i++) {
                view.printVerbose(list.get(i));
            }
        }
        
    }

}
