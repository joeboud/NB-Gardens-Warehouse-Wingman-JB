import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	static Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 
	static String DB_URL = "jdbc:mysql://192.168.1.73:3306/ngbmaindb";

	static String USER = "root";
	static String PASS = "netbuilder";

		public void Connect(){
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
}
