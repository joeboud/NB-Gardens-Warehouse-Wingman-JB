import java.lang.String;
import java.util.Currency;


public class Product {

	int productID;
	String name;
	String type;
	Currency price;
	String colour;
	String picture;
	Location location = new Location();
	
	public Product(){
		this.productID = productID;
		this.name = name;
		this.type = type;
		this.price = price;
		this.colour = colour;
		this.picture = picture;			//this will be a file address
	}
	
	//product must be able to be "removed from stock", have "removed from sale" state
}
