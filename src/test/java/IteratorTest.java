import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IteratorTest {
    private Iterator iterator;

    @Before
    public void before() {
        this.iterator = new IteratorImpl();
    }

    @Test
    public void Iterator_iterates_correctly() {
        final Grid grid = new Grid(3, 3, 0);
        grid.setCellAlive(0, 1, true);
        grid.setCellAlive(1, 1, true);
        grid.setCellAlive(2, 1, true);

        final Grid actualGrid = this.iterator.iterate(grid);

        assertTrue(actualGrid.isCellAlive(1, 0));
        assertTrue(actualGrid.isCellAlive(1, 1));
        assertTrue(actualGrid.isCellAlive(1, 2));

        assertFalse(actualGrid.isCellAlive(0, 0));
        assertFalse(actualGrid.isCellAlive(0, 1));
        assertFalse(actualGrid.isCellAlive(0, 2));
        assertFalse(actualGrid.isCellAlive(2, 0));
        assertFalse(actualGrid.isCellAlive(2, 1));
        assertFalse(actualGrid.isCellAlive(2, 2));
    }
}
