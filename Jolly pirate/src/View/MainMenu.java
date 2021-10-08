package View;

public class MainMenu extends Menu{

    Messages messages = new Messages();

    public void showMenu() {
        showGreeting();
        showMainMenuIntructions();
        showMenuAlternatives();
        System.out.println();
    }

    private void showGreeting() {
        showWithBorder(messages.getGreeting());
    }

    private void showMainMenuIntructions() {
        showWithBorder(messages.getInstructions());
    }

    private void showMenuAlternatives() {
        System.out.println(messages.getMenuAlternatives());
    }

}
