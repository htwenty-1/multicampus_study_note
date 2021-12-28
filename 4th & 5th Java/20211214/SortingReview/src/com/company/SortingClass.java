package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SortingClass {

    // 멤버변수는 클래스 내부에서 자유롭게 접근 가능함.
    int number[];
    int updown;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 개를 정렬합니까? >> ");
        int count = sc.nextInt();

        number = new int [count];

        for (int i = 0; i < number.length; i++) {
            System.out.println((i+1) + "번째 숫자를 입력하세요. >> ");
            number[i] = sc.nextInt();
        }

        System.out.println("오름차순 정렬은 1번, 내림차순 정렬은 2번 >> ");
        updown = sc.nextInt();
    }

    void sorting() {
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {

                if(updown == 1) {
                    if (number[i] > number[j]) {
                        swap(i, j);
                    }
                } else {
                    if (number[i] < number[j]) {
                        swap(j, i);
                    }
                }

            }
        }
    }

    void swap(int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }

    void result() {
        System.out.println(Arrays.toString(number));
    }

}
