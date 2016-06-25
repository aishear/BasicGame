/**
 * Created by Andrew on 6/24/2016.
 */
public class Engine {
    private Map map;

    public static void main(String[] argv) {
       System.out.println("hello world");
    }

    public Engine(Map m) {
        map = m;
    }

    public Boolean move(int fromX, int fromY, int toX, int toY) {
        if (!validMove(fromX, fromY, toX, toY)) return false;
        return map.move(fromX, fromY, toX, toY);
    }


    public Boolean validMove(int fromX, int fromY, int toX, int toY) {
        return true;
    }
}
