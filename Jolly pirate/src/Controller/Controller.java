package Controller;
import Model.*;
import View.*;

public class Controller {
    
    public Controller() {
    }

    public void welcomeUser(SimpleView view,Menu menu) {
        menu.setBorderStyle("*");
        view.showMenuInformation(menu.getGreeting(), menu.getBorderStyle());
    }

    public void startMenu(SimpleView view,Menu menu) {
        view.showMenuInformation(menu.getInstructions(), menu.getBorderStyle());
        view.showMenuAlternatives(menu.getAlternatives());
    }

    public void getUserInput() {

    }
}
