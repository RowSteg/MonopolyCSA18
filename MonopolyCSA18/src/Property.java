import java.util.HashMap;
public class Property extends Space{

	private final String color;
	private final int price;
	private int level; // level 0 - 5 representing number of houses/ hotel.
	private HashMap<Integer, Integer> rents; // stores level as the key and rent price as the value
	private boolean owned;
	private Player owner;
	
	public Property(String name, int xPos, int yPos, String color, int price, int... rents) { //rents should always be an array of length 6
		super(name, xPos, yPos);
		this.color = color;
		this.price = price;
		this.level = 0;
		owned  = false;
		for(int i = 0; i < 6; i++) {
			this.rents.put(i,  rents[i]);
		}
	}
	
	//Color
	public String getColor() {
		return color;
	}
	
	//Price
	public int getPrice() {
		return price;
	}
	
	//Rent
	public int getRent() {
		return rents.get(level);
	}
	
	//Level
	public int getLevel() {
		return level;
	}
	public void setLevel(int x) {
		level = x;
	}
	public void levelUp() {
		level++;
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
