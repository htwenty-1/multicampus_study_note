package cls;

public class YouClass {

    int number;

    public void memberMethod() {
        System.out.println("YouClass memberMethod()");
    }
    // 정적 함수
    public static void staticMethod() {
        System.out.println("YouClass staticMethod()");

        /*
            멤버변수, 멤버 메서드 접근 안됨
            number = 1;
            memberMethod();
            this 접근 안됨
            super 접근 안됨

            간단한 처리를 할 때 쓰면 좋음 ---> 객체 생성 없이 어디서나 바로 호출
        */
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] =  arr[j];
        arr[j] = temp;
    }
}
