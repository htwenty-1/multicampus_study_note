package main;

import dao.StudentDao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDao dao = new StudentDao();

        //menu
        while(true) {
            // CRUD
            System.out.println("*************************************");
            System.out.println("1. 학생정보 추가");
            System.out.println("2. 학생정보 삭제");
            System.out.println("3. 학생정보 검색");
            System.out.println("4. 학생정보 수정");

            // ETC.
            System.out.println("5. 학생정보 모두 출력");
            System.out.println("6. 종료");
            System.out.println("*************************************");

            System.out.print("메뉴 번호 입력 >> ");
            int menuNum = sc.nextInt();
            System.out.println("*************************************");

            switch(menuNum) {
                case 1:
                    dao.insert();
                    break;
                case 2:
                    dao.delete();
                    break;
                case 3:
                    dao.select();
                    break;
                case 4:
                    dao.update();
                    break;
                case 5:
                    dao.alldata();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }

    }
}

