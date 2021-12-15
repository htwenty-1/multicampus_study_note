package main;

import human.Student;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student se[] = new Student[3];

        se[0] = new Student("홍길동", 15, 171, 81, "201901");
        se[1] = new Student("정길동", 13, 183, 72, "201502");
        se[2] = new Student("박길동", 16, 175, 65, "202103");

        System.out.printf("%4s %5s %8s %8s %8s\n", "name", "나이", "신장", "몸무게", "학번");    // %칸수s

        for (Student sm : se)
            System.out.println(sm.toString());

    }

}
