
public class Space {
	
	private final String name;
	private final int xPos;
	private final int yPos;
	public Space(String name, int xPos, int yPos) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
}
