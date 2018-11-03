
public class Railroad extends Property{

	//Almost nothing unique about this class from property. May be TOTALLY unnecessary
	
	public Railroad(String name, int xPos, int yPos, int price, int... rents) {
		super(name, xPos, yPos, "Gray", price, -1, rents);
	}

}
