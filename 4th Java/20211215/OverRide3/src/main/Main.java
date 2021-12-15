package main;

import cls.ChildOneClass;
import cls.ChildTwoClass;
import cls.ParentClass;

public class Main {
    public static void main (String[] args) {

        // 자식 클래스의 객체를 총 10개 생성한다고 가정했을 때,
        ChildOneClass[] arrOne = new ChildOneClass[10];     // 각각의 최대개수를 잡는다
        ChildTwoClass[] arrTwo = new ChildTwoClass[10];

        /* 이렇게 하면 너무 복잡해~~
        String name = "";

        if (name.equals("one")) {

        } else {

        }

        arrOne[0] = new ChildOneClass();
        arrTwo[0] = new ChildTwoClass();
        arrTwo[1] = new ChildTwoClass();
        arrOne[1] = new ChildOneClass();
        arrOne[2] = new ChildOneClass();
        arrOne[3] = new ChildOneClass();
        arrTwo[2] = new ChildTwoClass();
        arrOne[4] = new ChildOneClass();
        */

        // 다시 한 번 자식 클래스의 객체를 총 10개 만들어보자!
        //ParentClass pc1 = new ChildOneClass();      // 자식 클래스를 부모클래스의 인스턴스에 넣어버려
        //ParentClass pc2 = new ChildTwoClass();

        ParentClass[] arrParent = new ParentClass[10];

        // 하나의 배열로 관리할 수 있으니까 더 편한것 같음
        // 위에서는 각각의 객체를 선언해서 했으니까 더 불편하고...
        arrParent[0] = new ChildOneClass();
        arrParent[1] = new ChildTwoClass();
        arrParent[2] = new ChildTwoClass();
        arrParent[3] = new ChildOneClass();
        arrParent[4] = new ChildOneClass();
        arrParent[5] = new ChildOneClass();
        arrParent[6] = new ChildTwoClass();
        arrParent[7] = new ChildOneClass();
        arrParent[8] = new ChildTwoClass();
        arrParent[9] = new ChildOneClass();

        for (int i = 0; i < arrParent.length; i++) {
            arrParent[i].Method();

            if(arrParent[i] instanceof ChildOneClass) {
                ChildOneClass one = (ChildOneClass) arrParent[i];
                one.func();
            } else if (arrParent[i] instanceof ChildTwoClass) {
                ChildTwoClass two = (ChildTwoClass) arrParent[i];
                two.proc();
            }
        }

        ChildOneClass o = (ChildOneClass) arrParent[0];
        o.func();

        // instanceof : 생성된 class를 찾아줌

       if(arrParent[0] instanceof ChildOneClass) {
            ChildOneClass one = (ChildOneClass) arrParent[0];
            one.func();
        }

    }
}
