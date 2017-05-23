import java.util.ArrayList

class Character : Mappable {

    var name: String? = null
    var health: Int = 0
    var mana: Int = 0

    var primaryWeapon: Weapon? = null
        private set
    val secondaryWeapon: Weapon? = null
    val shield: Armor? = null
    val bodyArmor: Armor? = null

    val inventory: List<Item> = ArrayList()

    var strength: Int = 0
    var dexterity: Int = 0
    var agility: Int = 0
    var constitution: Int = 0
    var focus: Int = 0
    var willpower: Int = 0

    val maxCarryWeight: Int
        get() = strength * 2

    val maxHealth: Int
        get() = 100 + 2 * constitution

    val maxMana: Int
        get() = willpower * 10

    val moveSpeed: Int
        get() {
            if (agility < 10) return 1
            if (agility > 100) return 10
            return agility / 10
        }

    //TODO sum resist from armor and race bonus
    val physicalResist: Int
        get() {
            var sum = 0
            if (bodyArmor != null) {
                sum += bodyArmor.physicalResist
            }
            if (shield != null) {
                sum += shield.physicalResist
            }
            return sum
        }

    //TODO sum resist from armor and race bonus
    val magicResist: Int
        get() {
            var sum = 0
            if (bodyArmor != null) {
                sum += bodyArmor.magicResist
            }
            if (shield != null) {
                sum += shield.magicResist
            }
            return sum
        }

    fun equipPrimaryWeapon(weapon: Weapon): Boolean {
        //TODO implement stat requirements
        primaryWeapon = weapon
        return true
    }

    val dexAttackBonus: Int
        get() = (dexterity / 10.0 * 3.0).toInt()

    val strengthDamageBonus: Int
        get() = strength / 10
}
