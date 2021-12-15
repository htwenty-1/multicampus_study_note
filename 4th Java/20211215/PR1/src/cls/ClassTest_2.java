package cls;

public class ClassTest_2 extends ClassTest_1{

    private String department;

    public ClassTest_2(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public void getInformation() {
        super.getInformation();
        System.out.println(" 부서: " + department);
    }

    @Override
    public void prn() {
        System.out.println("서브클래스");
    }

    public void callSuperThis() {
        super.prn();
        prn();
    }
}
