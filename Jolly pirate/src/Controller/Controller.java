package Controller;

import java.util.Scanner;

public class Controller {
    
    public Controller() {
    }

    public void welcomeUser(View.SimpleView view, Model.Menu menu) {
        menu.setBorderStyle("*");
        view.showMenuInformation(menu.getGreeting(), menu.getBorderStyle());
    }

    public void startMenu(View.SimpleView view, Model.Menu menu) {
        view.showMenuInformation(menu.getInstructions(), menu.getBorderStyle());
        view.showMenuAlternatives(menu.getAlternatives());
    }

    public void getUserInput(View.SimpleView view, Model.Menu menu) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice != 5) {
            switch (choice) {
                case 1:  choice = 1;
                         break;
                case 2:  choice = 2;
                         break;
                case 3:  choice = 3;
                         break;
                case 4:  choice = 4;
                         break;
                case 5:  choice = 5;
                         break;
            }
            choice = sc.nextInt();
            System.out.println("\nchoice: " + choice);
        }
        sc.close();
    }
}
