package dao;

import dto.StudentDto;

import java.util.Arrays;
import java.util.Scanner;

// 데이터의 접근, 관리
public class StudentDao {

    Scanner sc = new Scanner(System.in);

    private StudentDto student[] = new StudentDto[20];
    private int count;

    public StudentDao() {
        count = 0;
    }


    // CRUD
    public void insert() {  // 학생정보 추가
        System.out.print("번호 = ");
        int number = sc.nextInt();

        System.out.print("이름 = ");
        String name = sc.next();

        System.out.print("신장 = ");
        double height = sc.nextDouble();

        System.out.print("영어점수 = ");
        int eng = sc.nextInt();

        System.out.print("수학점수 = ");
        int math = sc.nextInt();

        student[count] = new StudentDto(number, name, height, eng, math);
        count++;
    }

    public void delete() {  // 학생정보 삭제
        for (int i = 0; i < student.length; i++) {
            System.out.println((i+1) + ". " + student[i]);
        }
        System.out.print("삭제할 학생정보 행 번호 입력 >> ");
        int delNum = sc.nextInt();

        for (int i = 0; i < delNum; i++) {
            student[i] = null;
        }
        System.out.print("삭제 완료");

    }

    public void select() {  // 학생정보 검색

    }

    public void update() {  // 학생정보 수정

    }

    // 전부보기 : 확인용
    public void alldata() {

    }


}
