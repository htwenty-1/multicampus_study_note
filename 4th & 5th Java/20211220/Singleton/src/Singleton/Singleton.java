package Singleton;

public class Singleton {

    private static Singleton single = null;
    public int number;
    public String name;
    public String gender;

    private Singleton() {}

    public static Singleton getInstance() {
        //if(single == null) {    // 1번만 실행
            single = new Singleton();
        //}
        return single;      // 1개의 인스턴스만큼 사용
    }
}
