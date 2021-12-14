package dao;

import dto.StudentDto;

import java.util.Scanner;

// 데이터의 접근, 관리
public class StudentDao {

    Scanner sc = new Scanner(System.in);

    private final StudentDto[] student = new StudentDto[20];
    private int count;
    private int wantDel;

    public StudentDao() {
        count = 0;

        student[0] = new StudentDto(1001, "홍길동", 171.1, 90, 85);
        student[1] = new StudentDto(1002, "성춘향", 165.3, 100, 90);
        student[2] = new StudentDto(1003, "일지매", 182.6, 80, 95);

        count = 3;
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
        // 정보를 수정하기 위해 학생들 목록을 보여줌
        studentArr();

        System.out.print("삭제할 학생정보 행 번호 입력 >> ");
        int delNum = sc.nextInt();

        student[delNum-1] = null;
        System.out.println("삭제 완료");

    }

    public void select() {  // 학생정보 검색

        System.out.print("검색할 학생 이름 입력 >> ");
        String name = sc.next();

        // 찾기
        int index = -1;     // 못찾을 경우 대배해서 인덱스넘버 -1로 선언
        for (int i = 0; i < student.length; i++) {
            StudentDto dto = student[i];
            if(dto != null && !dto.getName().equals("")) {
                if (dto.getName().equals(name)) {
                    index = i;
                    break;
                }
            }
        }

        // 출력
        if(index == -1) {
            System.out.println("데이터를 찾을 수 없음");
        } else {
            System.out.println(student[index].toString());
        }


    }

    public void update() {  // 학생정보 수정
        // 정보를 수정하기 위해 학생들 목록을 보여줌
        studentArr();


        for (int i = 0; i < student.length; i++) {
            System.out.print("수정할 학생 행번호 입력 >> ");
            wantDel = sc.nextInt();

            System.out.println(student[wantDel-1] + "을 수정합니다.");    // 위에서 i+1로 인덱스 넘버를 지정했기 때문에 입력한 번호의 -1번째를 수정하겠다고 명시
            System.out.println("변경 항목 선택");
            System.out.println("1. 번호, 2. 이름, 3. 키, 4. 영어점수, 5. 수학점수");
            System.out.print("번호입력 >> ");
            int selNum = sc.nextInt();

            switch (selNum) {
                case 1:
                    System.out.print("바꿀 내용 입력 >> ");
                    int changeNum = sc.nextInt();
                    student[selNum-1].setNumber(changeNum);
                    break;
                case 2:
                    System.out.print("바꿀 내용 입력 >> ");
                    String changeName = sc.next();
                    student[selNum-1].setName(changeName);
                    break;
                case 3:
                    System.out.print("바꿀 내용 입력 >> ");
                    double changeHeight = sc.nextDouble();
                    student[selNum-1].setHeight(changeHeight);
                    break;
                case 4:
                    System.out.print("바꿀 내용 입력 >> ");
                    int changeEng = sc.nextInt();
                    student[selNum-1].setEng(changeEng);
                    break;
                case 5:
                    System.out.print("바꿀 내용 입력 >> ");
                    int changeMath = sc.nextInt();
                    student[selNum-1].setMath(changeMath);
                    break;
            }

            break;

        }

    }

    // 전부보기 : 확인용
    public void alldata() {
        studentArr();
    }

    // 학생 정보를 불러오는 멤버 메서드
    public void studentArr() {
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {
                System.out.println((i+1) + ". " + student[i]);
            } else {
                System.out.print("");
            }
        }
    }


}
