import java.util.List;

public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        List<Hand> hands = deck.distribute();

        for (Hand hand : hands) {
            hand.print();
            System.out.println("\n");
        }

    }
}
