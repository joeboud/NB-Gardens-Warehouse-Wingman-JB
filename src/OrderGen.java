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
	double price;
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void GenOrders(DBReader2 dbread){
		
		System.out.println("Generating Orders...");
		
		DBCreator creatorgen = new DBCreator();
		Random rand = new Random();
		
		int orderNo = rand.nextInt(999);		//generate order number
		int customerID = rand.nextInt(120);		//generate customer
		double totalValue = 0;	

		int noOfLines = rand.nextInt(6);
		String table = "productdb";
		dbread.setTable(table);
		creatorgen.setTable(table);
		
		for (int count1 = 0 ; count1 <= noOfLines; count1++){
			
			
			Random rand1 = new Random();
			
			System.out.println("Generating line " + count1);
			
			int id = (rand1.nextInt(107) + 10000);			//generate product
			int quantity = rand.nextInt(10);		//generate quantity
			
			String sqlread = ("SELECT * FROM productdb WHERE id = " + id);
			
			dbread.DBRead(sqlread);
			double price = dbread.price;						//gets price from productdb
			double lineValue = price*quantity;				//calculates total live value
			boolean porousWare = rand1.nextBoolean();
			
			if (porousWare){
				lineValue = lineValue*1.3;
			}
			
			totalValue = totalValue + lineValue;
			
			String sqlcreate = ("INSERT INTO orderlinedb VALUES " + orderNo + "," +  id + "," + quantity + ",'" + porousWare + "'," + lineValue);
			creatorgen.DBCreate(sqlcreate);		//nullPointerException
		}
		
		String assignedTo = "N/A";
		
		boolean assigned = rand.nextBoolean();
		if (assigned){
		assignedTo = "Alex";
		}
		
		String datePlaced = "18/12/2015";
		table = "orderdb";
		creatorgen.setTable(table);
		String sqlcreate = ("INSERT INTO orderdb VALUES " + orderNo + "," + customerID + ",'" + datePlaced + "'," + totalValue + ",'" + status + "','" + assigned + "','" + assignedTo + "'");
		creatorgen.DBCreate(sqlcreate);
		
			
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

		}
	}

