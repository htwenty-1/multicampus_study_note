package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import dto.AccountDto;
import dao.AccountDao;

public class Main {

    public static void main(String[] args) {

        // composition of menus

        Scanner sc = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        System.out.println(dateTime);

        while(true) {
            // CRUD
            System.out.println("*****************************");
            System.out.println("*********가계부 ver1.0*********");
            System.out.println("**** 1. 수입/지출 항목 입력 *****");
            System.out.println("**** 2. 수입/지출 모두 조회 *****");
            System.out.println("**** 3. 수입/지출 항목 검색 *****");   // 조회 + 수정 + 삭제
            System.out.println("*****************************");

            int select = sc.nextInt();

            switch (select) {
                case 1:
                    //
                    break;
            }
        }

    }


}
