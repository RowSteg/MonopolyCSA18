public class Card {
	private final String event; 
	private final String effect;
	private final String direction;
	private final int amount;
	private final int amount2;
	private final String modifier;
	
	public Card(String event, String effect, String direction, int amount, int amount2, String modifier) {
		this.event = event;
		this.effect = effect;
		this.direction = direction;
		this.amount = amount;
		this.amount2 = amount2;
		this.modifier = modifier;
	}
	
	public String getEvent() {
		return this.event;
	}
	
	public String getEffect() {
		return this.effect;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public int getAmount2() {
		return this.amount2;
	}
	
	public String getModifier() {
		return this.modifier;
	}
}
