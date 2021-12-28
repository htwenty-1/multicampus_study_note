package health;

public class HealthRate extends Health {

    public HealthRate(String name, double height, double weight) {
        super(name, height, weight);
    }

    @Override
    public void prn() {
        System.out.printf("%s님의 키 %.0f, 몸무게 %.0f ", name, height, weight);

        double b = getB();

        if (b <= 10)                System.out.println("정상입니다");
        else if (10 <= b && b < 20) System.out.println("과체중입니다.");
        else                        System.out.println("비만입니다.");

    }

    public double getSW() {
        return (height - 100) * 0.9;
    }
    public double getB() {
        return (weight - getSW()) / getSW() * 100;
    }

}
