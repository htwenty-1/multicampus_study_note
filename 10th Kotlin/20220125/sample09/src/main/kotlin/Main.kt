fun main(args: Array<String>) {

    var user = User(1, "Tom", 18)

//    user.id = 11            // setter
//    val name = user.name    // getter

    val id = user.id
    println(id)

    user.name = "성춘향"
    val name = user.name
    println(name)

    var kim = FakeAge()
    kim.age = 15
    println(kim.toString())

    var lee = FakeAge()
    lee.age = 36
    println(lee.toString())

}

// getter와 setter
class User(_id:Int, _name:String, _age:Int) {
    var id:Int = _id
        get() = field

    var name:String = _name
        get() = field
        set(value){
            field = value
        }

    var age:Int = _age
        get() = field
        set(value) {
            field = value
        }


}

class FakeAge {
    var age:Int = 0
        set(v) {
            field = when {
                v < 18 -> 18
                v in 18..30 -> v
                else -> v - 3
            }
        }

    override fun toString(): String {
        return "FakeAge(age=$age)"
    }


}