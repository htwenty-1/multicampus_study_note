fun main(args: Array<String>) {

    // composition : 합성 - Class안에서 Class 사용
    val car = Car("BMW", "100hp")
    car.startEngine()
    car.stopEngine()

    // generic
    val box:Box<Int> = Box<Int>(123)
    println(box.value)

    val box2:Box<String> = Box<String>("my World")
    println(box2.value)

    val box3 = Box("245")
    println(box3.value)

    val res = add(3, 4) { x, y -> x + y }
    println(res)

    val cal:MyClass<Int, Double> = MyClass<Int, Double>(43, 4995.12)
    println(cal.num1)
    println(cal.num2)

}

// composition
class Car(val name:String, val power:String) {

    private var engine = Engine(power)

    fun startEngine() = engine.start()
    fun stopEngine() = engine.stop()

}

class Engine(power:String) {
    fun start() = println("Engine had been started")
    fun stop() = println("Engine has been stopped")
}

// Generic == Template <T> (제네릭은 자료형 변수다!)
/* Java
    class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value
        }

    }
*/

class Box<T>(var value:T)

fun<T> add(x:T, y:T, op:(T, T) -> T) : T = op(x, y)

class MyClass<T1, T2>(n1:T1, n2:T2) {
    var num1 = n1
    var num2 = n2

    /*
    fun myFunction() {
        return num1 + num2      // 자료형이 명확하지 않으므로 연산할 수 없음
    }
    */

}