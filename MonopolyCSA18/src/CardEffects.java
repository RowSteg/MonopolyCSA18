
public class CardEffects {

	public static void checkCard(Card card, Player player) {
		switch(card.getEffect()) {
		case "MOVEMENT":
			
		case "MONEY":
			
		case "KEEP":
			
		case "JAIL":
			player.gotojail();
			break;
		}
	}
	
	
}
