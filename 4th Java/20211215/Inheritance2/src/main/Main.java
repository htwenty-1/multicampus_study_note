package main;

import cls.ChildClass;
import cls.ParentClass;

public class Main {

    public static void main(String[] args) {
        // MyClass cls = new MyClass();
//         MyClass cls1 = new MyClass(1, "aaa");

        // ChildClass cc = new ChildClass();

        ParentClass pc = new ParentClass(11, "홍길동");

        ChildClass cc1 = new ChildClass(11, "홍길동", 180.1);
    }
}
