package dto;

import main.Main;

public class MyClass extends Main {

    // 멤버변수
    private int number;
    private String name;
    private double height;
    private String gender;

    // 생성자
    public MyClass() {}

    public MyClass(int number, String name, double height) {
        this.number = number;
        this.name = name;
        this.height = height;
    }

    // getter, setter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
