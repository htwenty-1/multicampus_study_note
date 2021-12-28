package com.company;

import java.util.*;

public class Main {

//    private static String[][] students;

    public static void main(String[] args) {
        /*
           2021년 12월 10일 과제

           1. 학생들의 정보를 2차원 배열에서 입력 받는다.
             1-1. 이름, 생년월일, 국어, 영어, 수학 점수
             1-2. 입력받을 학생 수, i번째 학생의 이름, 생년월일, 국어, 영어, 수학점수 순으로 입력받기
           2. 각 학생들의 국어, 영어, 수학 점수를 합친 총점, 개개인의 총점을 구한다.
           3. 학생들의 국어 점수 총점을 구한다.
           4. 영어 점수의 최고점을 구한다.
           5. 수학점수의 최저점을 구한다.
           6. 학급에서 1등은 누구인지 이름을 출력한다.
        */

        // 학생들의 정보를 2차원 배열에 입력 받기
        String[][] students = countStudent();
        // System.out.println(scores);

        // 각 과목별 총점 출력
        int[] scores = totalScore(students);
        System.out.println("국어 총점 : " + scores[0]);
        System.out.println("영어 총점 : " + scores[1]);
        System.out.println("수학 총점 : " + scores[2]);

        // 개인별 총점 출력
        int[] indivTotal = individualTotal(students);
        for (int i = 0; i < indivTotal.length; i++) {
            System.out.println((i+1) + "번째 학생의 총점은 " + indivTotal[i] + "점");
        }

        // 국어점수의 총점 구하기
        int korTotal = koreanTotal(students);
        System.out.println("모든 학생의 국어 총점은 " + korTotal + "점");

        // 수학점수의 총점 구하기
        int mathTotal = mathTotal(students);
        System.out.println("모든 학생의 수학 총점은 " + mathTotal + "점");

        // 영어점수의 총점 구하기
        int engTotal = engTotal(students);
        System.out.println("모든 학생의 영어 총점은 " + engTotal + "점");

        // 영어점수의 최고점 구하기
        int engTop = engTop(students);
        System.out.println("영어점수의 최고점은 " + engTop + "점");

        // 수학점수의 최저점 구하기
        int mathLow = mathLow(students);
        System.out.println("수학점수의 최저점은 " + mathLow + "점");

        // 학급에서 1등 누군지 구하기
        String ranking = rank(students);
        System.out.println("1등 학생의 이름은 \"" + ranking + "\"");


    }

    // 학생 수 입력
    public static String[][] countStudent () {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 학생 수 >> ");
        int count = sc.nextInt();

        String[][] students = new String[count][5];

        for (int i = 0; i < students.length; i++) {
            System.out.print((i+1) + "번째 학생의 이름 >> ");
            students[i][0] = sc.next();
            System.out.print((i+1) + "번째 학생의 생년월일(yyyy-mm-dd) >> ");
            students[i][1] = sc.next();
            System.out.print((i+1) + "번째 학생의 국어점수 >> ");
            students[i][2] = sc.next();
            System.out.print((i+1) + "번째 학생의 영어점수 >> ");
            students[i][3] = sc.next();
            System.out.print((i+1) + "번째 학생의 수학점수 >> ");
            students[i][4] = sc.next();
        }

        return students;
    }

    // 전체 점수 합
    public static int[] totalScore (String[][] student) {
        int[] scores = { 0, 0, 0 };

        for(int j=2; j < student.length; j++) {
            for (String[] students : student) {
                scores[j - 2] += Integer.parseInt(students[j]);
            }
        }

        return scores;
    }

    // 개인별 점수 합
    public static int[] individualTotal (String[][] student) {
        int[] scores = new int [student.length];
        int total = 0;

        for(int i=0; i < student.length; i++) {
            total = 0;
            for (int j=2; j < student[0].length; j++) {
                total += Integer.parseInt(student[i][j]);
            }
            scores[i] = total;
        }
        return scores;
    }

    // 국어 점수의 총점
    public static int koreanTotal (String[][] student) {
        int total = 0;

        for (int i = 0; i < student.length; i++) {
            total += Integer.parseInt(student[i][2]);
        }

        return total;
    }

    // 수학 점수의 총점
    public static int mathTotal (String[][] student) {
        int total = 0;

        for (int i = 0; i < student.length; i++) {
            total += Integer.parseInt(student[i][4]);
        }

        return total;
    }

    // 영어 점수의 총점
    public static int engTotal (String[][] student) {
        int total = 0;

        for (int i = 0; i < student.length; i++) {
            total += Integer.parseInt(student[i][3]);
        }

        return total;
    }
    
    // 영어 점수의 최고점
    public static int engTop (String[][] student) {
        int[] scoreArr = new int [student.length];

        // 영어점수 가져오기
        for (int i = 0; i < student.length; i++) { 
            scoreArr[i] += Integer.parseInt(student[i][3]);
        }
        
        // 내림차순으로 정렬
        // Arrays.sort(scoreArr);
        int temp;
        for (int i = 0; i < scoreArr.length - 1; i++) {
            for (int j = i+1; j < scoreArr.length; j++) {
                if (scoreArr[i] < scoreArr[j]) {
                    temp = scoreArr[i];
                    scoreArr[i] = scoreArr[j];
                    scoreArr[j] = temp;
                }
            }
        }

        // 최대값 뽑기
        int result = scoreArr[0];

        return result;
        
    }

    // 수학점수의 최저점
    public static int mathLow (String[][] student) {
        int[] scoreArr = new int [student.length];

        // 수학점수 가져오기
        for (int i = 0; i < student.length; i++) {
            scoreArr[i] += Integer.parseInt(student[i][4]);
        }

        // 오름차순으로 정렬
        // Arrays.sort(scoreArr);
        int temp;
        for (int i = 0; i < scoreArr.length - 1; i++) {
            for (int j = i+1; j < scoreArr.length; j++) {
                if (scoreArr[i] > scoreArr[j]);
                    temp = scoreArr[i];
                    scoreArr[i] = scoreArr[j];
                    scoreArr[j] = temp;
            }
        }

        // 최소값 뽑기
        int result = scoreArr[0];

        return result;

    }

    // 1등 학생 구하기
    public static String rank (String student[][]) {
        int[] toCompareScore = new int [student.length];

        int total;
        String index = "";

        for (int i = 0; i < student.length; i++) {
            total = 0;
            for (int j = 2; j < student[0].length; j++) {
                total += Integer.parseInt(student[i][j]);
            }
            toCompareScore[i] += total;

            if (toCompareScore[i] > toCompareScore[0]) {
                index = student[i][0];
            }
        }

        return index;

    }
}
