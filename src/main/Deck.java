import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Deck {
    private List<Card> cards = generateCards();


    public void shuffle() {
        Random rand = new Random();

        for (int i = 0; i < this.cards.size(); i++) {
            int r = i + rand.nextInt(52 - i);

            Card temp = this.cards.get(r);
            cards.set(r, cards.get(i));
            cards.set(i, temp);
        }
    }


    public List<Hand> distribute() {
        Hand hand1 = new Hand("Hand1");
        Hand hand2 = new Hand("Hand2");
        Hand hand3 = new Hand("Hand3");
        Hand hand4 = new Hand("Hand4");

        hand1.putCards(this.cards.subList(0,12));
        hand2.putCards(this.cards.subList(13,25));
        hand3.putCards(this.cards.subList(26,38));
        hand4.putCards(this.cards.subList(39,51));
        return Arrays.asList(hand1, hand2, hand3, hand4);
    }

    private List<Card> generateCards() {
        List<Card> c = new ArrayList<>(52);
        for (int i = 0; i < 52; i++) {
            switch (i / 13) {
                case 0:
                    Card club = new Card(getCardName(i % 13 + 1), Suits.CLUB);
                    c.add(club);
                    break;
                case 1:
                    Card diamond = new Card(getCardName(i % 13 + 1), Suits.DIAMOND);
                    c.add(diamond);
                    break;
                case 2:
                    Card spade = new Card(getCardName(i % 13 + 1), Suits.SPADE);
                    c.add(spade);
                    break;
                case 3:
                    Card heart = new Card(getCardName(i % 13 + 1), Suits.HEART);
                    c.add(heart);
                    break;
                default:
                    break;
            }
        }
        return c;
    }

    private String getCardName(int rank) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "A");
        names.put(2, "2");
        names.put(3, "3");
        names.put(4, "4");
        names.put(5, "5");
        names.put(6, "6");
        names.put(7, "7");
        names.put(8, "8");
        names.put(9, "9");
        names.put(10, "10");
        names.put(11, "J");
        names.put(12, "Q");
        names.put(13, "K");

        return names.get(rank);
    }
}
