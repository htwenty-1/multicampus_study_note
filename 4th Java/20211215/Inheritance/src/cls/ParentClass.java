package cls;

public class ParentClass {

    private int number;
    protected String name;      // 외부접근은 불가하지만 상속받은 객체는 접근 가능

    public void parentMethod () {
        System.out.println("ParentClass parentMethod()");
    }

    public int getNumber() {
        return number;
    }

    protected void setNumber(int number) {      // 외부 접근 불가
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
