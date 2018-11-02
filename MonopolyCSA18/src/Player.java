
public class Player {
	String name;
	int xPos;
	int yPos;
	int amountOfMoney;
	
	public Player(String name) {
		this.name = name;
		xPos = 10;
		yPos = 10;
		amountOfMoney = 1500;
	}
	
	public int[] getPos() {
		return new int[] {xPos, yPos};
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getAmountOfMoney() {
		return amountOfMoney;
	}
	
	public void setAmountOfMoney(int x) {
		this.amountOfMoney = x;
	}
	
	public String getName() {
		return name;
	}
}
