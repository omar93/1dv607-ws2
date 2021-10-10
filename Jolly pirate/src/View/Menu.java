package View;

public class Menu {

    public void showWithBorder (String message) {
        this.printBorder(message.length());
        this.printGreeting(message);
        this.printBorder(message.length());
    }

    private void printGreeting(String greeting) {
        System.out.println("| " + greeting + " |");
    }

    private void printBorder(int size) {
        for(int i = 0; i < size+4; i++) {
            System.out.print((i == (size+3)) ?  "*"+"\n" : "*");
        }
    }
}
