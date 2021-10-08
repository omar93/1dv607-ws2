package View;

public class UserMenu extends Menu {

    UserMessages userMessages = new UserMessages();

    public void showUserMenu() {
        showInstructions(userMessages.getUserMenuInstrctions());
        showAlternatives(userMessages.getUserAlternatives());
    }
    
}
