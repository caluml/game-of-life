import java.util.Random;

/**
 * Console implementation of Conway's Game of life.<br>Run with three args: width, height,
 * milliseconds between iterations
 * 
 * @see https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 * @author calum
 */
public class Main {

    final static Random random = new Random(System.currentTimeMillis());

    public static void main(final String[] args) throws InterruptedException {

        final Iterator iterator = new IteratorImpl();
        Grid grid = getRandomGrid(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
        while (true) {
            dumpGrid(grid);
            Thread.sleep(Integer.valueOf(args[2]));
            grid = iterator.iterate(grid);
        }
    }

    private static Grid getRandomGrid(final int width, final int height) {
        final Grid grid = new Grid(width, height, 0);

        final int starting = getNumberOfStartingCells(width, height);
        for (int i = 0; i < starting; i++) {
            grid.setCellAlive(random.nextInt(width), random.nextInt(height), true);
        }
        return grid;
    }

    private static int getNumberOfStartingCells(final int width, final int height) {
        final int possible = width * height;
        final int half = possible / 2;
        return random.nextInt(half) + random.nextInt(half);
    }

    private static void dumpGrid(final Grid grid) {
        System.out.println(grid.asAscii());
    }
}