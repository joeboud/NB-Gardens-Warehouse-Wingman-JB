import java.lang.String;
import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

public abstract class Order 
{
	
	// Fields here
	Random rand = new Random();
	int orderID = rand.nextInt(999);
	Currency  orderValue;
	String datePlaced;
	String dateDelivered;
	boolean archived;
	boolean assigned;
	String assignedTo;		//Location is location[0] = section, location[1] = shelf, location [2] = row
	OrderLine orderLine = new OrderLine();
	
	public Order(){
	
	boolean orderFulfilled;
		if (orderFulfilled = true)
		{
		archived = true;				// function for archiving the order, will be replaced with a DB update function
		}
		
	}
	
	public void DateSetup() {
		
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
		try {
			Date datePlaced =df.parse("");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
}
