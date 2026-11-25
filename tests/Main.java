public class Main {
    public static void main(String[] args) {
        Board board = new Board(4, 4);
        System.out.println("Board created: \n\n" + board);

        Coordinate coordinate = new Coordinate(false, true);
        board.setCoordinate(1, 1, coordinate);
        System.out.println("\nBoard after setting coordinate: \n\n" + board);
    }
}
