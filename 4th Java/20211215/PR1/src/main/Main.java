package main;

import cls.ClassTest_2;

public class Main {

    public static void main(String[] args) {
        ClassTest_2 ct = new ClassTest_2("이지나", 3000, "교육부");
        ct.callSuperThis();
        ct.getInformation();
    }
}
