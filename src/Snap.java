import java.util.Scanner;

public class Snap extends CardGame {
    private String previousCardSymbol = "";

    public Snap() {
        super();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to deal card");
        while (!previousCardSymbol.equals(super.dealCard().getSymbol())) {
            scanner.nextLine();
            previousCardSymbol = super.dealCard().getSymbol();
            System.out.println(super.dealCard().toString());
            super.shuffleDeck();
        }
        System.out.println(super.dealCard().toString());
        System.out.println("SNAP!!!");
    }

    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.playGame();
    }
}
