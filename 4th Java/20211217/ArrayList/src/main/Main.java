package main;

import dto.MyClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static <Myclass> void main(String[] args) {

        /*
            상속관계
            List (Interface)            ---> 목록
              |_ ArrayList (Class)      ---> 배열 리스트
              |                              배열처럼 사용할 수 있는 목록.
              |                              선형 구조를 갖는다. (예)    O-O-O-O-O-O-....-O
              |                              검색 속도가 빠르다.
              |                              'Index'로 접근/제어 할 수 있다.
              |
              |_ LinkedList (ClasS)     ----> 추가 / 삭제의 속도가 빠르다.  ==> 게임

        */

        // ArrayList<Integer> arrList = new ArrayList<Integer>();           // class
        List<Integer> arrList = new ArrayList<Integer>();                   // interface

        // CRUD

        // Create
        arrList.add(111);

        Integer in = new Integer(222);  // 생성하고 집어넣기
        arrList.add(in);

        arrList.add(new Integer(333));

        int len = arrList.size();

        System.out.println("list 크기 : " + len);

        /*
          arrList[0] = 111
          arrList[1] = 222
          arrList[2] = 333인 상태
        */

        System.out.println(arrList.get(0)); // 0번째 index를 get

        System.out.println("***********************************");

        // 싹다 꺼내와
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }

        System.out.println("***********************************");

        for (Integer index: arrList) {
            System.out.println(index);
        }

        System.out.println("***********************************");


        // 원하는 위치에 추가하기(현재 있는 데이터 사이에 끼워넣기)
        arrList.add(1, 200);

        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
            System.out.println(i + "번째: " + arrList.get(i));
            System.out.println("list 크기: " + arrList.size());
        }

        System.out.println("***********************************");
        /* ************************************************************************************************* */

        // Delete
        Integer num = arrList.remove(2);      // 삭제 + 지워주는 데이터 리턴
        System.out.println("삭제된 데이터: " + num);
        for ( Integer number : arrList) {
            System.out.println(number);
        }
        System.out.println("list 크기: " + arrList.size());

        System.out.println("***********************************");

        /* ************************************************************************************************* */

        // Read --> 검색
        int index = arrList.indexOf(333);       // index number
        System.out.println("index number: " + index);

        System.out.println("***********************************");

        /* 중요 */
        index = -1;
        for (int i = 0; i < arrList.size(); i++) {
            Integer val = arrList.get(i);
            if(val == 200) {
                index = i;
                break;
            }
        }
        System.out.println("200의 위치는 " + index);

        System.out.println("***********************************");

        /* ************************************************************************************************* */

        // Update
        Integer newVal = new Integer(100);
        arrList.set(0, newVal);
        for ( Integer n : arrList ) {
            System.out.println(n);
        }

        System.out.println("***********************************");

        /* ************************************************************************************************* */

        /*
        // ArrayList<String> slist 생성해서 추가, 삭제, 검색, 수정 구현하기


        // 생성 및 추가
        ArrayList<String> slist = new ArrayList<String>();

        String name = "홍길동";
        String idNumber = "960711-1234567";
        String telephone = "010-1234-5678";
        String nickname = "돼지";

        slist.add(name);
        slist.add(idNumber);
        slist.add(telephone);
        slist.add(nickname);

        System.out.println("데이터가 ArrayList에 추가됨");

        for (int i = 0; i < slist.size(); i++) {
            System.out.println(slist.get(i));
        }

        System.out.println("***********************************");

        // 삭제 (별명을 지워보자)

        String removeInformation = slist.remove(3);
        System.out.println(removeInformation + "가 삭제됨.");

        for (int i = 0; i < slist.size(); i++) {
            System.out.println(slist.get(i));
        }

        System.out.println("***********************************");

        // 검색
        index = -1;
        for (int i = 0; i < slist.size(); i++) {
            String value = slist.get(i);
            if(value.equals("010-1234-5678")) {
                index = i;
                break;
            }
        }

        System.out.println("전화번호 위치는 " + index);

        System.out.println("***********************************");

        // 수정
        String gender = "Male";

        slist.set(1, gender);

        for ( String g : slist ) {
            System.out.println(g);
        }

        System.out.println("***********************************");

        // 전체 확인

        for (String inf : slist) {
            System.out.println(inf);
        }
       */


        /* ************************************************************************************************* */
        /* ************************************************************************************************* */
        /* ************************************************************************************************* */
        /* ************************************************************************************************* */
        /* ************************************************************************************************* */
        /* ************************************************************************************************* */

        // 추가(3), 삭제(1), 검색(1), 수정(1) 구현 + 확인까지!!
        List<MyClass> list = new ArrayList<MyClass>();

        // 추가

        list.add(new MyClass(1001, "홍길동", 175.8));
        list.add(new MyClass(1002, "김길동", 180.2));
        list.add(new MyClass(1003, "박길동", 165.9));


        viewAll(list);

        System.out.println("************************************************");

        // 삭제
        MyClass removeInformation = list.remove(1);
        System.out.println(removeInformation.getName() + "의 정보가 삭제됨");
        viewAll(list);

        // 검색
        index = -1;
        for (int i = 0; i < list.size(); i++) {
            String humanName = list.get(i).getName();
            if(humanName == "홍길동") {
                index = i;
                break;
            }
        }

        System.out.println("홍길동은 " + (index+1) + "번째에 있음");

        System.out.println("************************************************");

        // 수정

        MyClass obj = list.get(0);
        obj.setHeight(189.4);

        for (MyClass my : list) {
            my.toString();
        }

        MyClass mcls = new MyClass(5, "정수동", 170.12);
        list.set(2, mcls);

        viewAll(list);




    }

    public static void viewAll(List<MyClass> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber());
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getHeight());
            System.out.println("----------------------");
        }
    }
}
