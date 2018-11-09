
public class Player {
	private String name;
	private int xPos;
	private int yPos;
	private int amountOfMoney;
	
	private int railroadsOwned;
	private int utilsOwned;
	ArrayList<Space> owned;
	
	boolean inJail;
	
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
		
	private void buyProperty(Property p) {
		p.setOwner(this);
		owned.add(p);
	}
	
	private void buyRailroad(Railroad r) {
		r.setOwner(this);
		owned.add(r);
		railroadsOwned++;
	}
	
	private void buyUtility(Utility u) {
		u.setOwner(this);
		owned.add(u);
		utilsOwned++;
	}
	
	public void doSpace(Gameboard board) {
		Space temp = board.getSpace(xPos, yPos);
		if(temp instanceof Space) { //go, jail/visiting, free parking, go to jail
			
		}
		else if(temp instanceof Property) { //properties
			Property current = (Property) temp;
			if(current.isOwned()) {
				//pay rent
				amountOfMoney -= current.getRent();
			}
			else {
				//player must either buy or auction the property. Never a time when it is not bought when landed on.
				
			}
		}
		else if(temp instanceof Railroad) { //Railroads. Different from above if because needs check for multiple railroads
			
		}
		else if(temp instanceof Utility) { //Utilities. Different from above ifs because needs dice check and check for multiple ownership
			
		}
	}
}
