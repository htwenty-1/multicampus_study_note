fun main(args: Array<String>) {

    // 객체 생성
    var cls = Person("길동", "홍", 24)
    cls.firstName = "춘향"
    cls.lastName = "성"
    cls.age = 25

    println(cls.getFullName())

    // 객체 생성
    val user = Human("abcd123", "1004abc", "성춘향")
    println("${user.id} ${user.password} ${user.name}")

    // 객체 생성
    val bird = Bird()
    bird.color = "red"
    bird.vol = "large"

    println(bird)


}

// Java랑 비슷하게
class Person {
    var firstName:String
    var lastName:String
    var age:Int

    constructor(firstName:String, lastName:String, age:Int) {
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
    }

    fun getFullName():String {
        return "$firstName $lastName $age"
    }
}

class Human(val id:String, var password:String, val name:String) {
    override fun toString(): String {
        return "Human(id='$id', password='$password', name='$name')"
    }
}

class Bird(var name:String = "myBird", var wing:Int=2, var vol:String="short", var color:String="blue") {
    fun fly() = println("fly wing: $wing")
    fun cry(vol:String) = println("cry vol: $vol")
    override fun toString(): String {
        return "Bird(name='$name', wing=$wing, vol='$vol', color='$color')"
    }

}