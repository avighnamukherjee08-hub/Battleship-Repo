import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) {

        System.out.println("WELCOME TO BATTLESHIP!!!!!\n");
        System.out.println("This is a miniature version of the classic game, with smaller boards & only 1 ship per player.");
        System.out.println("This game presumes that you know all the rules of Battleship. If you don't, look it up.");
        System.out.println("This game is to be played by 2 players who exchange their device within 3 seconds after each turn.");
        System.out.println("This is so that a player does not see their opponent's board.");
        System.out.println("SO DON'T CHEAT!!!!!");
        System.out.println("\nCoordinates range from 1 to the length of the board.");
        System.out.println("First enter the x-coordinate, then the y-coordinate.");
        System.out.println("On the board, 'S' represents a ship, 'O' represents a missed shot,");
        System.out.println("'X' represents a hit ship, and '_' represents an empty coordinate.");

        Board board1 = new Board(6, 6);
        System.out.println("\nPlayer 1, place your ship of length 3 on the board of size 6x6:");
        board1.setBoard();
        System.out.println("\nPlayer 1's Board:\n\n" + board1);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Board board2 = new Board(6, 6);
        System.out.println("\nNow player 2, place your ship of length 3 on the board of size 6x6:");
        board2.setBoard();
        System.out.println("\nPlayer 2's Board:\n\n" + board2);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("LET THE GAME BEGIN!!!!!");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Player 1's Board:\n\n" + board1);
            System.out.println("\nThe Target Board:\n\n" + board2.toString().replace("S", "_"));
            System.out.println("\nPlayer 1, shoot your shot");

            while (true) {
                try {
                    int y = Integer.parseInt(IO.readln("\nEnter the x-coordinate of your shot: "));
                    int x = Integer.parseInt(IO.readln("Enter the y-coordinate of your shot: "));
                    y--;
                    x--;

                    if (board2.shoot(x, y)) {
                        if (board2.allShipsSunk()) {
                            System.out.println("\n\n\nPLAYER 1 WINS!!!!!");
                            return;
                        }
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Player 2's Board:\n\n" + board2);
            System.out.println("\nThe Target Board:\n\n" + board1.toString().replace("S", "_"));
            System.out.println("\nPlayer 2, shoot your shot");

            while (true) {
                try {
                    int y = Integer.parseInt(IO.readln("\nEnter the x-coordinate of your shot: "));
                    int x = Integer.parseInt(IO.readln("Enter the y-coordinate of your shot: "));
                    y--;
                    x--;

                    if (board1.shoot(x, y)) {
                        if (board1.allShipsSunk()) {
                            System.out.println("\n\n\nPLAYER 2 WINS!!!!!");
                            return;
                        }
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }

        }

    }
}
