package main;

import Singleton.Singleton;
import cls.HeClass;
import cls.MyClass;
import cls.YouClass;

public class Main {

    public static void main(String[] args) {

        MyClass mycls = new MyClass();
        YouClass youcls = new YouClass();
        HeClass hecls = new HeClass();

        // youcls.setTotal(mycls.getNumber());
        // youcls.setTotal(mycls.getName());

        mycls.method();
        System.out.println();
//        youcls.func();
//        hecls.method();

//        System.out.println(youcls.toString());
//
//        Singleton s = Singleton.getInstance();
//        System.out.println(s);
//
//        s = Singleton.getInstance();
//        System.out.println(s);

    }
}
