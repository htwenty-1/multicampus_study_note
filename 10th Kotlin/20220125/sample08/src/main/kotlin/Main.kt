fun main(args: Array<String>) {

//    var person = Person("Chunhyang", "Seong", 24)
//    val lastName = person.lastName

    // person.age = person.age + 1
//    println(person.toString())

    var human = Human()
    human.method()
    // human.protectedVar = 25      // 안됨
    human.internalVar = 50

    var bird = Bird("나이팅게일", 2, "blue")
    println(bird.toString())

    var mycls = MyClass()

    val base = Base("abc", "1234ab", 30)
    println(base.toString())

    val base2 = Base("bcd", "5t5t")
    println(base2.toString())

}

// 생성자
class Bird(var name: String, var wing: Int, var color: String) {    // 외부 초기화

    /*
    var name:String
    var wing:Int
    var color:String
    */

    /*
    constructor(name: String, wing: Int, color: String) {
        this.name = name
        this.wing = wing
        this.color = color
    }
    */

    fun fly() = println("Fly Wing: $wing")
    override fun toString(): String {
        return "Bird(name='$name', wing=$wing, color='$color')"
    }


}

class MyClass {
    var number:Int
    init {              // 내부 초기화, 객체 생성시 자동 호출
        number = 123
        println(number)
    }
}

class Base(var id:String, var password:String, val age:Int) {   // 기본생성자

    // 이런식으로도 생성자를 만들 수 있음(보조 생성자)  --> 같은 생성자를 두개 만들 수 없으므로 age를 제외하였음.
    constructor(id:String, password:String) : this(id, password, 24) {
        println("constructor($id:String, $password:String, val age:Int)")
    }

    override fun toString(): String {
        return "Base(id='$id', password='$password', age=$age)"
    }


}


// 접근 제어자

open class Person {      // class에 private를 선언해줘도 외부에서 생성하는데는 문제가 안된다.
    val firstName:String = ""
    val lastName:String = ""
    private var age:Int = 0

    protected var protectedVar:Int = 123

    internal var internalVar:Int = 20

    /*
    constructor(firstName: String, lastName: String, age: Int) {
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
    }
*/

    private fun privateFunc() {

    }

    override fun toString(): String {
        return "Person(firstName='$firstName', lastName='$lastName', age=$age)"
    }


}


class Human : Person() {
    fun method() {
        protectedVar = 23
        internalVar = 30
        println(protectedVar)
    }
}