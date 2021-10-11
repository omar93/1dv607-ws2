package View;

import java.util.Scanner;

import Model.Boat;

public class BoatView {

    private Scanner Intscanner = new Scanner(System.in);
    private Scanner Stringscanner = new Scanner(System.in);

    private double boatLength;
    private String boatType;
    private int typeChoice;

    private String boatAlternatives = 
    "Sailboat\n"+
    "Motorsailer\n"+
    "kayak/Canoe\n"+
    "Other";


    public void showBoatsInformation(Boat boat) {
        System.out.println("Type: "+boat.getType());
        System.out.println("ID: "+boat.getLength()+"M");
        System.out.println("------------------------");
    }


    public Boat showInputForm() {
        System.out.println("Enter boat length");
        this.boatLength = Intscanner.nextInt();

        System.out.println("Enter boat type by pressing 1-4 and then Enter");
        System.out.print(boatAlternatives);
        this.typeChoice = Intscanner.nextInt();
        	
		switch (this.typeChoice) {
			case 1:this.boatType = "Sailboat";break;
			case 2:this.boatType  = "Motorsailer";break;
			case 3:this.boatType  = "kayak/Canoe";break;
			case 4:this.boatType  = "Other";break;
		}
        return (new Boat(this.boatType, this.boatLength));
    }

    // Scans id and returns it
	public String showBoatIdInput() {
        System.out.println("Enter of the boat you want to change in the order they are displayed");
		return Stringscanner.nextLine();
	}

     
}
