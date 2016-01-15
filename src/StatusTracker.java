import java.util.Observable;


public class StatusTracker extends Observable{

	public enum Statuses{
		WAITING,PICKED,PACKED,DESPATCHED,ARCHIVED;
		
		public static Statuses getRandom() {
	        return values()[(int) (Math.random() * values().length)];
	    }
	}	
	
	Statuses status = Statuses.WAITING;
	
	public static void Tracking(Statuses status){
		//receive "update status" command from Main
		//increase status by 1
		
	}
	
	
	public void Notification(Statuses status){
	switch (status){
	
		case PICKED:
			System.out.println("Order has been " + status);
			//command StockList to remove stock
			notifyObservers();
			break;
			
		case PACKED:
			System.out.println("Order has been " + status);
			notifyObservers();
			break;
			
		case DESPATCHED:
			System.out.println("Order has been " + status);
			notifyObservers();
			break;
			
		case ARCHIVED:
			System.out.println("Order has been " + status);
			notifyObservers();
			break;
			
		default:
			System.out.println("You cannot track an order that doesn't exist!");
			break;
			
		}
	}
}
