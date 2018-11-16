import java.util.Scanner;

public class GameRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gameboard yeet = new Gameboard("RawSpacesList.txt");
		
		Scanner in = new Scanner(System.in);
		System.out.println("How Many Players?");
		int x = in.nextInt();  
		Graphic.setBoard(yeet);
		Graphic.setPlayNum(x);
		Graphic.main(args);
		
		/*CardStack chanceCards = new CardStack("RawChanceList.txt");
		CardStack communityChestCards = new CardStack("RawCCList.txt");
		chanceCards.shuffleCards();
		communityChestCards.shuffleCards();
		
		System.out.println(chanceCards.toString());
		System.out.println(communityChestCards.toString());*/
	}

}
