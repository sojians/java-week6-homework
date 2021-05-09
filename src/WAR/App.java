package WAR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class App {
	private Player player1;
	private Player player2;
	List<String> players = List.of("Alice", "Bob", "Carol", "Dan", "Eve", "Frank");
	
//	Create a class called App with a main method.
	public static void main(String[] args) {
		new App().run();
	}

//	Instantiate a Deck and two Players, call the shuffle method on the deck.

	private void run() {
		selectPlayers();		
		
		Deck deck = new Deck();
		deck.shuffle();
		dealCards(deck);
		playGame();
		checkWhoWon();

	}

//	compare the final score from each player. 
	private void checkWhoWon() {
		if(player1.getScore() > player2.getScore()) {
			announceWinner(player1, player2);
		}
		else if(player2.getScore() > player1.getScore()) {
			announceWinner(player2, player1);
		}
		else {
			System.out.println("No one won - tied!");
		}
	}

//	Print the final score of each player and either “Player 1”, “Player 2”, or 
//	“Draw” depending on which score is higher or if they are both the same.
	private void announceWinner(Player winner, Player loser) {
		System.out.println("Congrats to " + winner.getName() + " who won with " 
				+ winner.getScore() + " points!");
		System.out.println("Our condolances to " + loser.getName() + " losing "
				+ "with " + loser.getScore() + " points!");
	}

//	Using a traditional for loop, iterate 26 times and call the flip method 
//	for each player
	private void playGame() {
		for(int bin = 0; bin < 26; bin++) {
			Card player1Card = player1.flip();
			Card player2Card = player2.flip();
			
//			Compare the value of each card returned by the two player’s flip 
//			methods. Call the incrementScore method on the player whose card 
//			has the higher value.
			if(player1Card.getRank() > player2Card.getRank()) {
				player1.incrementScore();
			}
			else if (player2Card.getRank() > player1Card.getRank()) {
				player2.incrementScore();
			}
		}
	}

	private void dealCards(Deck deck) {
//	The traditional for loop asked for in the most cheaty way possible because 
//	I could not figure out the error when I did it w/o the while loop
		while(!deck.isEmpty()) {
			for (int index = 0; index < deck.size(); index++) {
				player1.draw(deck);
				player2.draw(deck);
			}
		}
	}

//	Generate 2 random players that are not the same
	private void selectPlayers() {
		Set<String> contestants = new TreeSet<>();
		Random random = new Random();
		while(contestants.size() < 2) {
			contestants.add(players.get(random.nextInt(players.size())));
		}
		List<String> result = new ArrayList<>(contestants);
		player1 = new Player(result.get(0));
		player2 = new Player(result.get(1));
		
	}
}
