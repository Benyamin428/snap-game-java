import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    private String previousCardSymbol = "";
    private String snapStr = "";
    Scanner scanner = new Scanner(System.in);

    public Snap() {
        super();
    }

    TimerTask task = new TimerTask()
    {
        public void run()
        {
            if( snapStr.equals("") )
            {
                System.out.println("You took longer than 2 seconds to type in SNAP");
                System.out.println("You lost!");
                System.exit( 0 );
            }
        }
    };

    public void playGame() {
        System.out.println("Press Enter to deal card");
        while (!previousCardSymbol.equals(super.dealCard().getSymbol())) {
            System.out.println("Player " + Player.getPlayer() + " turn");
            Player.switchPlayer();
            scanner.nextLine();
            previousCardSymbol = super.dealCard().getSymbol();
            System.out.println(super.dealCard().toString());
            super.shuffleDeck();
        }
        System.out.println(super.dealCard().toString());

        this.countdown();
    }

    public void countdown() {

        Timer timer = new Timer();

        timer.schedule( task, 2000 );

        snapStr = scanner.nextLine();

        timer.cancel();

        this.checkWin();
    }

    public void checkWin() {
        if (snapStr.toLowerCase().equals("snap")) {
            System.out.println("SNAP!!!");
            System.out.println("Player " + Player.getPlayer() + " won the game");
        }
        else {
            System.out.println("You didn't type in SNAP to confirm your SNAP");
            System.out.println("You lost!");
        }
    }

    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.playGame();
    }
}
