package cls;

public class Marine extends Unit {

    public Marine(int x, int y) {
        super(x, y);
    }

    void stimPack() {
        /* 스팀팩 사용 */
        System.out.println("use stim pack");
    }
}
