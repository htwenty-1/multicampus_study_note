package com.company;

public class Main {

    public static void main(String[] args) {

        /*
            Exception : 예외 != 에러
            int number에 'A'를 입력받는 사례 : 틀렸다??

            예)
                숫자가 입력되어야 하는데 문자가 입력된 경우
                배열의 범위가 초과되었을 때
                클래스를 사용하고자 호출했는데 없을 때
                파일을 해당 위치에서 불러와야 하는데 그 위치에 없을 때

            예외처리 하기
                try {
                    예외가 발생될 가능성이 있는 코드
                } catch(예외 클래스 1 e) {
                    예외 클래스 메시지 출력
                } catch(예외 클래스 2 e {
                    예외 클래스 메시지 출력
                }           :
                            :
                finally {
                    무조건 실행!
                    뒤처리
                }

                * catch는 계속 붙여줄 수 있다.

          함수 안에서 예외가 발생하는 경우
              public static void method() throws 예외클래스 {
                    함수 안에서 예외가 발생될 경우
              }


        */

        //
        int array[] = { 1, 2, 3 };

        System.out.println("start");

        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(array[i]);
            }

            System.out.println("process");

        } catch (ArrayIndexOutOfBoundsException e) {
            // System.out.println("배열의 범위를 초과함");
            e.printStackTrace();        // 콘솔에 메시지를 출력해줌.
            // return                   밑에가 실행이 안딤
        } finally {
            System.out.println("finally");
        }

        System.out.println("end");



    }

    public static void method () throws InddexOutOfBoundsException  {
        int[] num = { 1, 2, 3 };
        for (int i = 0; i < 4; i++) {
            System.out.println(num[i]);
        }
    }

    public static void objectCall()throws ClassNotFounderException {
        Class.forName("My Classs");
     }
}
