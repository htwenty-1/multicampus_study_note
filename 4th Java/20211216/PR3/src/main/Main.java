package main;

import cls.Dropship;
import cls.Marine;
import cls.Tank;
import cls.Unit;

public class Main {

    public static void main(String[] args) {

        /*
            문3) 아래 세 개의 클래스로부터 공통부분을 뽑아서
            Unit이라는 클래스를 만들고, 이 클래스를 상속받도록 코드를 변경하시오.
        */

        Unit unitArr[] = new Unit[10];
        unitArr[0] = new Marine(1, 2);
        unitArr[1] = new Tank(3, 4);
        unitArr[3] = new Dropship(5, 6);
    }
}
