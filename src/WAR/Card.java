package WAR;

//	Create the following classes... Card
public class Card {
	// value (contains a value from 2-14 representing cards 2-Ace)
	private String value;
	// name (e.g. Ace of Diamonds, or Two of Hearts)
	private String name;
	private int rank;
	
	// Methods Getters and Setters
	public String getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	public int getRank() {
		return rank;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Card(String value, String name, int rank) {
		this.value = value;
		this.name = name;
		this.rank = rank;
	}

	// describe (prints out information about a card)
	public String describe(String value, String name, int rank) {
		System.out.println("Card: " + value + " of " + name + ": " + rank);
		return null;
	}


}
