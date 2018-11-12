
public class GameRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gameboard yeet = new Gameboard("RawSpacesList.txt");
		Graphic.setBoard(yeet); 
		
		Graphic.main(args);
		
		/*CardStack chanceCards = new CardStack("RawChanceList.txt");
		CardStack communityChestCards = new CardStack("RawCCList.txt");
		chanceCards.shuffleCards();
		communityChestCards.shuffleCards();
		
		System.out.println(chanceCards.toString());
		System.out.println(communityChestCards.toString());*/
	}

}
