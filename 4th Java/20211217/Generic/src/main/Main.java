package main;

public class Main {
    public static void main(String[] args) {

        /*
            제네릭, Generic == Template(형태) ---> 자료형 변수
            같은 클래스에서 다양한 자료형을 사용하고 싶은 경우에 설정하는 요소


        */

        Box<Integer> box = new Box<Integer>(123);
        box.setTemp(234);
        System.out.println(box.getTemp());

        Box<String> sbox = new Box<String>("Hello");
        sbox.setTemp("World");
        System.out.println(sbox.getTemp());

        // 제네릭에 일반 자료형은 쓸 수 없다.
        // Box<int> mybox = new Box<int>(); 안됨

        BoxMap<Integer, String> bmap = new BoxMap<Integer, String>(1001, "Honggildong");
        System.out.println(bmap.getKey());
        System.out.println(bmap.getValue());

        BoxMap<String, String> smap = new BoxMap<String, String>("Apple", "사과");
    }
}

class Box<T> {

    T temp;

    public Box(T temp) {
        this.temp = temp;
    }

    public T getTemp() {
        return temp;
    }

    public void setTemp(T temp) {
        this.temp = temp;
    }
}

class BoxMap<KEY, VALUE> {
    KEY key;
    VALUE value;

    public BoxMap(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    public KEY getKey() {
        return key;
    }

    public void setKey(KEY key) {
        this.key = key;
    }

    public VALUE getValue() {
        return value;
    }

    public void setValue(VALUE value) {
        this.value = value;
    }
}