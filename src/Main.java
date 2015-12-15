import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args){
		
		int selectedOption;
		
		System.out.println("Welcome to W-W-W-WAREHOUSE W-W-W-WINGMAAAAAN!!!!! v1.0 (TM)");
		System.out.println(" ");
		System.out.println("-----------MENU-----------");
		System.out.println(" ");
		System.out.println("1. List Current Orders");
		System.out.println("2. Assign Orders");
		System.out.println("3. Mark Picked Orders");
		System.out.println("4. Process Purcase Order");
		System.out.println("5. Generate Random Orders");
		System.out.println(" ");
		System.out.println("--------------------------");
		
		Scanner scan = new Scanner(System.in);
		selectedOption = scan.nextInt();
		
		switch(selectedOption){
		case 1:
			System.out.println("-----Current Order List-----");
			//list all orders
			break;
		case 2:
			System.out.println("-----Currently Unassigned Orders-----");
			//list unassigned orders
			break;
		case 3:
			System.out.println("-----Assigned Orders-----");
			//list assigned orders
			break;
		case 4:
			System.out.println("-----Incoming Purchase Orders-----");
			System.out.println("Which Purchase Order has arrived?");
			// List of PO ID numbers
			break;
		case 5:
			System.out.println("Generating random orders...");
			//instantiate random class
		}
		
		//function to update StatusTracker
		
		//function to allow user to archive orders
	}
}
