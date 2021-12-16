package main;

import cls.Circle;
import cls.Rectangle;

public class Main {

    public static void main(String[] args) {

        /*
            다음은 도형을 정의한 Shape클래스이다.
            이 클래스를 부모로 하는 Circle클래스와 Rectangle클래스를 작성하시오.
            이 때, 생성자도 각 클래스에 맞게 적절히 추가해야 한다.

            (1) 클래스명 : Circle           부모클래스 : Shape
                멤버변수 : double r – 반지름
            (2) 클래스명 : Rectangle        부모클래스 : Shape
                멤버변수 : int width - 폭    int height - 높이
                메서드 :
                        1. 메서드명 : isSquare
                        기 능 : 정사각형인지 아닌지를 알려준다. 반환타입 : boolean
                        매개변수 : 없음
        */

        Circle c = new Circle(3.0);
        System.out.println(c.calcArea());

        Rectangle rect = new Rectangle(3, 6);
        System.out.println(rect.calcArea());
        System.out.println(rect.isSquare());


    }
}
