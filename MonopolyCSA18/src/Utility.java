public class Utility extends Space{

	final int price;
	final int mortgage;
	
	private boolean owned;
	private Player owner;
	
	//calculating rent may be annoying and I don't think it should be done in this class
	//will probably be calculated in player class
	 
	public Utility(String name, int xPos, int yPos, int price) {
		super(name, xPos, yPos);
		this.price = 150;
		this.mortgage = price/2;
	}
	
	//Price
	public int getPrice() {
		return price;
	}
	
	//Mortgage
	public int getMortgage() {
		return mortgage;
	}
	
	//Ownership
	public boolean isOwned() {
		return owned;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player p) {
		owned = true;
		owner = p;
	}
}
