package main;

import cls.ChildClass;

public class Main {

    public static void main(String[] args) {
        ChildClass cc = new ChildClass();

        cc.parentMethod();
        cc.childMethod();
    }
}
