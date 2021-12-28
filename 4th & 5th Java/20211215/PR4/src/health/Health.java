package health;

public class Health {
    String name; 	// 이름
    double height; 	// 신장
    double weight; 	// 몸무게

    public Health(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void prn() {
        System.out.printf("%s님의 키 %.0f, 몸무게 %.0f 입니다.\n", name, height, weight);
    }
}
