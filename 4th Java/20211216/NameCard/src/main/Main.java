package main;

import cls.NameCard;
import cls.PrintNameCard;
import cls.PrintNamePhoneCard;

public class Main {

    public static void main(String[] args) {

        NameCard namecard = new NameCard("홍길동", "123-4567", "hong.gildong@gmail.com");

        namecard.setPrintNameCard(new PrintNameCard());
        namecard.print();

        PrintNamePhoneCard pnpc = new PrintNamePhoneCard();
        namecard.setPrintNamePhoneCard(pnpc);
        namecard.printPhone();

    }
}
