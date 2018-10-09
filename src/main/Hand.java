import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
    private String name;
    private List<Card> cards;

    public Hand(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this.name + ":\n");
        Map<String, List<Card>> sortedCards = sort();

        StringBuilder res = new StringBuilder("Hearts : ");
        for (Card card : sortedCards.get("Hearts")) {
            res.append(card.getName()).append(", ");
        }

        res.append("\nDiamond : ");
        for (Card card : sortedCards.get("Diamond")) {
            res.append(card.getName()).append(", ");
        }

        res.append("\nClub : ");
        for (Card card : sortedCards.get("Club")) {
            res.append(card.getName()).append(", ");
        }

        res.append("\nSpade : ");
        for (Card card : sortedCards.get("Spade")) {
            res.append(card.getName()).append(", ");
        }

        System.out.println(res);

    }

    private Map<String, List<Card>> sort() {
        List<Card> hearts = new ArrayList<>(), spade = new ArrayList<>(), club = new ArrayList<>(), diamond = new ArrayList<>();
        for (Card card : this.cards) {
            switch (card.getSuit()) {
                case "HEART":
                    hearts.add(card);
                    break;

                case "SPADE":
                    spade.add(card);
                    break;

                case "CLUB":
                    club.add(card);
                    break;

                case "DIAMOND":
                    diamond.add(card);
                    break;

                default:
                    break;
            }
        }
         Map<String, List<Card>> mapper = new HashMap<>();
        mapper.put("Hearts", hearts);
        mapper.put("Spade", spade);
        mapper.put("Club", club);
        mapper.put("Diamond", diamond);

        return mapper;
    }

    public void putCards(List<Card> subList) {
        this.cards = subList;
    }
}
