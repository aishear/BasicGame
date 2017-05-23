import org.junit.Test

import java.util.Random
import org.junit.Assert.*

class CombatIntegrationTest {

    @Test
    fun basicCombatTest() {
        val cf = CharacterFactory()

        val human1 = cf.buildBasicHuman()
        val human2 = cf.buildBasicHuman()

        val r = Random()
        r.setSeed(42)
        val c = Combat(r)

        assertEquals(180, human2.health.toLong())
        val hit = c.hit(human1, human1.primaryWeapon!!)
        var damage = 0
        if (hit) {
            damage = c.applyAttackDamage(human1, human1.primaryWeapon!!, human2)
        }
        assertTrue(hit)
        assertEquals(15, damage.toLong())
        assertEquals(165, human2.health.toLong())
    }
}
