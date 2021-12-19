package main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.AccountDao;

public class Main {

    public static void main(String[] args) {

        // composition of menus

        Scanner sc = new Scanner(System.in);

        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        System.out.println(dateTime);

        AccountDao dao = new AccountDao();

        while(true) {
            // CRUD
            System.out.println("*****************************");
            System.out.println("*********가계부 ver1.0*********");
            System.out.println("**** 1. 수입/지출 항목 입력 *****");
            System.out.println("**** 2. 전체 데이터 열람 ********");
            System.out.println("**** 3. 연/월별 데이터 검색 *****");
            System.out.println("**** 4. 데이터 수정 ***********");
            System.out.println("**** 5. 데이터 삭제 ***********");
            System.out.println("**** 6. 메모 내용으로 검색 *****");
            System.out.println("**** 7. 내역을 파일로 저장 *****");
            System.out.println("**** 8. 파일을 콘솔에 출력 *****");
            System.out.println("**** 9. 프로그램 종료 *********");
            System.out.println("*****************************");
            System.out.print("사용할 메뉴 번호 입력 >> ");
            int select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                case 1:
                    dao.categorization();
                    break;
                case 2:
                    dao.printAllData();
                    break;
                case 3:
                    dao.search();
                    break;
                case 4:
                    dao.editData();
                    break;
                case 5:
                    dao.deleteDate();
                    break;
                case 6:
                    dao.searchWithMemoVariable();
                    break;
                case 7:
                    dao.saveAsTextFile();
                    break;
                case 8:
                    try {
                        dao.readFileAsList();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("없는 메뉴입니다. 다시 시도하세요.");
                    break;
            }
        }

    }


}
