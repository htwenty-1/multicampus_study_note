package cls;

import inter.MyInterface;
import inter.YouInterface;

public class YouClass implements MyInterface, YouInterface {        // 이름하여 다중상속

    @Override
    public void method() {
        System.out.println("YouClass method()");
    }

    @Override
    public void func() {
        System.out.println("YouClass func()");
    }
}
