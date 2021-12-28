package cls;

import inter.Unit;

public class Marine implements Unit {

    private int x, y;

    public Marine(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void stimPack() {
        System.out.println("스팀팩 사용");
    }

    @Override
    public void move(int x, int y) {
        System.out.println(x + ", " + y + "로 이동");
    }

    @Override
    public void stop() {
        System.out.println("현위치에서 정지");
    }
}
