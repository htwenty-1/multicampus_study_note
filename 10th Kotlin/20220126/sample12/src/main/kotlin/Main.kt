fun main(args: Array<String>) {

    val base = Base("gildong", "hong", 24)
    base.firstName = "Jinho"        // setter
    println(base.fullName)

    val child = Child("춘향", "성", 15, "서울시")
    println(child.lastName)
    println(child.fullName)

    val parrot = Parrot("나이팅게일", 2, "블루", 7)
    println(parrot.toString())
    println(parrot.allData())

    val cal = Calc()
    println(cal.add(3, 4))
    println(cal.add(3.12, 4.34))
    println(cal.add(3, 4, 5))
    println(cal.add(3.12, 4.34, 7.54))

}

open class Base (var firstName:String="길동", var lastName:String="홍", var age:Int=24) {
//class Base {

    /*
    var firstName:String
    var lastName:String
    var age:Int

    constructor(firstName:String, lastName:String, age:Int) {
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
    }
    */

    open val fullName:String
        get() = "$firstName $lastName"


}

class Child(firstName:String, lastName:String, age:Int, var address:String) : Base(firstName, lastName, age) {

    // 또는 var address:String

    override val fullName:String        // 오버라이딩하려면 오버리이드 받을 변수, 클래스, 메서드 모두 open이 들어가야 함.
        get() = "$firstName $age $address"
}

open class Bird(var name:String, var wing:Int, var color:String) {

    fun fly() = println("fly wing: $wing")

    override fun toString(): String {
        return "Bird(name='$name', wing=$wing, color='$color')"
    }

    open fun allData() = print("$name $wing $color ")


}

class Lark(name:String, wing:Int, color:String) : Bird(name, wing, color) {
    fun singHitOne() = println("짹짹")
}

// 이렇게도 상속을 받을 수 있다.
class Parrot : Bird {

    var volume:Int

    constructor(name:String, wing:Int, color:String, volume:Int):super(name, wing, color) {
        this.volume = volume
    }

    override fun toString(): String {
        return super.toString() + "Parrot(volume=$volume)"
    }

    override fun allData() {
        super.allData()
        println("$volume")
    }

}

// 오버로드
class Calc {

    fun add(x:Int, y:Int):Int = x + y
    fun add(x:Double, y:Double):Double = x + y
    fun add(x:Int, y:Int, z:Int):Int = x + y + z
    fun add(x:Double, y:Double, z:Double):Double = x + y + z

}