import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBReader {

		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 
		String DB_URL = "jdbc:mysql://localhost:3306/nbgmaindb";

		String USER = "joeboud";
		String PASS = "t3cni110n";
		String table;

		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 
			 public void DBRead(){
				 
				 if (table == "customerdb"){
					 String sql2 = ("SELECT id, firstName, secondName, addressLine1, addressLine2, county, postecode, telNo, email FROM " + table);
					
					 try {
						 System.out.println("Reading: " + table);
						 stmt = conn.createStatement();
						 ResultSet rs = stmt.executeQuery(sql2);
						 
					while (rs.next()) {
						
					
						int id = rs.getInt("id");	
						String customerName = rs.getString("name");
						String firstName = rs.getString("firstName");
						String secondName = rs.getString("secondName");
						String addressLine1 = rs.getString("addressLine1");
						String addressLine2 = rs.getString("addressLine2");
						String county = rs.getString("county");
						String postcode = rs.getString("postcode");
						String telNo = rs.getString("telNo");
						String email = rs.getString("email");
					}
					}
				 
					else if (table == "stockdb"){
					 String sql2 = ("SELECT id, level, pwlevel, threshold, pwThreshold, onSale, section, row, stack, shelf FROM " + table);
					
						 System.out.println("Reading: " + table);
						 stmt = conn.createStatement();
						 
						 ResultSet rs = stmt.executeQuery(sql2);
					while (rs.next()) {
						int id = rs.getInt("id");
						int level = rs.getInt("level");
						int pwlevel = rs.getInt("pwlevel");
						int threshold = rs.getInt("threshold");
						int pwThreshold = rs.getInt("pwThreshold");
						Boolean onSale = rs.getBoolean("onSale");
						String section = rs.getString("section");
						int row = rs.getInt("row");
						int stack = rs.getInt("stack");
						int shelf = rs.getInt("shelf");
					}
					}
					else if (table == "productdb"){
					 String sql2 = ("SELECT id, name, price, type, colour, picture FROM " + table);
					 
						 System.out.println("Reading: " + table);
						 stmt = conn.createStatement();
						 
						 ResultSet rs = stmt.executeQuery(sql2);
					while (rs.next()) {
						int id = rs.getInt("id");
						String productName = rs.getString("name");
						double price = rs.getDouble("price");
						String type = rs.getString("type");
						String colour = rs.getString("colour");
						String picture = rs.getString("picture");
						System.out.println("ID: " + id + ", name: " + productName);
					}
						
				 }
					 }
					
					}
				rs.close();


	            if (rs.next()) {
	                System.out.println(rs.getString(1));
	            }

	        } catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(Main.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        }
		  finally {
			  try {
				
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
			  }
		  }
		 
		 
	 
}
}
				 