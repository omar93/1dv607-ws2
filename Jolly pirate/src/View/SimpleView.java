package View;

public class SimpleView {
    
    public SimpleView() {
        
    }
    
    public void showMenuInformation(String text, String borderStyle) {
        this.printBorder(text.length(),borderStyle);
        this.printGreeting(text,borderStyle);
        this.printBorder(text.length(),borderStyle);
        System.out.println();
    }

    public void showMenuAlternatives(String alternatives) {
        System.out.println(alternatives);
    }
    
    private void printGreeting(String greeting, String borderStyle) {
        System.out.println("| " + greeting + " |");
    }

    private void printBorder(int size, String style) {
        for(int i = 0; i < size+4; i++) {
            System.out.print((i == (size+3)) ?  style+"\n" : style);
        }
    }
}
