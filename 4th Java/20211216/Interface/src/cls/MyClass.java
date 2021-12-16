package cls;

import inter.MyInterface;

public class MyClass implements MyInterface {       // 상속 받을 때 implements
    @Override
    public void method() {
        System.out.println("MyClass method()");     // 이렇게 인터페이스에 있는걸 정의해서 써준다
    }
}
