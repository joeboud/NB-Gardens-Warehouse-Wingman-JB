
public class OrderLine {

	int quantity;
	double lineValue;
	Product product = new Product();
	
	public OrderLine(int quantity, double lineValue){
		this.quantity = quantity;
		this.lineValue = lineValue;
	}
	
	
	//Getters & Setters

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getLineValue() {
		return lineValue;
	}

	public void setLineValue(double lineValue) {
		this.lineValue = lineValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
