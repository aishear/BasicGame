import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MapTest {
    var map: Map = Map(0, 0)
    var c1: Character = Character()
    var c2: Character = Character()
    var c3: Character = Character()
    var c4: Character = Character()

    @Before
    fun setUp() {
        map = Map(10, 10)
        c1 = Character()
        c2 = Character()
        c3 = Character()
        c4 = Character()

        map.put(c1, 0, 0)
        map.put(c2, 9, 9)
        map.put(c3, 5, 4)
        map.put(c4, 1, 2)
    }

    @Test
    fun testPut() {
        val c5 = Character()
        val ret = map.put(c5, 1, 1)
        assertTrue(ret!!)
        assertEquals(c5, map[1, 1])
    }

    @Test
    fun testPutOutOfBounds() {
        assertFalse(map.put(Character(), -1, 0)!!)
        assertFalse(map.put(Character(), 0, -1)!!)
        assertFalse(map.put(Character(), 10, 0)!!)
        assertFalse(map.put(Character(), 0, 10)!!)
    }

    @Test
    fun testPutSpotTaken() {
        val c5 = Character()
        val ret = map.put(c5, 0, 0)
        assertFalse(ret!!)
        assertNotEquals(c5, map[0, 0])
    }

    @Test
    fun testGet() {
        assertEquals(c1, map[0, 0])
        assertEquals(c2, map[9, 9])
        assertEquals(c3, map[5, 4])
        assertEquals(c4, map[1, 2])
    }

    @Test
    fun testGetEmptySpot() {
        assertNull(map[1, 1])
    }

    @Test
    fun testRemove() {
        assertEquals(c1, map[0, 0])
        assertTrue(map.remove(0, 0)!!)
        assertNull(map[0, 0])
    }

    @Test
    fun testMove() {
        assertEquals(c1, map[0, 0])
        assertTrue(map.move(0, 0, 1, 1)!!)
        assertNull(map[0, 0])
        assertEquals(c1, map[1, 1])
    }
}