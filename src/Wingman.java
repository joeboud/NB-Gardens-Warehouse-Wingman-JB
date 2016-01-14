import java.util.ArrayList;
import java.util.Scanner;

public class Wingman {
	
	public void Run(){
		
	}
	
	int selectedOption;
	
	public void setSelectedOption(int selectedOption){
		this.selectedOption = selectedOption;
	}

	public void RealMain(){
		
	
	String table;
	String user = "Alex";
	
	DBConnect connection = new DBConnect();
	connection.Connect();
	
	System.out.println("Welcome to W-W-W-WAREHOUSE W-W-W-WINGMAAAAAN!!!!! v1.0 (TM)");
	System.out.println(" ");
	System.out.println("-----------MENU-----------");
	System.out.println(" ");
	System.out.println("1. List Current Orders");
	System.out.println("2. Assign Orders");
	System.out.println("3. Update Order Status");
	System.out.println("4. Create Purchase Order");
	System.out.println("5. Process Purchase Order");
	System.out.println("6. Generate Random Orders");
	System.out.println(" ");
	System.out.println("--------------------------");
	
	Scanner scan = new Scanner(System.in);
	selectedOption = scan.nextInt();
	
	int noOfOrders;
	switch(selectedOption){
	case 1:
		System.out.println("-----Current Order List-----");
		
		DBReader2 listAll1 = new DBReader2();				//first instance of DBRead for order display
		table = "orderdb";
		listAll1.setTable(table);
		String sql = "SELECT * FROM orderdb";
		listAll1.DBRead(sql);
		ArrayList<ArrayList<Comparable>> results1 = listAll1.result;
		
		System.out.println("---Currently Active Orders---");
		noOfOrders = results1.size();
		
		for (int i = 0 ; i < noOfOrders; i++){
			ArrayList<Comparable> result1 = results1.get(i);
			System.out.println("---Order: " + i + " ---");
			System.out.println("Order Number: " + result1.get(0));
			System.out.println("Customer ID: " + result1.get(1));
			System.out.println("Date Placed: " + result1.get(2));
			System.out.println("Total Value: " + result1.get(3));
			System.out.println("Assigned to: " + result1.get(6));
			System.out.println("Status: " + result1.get(4));
			System.out.println("\n");
		}
		
		System.out.println("Select an Order to view more details");
		Scanner scan1 = new Scanner(System.in);
		int selectedOrder = scan1.nextInt();
		ArrayList<Comparable> result1 = results1.get(selectedOrder);	//take single digit entry and translate to order number
		int orderNo = (int) result1.get(0);
		DBReader2 listAll2 = new DBReader2();				//second instance of DBRead for order line display
		table = "orderlinedb";
		listAll2.setTable(table);
		
		sql = ("SELECT * FROM orderlinedb WHERE orderNo= '" + orderNo + "'");
		System.out.println(sql);
		listAll2.DBRead(sql);
		
		ArrayList<ArrayList<Comparable>> result2 = listAll2.result;
		
		System.out.println("---Order Details---");
		int noOfObjects = result2.size();
		System.out.println("Product ID \t Quantity \t Porousware \t Line Value");
		for (int i = 0 ; i < noOfObjects; i++){
			ArrayList<Comparable> results = result2.get(i);
			System.out.println(results.get(1) + "\t" + results.get(2) + "\t" + results.get(3) + "\t" + results.get(4));
		}
		
		DBReader2 listAll3 = new DBReader2();				//third instance of DBRead for customer detail display
		table = "customerdb";
		ArrayList<Comparable> custResult = results1.get(1);	//retrieve customer order number
		String selectedCustomer = (String) custResult.get(1);
		listAll3.setTable(table);
		sql = ("SELECT * FROM customerdb WHERE id= '" + selectedCustomer + "'");
		listAll3.DBRead(sql);									//use order number to retrieve customer details
		ArrayList<ArrayList<Comparable>> results3 = listAll3.result;
		
		System.out.println("---Customer Details---");			//print customer details
		ArrayList<Comparable> result3 = results3.get(0);
		System.out.println("Full Name: " + result3.get(1) + " " + result3.get(2));
		System.out.println("Delivery Address: ");
		System.out.println("\t" + result3.get(3));
		System.out.println("\t" + result3.get(4));
		System.out.println("\t" + result3.get(5));
		System.out.println("\t" + result3.get(6));
		System.out.println("Telephone Number: " + result3.get(7));
		System.out.println("Email: " + result3.get(8));
		System.out.println("\n");
		
		
		break;
	case 2:
		System.out.println("-----Currently Unassigned Orders-----");
		//list unassigned orders
		DBReader2 listUnassigned = new DBReader2();
		table = "orderdb";
		listUnassigned.setTable(table);
		String unassignedSQL = "SELECT * FROM orderdb WHERE assigned = 0";
		listUnassigned.DBRead(unassignedSQL);
		ArrayList<ArrayList<Comparable>> results4 = listUnassigned.result;
		
		System.out.println("Currently unassigned orders:");
		noOfOrders = results4.size();
		
		for (int i = 0 ; i <= noOfOrders; i++){
			ArrayList<Comparable> result4 = results4.get(i);
			System.out.println("Order Number:" + result4.get(0));
			System.out.println("Customer ID:" + result4.get(1));
			System.out.println("Date Placed:" + result4.get(2));
			System.out.println("Total Value:" + result4.get(3));
		}
		
		System.out.println("Please enter the Order Number you would like to assign yourself to:");
		Scanner scan2 = new Scanner(System.in);
		selectedOrder = scan2.nextInt();
		//use selectedOrder in SQL statement to update to assigned = true
		sql = ("UPDATE orderdb SET assigned= 'TRUE', assignedTo= '" + user + "' WHERE orderNo= '" + selectedOrder + "'");
		DBCreator statusUpdate = new DBCreator();
		statusUpdate.DBCreate(sql);
		
		System.out.println("Order " + selectedOrder + "is now Assigned to " + user);
		
		break;
	case 3:
		System.out.println("-----Assigned Orders-----");

		DBReader2 listAssigned = new DBReader2();
		table = "orderdb";
		listAssigned.setTable(table);
		String assignedSQL = "SELECT * FROM orderdb WHERE assigned = 1";
		listAssigned.DBRead(assignedSQL);
		ArrayList<ArrayList<Comparable>> results5 = listAssigned.result;
		
		System.out.println("Currently unassigned orders:");
		noOfOrders = results5.size();
		
		for (int i = 0 ; i <= noOfOrders; i++){
			ArrayList<Comparable> result5 = results5.get(i);
			System.out.println("Order Number: " + result5.get(0));
			System.out.println("Customer ID: " + result5.get(1));
			System.out.println("Date Placed: " + result5.get(2));
			System.out.println("Total Value: " + result5.get(3));
			System.out.println("Assigned to: " + result5.get(6));
			System.out.println("Status: " + result5.get(4));
		}
		
		break;
	case 4:
		System.out.println("-----Create a Purchase Order-----");
		System.out.println("\n-----Items with low stock-----");
		DBReader2 lowStockCheck = new DBReader2();
		table = "stockdb";
		lowStockCheck.setTable(table);
		String stockSQL = "SELECT * FROM stockdb";
		lowStockCheck.DBRead(stockSQL);
		ArrayList<ArrayList<Comparable>> results6 = lowStockCheck.result;
		int noOfItems = results6.size();
		
		for (int i = 0 ; i <= noOfItems; i++){
			ArrayList<Comparable> result6 = results6.get(i);
			int currentStock = (int) result6.get(1);
			int threshold = (int) result6.get(3);
			if (currentStock <= threshold){
				System.out.println(result6.get(0));
			}
		}
		System.out.println("Would you like to add these items to a purchase order?");
		Scanner scan3 = new Scanner(System.in);
		Boolean lowStockAdd = scan3.nextBoolean();
		if (lowStockAdd){
			//TODO Add these items to proto order
		}
		System.out.println("Please enter any aditional item numbers to add to the Purchase Order");
		System.out.println("This feature is not yet implemented!");
		break;
	case 5:
		System.out.println("-----Incoming Purchase Orders-----");
		DBReader2 listPO = new DBReader2();
		table = "podb";
		listPO.setTable(table);
		String poSQL = "SELECT * FROM podb";
		listPO.DBRead(poSQL);
		ArrayList<ArrayList<Comparable>> results7 = listPO.result;

		System.out.println("Current active Purchase Orders:");
		noOfOrders = results7.size();
		
		for (int i = 0 ; i <= noOfOrders; i++){
			ArrayList<Comparable> result7 = results7.get(i);
			System.out.println("Order Number: " + result7.get(0));
			System.out.println("Date Placed: " + result7.get(2));
			System.out.println("Total Value: " + result7.get(1));
			System.out.println("Ordered By: " + result7.get(3));
		}
		
		System.out.println("Which Purchase Order has arrived? Please enter the Order Number: ");
		Scanner scan4 = new Scanner(System.in);
		selectedOrder = scan4.nextInt();
		//use selectedOrder in SQL statement to update to arrivedS = true
		sql = ("UPDATE purchaseorderdb SET arrived= 'TRUE' WHERE orderNo= '" + selectedOrder + "'");
		DBCreator poStatusUpdate = new DBCreator();
		poStatusUpdate.DBCreate(sql);
		
		break;
	case 6:
		System.out.println("----Random Order Generation----");
		OrderGen generate = new OrderGen();
		generate.GenOrders();
		break;
	default:
		System.out.println("Please rerun the program and enter a number between 1-5");
		break;
		
	
	}
	//function to update StatusTracker
	
	//function to allow user to archive orders
}
}
