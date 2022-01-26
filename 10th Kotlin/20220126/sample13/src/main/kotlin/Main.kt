fun main(args: Array<String>) {
    println("Hello World!")

//    val prt = MyPrinter()
//    prt.print()

    myPrinter.print()

    val car = Car("super-car", "yellow", 1100.0, 300.0)
    val motor = MotorCycle("Dream Bike", "red", 101.0, 180.0)

    car.year = 2020
    car.start()
    car.displaySpecs()
    car.stop()

    motor.year = 2021
    motor.start()
    motor.displaySpecs()
    motor.stop()

    var cf = CreateFoo(123)
    cf.bar = 234
    println(cf.method("hi"))

    val pega = Pegasus()
    pega.fly()
    pega.run()
    pega.jump()

}

/*
abstract class Printer {
   abstract fun print()
   fun method() = println("Printer Method()")
}

class MyPrinter : Printer() {
    override fun print() {
        println("출력합니다!!")
    }
}
*/

abstract class Printer {
    abstract fun print()
    fun method() = println("Printer Method()")
}

val myPrinter = object : Printer() {
    override fun print() {
        println("myPrinter print()")
    }

}

// 추상클래스 = 일반 메서드 + 추상 메서드 가능!!
abstract class Vehicle(val name:String, val color:String, val weight:Double) {

    abstract var maxSpeed:Double    // 추상 property

    var year:Int = 2019

    abstract fun start()            // 추상 method
    abstract fun stop()

    fun displaySpecs() {
        println("Name: $name, Color: $color, Weight: $weight, Year: $year, MaxSpeed: $maxSpeed")
    }

}

// Vehicle을 상속받는 클래스
class Car(name:String, color:String, weight:Double, override var maxSpeed: Double) : Vehicle(name, color, weight) {
    override fun start() {
        println("자동차가 출발합니다.")
    }

    override fun stop() {
        println("자동차가 멈춥니다.")
    }
}

class MotorCycle(name:String, color:String, weight:Double, override var maxSpeed: Double) : Vehicle(name, color, weight) {
    override fun start() {
        println("오토바이가 출발합니다.")
    }

    override fun stop() {
        println("오토바이가 멈춥니다.")
    }

}

// 인터페이스 구현
interface Foo {
    var bar:Int
    fun method(str:String)
}

class CreateFoo(val _bar:Int) : Foo {
    override var bar: Int = _bar

    override fun method(str: String) {
        println("$bar $str")
    }
}

// 다중상속
interface Bird {
    var wings:Int
    fun fly()

    fun jump() {    // 메서드를 정의할 수 있다?
        println("Bird jump")
    }
}

interface Horse {
    var maxSpeed:Int
    fun run()

    fun jump() {    // 메서드를 정의할 수 있다?
        println("Horse jump & maxSpeed ")
    }
}

class Pegasus : Bird, Horse {
    override var wings: Int = 2
    override var maxSpeed: Int = 100

    override fun fly() {
        println("Fly Sky~~")
    }

    override fun run() {
        println("Run~~")
    }

    override fun jump() {
        super<Bird>.jump()      // 그냥 jump를 호출하면 상속받는 인터페이스에 모두 jump가 있어서 에러가 발생하므로 제네릭 타입으로 상위 타입을 지정해주자!
        println("Pegasus Jump~~!!")
    }

}