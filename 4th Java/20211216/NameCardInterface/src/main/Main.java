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
