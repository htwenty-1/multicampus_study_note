package main;

import main.cls.Book;
import main.cls.Magazine;

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book();
        Magazine magazine = new Magazine();

        // Java Pro
        book.isbn = "21424";
        book.title = "Java Pro";
        book.author = "김하나";
        book.publisher = "Jaen.kr";
        book.price = 15000;

        System.out.println("*********************** 도서목록 **************************");
        System.out.println(book);

        // OOAD
        book.isbn = "35335";
        book.title = "OOAD 분석, 설계";
        book.author = "소나무";
        book.publisher = "Jaen.kr";
        book.price = 30000;

        System.out.println(book);

        // Java World
        magazine.isbn = "35535";
        magazine.title = "Java World";
        magazine.author = "편집부";
        magazine.publisher = "androidjava.com";
        magazine.price = 7000;
        magazine.year = 2013;
        magazine.month = 2;

        System.out.println(magazine);

    }
}
