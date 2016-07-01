import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by andrew on 7/1/16.
 */
public class CombatIntegrationTest {

    @Test
    public void basicCombatTest() {
        CharacterFactory cf = new CharacterFactory();

        Character human1 = cf.buildBasicHuman();
        Character human2 = cf.buildBasicHuman();

        Random r = new Random();
        r.setSeed(42);
        Combat c = new Combat(r);

        assertEquals(180, human2.getHealth());
        boolean hit = c.hit(human1, human1.getPrimaryWeapon());
        int damage = 0;
        if (hit) {
            damage = c.applyAttackDamage(human1, human1.getPrimaryWeapon(), human2);
        }
        assertTrue(hit);
        assertEquals(15, damage);
        assertEquals(165, human2.getHealth());
    }
}
