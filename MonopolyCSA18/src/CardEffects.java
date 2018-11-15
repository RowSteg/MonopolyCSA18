import java.util.ArrayList;

public class CardEffects {

	public static void checkCard(Card card, Player player, Gameboard board) {
		switch(card.getEffect()) {
		case "MOVEMENT":
			//set player position based on modifier and check if they passed go
			String spaceName = card.getModifier();
			int currentPos = board.getPosition(board.getSpace(player.getXPos(), player.getYPos()));
			switch(spaceName) {
			case "UTIL":
				//if the player's current position is between 0-12, electric company, didn't pass go
				//if the player's current position is between 13-28, water works, didn't pass go
				//if the player's current position is between 29-40, electric company, passed go
				Utility utility;
				if(currentPos <=12) {
					utility = (Utility) board.getSpace(13);
					player.setPosition(2, 0);
				}
				else if(currentPos <= 28) {
					utility = (Utility) board.getSpace(29);
					player.setPosition(10, 8);
				}
				else {
					utility = (Utility) board.getSpace(13);
					player.setPosition(2, 0);
					player.setAmountOfMoney(player.getAmountOfMoney() + 200);
					
				}
				if(utility.isOwned()) {
					//pay owner 10x dice roll
					int[] diceRoll = Dice.rollDice();
					int rent = 10 * (diceRoll[0] + diceRoll[1]);
					player.setAmountOfMoney(player.getAmountOfMoney() - rent);
					Player owner = utility.getOwner();
					owner.setAmountOfMoney(owner.getAmountOfMoney() + rent);
				}
				else {
					player.doSpace(board);
				}
				break;
			case "RAIL":
				//if the player's current position is between 0-5, reading, didn't pass go
				//if the player's current position is between 6-15, Pennsylvania, didn't pass go
				//if the player's current position is between 16-25, B&O, didn't pass go
				//if the player's current position is between 26-35, short line, didn't pass go
				//if the player's current position is between 36-40, reading, passed go
				Railroad railroad;
				if(currentPos <= 5) {
					railroad = (Railroad) board.getSpace(6);
					player.setPosition(0, 5);
				}
				else if(currentPos <= 15) {
					railroad = (Railroad) board.getSpace(16);
					player.setPosition(5, 0);
				}
				else if(currentPos <= 25) {
					railroad = (Railroad) board.getSpace(26);
					player.setPosition(10, 5);
				}
				else if(currentPos <= 35) {
					railroad = (Railroad) board.getSpace(36);
					player.setPosition(5, 10);
				}
				else {
					railroad = (Railroad) board.getSpace(6);
					player.setPosition(0, 5);
					player.setAmountOfMoney(player.getAmountOfMoney() + 200);
				}
				if(railroad.isOwned()) {
					//pay owner 2x normal rent
					Player owner = railroad.getOwner();
					int owned = owner.getRailroadsOwned();
					int rent = (int) (50 * Math.pow(2, owned - 1));
					player.setAmountOfMoney(player.getAmountOfMoney() - rent);
					owner.setAmountOfMoney(owner.getAmountOfMoney() + rent);
				}
				else {
					player.doSpace(board);
				}
				break;
			case "GO":
				//move the player to go and give them $200
				player.setPosition(0, 10);
				player.setAmountOfMoney(player.getAmountOfMoney() + 200);
				break;
			default:
				//find the space mentioned on the card and send the player there
				for(Space space : board.getBoard()) {
					if(space.getName().equals(spaceName)) {
						player.setPosition(space.getXPos(), space.getYPos());
						if(board.getPosition(space) <= currentPos) {
							player.setAmountOfMoney(player.getAmountOfMoney() + 200);
						}
						player.doSpace(board);
					}
				}
				break;
			}
			break;
		case "MONEY":
			switch(card.getModifier()) {
			case "NULL": //no modifier
				switch(card.getDirection()) {
				case "ADD":
					player.setAmountOfMoney(player.getAmountOfMoney() + card.getAmount());
					break;
				case "SUBTRACT":
					player.setAmountOfMoney(player.getAmountOfMoney() - card.getAmount());
					break;
				}
				break;
			case "PLAYER":
				switch(card.getDirection()) {
				case "ADD": //TODO
					//steal money from everyone else
					break;
				case "SUBTRACT": //TODO
					//gift money to everyone else
					break;
				}
				break;
			case "LEVELS":
				//for every property the player owns, they must pay based on houses and hotels
				ArrayList<Space> owned = player.getOwned();
				for(Space space : owned) {
					if(space instanceof Property && !(space instanceof Railroad)) {
						Property property = (Property) space;
						switch(property.getLevel()) {
						case 0:
							break;
						case 1:
						case 2:
						case 3:
						case 4:
							player.setAmountOfMoney(player.getAmountOfMoney() - card.getAmount());
							break;
						case 5:
							player.setAmountOfMoney(player.getAmountOfMoney() - card.getAmount2());
							break;
						}
					}
				}
				break;
			}
			break;
		case "KEEP":
			//player keeps get out of jail free card
			player.addJailCard();
			break;
		case "JAIL":
			//sends the player directly to jail without passing go
			player.goToJail();
			break;
		}
	}
}
