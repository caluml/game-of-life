import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class GridTest {

    @Test
    public void getNumNeighbours_works_correctly() {
        final Grid grid = new Grid(3, 3, 0);
        grid.setCellAlive(0, 1, true);
        grid.setCellAlive(1, 1, true);
        grid.setCellAlive(2, 1, true);

        assertEquals(3, grid.getNumAliveNeighbours(1, 0));
        assertEquals(2, grid.getNumAliveNeighbours(1, 1));
    }

    @Test
    public void Getting_out_of_bounds_returns_false() {
        final Grid grid = new Grid(3, 3, 0);
        assertFalse(grid.isCellAlive(4, 5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void Setting_out_of_bounds_throws_ArrayIndexOutOfBoundsException() {
        final Grid grid = new Grid(3, 3, 0);
        grid.setCellAlive(4, 5, false);
    }

    @Test
    public void asAscii_works_correctly() {
        final Grid grid = new Grid(3, 3, 0);
        grid.setCellAlive(0, 1, true);
        grid.setCellAlive(1, 1, true);
        grid.setCellAlive(2, 1, true);

        final String expected = "0\n   \nXXX\n   \n";
        assertEquals(expected, grid.asAscii());
    }
}
