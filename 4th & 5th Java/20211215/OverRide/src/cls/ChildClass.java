package cls;

public class ChildClass extends ParentClass{

    /*
        OverRide : 오버 라이드, 부모 클래스에서 상속받은 메서드를 고쳐 기입하는 행위

        왜 오버라이드를 하나?
        1. 상속받은 함수를 고쳐 작성하여 사용하려고
        2. class 관리

        오버라이딩 규칙
        1. 상속받은 클래스의 오버라이딩 할 멤버 메서드와 이름이 동일해야 함
        2. 반환할 자료형이 같아야함.

        참고
        1. 오버라이딩 해준 메서드는 오버라이딩된게 우선 호출되고, 만약에 고치기 전의 메서드를 호출하고 싶으면 super를 붙여라 이말이야
        2. 근데 오버라이딩 하지 않은 메서드는 그냥 호출해도 사용할 수가 있다고~~

    */

    // OverRide된 메서드
    //@Override       // name space -> 주석, 그냥 오버라이드다 하는 표시, 안적어도 뭐...
    // public void pMethod() { }


    @Override
    public void pMethod() {
        //super.pMethod();        // 부모 클래스에 있는 메서드도 super로 접근할 수 있음. 근데 이때는 순서 상관이 없다~~
        System.out.println("ChildClass pMethod()");
    }

    public void func() {
        //pMethod();      // 이거는 기존의 ParentClass에서 오버라이딩 된 ChildClass에 있는 pMethod()가 호출되는것
        super.pMethod();    // 이거는 ParentClass로 올라가서 거기있는 pMethod()가 호출됨.
    }


}
