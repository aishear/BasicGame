import org.junit.Test

import java.util.Random

import org.junit.Assert.*

class CombatTest {

    internal inner class MockRandom : Random() {
        private var output: Int = 0
        fun setOutput(output: Int) {
            this.output = output
        }

        override fun nextInt(range: Int): Int {
            return output
        }
    }

    @Test
    fun noHitWithZeroAccuracy() {
        val mockRandom = MockRandom()
        val c = Combat(mockRandom)
        mockRandom.setOutput(0)
        assertFalse(c.hit(0))

        mockRandom.setOutput(1)
        assertFalse(c.hit(0))

        mockRandom.setOutput(99)
        assertFalse(c.hit(0))
    }

    @Test
    fun someHitWithLowAccuracy() {
        val mockRandom = MockRandom()
        val c = Combat(mockRandom)
        mockRandom.setOutput(0)
        assertTrue(c.hit(2))

        mockRandom.setOutput(1)
        assertTrue(c.hit(2))

        mockRandom.setOutput(2)
        assertFalse(c.hit(2))

        mockRandom.setOutput(99)
        assertFalse(c.hit(2))
    }

    @Test
    fun allHitWithMaxAccuracy() {
        val mockRandom = MockRandom()
        val c = Combat(mockRandom)
        mockRandom.setOutput(0)
        assertTrue(c.hit(100))

        mockRandom.setOutput(1)
        assertTrue(c.hit(100))

        mockRandom.setOutput(58)
        assertTrue(c.hit(100))

        mockRandom.setOutput(99)
        assertTrue(c.hit(100))
    }
}