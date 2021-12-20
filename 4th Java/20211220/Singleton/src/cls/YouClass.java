package cls;

import Singleton.Singleton;

import java.security.Signature;

public class YouClass {

    private int total;
    private String name;

    public void func() {}

    /*
    public void setTotal(int total) {
        this.total = total;
    }

    public void setName(String name) {
        this.name = name;
    }
    */
    public void method () {
        Singleton s = Singleton.getInstance();
        total = s.number;
        name = s.name;
    }

    @Override
    public String toString() {
        return "YouClass{" +
            "total=" + total +
            ", name='" + name + '\'' +
            '}';
    }
}
