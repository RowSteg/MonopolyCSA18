import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class CardStack {
	Deque<Card> cardStack = new LinkedList<Card>();
	Deque<Card> cardStackCopy = new LinkedList<Card>();
	public CardStack(Deque<Card> cardStack) {
		this.cardStack = cardStack;
		cardStackCopy = cardStack;
	}
	public void addCard(Card card) {
		cardStack.addFirst(card);
	}
	public Card drawCard() {
		Card card = cardStack.getFirst();
		cardStack.remove();
		return card;
	}
	public void shuffleCards() {
		ArrayList<Card> list = new ArrayList<Card>(cardStack);
		Collections.shuffle(list);
		cardStack = new LinkedList<Card>(list);
	}
	public void resetCards() {
		cardStack = cardStackCopy;
	}
	
}
