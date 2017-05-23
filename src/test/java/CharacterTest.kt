import org.junit.Test

import org.junit.Assert.*

class CharacterTest {
    @Test
    fun testGetMoveSpeed() {
        val c = Character()
        c.agility = 50
        assertEquals(5, c.moveSpeed.toLong())
    }

    @Test
    fun testGetMoveSpeedAgilityNotDivisable() {
        val c = Character()
        c.agility = 56
        assertEquals(5, c.moveSpeed.toLong())
    }

    @Test
    fun testGetMoveSpeedZeroAgility() {
        val c = Character()
        c.agility = 0
        assertEquals(1, c.moveSpeed.toLong())
    }

    @Test
    fun testGetMoveSpeedMaxAgility() {
        val c = Character()
        c.agility = 100
        assertEquals(10, c.moveSpeed.toLong())
    }

    @Test
    fun testGetMoveSpeedGreaterThanMaxAgility() {
        val c = Character()
        c.agility = 120
        assertEquals(10, c.moveSpeed.toLong())
    }
}