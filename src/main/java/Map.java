/**
 * Created by Andrew on 6/25/2016.
 */
public class Map {
    private Mappable[][] map;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Mappable[height][width];
    }

    /**
     * @param m mappable to add to the map
     * @param x target x coordinate
     * @param y target y coordinate
     * @return true on success, false otherwise
     */
    public Boolean put(Mappable m, int x, int y) {
        if (x < 0 || x >= width) return false;
        if (y < 0 || y >= height) return false;
        if (map[y][x] != null) return false;

        map[y][x] = m;

        return true;
    }

    public Mappable get(int x, int y) {
        if (x < 0 || x >= width) return null;
        if (y < 0 || y >= height) return null;
        return map[y][x];
    }

    public Boolean remove(int x, int y) {
        if (x < 0 || x >= width) return false;
        if (y < 0 || y >= height) return false;
        if (map[y][x] == null) return false;

        map[y][x] = null;

        return true;
    }

    public Boolean move(int fromX, int fromY, int toX, int toY) {
        if (fromX < 0 || fromX >= width) return false;
        if (fromY < 0 || fromY >= height) return false;
        if (map[fromY][fromX] == null) return false;
        if (toX < 0 || toX >= width) return false;
        if (toY < 0 || toY >= height) return false;
        if (map[toY][toX] != null) return false;

        map[toY][toX] = map[fromY][fromX];
        map[fromY][fromX] = null;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(width * height + height);
        for (Mappable[] row : map) {
            for (Mappable m : row) {
                if (m  != null) {
                    sb.append("m");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
