package mycls;

public class MyClass {

    /*
        Encapsulation : 은닉성, 캡슐화
        member(member variables)에 대한 외부 접근을 제어(차단, 읽기전용, 허용여부 결정 등)

        접근 지정자
        private : 개인적인 - 클래스 내부에서만 접근할 수 있음.
        public : 대중적인
        protected : 상속에 따른 보호 ... 요즘은 별로 안씀
    */

    private int number;
    public String name;
    protected double height;

    public void setNumber(int number) {     // setter
        this.number = number;
    }

    // 외부에서 접근할 수 있도록 허용
    public int getNumber() {                // getter
        return this.number;
    }
}
