import java.util.Random

class Combat(private val attackRandomizer: Random) {

    /**
     * Randomly determine if an attack missed or not
     * @param source
     * *
     * @param sourceWeapon
     * *
     * @return true on hit or false on miss
     */
    fun hit(source: Character, sourceWeapon: Weapon): Boolean {
        return hit(getAttackAccuracy(source, sourceWeapon))
    }

    fun getAttackAccuracy(source: Character, sourceWeapon: Weapon): Int {
        var accuracy = sourceWeapon.accuracy + source.dexAttackBonus
        if (accuracy > 100) accuracy = 100
        return accuracy
    }

    fun getAttackDamage(source: Character, sourceWeapon: Weapon): Int {
        // apply strength damage bonus for melee weapons, but not for ranged weapons
        if (sourceWeapon.range > 1) {
            return sourceWeapon.damage
        } else {
            return sourceWeapon.damage + source.strengthDamageBonus
        }
    }

    /**
     * @param source
     * *
     * @param sourceWeapon
     * *
     * @param target
     * *
     * @return total damage dealt
     */
    fun applyAttackDamage(source: Character, sourceWeapon: Weapon, target: Character): Int {
        val damage = getAttackDamage(source, sourceWeapon)
        val totalDamage = damage - target.physicalResist
        target.health = target.health - totalDamage
        return totalDamage
    }

    /**
     * Randomly determine if an attack missed or not
     * @param accuracy the accuracy of the attack
     * *
     * @return true on hit false on miss
     */
    fun hit(accuracy: Int): Boolean {
        return attackRandomizer.nextInt(100) < accuracy
    }
}
