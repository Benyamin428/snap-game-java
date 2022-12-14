public class Card {

    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return  "┌─────┐"+ "\n"+
                "|"+this.symbol+"    |"+ "\n"+
                "|  "+this.suit+"  |"+ "\n"+
                "|    "+this.symbol+"|"+ "\n"+
                "└─────┘";
    }
}
