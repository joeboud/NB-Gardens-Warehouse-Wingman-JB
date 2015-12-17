import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class OrderGen {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 
	String DB_URL = "jdbc:mysql://localhost:3306/nbgmaindb";

	String USER = "joeboud";
	String PASS = "t3cni110n";

	String table;
	
	StatusTracker.Statuses status;
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public void DBUpdate(){
		
		System.out.println("DBUpdater Initialised");
		
		try {
			System.out.println("Attempting to connect to the database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null)
				System.out.println("Connection Successfull!");
		}catch (Exception e){
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		
		Random rand = new Random();
		int noOfOrders = rand.nextInt();
		int count1 = 1;
		
		for (count1 : noOfOrders : 1++){
			
			Random rand = new Random();
			
			int id = rand.nextInt();			//generate product
			int quantity = rand.nextInt();		//generate quantity
			
			String sql = ("SELECT price FROM orderlinedb WHERE id = '" + id + "'");
			DBReader2 inst = new DBReader2();
			inst.DBRead(sql);
			double price = inst.price;						//gets price from productdb
			double lineValue = price*quantity;				//calculates total live value
		}
		
		if (table == "orderdb"){
			Random rand = new Random();
			
			int orderNo = rand.nextInt(999);		//generate order number
			int customerID = rand.nextInt(120);		//generate customer
			//date placed
			int totalValue;							//calculate total value?
			
			// Summing an array. From Will
			int sum = 0;
			for(num : nums) {
				totalValue += num;
			}
			
			
			int statusChoice = rand.nextInt(5);
			switch (statusChoice){
			case 1:
				status = StatusTracker.Statuses.WAITING;
			case 2:
				status = StatusTracker.Statuses.PICKED;
			case 3:
				status = StatusTracker.Statuses.PACKED;
			case 4:
				status = StatusTracker.Statuses.DESPATCHED;
			case 5:
				status = StatusTracker.Statuses.ARCHIVED;
			}
			boolean assigned = rand.nextBoolean();
			String assignedTo = "Alex";

		}
		

	}
}
