package main;

import main.cls.Book;
import main.cls.Magazine;

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000);

        System.out.println("*********************** 도서목록 **************************");
        System.out.println(book);

        Book book2 = new Book("35335", "OOAD 분석, 설계", "소나무", "Jaen.kr", 30000);

        System.out.println(book2);

        Magazine magazine = new Magazine("35535", "Java World", "편집부", "androidjava.com", 7000, 2013, 2);

        System.out.println(magazine);

    }
}
