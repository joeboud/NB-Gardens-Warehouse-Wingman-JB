import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class OrderGen {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String table;
	
	StatusTracker.Statuses status;
	double price;
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void GenOrders(){
		
		System.out.println("Generating Orders...");
		
		DBCreator creatorgen = new DBCreator();	//initialises the dbcreator
		DBReader2 dbread = new DBReader2();
		Random rand = new Random();
		
		int orderNo = rand.nextInt(999);		//generate order number
		int customerID = rand.nextInt(120);		//generate customer
		BigDecimal totalValue = BigDecimal.ZERO;	

		int noOfLines = (rand.nextInt(6) + 1);		//chooses max number order lines
		String table = "productdb";
		dbread.setTable(table);
		creatorgen.setTable(table);
		
		for (int count1 = 0 ; count1 <= noOfLines; count1++){
			
			
			System.out.println("Generating line " + count1);
			
			int id = (rand.nextInt(107) + 10000);			//generate product
			int quantity = (rand.nextInt(10) + 1);		//generate quantity
			
			String sqlread = ("SELECT * FROM productdb WHERE id = " + id);
			
			//dbread.DBConnect();
			dbread.DBRead(sqlread);
			ArrayList<ArrayList<Comparable>> result = dbread.result;
			ArrayList<Comparable> results = result.get(0);
			double getPrice = (double) results.get(2);						//gets price from productdb
			BigDecimal price = BigDecimal.valueOf(getPrice);
			System.out.println("Price:" + price);
			BigDecimal lineValue = price.multiply( new BigDecimal(quantity));				//calculates total line value
			System.out.println("Line value:" + lineValue);
			boolean pW = rand.nextBoolean();
			int porousware = (pW) ? 1 : 0;
			double pwValue = 1.3;
			
			if (porousware == 1){
				lineValue = lineValue.multiply( new BigDecimal(pwValue));
			}
			
			totalValue = totalValue.add(lineValue);
			
			String sqlcreate = ("INSERT INTO orderlinedb VALUES ('" + orderNo + "','" +  id + "','" + quantity + "','" + porousware + "','" + lineValue + "')");
			creatorgen.DBCreate(sqlcreate);
		}
		
		String assignedTo = "N/A";
		
		boolean assigned = rand.nextBoolean();
		if (assigned){
		assignedTo = "Alex";
		}
		
		String datePlaced = "27/12/2015";
		table = "orderdb";
		creatorgen.setTable(table);
		String sqlcreate = ("INSERT INTO orderdb VALUES ('" + orderNo + "','" + customerID + "','" + datePlaced + "','" + totalValue + "','" + status + "','" + assigned + "','" + assignedTo + "')");
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

