package main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
            ArrayList : 검색이나 대입 등에 자주 활용된다. (Vector조사해보기)

            LinkedList : 실시간으로 추가, 삭제 처리가 빠르다.

        */


        LinkedList<String> list = new LinkedList<String>();

        list.add("Tigers");
        list.add(new String("Lions"));
        list.add("Giants");


        for (String s : list) {
            System.out.println(s);
        }

        list.addFirst("Bears");     // LinkedList에만 있는 메서드
        // ===  list.add(0, "Bears");
        ArrayList<String> alist = new ArrayList<String>(list);      //LinkedList 객체를 ArrayList로 넘겨줌
        // alist.add();

        for (String str : alist) {
            System.out.println(str);
        }

        // 수정
        String ss = "Twins";
        list.set(2, ss);        // 2번째에 넣어주고 기존의 2번째 삭제시킴

       for (String str : list
             ) {
            System.out.println(str);
        }

       /*
            Map Interface
                - HashMap
                  * key: value 형태로 관리
                  * key가 인덱스 역할
                  * key를 중복사용할 수 없다
     리          - TreeMap
                  * 트리구조? 셔플, 정렬, 탐색, 트리
                  * HashMap + Sort
       */

        // 둘다 사용 가능
//        HashMap<Integer, String> hMap = new HashMap<Integer, String>();
        Map<Integer, String> hMap = new HashMap<Integer, String>();


        // 추가
        hMap.put(111, "백십일");
        hMap.put(222, "이백이십이");
        hMap.put(333, "삼백삼십삼");

        // 꺼내오기
        String value = hMap.get(111);       // key를 통해서 가져옴
        System.out.println(value);

        // 전체 데이터 꺼내오기 : 선형구조가 아니라서 반복문으로 0번째부터 주우욱 가져오는게 불가능 ===> iterator로 가져옴(반복자==주소==포인터)
        Iterator<Integer> it = hMap.keySet().iterator();

        while(it.hasNext()) {
            Integer k = it.next();
            System.out.println(k);

            String v = hMap.get(k);
            System.out.println(v);
        }


        // 삭제
        String val = hMap.remove(222);
        System.out.println(val);

        it = hMap.keySet().iterator();          // 갱신

        while(it.hasNext()) {
            String v = hMap.get(it.next());
            System.out.println(v);
        }
        System.out.println(hMap.size());

        // 검색(=key)
        boolean b = hMap.containsKey(111);      // containsValue도 있는데 key를 주로 사용
        if (b == true) {
            System.out.println(hMap.get(333));
        }

        // 수정
        hMap.replace(111, "백 + 십 + 일");
        System.out.println(hMap.get(111));

        hMap.put(111, "100 + 10 + 1");
        System.out.println(hMap.get(111));          // 추가해줄 때는 어떤 key가 있는지 확인하고 해당 key가 있다면 값이 갱신되니까 조심해야 한다!


        /* ************************************************************************************************************************* */

        // Tree Map Sort ===> key 값으로 sorting
        Map<String, String> map = new HashMap<String, String>();

        map.put("pear", "배");
        map.put("apple", "사과");
        map.put("grape", "포도");
        map.put("banana", "바나나");
        map.put("orange", "오렌지");

        Iterator<String> iter = map.keySet().iterator();

        while(iter.hasNext()) {
            String k = iter.next();
            String va = map.get(k);
            System.out.println("key: " + k + ", value: " + va);
        }
        System.out.println();       // 개행

        // TreeMap
        TreeMap<String, String> tMap = new TreeMap<String, String>(map);    // map을 인자로 전달

        //Iterator<String> iter2 = tMap.keySet().iterator();                  // 오름차순 정렬

        Iterator<String> iter2 = tMap.descendingKeySet().iterator();          // 내림차순 정렬

        while(iter2.hasNext()) {
            String k = iter2.next();
            String va = tMap.get(k);
            System.out.println("key: " + k + ", value: " + va);
        }


    }
}
