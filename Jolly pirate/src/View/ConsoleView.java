package View;

import java.util.Scanner;

import Model.Member;

public class ConsoleView extends Menu {
    
    Messages messages = new Messages();

    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String pn;
    private int id;
    public static int counter;
        
    public void showMainMenu() {
        System.out.println("\n"+messages.getMenuAlternatives());
    }

    public void showGreeting() {
        showWithBorder(messages.getGreeting());
    }

    public void showInstructions() {
        showWithBorder(messages.getInstructions());
    }

    public void createNewMember() {
        counter++;
        System.out.println("Enter name:");
        this.name = NameFromScanner();
        System.out.println("Enter personal number:");
		this.pn = pnScanner();
        System.out.println("New user: " + name+" PN: "+pn);
    }

    public void showIdInput() {
        System.out.println("Enter user ID:");
        this.id = idScanner();
    }

    public void printCompact(Member member) {
        System.out.println("Name: "+member.getName());
        System.out.println("ID: "+member.getId());
        System.out.println("Boats: "+member.getBoats());
        System.out.println("------------------------");
    }

    public void printVerbose(Member member) {
        System.out.println("______________________________________");
        System.out.println("Name: "+member.getName());
        System.out.println("Personal number: "+member.getPn());
        System.out.println("ID: "+member.getId());
        System.out.println("Boats: "+member.getBoats());
        System.out.println("Boats information:\n");
        for (int i = 0; i < member.getBoat().size(); i++) {
            System.out.println("    Length: " + member.getBoat().get(i).getLength());
            System.out.println("    Type: " + member.getBoat().get(i).getType());
            System.out.println("-------------------------------");
        }
    }

    // Scans name returns it
	private String NameFromScanner() {
		String name = scanner.nextLine();
		return name;
	}

    // Scans pn and returns it
	private String pnScanner() {
		String pn = scanner.nextLine();
		return pn;
	}

    // Scans id and returns it
	private int idScanner() {
		int id = scanner.nextInt();
		return id;
	}

    public String getName() {
        return this.name;
    }
    public String getPn() {
        return this.pn;
    }
    public int getId() {
        return this.id;
    }







}
