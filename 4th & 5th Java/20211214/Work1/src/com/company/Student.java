package com.company;

public class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int total;

    int getTotal(int kor, int eng, int math) {
        total = kor + eng + math;
        return total;
    }

    double getAverage() {
        return (double)total / 3;
    }

    /*
    int getTotal(int kor, int eng, int math) {
        this.kor = kor;
        this.math = math;
        this.eng = eng;

        int total = kor, math, eng;

        return total;
    }

    double getAverage() {
        return (double)(kor + eng + math) / 3;
    }
    */
}
