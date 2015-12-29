import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class DateTest {
	
	public void dates() throws ParseException{
	
	System.out.println("hello");

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	Date dateOne = df.parse("2011-02-08 10:00:00 +0100");
	


	
	Random rand = new Random();
	
	}
}
