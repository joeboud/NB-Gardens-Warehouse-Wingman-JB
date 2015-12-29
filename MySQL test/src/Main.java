import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
		
public class Main {

	public static void main(String[] args){

		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			 
		 String DB_URL = "jdbc:mysql://localhost:3306/nbgmaindb";

		 String USER = "joeboud";
		 String PASS = "t3cni110n";

			 Connection conn = null;
			 Statement stmt = null;
			 ResultSet rs = null;
				 
			 try {
		            conn = DriverManager.getConnection(DB_URL, USER, PASS);
		            stmt = conn.createStatement();
		            rs = stmt.executeQuery("SELECT VERSION()");

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

	
	
