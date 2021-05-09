package WAR;

import java.util.ArrayList;
import java.util.List;

//Create the following classes... Player
public class Player {
	
	// Fields: hand, score, and name
	private List<Card> hand = new ArrayList<>();
	private int score;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
		
	public int size() {
		return hand.size();
	}
	
	public String getName() {
		return name;
	}
		

	public String describe() {
		StringBuilder builder = new StringBuilder();		
		builder.append("Player ").append(name).append(" with ").append(score).append(" points...\n").append("Hand: \n");
		for(Card card : hand) {
			builder.append("    ").append(card).append("\n");
		}
		return builder.toString();
	}
	
	public Card flip() {
		if(hand.isEmpty()) {
			throw new IllegalStateException("Hand is empty - cannot draw!");
		}
		return hand.remove(0);		
	}
		
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}

	public void incrementScore() {
		score += 1;
	}

	public int getScore() {
		return score;
	}
}
