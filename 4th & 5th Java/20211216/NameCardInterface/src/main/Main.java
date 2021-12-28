package main;

import cls.NameCard;
import cls.PrintNameCard;
import cls.PrintNamePhoneCard;
import cls.PrintNamePhoneEmailCard;

public class Main {

    public static void main(String[] args) {

        NameCard nameCard = new NameCard("홍길동", "123-4567", "h.gildong@gmail.com");

        nameCard.setPrintCard(new PrintNameCard());
        nameCard.print();

        nameCard.setPrintCard(new PrintNamePhoneCard());
        nameCard.print();

        nameCard.setPrintCard(new PrintNamePhoneEmailCard());
        nameCard.print();

    }
}

/*

    ParentClass --> int age; String name; void parentMethod();

    ChildClass --> void childMethod();

    ChildClass extends ParentClass ==> int age; String name; void parentMethod(); + void childMethod();

    ParentClass ---> childMethod();

    ParentClass pc = new ChildClass(); // 자식이 부모로 바뀌어

    (ChildClass) ParentClass = pc;     //


    프론트단 <---- jQuery Ajax, RestAPI, JSON ----> 백엔드단
    Spring Framework =====> Spring Boot
*/