package Controller;
import Model.*;
import View.*;

public class Controller {

    private SimpleView view;
    private Menu menu;

    
    public Controller(SimpleView view,Menu menu) {
        this.view = view;
        this.menu = menu;
    }

    public void startProgram() {
        this.welcomeUser();
        this.startMenu();
    }

    public void welcomeUser() {
        view.showGreeting(this.menu.getGreeting());
    }

    public void startMenu() {
        view.showMenu(this.menu.getMenu());
    }
}
