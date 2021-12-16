package cls;

public class Unit {
    protected int x, y;       // 현재위치

    protected void move(int x, int y) {
        /* 지정된 위치로 이동 */
        System.out.println("Move");
    };

    protected void stop() {
        /* 현 위치에 정지 */
        System.out.println("Stop");
    };

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
