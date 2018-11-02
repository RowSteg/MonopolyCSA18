public class Property extends Space{

	private final String color;
	private final int price;
	private int rent;
	
	
	public Property(String name, int xPos, int yPos, String color, int price) {
		super(name, xPos, yPos);
		this.color = color;
		this.price = price;
	}
	
	public String getColor() {
		return color;
	}
	public int getPrice() {
		return price;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int x) {
		rent = x;
	}
}
