import java.util.Observable;

public class CustomerOrder extends Order 
{
	int customerID;
	String name;
	String address;
	StatusTracker.Statuses status;
	
	
	
	public void timeLimit(){
		
		// generate latest despatch date and calculate time remaining
		
	}



	// -------Random Order Generation------
	
	
	public void setCustomerID(int customerid2) {
		this.customerID = customerID;
		// TODO Auto-generated method stub
	}
	public void setNoItems(int noItems) {
		this.customerID = customerID;
		
		// TODO Auto-generated method stub
	}

	// ---------------------------------------

	//Method to observe StatusTracker and update orderStatus

	
	
	//status list
	//waiting: no change
	//picked: update stock levels
	//packed: no change
	//despatched: no change
}
