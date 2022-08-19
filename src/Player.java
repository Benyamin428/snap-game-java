public class Player {
    private static int player = 1;
    private static boolean beatTimer = false;

    public static int getPlayer() {
        return player;
    }

    public static void switchPlayer() {
        if (player == 1) {
            player = 2;
        }
        else if (player == 2) {
            player = 1;
        }
    }

    public static boolean getBeatTimer() {
        return Player.beatTimer;
    }

    public static void setBeatTimerToTrue() {
        Player.beatTimer = true;
    }
}
