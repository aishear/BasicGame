/**
 * Created by Andrew on 6/25/2016.
 */
public class Character implements Mappable {
    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    private int agility;

    int getMoveSpeed() {
        if (agility  < 10) return 1;
        if (agility > 100) return 10;
        return agility / 10;
    }
}
