import java.util.Observable;
import java.util.Observer;


public class StockList {
	
	private void stockCheck(){
		
		int lowStockLimit = 0;
		int itemLimit = 0;
		int stockLevel = 0;
		int items[] = null;
		int noOfItems = items.length;
		

		

		if (stockLevel >= lowStockLimit || noOfItems >= itemLimit)
		{
			//use getLocations and getStock to generate low stock list
		}
		
		//function that checks stock periodically
		//function that populates low stock ID array
		//until a limit is reached
	}
	public void update(Observable obj, Object arg){
		//update stock level
		System.out.println("Item has been picked, stock level updated.");
	}
	
	public void getLowStockID()
	{
		// retrieve list of item IDs with low stock
	}
	
	public void getLocations(){
		//retrieve these locations
	}
	
	public void getStock(){
		//retrieve stock levels
	}
}
