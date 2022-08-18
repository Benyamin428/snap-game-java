import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.getDeck();
    }
}
