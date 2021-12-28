package main;

import cls.Dropship;
import cls.Marine;
import cls.Tank;

public class Main {

    public static void main(String[] args) {

        /* heap 메모리 주소
        System.out.println(new Marine(1, 2));
        System.out.println(new Tank(3, 4));
        System.out.println(new Dropship(5, 6));
        */

        Marine m = new Marine(1, 2);
        m.move(1, 2);
        m.stop();
       // 이런식으로

    }
}
