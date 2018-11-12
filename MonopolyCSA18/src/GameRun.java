
public class GameRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gameboard yeet = new Gameboard("RawSpacesList.txt");
		
		System.out.println(yeet.toString()); 
		
		CardStack chanceCards = new CardStack("RawChanceList.txt");
		CardStack communityChestCards = new CardStack("RawCCList.txt");
		chanceCards.shuffleCards();
		communityChestCards.shuffleCards();
		
		System.out.println(chanceCards.toString());
		System.out.println(communityChestCards.toString());
	}

}
