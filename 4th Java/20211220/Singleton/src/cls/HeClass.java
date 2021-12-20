package cls;

import Singleton.Singleton;

public class HeClass {

    private String gender;

    public HeClass(String gender) {
        gender = "Male";
    }

    public HeClass() {}

    public void method() {
        Singleton s = Singleton.getInstance();
        s.gender = gender;
    }

    @Override
    public String toString() {
        return "HeClass{" +
            "gender='" + gender + '\'' +
            '}';
    }
}
