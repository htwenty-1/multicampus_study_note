package dao;

import dto.AccountDto;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AccountDao {

    Scanner sc = new Scanner(System.in);

    // list
//    private List<AccountDto> list = new LinkedList<>();
    private List<AccountDto> list = new LinkedList<AccountDto>() {{
        add(0, new AccountDto(LocalDateTime.now(), "수입", "용돈 수령", 500000, "용돈 수령"));
        add(0, new AccountDto(LocalDateTime.of(2021, 12, 18, 10, 15, 20), "수입", "빈병 팔기", 3800, "빈병팔기"));
        add(1, new AccountDto(LocalDateTime.of(2021, 12, 19, 10, 10, 10), "지출", "용돈 삭제", 8000, "용돈 삭제"));
        add(2, new AccountDto(LocalDateTime.of(2021, 11, 10, 20,25,48), "수입", "폐지줍기", 700, "폐지 많이 주웠다!!"));
        add(2, new AccountDto(LocalDateTime.of(2021, 11, 17, 10,25,48), "지출", "떡볶이", 3000, "떡볶이"));
        add(3, new AccountDto(LocalDateTime.of(2021, 11, 21, 22, 15,14), "지출", "야쿠르트", 400, "야쿠르트"));
    }};



    // CRUD - Create : 항목생성
    public void create(String classify) {
        // 입력 시간을 저장하기 위한 객체
        LocalDateTime now = LocalDateTime.now();
//        dateTime = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

        System.out.print("키워드를 입력하세요. >>> ");
        // 지출 카테고리(예: 극장구경, 데이트처럼 단어수준)
        String use = sc.next();

        System.out.print("금액(숫자만)을 입력하세요. >> ");
        int money = sc.nextInt();
        sc.nextLine();

        System.out.print("메모할 내용을 입력하세요. >> ");
        String memo = sc.next();

        list.add(new AccountDto(now, classify, use, money, memo));
    }

    // CRUD - categorization : 항목생성 시 수입, 지출여부
    public void categorization() {
        System.out.print("수입 또는 지출여부를 입력하세요. >> ");
        String classify = sc.next();

        while (true) {
            if (classify.equals("수입")) {
                create(classify);
                break;
            } else if (classify.equals("지출")) {
                create(classify);
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                create(classify);
                break;
            }
        }
    }

    // 모든 데이터 출력
    public void printAllData() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).toString());
        }
    }

    // 검색(입력한 달의 데이터를 모두 출력, 월간 총수입과 총지출 나타내기)
    public void search() {
        // 입력한 연, 월의 데이터 출력
        System.out.print("검색하려는 연도를 입력하세요.(숫자만) >> ");
        int wantSearchYearly = sc.nextInt();
        sc.nextLine();

        System.out.print("검색하려는 월을 입력하세요.(숫자만) >> ");
        int wantSearchMonthly = sc.nextInt();
        sc.nextLine();

        /*
        List<AccountDto> temp = new LinkedList<>();

        for (AccountDto accountDto : list) {
            int year = accountDto.getDateTime().getYear();
            if (year == wantSearchYearly) {
                temp.add(accountDto);
            }
        }

        List<AccountDto> temp2 = new LinkedList<>();
        for (AccountDto accountDto : temp) {
            int month = accountDto.getDateTime().getMonthValue();
            if (month == wantSearchMonthly) {
                temp2.add(accountDto);
            }
        }

        for (int i = 0; i < temp2.size(); i++) {
            System.out.println(temp2.get(i).toString());
        }

         */

        System.out.println("****************************");

        // 수입, 지출 구분해서 넣어주는 리스트
        List<AccountDto> income = new LinkedList<>();
        List<AccountDto> expense = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getClassify().equals("수입")) {
                income.add(list.get(i));
            } else if (list.get(i).getClassify().equals("지출")) {
                expense.add(list.get(i));
            }
        }


        // 월간 총수입, 지출 출력내기
        /*
        list.stream()
            .filter(accountDto -> accountDto.getClassify().equals("수입"))
            .collect(Collectors.groupingBy(accountDto -> accountDto.getDateTime().getYear(), Collectors.groupingBy(accountDto -> accountDto.getDateTime().getMonthValue())))
            .forEach((integer, integerListMap) -> integerListMap.forEach((integer1, accountDtos) -> System.out.println(integer1 + " = " + accountDtos)));
         */

        // 수입
        List<AccountDto> sortedIncomeList = new LinkedList<>();
        for (int i = 0; i < income.size(); i++) {
            int checkYear = income.get(i).getDateTime().getYear();
            int checkMonth = income.get(i).getDateTime().getMonthValue();
            if(checkYear == wantSearchYearly && checkMonth == wantSearchMonthly) {
                sortedIncomeList.add(income.get(i));
            }
        }

        for (AccountDto dto : sortedIncomeList) {
            System.out.println(dto);
        }

        System.out.println("****************************");


        /*
        list.stream()
            .filter(accountDto -> accountDto.getClassify().equals("지출"))
            .collect(Collectors.groupingBy(accountDto -> accountDto.getDateTime().getYear(), Collectors.groupingBy(accountDto -> accountDto.getDateTime().getMonthValue())))
            .forEach((integer, integerListMap) -> System.out.println("integer = " + integer));

         */

        // 지출
        List<AccountDto> sortedExceptionList = new LinkedList<>();
        for (int i = 0; i < expense.size(); i++) {
            int checkYear = expense.get(i).getDateTime().getYear();
            int checkMonth = expense.get(i).getDateTime().getMonthValue();
            if(checkYear == wantSearchYearly && checkMonth == wantSearchMonthly) {
                sortedExceptionList.add(expense.get(i));
            }
        }

        for (AccountDto dto : sortedExceptionList) {
            System.out.println(dto);
        }

        // 총수입
        int total = 0;
        for (int i = 0; i < sortedIncomeList.size(); i++) {
            total += sortedIncomeList.get(i).getMoney();
        }
        System.out.println("총 수입은 " + total + "원 입니다.");

        // 총지출
        total = 0;
        for (int i = 0; i < sortedExceptionList.size(); i++) {
            total += sortedExceptionList.get(i).getMoney();
        }
        System.out.println("총 지출은 " + total + "원 입니다.");

    }

    // 수정 및 삭제
    public void editData() {
        System.out.print("수정하고자 하는 데이터의 번호를 입력하세요. >> ");
        int wantEditNum = sc.nextInt() - 1;
        sc.nextLine();

        System.out.println("수정할 항목이 없으면 Enter키를 누르세요.");

        AccountDto findAccountDto = list.get(wantEditNum);

        System.out.print("수입 또는 지출여부 >> ");
        String inputClassify = sc.nextLine();
        System.out.print("카테고리 입력 >> ");
        String inputUse = sc.nextLine();
        System.out.print("금액 >> ");
        String inputMoney = sc.nextLine();
        //sc.nextLine();
        System.out.print("메모 >> ");
        String inputMemo = sc.nextLine();

        AccountDto accountDto = new AccountDto(findAccountDto.getDateTime(),
            inputClassify.isEmpty() ? findAccountDto.getClassify() : inputClassify,
            inputUse.isEmpty() ? findAccountDto.getUse() : inputUse,
            inputMoney.isEmpty() ? findAccountDto.getMoney() :Integer.parseInt(inputMoney),
            inputMemo.isEmpty() ? findAccountDto.getMemo() : inputMemo);

        list.set(wantEditNum, accountDto);

    }

    public void deleteDate() {
        System.out.print("삭제하고자 하는 데이터의 번호를 입력하세요 >> ");
        int wantDelNum = sc.nextInt() - 1;
        sc.nextLine();

        list.remove(list.get(wantDelNum));

    }


    // 내용(AccountDto 클래스의 멤버변수 memo) 검색어로 산출된 데이터 출력
    public void searchWithMemoVariable() {
        System.out.print("검색할 메모 내용을 입력하세요 >> ");
        String searchMemo = sc.next();

        for (AccountDto accountDto : list) {
            if (accountDto.getMemo().contains(searchMemo)) {
                System.out.println(accountDto);
            }
        }
    }

    // txt파일로 저장하는 기능을 메뉴에 추가하고 리스트로 다시 불러오는 기능 구현
    public void saveAsTextFile() {
        File newFile = new File("/Users/hwangduil/Desktop/Account.text");

        try {
            newFile.createNewFile();
        } catch (Exception e) {
            System.out.println("파일 생성에 실패하였습니다.");
        }



        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            PrintWriter pw = new PrintWriter(bw);

            StringBuilder result = new StringBuilder();

            for(AccountDto accountDto: list) {
                result.append(accountDto.getDateTime()).append(", ");
                result.append(accountDto.getClassify()).append(", ");
                result.append(accountDto.getMoney()).append(", ");
                result.append(accountDto.getMemo()).append(", ");
                result.append(accountDto.getUse()).append(" ");
                result.append("\n");
            }
            pw.print(result);

            pw.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(newFile, true);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                for (AccountDto accountDto : list) {
                    result.append(accountDto.toString());
                }
            }
            fw.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFileAsList() throws IOException {
        File origin = new File("/Users/hwangduil/Desktop/Account.text");

        BufferedReader br = new BufferedReader(new FileReader(origin));

        String line;

        while((line = br.readLine()) != null) {
            System.out.println(line);
            String[] s = line.split(", ");

            AccountDto accountDto = new AccountDto(
                LocalDateTime.parse(s[0]), s[1], s[3], Integer.parseInt(s[2]), s[4]
            );

            list.add(accountDto);
        }
    }
}
