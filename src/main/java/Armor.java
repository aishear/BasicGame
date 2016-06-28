/**
 * Created by Andrew on 6/26/2016.
 */
public class Armor extends Item {
    private int physicalResist;
    private int magicResist;

    public int getPhysicalResist() {
        return physicalResist;
    }

    public void setPhysicalResist(int physicalResist) {
        this.physicalResist = physicalResist;
    }

    public int getMagicResist() {
        return magicResist;
    }

    public void setMagicResist(int magicResist) {
        this.magicResist = magicResist;
    }
}
