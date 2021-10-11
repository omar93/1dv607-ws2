package View;

import java.util.Scanner;

import Model.Member;

public class ConsoleView extends Menu {
    
    Messages messages = new Messages();

    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String pn;
    private String id;
    public static int counter;
    // private Member member;
        
    public void showMainMenu() {
        System.out.println("\n"+messages.getMenuAlternatives());
    }

    public void showGreeting() {
        showWithBorder(messages.getGreeting());
    }

    public void showInstructions() {
        showWithBorder(messages.getInstructions());
    }

    public Member showNewMemberInput(String id) {
        System.out.println("Enter name:");
        name = NameFromScanner();
        System.out.println("Enter personal number:");
		pn = pnScanner();
        System.out.println("New user: " + name+" PN: "+pn);
        return new Member(name,pn,id);
    }

    public String showIdInput() {
        System.out.println("Enter user ID:");
        id = idScanner();
        return id;
    }

    public void showError() {
        System.out.println("No users");
    }

    public void printCompact(Member member) {
        System.out.println("Name: "+member.getName());
        System.out.println("ID: "+member.getId());
        System.out.println("Boats: "+member.getBoatAmmount());
        System.out.println("------------------------");
    }
    
    public void printVerbose(Member member) {
        System.out.println("Name: "+member.getName());
        System.out.println("Personal number: "+member.getPn());
        System.out.println("ID: "+member.getId());
        System.out.println("Boats: "+member.getBoatAmmount());
        System.out.println("\nBoats information:\n");
        for (int i = 0; i < member.getBoats().size(); i++) {
            System.out.println("    Length: " + member.getBoats().get(i).getLength()+"M");
            System.out.println("    Type: " + member.getBoats().get(i).getType()+"\n");
        }
        System.out.println("______________________________________");
    }

    // Scans name returns it
	private String NameFromScanner() {
		return scanner.nextLine();
	}

    // Scans pn and returns it
	private String pnScanner() {
		return scanner.nextLine();
	}

    // Scans id and returns it
	private String idScanner() {
		return scanner.nextLine();
	}


}
