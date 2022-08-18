import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;

public class CardGame {
    private List<Card> cardDeck = new ArrayList<>();
    public CardGame() {
        char[] suit = {'\u2764', '\u2663', '\u2666', '\u2660'};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q", "A"};
        int counter = 0;
        for (int i = 0; counter < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cardDeck.add(new Card(Character.toString(suit[i]), rank[j], j+2));
            }
            counter++;
        }
    }

    public void getDeck() {
        for (Card card : cardDeck) {
            System.out.println(card.toString());
        }
    }

    public Card dealCard() {
        return cardDeck.get(0);
    }

    public List<Card> sortDeckInNumberOrder() {
        Collections.sort(cardDeck, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        return cardDeck;
    }

    public List<Card> sortDeckIntoSuits() {
        Map<String, List<Card>> cardDeckInSuits = new HashMap<>();

        for (Card card : cardDeck) {
            if(!cardDeckInSuits.containsKey(card.getSuit())) {
                cardDeckInSuits.put(card.getSuit(), new ArrayList<>());
            }
            cardDeckInSuits.get(card.getSuit()).add(card);
        }

        //the stream below converts a map data structure into a list
        cardDeck = cardDeckInSuits.values()
                .stream()
                .flatMap(item -> item.stream())
                .collect(Collectors.toList());

        return cardDeck;
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.sortDeckInNumberOrder();
        cardGame.sortDeckIntoSuits();
        cardGame.getDeck();
    }
}
