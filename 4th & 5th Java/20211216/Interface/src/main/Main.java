package main;

import cls.MyClass;
import cls.YouClass;
import inter.MyInterface;

public class Main {

    public static void main(String[] args) {

        // MyClass myi = new MyInterface();     안됨...

        MyClass mycls = new MyClass();
        mycls.method();

        MyInterface myi = new MyClass();        // 부모인터페이스를 인스턴스로 자식 클래스를 넣어주는건 가능
        myi.method();

        MyInterface myinter = new MyInterface() {
            @Override
            public void method() {
                System.out.println("MyInterface method()");
            }
        };

        myinter.method();

        YouClass ycls = new YouClass();
        ycls.func();
        ycls.method();

        // 모든걸 다 담을 수 있는거는 바로바로 Object(최상위 클래스)
        // 원래는 모든 클래스는 Object의 상속을 받게 되어 있는데, 그냥 생략하고 안써주는거임 왜냐면 당연한 사실이니까

        Object myobj = new MyClass();
        Object youobj = new YouClass();


    }
}
