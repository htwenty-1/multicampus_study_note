package dao;

import dto.AccountDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountDao {

    // list
    private List<AccountDto> list = new LinkedList<>();

    // CRUD
    Scanner sc = new Scanner(System.in);

    // create
    // 수입 또는 지출 구분
    public void categorization() {
        System.out.print("수입 또는 지출 입력 >>> ");
        String classify = sc.next();

        while(true) {
            if (classify.equals("수입")) {
                create();
                break;
            } else if (classify.equals("지출")) {
                create();
                break;
            } else {
                System.out.println("잘못된 입력");
                break;
            }
        }
        list.add(new AccountDto(classify));
    }
    // 항목생성
    public void create() {
        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

        System.out.print("항목명 >>> ");
        String use = sc.next();

        System.out.print("금액(숫자만) >>> ");
        int money = sc.nextInt();

        System.out.print("메모 >>> ");
        String memo = sc.next();

        list.add(new AccountDto(dateTime, use, money, memo));
    }

    // allDataPrint : 입력된 모든 항목 출력
    public void allDatePrint() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // Select(검색)
    public void search() {
        System.out.println("검색할 항목 선택");
        System.out.println("1. 월간 데이터 모두");
        System.out.println("2. 월간 총 수입 및 총 지출");
        System.out.println("3. ");
        System.out.println("4. 메모내용으로 검색");
    }
    // Print input data(monthly) 입력한 달의 데이터 모두 출력
    // print revenue and expense(monthly) 월간 총수입과 총지출 나타내기
    // print data calculated by searching with memo variable 내용(memo) 검색어로 산출된 데이터 출력

    // ++ txt 파일로 저장하는 기능 메뉴에 추가하고 리스트에 불러오기 기능 구현하기
}
