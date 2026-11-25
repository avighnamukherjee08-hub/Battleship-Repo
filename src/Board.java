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
}
