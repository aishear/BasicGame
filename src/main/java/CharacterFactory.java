/**
 * Created by andrew on 7/1/16.
 */
public class CharacterFactory {
    public Character buildBasicHuman() {
        Character character = new Character();
        character.setName("Basic Human");
        character.setStrength(50);
        character.setDexterity(40);
        character.setAgility(50);
        character.setConstitution(40);
        character.setFocus(20);
        character.setWillpower(0);
        character.setHealth(character.getMaxHealth());
        character.setMana(character.getMaxMana());

        WeaponFactory wf = new WeaponFactory();
        character.equipPrimaryWeapon(wf.buildDagger());

        return character;
    }
}
