package View;

import java.util.Scanner;

public class BoatView {

    private Scanner scanner = new Scanner(System.in);

    private double boatLength;
    private String boatType;
    private int typeChoice;
    private int boatId;

    public void showInputForm() {
        System.out.println("Enter boat length");
        this.boatLength = scanner.nextInt();
        System.out.println("Enter boat type");
        this.typeChoice = scanner.nextInt();
        System.out.println("Enter boat ID");
        this.typeChoice = scanner.nextInt();	
		switch (this.typeChoice) {
			case 1:this.boatType = "Sailboat";break;
			case 2:this.boatType  = "Motorsailer";break;
			case 3:this.boatType  = "kayak/Canoe";break;
			case 4:this.boatType  = "Other";break;
		}
    }

    public double getLength() {
        return this.boatLength;
    }

    public String getType() {
        return this.boatType;
    }

    public int getBoatId() {
        return this.boatId;
    }
     
}
