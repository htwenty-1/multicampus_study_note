package cls;

import Singleton.Singleton;

public class MyClass {

    private int number;
    private String name;

    public MyClass(int number, String name) {
        number = 333;
        name = "홍길동";
    }

    public void method () {
        Singleton s = Singleton.getInstance();
        s.number = number;
        s.name = name;
    }

    public MyClass() {

    }

    /*
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
    */
}
