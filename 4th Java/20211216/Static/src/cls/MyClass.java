package cls;

public class MyClass {

    private int number;         // 멤버 변수
    public static int staticNumber;    // 정적 변수 == 전역 변수로도 사용하는 경우가 있다.

    public void method(int number) {    // 매개변수
        int localNumber;                // 지역변수

        {
            int localNum;
        }
    }

    public void func() {
        int localNumber = 0;
        number++;
        staticNumber++;     // 멤버변수와 정적변수는 선언해주면 자동으로 0이 됨.
        localNumber++;    // 이건 초기화 필요 : function을 메인에서 호출할 때마다 0이 됨.

        System.out.println("local variable: " + localNumber);
        System.out.println("member variable: " + number);
        System.out.println("static variable: " + staticNumber);




    }

}

/*
        stack                   heap                        static                          system
       지역변수                  멤버변수                        정적변수
       매개변수
         |                       |                             |
       블록이 시작할때 생기고    클래스가 생성될 때 생기고           시스템을 시작할 때 생기고
       블록을 나오면 사라짐     클래스가 종료되면 heap에서 삭제      시스템이 종료되면 삭제됨
                                                         남발할 경우 과도한 메모리 차지
*/
