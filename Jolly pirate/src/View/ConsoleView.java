package View;

import java.util.Scanner;

import Model.Member;

public class ConsoleView {
    
    MainMenu mainMenu = new MainMenu();
    UserMenu userMenu = new UserMenu();
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String pn;
        
    public void showMainMenu() {
        mainMenu.showMenu();
    }

    public void createNewMember() {
        System.out.println("Enter name:");
        name = getNameFromScanner();
        System.out.println("Enter personal number:");
		pn = pnScanner();
        System.out.println("New user: " + name+" PN: "+pn);
        showMainMenu();
    }

    public void printCompact(Member member) {
        System.out.println("Name: "+member.getName());
        System.out.println("ID: "+member.getId());
        System.out.println("Boats: "+member.getBoats());
        System.out.println("------------------------");
    }

    public void printVerbose(Member member) {
        System.out.println("Name: "+member.getName());
        System.out.println("Personal number: "+member.getPn());
        System.out.println("ID: "+member.getId());
        System.out.println("Boats: "+member.getBoats());
        System.out.println("------------------------");
    }

    // Scans name returns it
	private String getNameFromScanner() {
		String name = scanner.nextLine();
		return name;
	}

    // Scans pn and returns it
	private String pnScanner() {
		String pn = scanner.nextLine();
		return pn;
	}

    public String getName() {
        return this.name;
    }
    public String getPn() {
        return this.pn;
    }






}
