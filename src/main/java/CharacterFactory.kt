class CharacterFactory {
    fun buildBasicHuman(): Character {
        val character = Character()
        character.name = "Basic Human"
        character.strength = 50
        character.dexterity = 40
        character.agility = 50
        character.constitution = 40
        character.focus = 20
        character.willpower = 0
        character.health = character.maxHealth
        character.mana = character.maxMana

        val wf = WeaponFactory()
        character.equipPrimaryWeapon(wf.buildDagger())

        return character
    }
}
