public interface Iterator {

    /**
     * Takes a grid, and applies the Game of life logic to it, returning a new grid.
     * 
     * @param grid
     * @return
     */
    Grid iterate(Grid grid);

}
