import java.util.ArrayList;
 public class Player {
 	private String name;
 	private String color;
 	private int xPos;
 	private int yPos;
 	private int amountOfMoney;
 	private int space=0;
 	
 	private int railroadsOwned;
 	private int utilsOwned;
 	ArrayList<Space> owned;
 	
 	private boolean inJail;
 	private int jailCards;
 	
 	public Player(String name, String color) {
 		this.name = name;
 		this.color = color;
 		xPos = 0;
 		yPos = 10;
 		amountOfMoney = 1500;
 		jailCards = 0;
 	}
 	
 	public String getColor() {
 		return this.color;
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
	
	public void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
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
	
	//number of certain types
	public int getRailroadsOwned() { 
		return railroadsOwned;
	}	
	public int getUtilsOwned() {
		return utilsOwned;
	}
	
	public void playMove(int x, Gameboard board) {
		this.space+=x;
		
		while(space+1>board.getSize()) {
			space-=board.getSize();

			this.amountOfMoney+=200;

			this.amountOfMoney += 200;

		}
		
		Space spac = board.getSpace(this.space);
		this.setPosition(spac.getXPos(), spac.getYPos());
	}
	 
	//buy stuff
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
 	
 	//jail
 	public void goToJail() {
 		xPos = 10;
 		yPos = 10;
 		inJail = true;
 	}
 	public void getOutJail() {
 		inJail = false;
 	}
	
 	public ArrayList<Space> getOwned(){
 		return owned;
 	}
 	
 	public int getJailCards() {
 		return jailCards;
 	}
 	
 	public void addJailCard() {
 		jailCards++;
 	}
 	
 	public void removeJailCard() {
 		if(jailCards > 0) {
 			jailCards--;
 		}
 	}
 	
 	public void setJailCards(int n) {
 		jailCards = n;
 	}
 	
	public void doSpace(Gameboard board) {
		
		Space temp = board.getSpace(xPos, yPos);
		
		if(temp instanceof Railroad) { //Railroads. Different from above if because needs check for multiple railroads
			
			Railroad current  = (Railroad) temp;
			if(current.isOwned()) {
				amountOfMoney -= 25 * Math.pow(2, current.getOwner().getRailroadsOwned()-1);
			}
			else {
				this.buyRailroad(current);
				//player must either buy or auction the property
			}
		}
		
		else if(temp instanceof Property) { //properties
			Property current = (Property) temp;
			if(current.isOwned()) {
				//pay rent
				//amountOfMoney -= current.getRent();
			}
			else {
				//this.buyProperty(current);
				//player must either buy or auction the property. Never a time when it is not bought when landed on.
				
				//TODO auction functionality still needed
			}
		}
		
		else if(temp instanceof Utility) { //Utilities. Different from above ifs because needs dice check and check for multiple ownership
			
			Utility current = (Utility) temp;
			if(current.isOwned()) {
				//amountOfMoney -= (current.getOwner().getUtilsOwned() == 1) 4 * diceRoll : 10 * diceRoll;
			}
			else {
				this.buyUtility(current);
				//player must either buy or auction the property
			}
		}
		
		else{ //go, jail/visiting,  free parking, go to jail
			
			switch(temp.getName()) {
				case "go":
					amountOfMoney += 200;
					break;
					
				case "jail": 
					//use get out of jail free card, buying card from other player(complicated?), paying 50
					break;
 				case "go to jail":
					xPos = 10;
					yPos = 10;
					inJail = true;
					break;
					
				//free parking does nothing, so no case
			}
		}
		
		System.out.println(this.name + " has " + this.amountOfMoney);
	}
	
	public int getSpace() {
		return this.space;
	}
}