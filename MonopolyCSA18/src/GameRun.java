import java.util.Scanner;

public class GameRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Gameboard yeet = new Gameboard("RawSpacesList.txt");
		
		Scanner in = new Scanner(System.in);
		System.out.println("How Many Players?");
		int x = in.nextInt();
		if(x > 1 && x <= 8) {
		    Graphic.setPlayNum(x);
		}
		else {
			System.out.println("Number of players must be greater than 1 and less than or equal to 8");
		}
		Graphic.setBoard(yeet);
		Graphic.main(args);
		
		CardStack chanceCards = new CardStack("RawChanceList.txt");
		CardStack communityChestCards = new CardStack("RawCCList.txt");
		chanceCards.shuffleCards();
		communityChestCards.shuffleCards();
	} 

}
