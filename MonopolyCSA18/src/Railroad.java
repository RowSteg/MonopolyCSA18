
public class Railroad extends Property{

	//rent is calculated by 25 * 2^(numberowned-1) -> up to 200
	//implemented in player
	
	public Railroad(String name, int xPos, int yPos, String color, int price, int housePrice, int... rents) {
		super(name, xPos, yPos, "GRAY", price, -1, rents);
	} 

}
