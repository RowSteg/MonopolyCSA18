import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardStack {
	private Deque<Card> cardStack;
	private final Deque<Card> cardStackCopy; //reset deck to use once the deck is empty
	public CardStack(String inFile) { //instantiates the deck and all cards
		cardStack = new LinkedList<Card>();
		ArrayList<String[]> cards = new ArrayList<String[]>();
		try {
			Scanner in = new Scanner(new File(inFile));
			while(in.hasNextLine()) {
				cards.add(in.nextLine().split(";"));
			}
			for(int i = 0; i < cards.size(); i++) {
				String[] temp = cards.get(i);
				addCard(new Card(temp[0],
						temp[1],
						temp[2],
						Integer.parseInt(temp[3]),
						Integer.parseInt(temp[4]),
						temp[5]
						));
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		cardStackCopy = cardStack;
	}
	public void addCard(Card card) { //add a card to the deck
		cardStack.addFirst(card);
	}
	public Card drawCard() { //removes Card from top of stack
		Card card = cardStack.getFirst();
		cardStack.remove();
		return card;
	}
	public void shuffleCards() { //shuffles the order of the cards in the deck
		ArrayList<Card> list = new ArrayList<Card>(cardStack);
		Collections.shuffle(list);
		cardStack = new LinkedList<Card>(list);
	}
	public void resetCards() { //resets the deck to default NOTE remember to shuffle after resetting
		cardStack = cardStackCopy;
	}
	
	//FOR DEBUGGING ONLY!!!!
	public String toString() {
		String out = "";
		ArrayList<Card> list = new ArrayList<Card>(cardStack);
		for(int i = 0; i < list.size(); i++) {
			out += list.get(i).getEvent() + "\n";
		}
		return out;
	}
	
}
