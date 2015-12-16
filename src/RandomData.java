import java.util.Random;

public class RandomData {

	public CustomerOrder generateCO(CustomerOrder randCustomerOrder){
		
		Random rand = new Random();
		int noItems = rand.nextInt(20);
		int quantity = rand.nextInt(10);
		int customerid = rand.nextInt(120);
		
		randCustomerOrder.setNoItems(noItems);
		randCustomerOrder.setRandQuantity(quantity);
		randCustomerOrder.setRandCustomerID(customerid);
		
		return randCustomerOrder;
		
	}
	
}