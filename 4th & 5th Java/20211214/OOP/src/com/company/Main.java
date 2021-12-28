package com.company;

public class Main {

    public static void main(String[] args) {

        /*
            OOP : Object Oriented Programming, 객체 지향 프로그래밍
            POP : Procedure Oriented Programming, 절차 지향 프로그래밍

            1. 절차지향은 객체지향에 비해 속도는 빠르다.
            2. 그렇지만 같은 로직을 가진 다양한 객체를 만드는 경우에는 객체 지향이 더 효율적이다.
            3. OOP의 특징
               - 은닉성(캡슐화)
               - 상속성
               - 다형성
               - 추상화
        cls1.name = "성춘향";
        cls1.method();

        // 절차지향
        boolean[] isPowerOn = new boolean[2];
        int[] channel = new int[2];
        int[] volume = new int[2];

        String maker[] = new String[2];

        isPowerOn[0] = true;
        channel[0] = 23;
        volume[0] = 10;
        maker[0] = "Samsung";

        isPowerOn[1] = false;
        channel[1] = 50;
        volume[1] = 0;
        maker[1] = "LG";

        for (int i = 0; i < channel.length; i++) {
            System.out.println("TV 제조사는 " + maker[i] + "이고, 상태는 " + isPowerOn[i] + "이고, " + channel[i] + "번을 보고 있으며 볼륨은 " + volume[i] + "입니다.");
        }




        // 객체지향
        /*
        TV tv1 = new TV();
        tv1.isPowerOn = true;
        tv1.channel = 23;
        tv1.volume = 10;
        tv1.method();

        TV tv2 = new TV();
        tv2.isPowerOn = false;
        tv2.channel = 50;
        tv2.volume = 0;
        tv2.method();
        */

        TV[] tvArray = new TV[2];   // 이건 배열 생성이지 객체 생성이 아닙니다~ == TV tv1, tv2
        for (int i = 0; i < tvArray.length; i++) {
            tvArray[i] = new TV();  // 객체 생성
        }

        tvArray[0].isPowerOn = true;
        tvArray[0].channel = 23;
        tvArray[0].volume = 10;
        tvArray[0].maker = "Samsung";

        tvArray[1].isPowerOn = false;
        tvArray[1].channel = 50;
        tvArray[1].volume = 0;
        tvArray[1].maker = "LG";

        for (int i = 0; i < tvArray.length; i++) {
            tvArray[i].method();
        }

    }

}

class TV {
    boolean isPowerOn;
    int channel;
    int volume;
    String maker;

    void method() {
        System.out.println("TV는 제조사는 " + maker + "이며, 상태는 " + isPowerOn + "이고, " + channel + "번을 보고 있으며 볼륨은 " + volume + "입니다.");
    }
}

// class 생성
class MyClass {
    // Member Variable
    int number;
    String name;

    // Member Method
    void method() {
        System.out.println("MyClass method()");
    }

}
