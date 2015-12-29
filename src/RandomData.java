import java.util.Random;

public class RandomData {

	public CustomerOrder generateCustID(CustomerOrder randCustomerOrder){
		
		Random rand = new Random();
		
		int customerid = rand.nextInt(120);
		randCustomerOrder.setCustomerID(customerid);
		
		return randCustomerOrder;
		
		
	}
	
	public OrderLine generateQuant(OrderLine randQuant){
		
		Random rand = new Random();
		
		int quantity = rand.nextInt(10);
		randQuant.setQuantity(quantity);
		
		return randQuant;
		
	}
	
}