package main.cls;

public class Magazine {

    public String isbn;
    public String title;
    public String author;
    public String publisher;
    public int year;
    public int month;
    public int price;
    public String desc;

    public Magazine() {
    }

    public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price, String desc) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.month = month;
        this.price = price;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return isbn + "\t | "+ title + "\t | " + author + " | " + publisher + "\t | " + price + "\t | " + year + "." + month;
    }
}
