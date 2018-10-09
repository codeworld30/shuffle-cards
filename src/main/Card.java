public class Card {
    private final String name;
    private final Suits suit;

    public Card(String name, Suits suit) {
        this.name = name;
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit.name();
    }

    public String getName() {
        return this.name;
    }
}
