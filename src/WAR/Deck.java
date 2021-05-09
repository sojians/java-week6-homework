package WAR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Create the following classes... Deck
public class Deck {
	private List<String> values = List.of("Two", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace");

	private List<String> names = List.of("Hearts", "Diamonds", "Clubs", 
			"Spades");
	
	// Field cards (List of Card)
	private List<Card> cards = new ArrayList<>();
	
	// In the constructor, when a new Deck is instantiated, the Cards field 
	// should be populated with the standard 52 cards.
	public Deck() {
		for (String name : names) {
			for(int index = 0; index < values.size(); index += 1) {
				Card card = new Card(values.get(index), name, index + 2);
				cards.add(card);
			}
		}
	}

	// shuffle (randomizes the order of the cards)
	public void shuffle() {
		Collections.shuffle(cards);		
	}
	
	// draw (removes and returns the top card of the Cards field)
	public Card draw() {
		if(cards.isEmpty()) {
			throw new IllegalStateException("Deck is empty - cannot draw!");
		}
		return cards.remove(0);
	}
	
	public int size() {
		return cards.size();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append("Deck:\n");
		
		for(Card card : cards) {
			builder.append("    ").append(card).append("\n");
		}
		
		return builder.toString();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

}

