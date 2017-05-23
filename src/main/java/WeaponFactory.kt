class WeaponFactory {
    fun buildDagger(): Weapon {
        val dagger = Weapon()
        dagger.name = "Dagger"
        dagger.accuracy = 75
        dagger.damage = 10
        dagger.range = 1

        return dagger
    }
}
