package Controller;
import Model.*;
import View.*;

public class Controller {
    
    public Controller() {
    }

    public void welcomeUser(SimpleView view,Menu menu) {
        view.showGreeting(menu.getGreeting());
    }

    public void startMenu(SimpleView view,Menu menu) {
        view.showMenu(menu.getMenu());
    }

    public void getUserInput() {

    }
}
