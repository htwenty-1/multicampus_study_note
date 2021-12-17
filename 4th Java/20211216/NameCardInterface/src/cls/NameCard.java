package cls;

import inter.PrintInterface;

public class NameCard {

    private final String name;
    private final String phone;
    private final String email;

    // interface
    private PrintInterface pI;

    public NameCard(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // 구현체들을 모두 담기 위해서 인터페이스를 인자로 받는다.
    // 인터페이스만 가지고 있는 메서드만 setPrintCard로 받는거지!
    public void setPrintCard(PrintInterface p) {    // 자식 클래스가 부모 클래스로 casting
        this.pI = p;
    }

    public void print() {
        this.pI.print(this);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

}
