package cls;

public class ChildClass extends ParentClass {

    private double height;

    public ChildClass() {
        // this(1.12);
        super(123, "hello");    // super : 부모 클래스에 있는 생성자를 포인팅하여 알려줌, 매개변수를 안넣어주면 부모클래스의 첫번째에 있던 생성자 호출
        System.out.println("ChildClass ChildClass()");
    }

    public ChildClass(double height) {
        super();
        this.height = height;
    }

    public ChildClass(int number, String name, double height) {
        super(number, name);            // super는 맨 위에 적어야함. 그리고 생성자를 호출할 때 this()와 super()는 같이 사용할 수 없어~
        this.height = height;
    }

}
