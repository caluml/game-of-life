public class Grid {

    /**
     * Array to store the state of the cells
     */
    private final boolean[][] cells;

    /**
     * The width of the grid
     */
    private final int width;

    /**
     * The height of the grid
     */
    private final int height;

    /**
     * Iteration count
     */
    private final long iteration;

    /**
     * Instantiates a new Grid
     * 
     * @param width the width
     * @param height the height
     * @param iteration the number of iterations that have occurred to reach this grid
     */
    public Grid(final int width, final int height, final long iteration) {
        this.cells = new boolean[width][height];
        this.width = width;
        this.height = height;
        this.iteration = iteration;
    }

    /**
     * Checks if a specific cell is on or off
     * 
     * @param x
     * @param y
     * @return
     */
    public boolean isCellAlive(final int x, final int y) {
        try {
            return this.cells[x][y];
        } catch (final ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Switch a specific cell on or off
     * 
     * @param x
     * @param y
     * @param b
     */
    public void setCellAlive(final int x, final int y, final boolean b) {
        this.cells[x][y] = b;
    }

    /**
     * Produces an ASCII-art representation
     * 
     * @return
     */
    public String asAscii() {
        final StringBuilder ret = new StringBuilder();
        ret.append(this.iteration + "\n");
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (this.cells[x][y]) {
                    ret.append("X");
                } else {
                    ret.append(" ");
                }
            }
            ret.append("\n");
        }
        return ret.toString();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public long getIteration() {
        return this.iteration;
    }

    /**
     * Gets the number of neighbours which are alive in the 8 cells around the specified one
     * 
     * @param x
     * @param y
     * @return
     */
    public int getNumAliveNeighbours(final int x, final int y) {
        int num = 0;

        num = checkNeighbour(num, x - 1, y - 1);
        num = checkNeighbour(num, x - 1, y);
        num = checkNeighbour(num, x - 1, y + 1);
        num = checkNeighbour(num, x, y - 1);
        num = checkNeighbour(num, x, y + 1);
        num = checkNeighbour(num, x + 1, y - 1);
        num = checkNeighbour(num, x + 1, y);
        num = checkNeighbour(num, x + 1, y + 1);

        return num;
    }

    private int checkNeighbour(final int num, final int x, final int y) {
        try {
            if (this.cells[x][y]) {
                return num + 1;
            }
        } catch (final ArrayIndexOutOfBoundsException e) {
            // Going out of the square.
        }
        return num;
    }

}
