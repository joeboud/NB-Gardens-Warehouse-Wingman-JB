import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBCreator {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 
	String DB_URL = "jdbc:mysql://192.168.1.73:3306/nbgmaindb";

	String USER = "joeboud";
	String PASS = "t3cni110n";

	String table;
	
	StatusTracker.Statuses status;
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public void DBCreate(String sql){
		
		try {
			 System.out.println("Creating record in: " + table);
			 conn = DBReader2.conn;
			 stmt = conn.createStatement();					//nullPointerException
			 stmt.executeUpdate(sql);
		}
		catch (SQLException ex){
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
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
		
	}
}
