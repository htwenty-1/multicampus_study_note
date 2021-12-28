package abstractCls;

/*
    Abstract Class, 추상 클래스
    - 추상 메서드를 하나 이상 포함하고 있는 클래스
    - 일반 메서드를 포함시킬 수 있다.
    - 멤버 변수도 포함시킬 수 있다.

    ** 틀만 만들고 거기다 뭔가 채워넣는 그런 느낌?

    Abstract Method?
    - 내용(처리)은 없고 prototype(매개변수, return 값)만 선언되어 있는 메서드
    - 형식 예
        public abstract void method (char c, int i);
        * 메서드에 abstract 붙여준다!(클래스 앞에도 붙여줌)
        * 이런 형식을 하나 이상 가지고 있는게 Abstract Class!
*/

// 근데 이렇게만 사용을 못하니까 상속을 받은 클래스에서 사용해야함.
public abstract class AbstractClass {

    private String name;

    public AbstractClass() {
    }

    public AbstractClass(String name) {
        this.name = name;
    }

    public void method() {
        System.out.println("AbstractClass method()");
    }

    public abstract void abstractMethod();

}
