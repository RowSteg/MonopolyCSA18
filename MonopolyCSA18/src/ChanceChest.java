
public class ChanceChest extends Space{
	private final String chanceOrChest;

	public ChanceChest(String name, int xPos, int yPos, String chanceOrChest) {
		super(name, xPos, yPos);
		this.chanceOrChest = chanceOrChest;
	}
	
	public String getType() {
		return chanceOrChest;
	}

}
