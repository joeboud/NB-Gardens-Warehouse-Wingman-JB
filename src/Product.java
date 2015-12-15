import java.lang.String;
import java.util.Currency;


public class Product {

	int productID;
	String type;
	Currency value;
	Currency price;
	String colour;
	String picture;
	
	public Product(int productID, String type, Currency value, Currency price, String colour, String picture){
		this.productID = productID;
		this.type = type;
		this.value = value;
		this.price = price;
		this.colour = colour;
		this.picture = picture;			//this will be a file address
	}
	
	//product must be able to be "removed from stock", have "removed from sale" state
}
