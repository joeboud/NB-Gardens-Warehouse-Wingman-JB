import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args){
		
		int selectedOption;
		String table;
		String user = "Alex";
		
		DBConnect connection = new DBConnect();
		
		System.out.println("Welcome to W-W-W-WAREHOUSE W-W-W-WINGMAAAAAN!!!!! v1.0 (TM)");
		System.out.println(" ");
		System.out.println("-----------MENU-----------");
		System.out.println(" ");
		System.out.println("1. List Current Orders");
		System.out.println("2. Assign Orders");
		System.out.println("3. Update Order Status");
		System.out.println("4. Process Purcase Order");
		System.out.println("5. Generate Random Orders");
		System.out.println(" ");
		System.out.println("--------------------------");
		
		Scanner scan = new Scanner(System.in);
		selectedOption = scan.nextInt();
		
		
		switch(selectedOption){
		case 1:
			System.out.println("-----Current Order List-----");
			
			/*System.out.println("Please Select a table to read: 1 = Customer, 2 = Products, 3 = Stock List.");
			
			Scanner scan1 = new Scanner(System.in);
			int option = scan1.nextInt();
			
				if (option == 1){
				table = "customerdb";
				System.out.println("Printing " +table);
				dbread.setTable(table);
				//dbread.DBRead(sql);
				}
				else if(option == 2){
				table = "productdb";
				System.out.println("Printing " +table);
				dbread.setTable(table);
				//dbread.DBRead(sql);
				}
				if(option == 3){
				table = "stockdb";
				System.out.println("Printing " +table);
				dbread.setTable(table);
				//dbread.DBRead(sql);
				} */
			break;
		case 2:
			System.out.println("-----Currently Unassigned Orders-----");
			//list unassigned orders
			DBReader2 listUnassigned = new DBReader2();
			table = "orderdb";
			listUnassigned.setTable(table);
			String unassignedSQL = "SELECT * FROM orderdb WHERE assigned = 0";
			listUnassigned.DBRead(unassignedSQL);
			ArrayList<ArrayList<Comparable>> result = listUnassigned.result;
			
			System.out.println("Currently unassigned orders:");
			int noOfOrders = result.size();
			
			for (int i = 0 ; i <= noOfOrders; i++){
				ArrayList<Comparable> results = result.get(i);
				System.out.println("Order Number:" + results.get(0));
				System.out.println("Customer ID:" + results.get(1));
				System.out.println("Date Placed:" + results.get(2));
				System.out.println("Total Value:" + results.get(3));
			}
			
			System.out.println("Please enter the Order Number you would like to assign yourself to:");
			Scanner scan1 = new Scanner(System.in);
			int selectedOrder = scan1.nextInt();
			//use selectedOrder in SQL statement to update to assigned = true
			String sql = ("UPDATE orderdb SET assigned= 'TRUE' WHERE orderNo= '" + selectedOrder + "'");
			DBCreator statusUpdate = new DBCreator();
			statusUpdate.DBCreate(sql);
			
			System.out.println("Order " + selectedOrder + "is now Assigned to " + user);
			
			break;
		case 3:
			System.out.println("-----Assigned Orders-----");
			//list assigned orders
			System.out.println("This Feature has not yet been implemented!");
			break;
		case 4:
			System.out.println("-----Incoming Purchase Orders-----");
			System.out.println("Which Purchase Order has arrived?");
			// List of PO ID numbers
			System.out.println("This Feature has not yet been implemented!");
			break;
		case 5:
			System.out.println("----Random Order Generation----");
			OrderGen generate = new OrderGen();
			generate.GenOrders(connection);				//nullPointerException
			break;
		default:
			System.out.println("Please rerun the program and enter a number between 1-5");
			break;
			
		}
		
		//function to update StatusTracker
		
		//function to allow user to archive orders
	}
}
