package human;

public class Student extends Human {

    private String hak;

    public Student(String name, int age, int height, int weight, String hak) {
        super(name, age, height, weight);
        this.hak = hak;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + this.hak;
    }
}
