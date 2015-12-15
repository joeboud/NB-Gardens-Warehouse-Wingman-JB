import java.lang.String;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

public abstract class Order 
{
	
	// Fields here
	int orderID;
	Currency  orderValue;
	String dateDelivered;
	boolean archived;
	boolean assigned;
	String assignedTo;
	int location[];			//Location is location[0] = section, location[1] = shelf, location [2] = row
	Product[] products = new Product[6];
	
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
