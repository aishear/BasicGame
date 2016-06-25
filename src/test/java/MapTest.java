import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 6/25/2016.
 */
public class MapTest {
    public Map map;
    public Character c1;
    public Character c2;
    public Character c3;
    public Character c4;

    @Before
    public void setUp() {
        map = new Map(10, 10);
        c1 = new Character();
        c2 = new Character();
        c3 = new Character();
        c4 = new Character();

        map.put(c1, 0, 0);
        map.put(c2, 9, 9);
        map.put(c3, 5, 4);
        map.put(c4, 1, 2);
    }

    @Test
    public void testPut() {
        Character c5 = new Character();
        Boolean ret = map.put(c5, 1, 1);
        assertTrue(ret);
        assertEquals(c5, map.get(1, 1));
    }

    @Test
    public void testPutOutOfBounds() {
        assertFalse(map.put(new Character(), -1, 0));
        assertFalse(map.put(new Character(), 0, -1));
        assertFalse(map.put(new Character(), 10, 0));
        assertFalse(map.put(new Character(), 0, 10));
    }

    @Test
    public void testPutSpotTaken() {
        Character c5 = new Character();
        Boolean ret = map.put(c5, 0, 0);
        assertFalse(ret);
        assertNotEquals(c5, map.get(0, 0));
    }

    @Test
    public void testGet() {
        assertEquals(c1, map.get(0, 0));
        assertEquals(c2, map.get(9, 9));
        assertEquals(c3, map.get(5, 4));
        assertEquals(c4, map.get(1, 2));
    }

    @Test
    public void testGetEmptySpot() {
        assertNull(map.get(1, 1));
    }

    @Test
    public void testRemove() {
        assertEquals(c1, map.get(0, 0));
        assertTrue(map.remove(0, 0));
        assertNull(map.get(0, 0));
    }

    @Test
    public void testMove() {
        assertEquals(c1, map.get(0, 0));
        assertTrue(map.move(0, 0, 1, 1));
        assertNull(map.get(0, 0));
        assertEquals(c1, map.get(1, 1));
    }
}