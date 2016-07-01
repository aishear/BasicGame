import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by andrew on 6/30/16.
 */
public class CombatTest {

    class MockRandom extends Random {
        private int output;
        public void setOutput(int output) {
            this.output = output;
        }
        @Override
        public int nextInt(int range) {
            return output;
        }
    }

    @Test
    public void noHitWithZeroAccuracy() {
        MockRandom mockRandom = new MockRandom();
        Combat c = new Combat(mockRandom);
        mockRandom.setOutput(0);
        assertFalse(c.hit(0));

        mockRandom.setOutput(1);
        assertFalse(c.hit(0));

        mockRandom.setOutput(99);
        assertFalse(c.hit(0));
    }

    @Test
    public void someHitWithLowAccuracy() {
        MockRandom mockRandom = new MockRandom();
        Combat c = new Combat(mockRandom);
        mockRandom.setOutput(0);
        assertTrue(c.hit(2));

        mockRandom.setOutput(1);
        assertTrue(c.hit(2));

        mockRandom.setOutput(2);
        assertFalse(c.hit(2));

        mockRandom.setOutput(99);
        assertFalse(c.hit(2));
    }

    @Test
    public void allHitWithMaxAccuracy() {
        MockRandom mockRandom = new MockRandom();
        Combat c = new Combat(mockRandom);
        mockRandom.setOutput(0);
        assertTrue(c.hit(100));

        mockRandom.setOutput(1);
        assertTrue(c.hit(100));

        mockRandom.setOutput(58);
        assertTrue(c.hit(100));

        mockRandom.setOutput(99);
        assertTrue(c.hit(100));
    }
}