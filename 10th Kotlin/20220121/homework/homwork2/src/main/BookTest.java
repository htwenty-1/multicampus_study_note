package main;

import main.cls.Book;
import main.cls.Magazine;

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book();
        Magazine magazine = new Magazine();

        // Java Pro
        book.setIsbn("21424");
        book.setTitle("Java Basic");
        book.setAuthor("김하나");
        book.setPublisher("Jaen.kr");
        book.setPrice(15000);
        book.setDesc("Java 기본 문법");
        System.out.println("*********************** 도서목록 **************************");
        System.out.println(book);

        //JDBC Pro
        book.setIsbn("33455");
        book.setTitle("JDBC Pro");
        book.setAuthor("김철수");
        book.setPublisher("Jaen.kr");
        book.setPrice(23000);
        book.setDesc("");
        System.out.println(book);

        // Servlet/JSP
        book.setIsbn("55355");
        book.setTitle("Servlet/JSP");
        book.setAuthor("박자바");
        book.setPublisher("Jaen.kr");
        book.setPrice(41000);
        book.setDesc("Model2 기반");
        System.out.println(book);

        // Android App
        book.setIsbn("35322");
        book.setTitle("Android App");
        book.setAuthor("홍길동");
        book.setPublisher("Jaen.kr");
        book.setPrice(25000);
        book.setDesc("Lightweight Framework");
        System.out.println(book);

        // OOAD
        book.setIsbn("35335");
        book.setTitle("OOAD 분석, 설계");
        book.setAuthor("소나무");
        book.setPublisher("Jaen.kr");
        book.setPrice(30000);
        book.setDesc("");

        System.out.println(book);

        // Java World
        magazine.setIsbn("35535");
        magazine.setTitle("Java World");
        magazine.setAuthor("편집부");
        magazine.setPublisher("Jaen.kr");
        magazine.setPrice(7000);
        magazine.setDesc("");
        magazine.setYear(2013);
        magazine.setMonth(2);
        System.out.println();
        System.out.println("*********************** 잡지목록 **************************");
        System.out.println(magazine);

        // Mobile World
        magazine.setIsbn("35434");
        magazine.setTitle("Mobile World");
        magazine.setAuthor("편집부");
        magazine.setPublisher("Jaen.kr");
        magazine.setPrice(8000);
        magazine.setDesc("");
        magazine.setYear(2013);
        magazine.setMonth(8);
        System.out.println(magazine);

        // Next Web
        magazine.setIsbn("35434");
        magazine.setTitle("Next Web");
        magazine.setAuthor("편집부");
        magazine.setPublisher("Jaen.kr");
        magazine.setPrice(10000);
        magazine.setDesc("AJAX 소개");
        magazine.setYear(2012);
        magazine.setMonth(10);
        System.out.println(magazine);

        // Architecture
        magazine.setIsbn("35434");
        magazine.setTitle("Architecture");
        magazine.setAuthor("편집부");
        magazine.setPublisher("Jaen.kr");
        magazine.setPrice(5000);
        magazine.setDesc("java 시스템");
        magazine.setYear(2010);
        magazine.setMonth(3);
        System.out.println(magazine);

        // Data Modeling
        magazine.setIsbn("35434");
        magazine.setTitle("Data Modeling");
        magazine.setAuthor("편집부");
        magazine.setPublisher("Jaen.kr");
        magazine.setPrice(14000);
        magazine.setDesc("");
        magazine.setYear(2012);
        magazine.setMonth(12);
        System.out.println(magazine);

    }
}
