/**
 * Created by andrew on 7/1/16.
 */
public class WeaponFactory {
    public Weapon buildDagger() {
        Weapon dagger = new Weapon();
        dagger.setName("Dagger");
        dagger.setAccuracy(75);
        dagger.setDamage(10);
        dagger.setRange(1);

        return dagger;
    }
}
