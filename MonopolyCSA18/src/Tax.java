
public class Tax extends Space{
	
	final int price;

	public Tax(String name, int xPos, int yPos, int price) {
		super(name, xPos, yPos);
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

}
