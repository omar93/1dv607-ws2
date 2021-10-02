package Controller;
import Model.*;
import View.*;

public class Controller {
    
    public Controller() {

    }

    public void startMenu(SimpleView view,Menu menu) {
        view.showGreeting(menu.getGreeting());
        view.showMenu(menu.getMenu());
    }
}
