import java.util.ArrayList;

/**
 * Created by Andrew on 6/25/2016.
 */
public class Character implements Mappable {

    private String name;
    private int health;
    private int mana;

    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;
    private Shield shield;
    private Armor armor;

    private ArrayList<Item> inventory;

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
        return strength * 2;
    }

    public int getMaxHealth() {
        return 100 + (2 * constitution);
    }

    public int getMaxMana() {
        return willpower * 10;
    }

    public int getMoveSpeed() {
        if (agility  < 10) return 1;
        if (agility > 100) return 10;
        return agility / 10;
    }

    public int getPhysicalResist() {
        //TODO sum resist from armor
        return 0;
    }

    public int getMagicResist() {
        //TODO sum resist from armor
        return 0;
    }
}
