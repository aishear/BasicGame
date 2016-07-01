import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 6/25/2016.
 */
public class Character implements Mappable {

    private String name;
    private int health;
    private int mana;

    public Weapon getPrimaryWeapon() {
        return primaryWeapon;
    }

    public Weapon getSecondaryWeapon() {
        return secondaryWeapon;
    }

    public Armor getShield() {
        return shield;
    }

    public Armor getBodyArmor() {
        return bodyArmor;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;
    private Armor shield;
    private Armor bodyArmor;

    private List<Item> inventory = new ArrayList<Item>();

    private int strength;
    private int dexterity;
    private int agility;
    private int constitution;
    private int focus;
    private int willpower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public int getMaxCarryWeight() {
        return getStrength() * 2;
    }

    public int getMaxHealth() {
        return 100 + (2 * getConstitution());
    }

    public int getMaxMana() {
        return getWillpower() * 10;
    }

    public int getMoveSpeed() {
        if (getAgility() < 10) return 1;
        if (getAgility() > 100) return 10;
        return getAgility() / 10;
    }

    public int getPhysicalResist() {
        //TODO sum resist from armor and race bonus
        int sum = 0;
        if (bodyArmor != null) {
            sum += bodyArmor.getPhysicalResist();
        }
        if (shield != null) {
            sum += shield.getPhysicalResist();
        }
        return sum;
    }

    public int getMagicResist() {
        //TODO sum resist from armor and race bonus
        int sum = 0;
        if (bodyArmor != null) {
            sum += bodyArmor.getMagicResist();
        }
        if (shield != null) {
            sum += shield.getMagicResist();
        }
        return sum;
    }

    public boolean equipPrimaryWeapon(Weapon weapon) {
        //TODO implement stat requirements
        primaryWeapon = weapon;
        return true;
    }
}
