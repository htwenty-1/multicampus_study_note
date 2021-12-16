package cls;

import inter.Unit;

public class Dropship implements Unit {

    private int x, y;

    public Dropship(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        System.out.println(x + ", " + y + "로 이동");
    }

    @Override
    public void stop() {
        System.out.println("현위치에서 정지");
    }

    public void load() {
        System.out.println("load 함");
    }

    public void unload() {
        System.out.println("unload 함");
    }


}
