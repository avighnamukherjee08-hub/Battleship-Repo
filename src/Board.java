import java.util.concurrent.TimeUnit;
public class Board {
    private Coordinate[][] grid;

    public Board(int columns, int rows) {
        grid = new Coordinate[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = new Coordinate(false, false);
            }
        }
    }

    public Coordinate[][] getGrid() { return grid; }

    public Coordinate getCoordinate(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            System.out.println("Coordinates out of bounds");
            return null;
        }
        return grid[x][y];
    }

    public void setCoordinate(int x, int y, Coordinate coordinate) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            System.out.println("Coordinates out of bounds");
            return;
        }
        grid[x][y] = coordinate;
    }

    public boolean isCoordinateValid(int x, int y, int a, int shipLength) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            System.out.println("Coordinates out of bounds");
            return false;
        }
        if (a == 1) {
            for (int i = 0; i < shipLength; i++) {
                if (y + i >= grid[0].length || grid[x][y + i].isShip()) {
                    return false;
                }
            }
        } else if (a == 2) {
            for (int i = 0; i < shipLength; i++) {
                if (x + i >= grid.length || grid[x + i][y].isShip()) {
                    return false;
                }
            }
        } else {
            System.out.println("Invalid orientation");
            return false;
        }
        return true;
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]);
                if (j != grid[i].length - 1) {
                    sb.append(" ");
                }
            }
            if (i != grid.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void setBoard() {
        boolean validInput = false;
        int a = 0;
        while (!validInput) {
            try {
                a = Integer.parseInt(IO.readln("\nEnter 1 for horizontal ship, 2 for vertical ship: "));
                if (a == 1 || a == 2) {
                    validInput = true;
                } else {
                    System.out.println("Enter 1 or 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }

        validInput = false;            
        while (!validInput) {
            try {
                int y = Integer.parseInt(IO.readln("\nNow provide the x-coordinate for the top-left edge of the ship: "));
                int x = Integer.parseInt(IO.readln("Now provide the y-coordinate for the top-left edge of the ship: "));
                y--;
                x--;

                if (isCoordinateValid(x, y, a, 3)) {
                    for (int i = 0; i < 3; i++) {
                        if (a == 1) {
                            getCoordinate(x, y + i).setShip(true);
                        } else if (a == 2) {
                            getCoordinate(x + i, y).setShip(true);
                        }
                    }
                    validInput = true;
                } else {
                    System.out.println("Invalid coordinates for ship placement");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    public boolean shoot(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            System.out.println("Coordinates out of bounds");
            return false;
        }
        Coordinate coordinate = getCoordinate(x, y);
        if (coordinate.isShot()) {
            System.out.println("This coordinate has already been shot at");
            return false;
        }
        coordinate.setShot(true);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if (coordinate.isShip()) {
            System.out.println("\nHIT!!!!!\n");
        } else {
            System.out.println("\nMISS!\n");
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return true;
    }

    public boolean allShipsSunk() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].isShip() && !grid[i][j].isShot()) {
                    return false;
                }
            }
        }
        return true;
    }
}
