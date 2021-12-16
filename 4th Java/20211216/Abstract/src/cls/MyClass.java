package cls;

import abstractCls.AbstractClass;

public class MyClass extends AbstractClass {

    public MyClass() {
        super();
    }

    // 그냥 사용하면 에러가 발생하니까 @Override 해줘야함
    @Override
    public void abstractMethod() {
        System.out.println("MyClass abstractMethod()");
    }

    public void func() {
        System.out.println("MyClass func()");
    }
}
