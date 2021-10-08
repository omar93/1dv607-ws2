package View;

import java.util.Scanner;

public class SimpleView {
    
    MainMenu mainMenu = new MainMenu();
    UserMenu userMenu = new UserMenu();
        
    public void showMainMenu() {
        mainMenu.showMenu();
    }

    public void showUserMenu() {
        userMenu.showUserMenu();
        getUserMenuInput();
    }

    public void getMainMenuInput() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice != 9) {
            switch (choice) {
                case 1:  showMainMenu();break;
                case 2:  showUserMenu();break;
            }
            choice = sc.nextInt();
        }
        sc.close();
    }

    public void getUserMenuInput() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice != 9) {
            switch (choice) {
                case 1:  createUser();break;
                case 2:  deleteUser();break;
            }
            choice = sc.nextInt();
        }
        sc.close();
    }

    private void deleteUser() {
        System.out.println("DELETE USER");
    }

    private void createUser() {
        System.out.println("CREATE NEW USER");
    }



}
