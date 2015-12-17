import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Query {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 
	String DB_URL = "jdbc:mysql://localhost:3306/nbgmaindb";

	String USER = "joeboud";
	String PASS = "t3cni110n";

	String table;


	public void setTable(String table) {
		this.table = table;
	}
	
	public ResultSet DBQuery(){
		System.out.println("Querying the database...");
		
		try {
			System.out.println("Attempting to connect to the database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null)
				System.out.println("Connection Successfull!");
		}catch (Exception e){
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		
		
		
		
		return rs;
		
		
	}

}
