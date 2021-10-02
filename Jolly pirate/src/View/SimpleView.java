package View;

public class SimpleView {
    
    public SimpleView() {
        
    }
    
    public void showMenuInformation(String text, String borderStyle) {
        this.printBorder(text.length(),borderStyle);
        this.printGreeting(text);
        this.printBorder(text.length(),borderStyle);
        System.out.println("");
    }

    public void showMenuAlternatives(String alternatives) {
        System.out.println(alternatives);
    }
    
    private void printGreeting(String greeting) {
        System.out.println("\n| "+greeting+" |");
    }

    private void printBorder(int size, String style) {
        for(int i = 0; i < size+4; i++) {
            System.out.print(style);
        }
    }
}
