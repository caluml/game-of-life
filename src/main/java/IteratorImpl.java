public class IteratorImpl implements Iterator {

    /*
     * (non-Javadoc)
     * 
     * @see Iterator#iterate(Grid)
     */
    @Override
    public Grid iterate(final Grid grid) {
        final int width = grid.getWidth();
        final int height = grid.getHeight();
        final Grid newGrid = new Grid(width, height, grid.getIteration() + 1);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                final boolean current = grid.isCellAlive(x, y);
                final int numNeighbours = grid.getNumAliveNeighbours(x, y);
                applyRules(current, numNeighbours, newGrid, x, y);
            }
        }
        return newGrid;
    }

    private void applyRules(final boolean current, final int numNeighbours, final Grid newGrid,
            final int x, final int y) {
        if (numNeighbours == 3) {
            newGrid.setCellAlive(x, y, true);
        } else if (numNeighbours == 2 && current) {
            newGrid.setCellAlive(x, y, true);
        } else {
            newGrid.setCellAlive(x, y, false);
        }
    }

}
