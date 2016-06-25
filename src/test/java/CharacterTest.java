import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 6/25/2016.
 */
public class CharacterTest {
    @Test
    public void testGetMoveSpeed() {
        Character c = new Character();
        c.setAgility(50);
        assertEquals(5, c.getMoveSpeed());
    }

    @Test
    public void testGetMoveSpeedAgilityNotDivisable() {
        Character c = new Character();
        c.setAgility(56);
        assertEquals(5, c.getMoveSpeed());
    }

    @Test
    public void testGetMoveSpeedZeroAgility() {
        Character c = new Character();
        c.setAgility(0);
        assertEquals(1, c.getMoveSpeed());
    }

    @Test
    public void testGetMoveSpeedMaxAgility() {
        Character c = new Character();
        c.setAgility(100);
        assertEquals(10, c.getMoveSpeed());
    }

    @Test
    public void testGetMoveSpeedGreaterThanMaxAgility() {
        Character c = new Character();
        c.setAgility(120);
        assertEquals(10, c.getMoveSpeed());
    }
}