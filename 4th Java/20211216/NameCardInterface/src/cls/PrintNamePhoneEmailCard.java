package cls;

import inter.PrintInterface;

public class PrintNamePhoneEmailCard implements PrintInterface {

    @Override
    public void print(NameCard nc) {
        System.out.println("이름: " + nc.getName());
        System.out.println("전화번호: " + nc.getPhone());
        System.out.println("이메일: " + nc.getEmail());
    }
}
