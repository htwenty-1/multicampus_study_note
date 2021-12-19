//package dao;
//
//import dto.AccountDto;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//public class AccountDao1 {
//
//    String dateTime;
//
//    // list
//    private List<AccountDto> list = new LinkedList<>();
//
//    // CRUD
//    static Scanner sc = new Scanner(System.in);
//
//    // create
//    // 수입 또는 지출 구분
//    public void categorization() {
//        System.out.print("수입 또는 지출 입력 >>> ");
//        String classify = sc.next();
//
//        while(true) {
//            if (classify.equals("수입")) {
//                create();
//                break;
//            } else if (classify.equals("지출")) {
//                create();
//                break;
//            } else {
//                System.out.println("잘못된 입력");
//                break;
//            }
//        }
//        list.add(new AccountDto(classify));
//    }
//
//    // 항목생성
//    public void create() {
//        LocalDateTime now = LocalDateTime.now();
//        dateTime = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
//
//        System.out.print("항목명 >>> ");
//        String use = sc.next();
//
//        System.out.print("금액(숫자만) >>> ");
//        int money = sc.nextInt();
//
//        System.out.print("메모 >>> ");
//        String memo = sc.next();
//
//        list.add(new AccountDto(dateTime, use, money, memo));
//    }
//
//    // allDataPrint : 입력된 모든 항목 출력
//    public void allDatePrint() {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }
//
//    // Select(검색)
//    public void search() {
//        System.out.print("검색할 항목 선택 >> ");
//        System.out.println("1. 월간 데이터 모두");
//        System.out.println("2. 월간 총 수입 및 총 지출");
//        System.out.println("3. 날짜로 검색");
//        System.out.println("4. 메모내용으로 검색");
//
//        int selectIndex = sc.nextInt();
//
//        while(true) {
//            if (selectIndex == 1) {
//                System.out.print("찾고자 하는 월(숫자만) >> ");
//                int month = (char) sc.nextInt();
//                if (month < 80 || month > 89) {
//                    System.out.println("잘못된 입력입니다.");
//                } else {
//                    int index = -1;
//                    for (int i = 0; i < list.size(); i++) {
////                        AccountDto dto = list.get(i);
//                        if(dateTime.substring(6, 8).equals(month)) {
//                            index = i;
//                            break;
//                        }
//                    }
//                    System.out.println(list.get(index));
//                }
//            } else if (selectIndex == 2) {
//                //
//
//            } else if (selectIndex == 3) {
//                System.out.print("날짜를 yyyy년 MM월 dd일 형식으로 입력 >> ");
//                String date = sc.next();
//
//                int index = -1;
//                for (int i = 0; i < list.size(); i++) {
//                    if (list.get(i).equals(date)) {
//                        index = i;
//                        break;
//                    }
//                }
//                System.out.println(list.get(index));
//
//            } else if (selectIndex == 4) {
//                System.out.print("검색할 메모 내용 >> ");
//                String memoContent = sc.next();
//
//                int index = -1;
//                for (int i = 0; i < list.size(); i++) {
//                    if(list.get(i).equals(memoContent)) {
//                        index = i;
//                        break;
//                    }
//                }
//                System.out.println(list.get(index));
//
//            } else {
//                System.out.println("잘못된 메뉴 선택. 처음부터 다시 시도");
//                break;
//            }
//        }
//    }
//    // Print input data(monthly) 입력한 달의 데이터 모두 출력
//    // print revenue and expense(monthly) 월간 총수입과 총지출 나타내기
//    // print data calculated by searching with memo variable 내용(memo) 검색어로 산출된 데이터 출력
//
//    // 배열 찾아주는 함수
//    public void searchWithMonth(int month) {
//        int index = -1;
//        for (int i = 0; i < list.size(); i++) {
//
//        }
//    }
//
//    // ++ txt 파일로 저장하는 기능 메뉴에 추가하고 리스트에 불러오기 기능 구현하기
//}
