import java.util.Random;

/**
 * Created by andrew on 6/29/16.
 */
public class Combat {

    private Random attackRandomizer;

    public Combat(Random attackRandomizer){
        this.attackRandomizer = attackRandomizer;
    }

    /**
     * Randomly determine if an attack missed or not
     * @param source
     * @param sourceWeapon
     * @return true on hit or false on miss
     */
    public boolean hit(Character source, Weapon sourceWeapon) {
        return hit(getAttackAccuracy(source, sourceWeapon));
    }

    public int getAttackAccuracy(Character source, Weapon sourceWeapon) {
        int accuracy = sourceWeapon.getAccuracy() + source.getDexAttackBonus();
        if (accuracy > 100) accuracy = 100;
        return accuracy;
    }

    public int getAttackDamage(Character source, Weapon sourceWeapon) {
        // apply strength damage bonus for melee weapons, but not for ranged weapons
        if (sourceWeapon.getRange() > 1) {
            return sourceWeapon.getDamage();
        } else {
            return sourceWeapon.getDamage() + source.getStrengthDamageBonus();
        }
    }

    /**
     * @param source
     * @param sourceWeapon
     * @param target
     * @return total damage dealt
     */
    public int applyAttackDamage(Character source, Weapon sourceWeapon, Character target) {
        int damage = getAttackDamage(source, sourceWeapon);
        int totalDamage = damage - target.getPhysicalResist();
        target.setHealth(target.getHealth() - totalDamage);
        return totalDamage;
    }

    /**
     * Randomly determine if an attack missed or not
     * @param accuracy the accuracy of the attack
     * @return true on hit false on miss
     */
    public boolean hit(int accuracy) {
        return attackRandomizer.nextInt(100) < accuracy;
    }
}
