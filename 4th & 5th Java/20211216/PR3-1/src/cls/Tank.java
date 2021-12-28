package cls;

import inter.Unit;

public class Tank implements Unit {

    private int x, y;

    public Tank(int x, int y) {
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

    public void changeMode() {
        System.out.println("공격모드 변환");
    }
}
