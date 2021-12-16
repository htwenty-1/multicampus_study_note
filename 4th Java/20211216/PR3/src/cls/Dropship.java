package cls;

public class Dropship extends Unit {

    public Dropship(int x, int y) {
        super(x, y);
    }

    void load() {
        System.out.println("load");
    }
    void unload() {
        System.out.println("unload");
    }
}
