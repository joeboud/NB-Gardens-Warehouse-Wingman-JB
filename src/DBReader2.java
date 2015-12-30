import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBReader2 {

	static Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 
	static String DB_URL = "jdbc:mysql://localhost:3306/ngbmaindb";

	static String USER = "joeboud";
	static String PASS = "t3cni110n";

	String table;
	String sql;
	
	//variables needed by queries
	double price;
	
	ArrayList<ArrayList<Comparable>> result = new ArrayList<ArrayList<Comparable>>();
	ArrayList<Comparable> results = new ArrayList<Comparable>();

	public void setTable(String table) {
		this.table = table;
	}
	
	public static void DBConnect(){
		try {
			System.out.println("Attempting to connect to the database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null)
				System.out.println("Connection Successfull!");
		}catch (Exception e){
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<ArrayList<Comparable>> DBRead(String sql){
		
		System.out.println("DBReader Initialised");
		
		if (table == "customerdb"){
			
			
			try {
				 System.out.println("Reading: " + table);
				 stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					
					int customerID = rs.getInt("id");	
					String firstName = rs.getString("firstName");
					String secondName = rs.getString("secondName");
					String addressLine1 = rs.getString("addressLine1");
					String addressLine2 = rs.getString("addressLine2");
					String county = rs.getString("county");
					String postcode = rs.getString("postcode");
					String telNo = rs.getString("telNo");
					String email = rs.getString("email");
					System.out.println("ID: " + customerID + "\nFirst Name: " + firstName + "\nSecond Name: " + secondName + "\nAddress:" + "\n" + addressLine1 + "\n" + addressLine2 + "\n" + county + "\n" + postcode +"\nTelephone Number: " + telNo + "\nemail: " + email);

					
				}
				
	            if (rs.next()) {
	                System.out.println(rs.getString(1));
	            }
	            }
			
	            catch (SQLException ex) {
		            Logger lgr = Logger.getLogger(Main.class.getName());
		            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	            }
				}
			
			   
				  /*try {
					
				  if(rs!=null){
					  rs.close();
				  }
				  if (stmt !=null){
					  stmt.close();
				  }
				  if (conn != null) {
					  conn.close();
				  }
				  } 
				  catch (SQLException ex){
					Logger lgr = Logger.getLogger(Main.class.getName());
					lgr.log(Level.WARNING, ex.getMessage(), ex);
				  } */
			  
			  
		
	if (table == "stockdb"){
		
		
		try {
			 System.out.println("Reading: " + table);
			 stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
					int itemID = rs.getInt("id");
					int level = rs.getInt("level");
					int pwlevel = rs.getInt("pwlevel");
					int threshold = rs.getInt("threshold");
					int pwThreshold = rs.getInt("pwThreshold");
					Boolean onSale = rs.getBoolean("onSale");
					String section = rs.getString("section");
					int row = rs.getInt("row");
					int stack = rs.getInt("stack");
					int shelf = rs.getInt("shelf");
					System.out.println("ID: " + itemID + "\nAvailable Stock: " + level + "\nPorousWare(TM) Stock: " + pwlevel + "\nTreshold: " + threshold + "\nPW Threshold: " + pwThreshold + "\nAvailable for Sale: " + onSale + "\n ---Location---\nSection: " + section + "\nRow: " + row + "\nStack: " + stack + "\nShelf :" + shelf);

				
			}
			
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
            }
		
            catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(Main.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

            }
		}
		
		   
			 /* try {
				
			  if (rs !=null){
				  rs.close();
			  }
			  if (stmt !=null){
				  stmt.close();
			  }
			  if (conn != null) {
				  conn.close();
			  }
			  } 
			  catch (SQLException ex){
				Logger lgr = Logger.getLogger(Main.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			  } */
		  
		  
	
			if (table == "productdb"){
	
	
				try {
		 System.out.println("Reading: " + table);
		 stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery(sql);

		
		 	while (rs.next()) {
			System.out.println(sql);
			int itemID = rs.getInt("id");
			results.add(itemID);
			String productName = rs.getString("name");
			results.add(productName);
			double price = rs.getDouble("price");
			results.add(price);
			String type = rs.getString("type");
			results.add(type);
			String colour = rs.getString("colour");
			results.add(colour);
			String picture = rs.getString("picture");
			results.add(picture);
			result.add(results);
			System.out.println("ID: " + itemID + "\nProduct Name: " + productName + "\nPrice: £" + price + "\nType: " + type + "\nColour: " + colour + "\nPicture: " + picture);
		 	System.out.println("The price is: £" + price);
		 	}
		
        if (rs.next()) {
            System.out.println(rs.getString(1));
        }
        }
	
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
	}
			if (table == "orderdb"){
				
				try {
					 System.out.println("Reading: " + table);
					 stmt = conn.createStatement();
					 ResultSet rs = stmt.executeQuery(sql);
					 
					 while (rs.next()){
						 
						 System.out.println(sql);
							int orderNo = rs.getInt("orderNo");
							results.add(orderNo);
							String custID = rs.getString("customerID");
							results.add(custID);
							String datePlaced = rs.getString("datePlaced");
							results.add(datePlaced);
							double totalValue = rs.getDouble("totalValue");
							results.add(totalValue);
							String state = rs.getString("state");
							results.add(state);
							Boolean assigned = rs.getBoolean("assigned");
							results.add(assigned);
							String assignedTo = rs.getString("assignedTo");
							results.add(assignedTo);
							result.add(results);
					 }
				        if (rs.next()) {
				            System.out.println(rs.getString(1));
				        }
				}
		        catch (SQLException ex) {
		            Logger lgr = Logger.getLogger(Main.class.getName());
		            lgr.log(Level.SEVERE, ex.getMessage(), ex);

		        }
					 
				}

			
			return result;
	
	   
		 /* try {
			
		  if(rs!=null){
			  rs.close();
		  }
		  if (stmt !=null){
			  stmt.close();
		  }
		  if (conn != null) {
			  conn.close();
		  }
		  } 
		  catch (SQLException ex){
			Logger lgr = Logger.getLogger(Main.class.getName());
			lgr.log(Level.WARNING, ex.getMessage(), ex);
		  } */
		  
		  //String[] result = {Integer.toBinaryString(itemID), }
	  
	  
	}
}