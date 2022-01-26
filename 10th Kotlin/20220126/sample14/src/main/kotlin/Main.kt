fun main(args: Array<String>) {

    val master = Master()
    val dog = Dog("바둑이", "Small")
    master.playWithPet(dog)

    val cat = Cat("야옹이", "Middle")
    master.playWithPet(cat)

}

open class Animal(val name:String) {}

interface Pet {
    var category:String
    val msgTags:String
        get() = "I love my pet!"

    var species:String
    fun feeding()
    fun patting() {
        println("Keep patting")
    }
}

class Cat(name:String, override var category: String) : Pet, Animal(name) {

    override var species: String = "Cat"
    override fun feeding() {
        println("Feeding Cat")
    }
}

class Dog(name:String, override var category: String) : Pet, Animal(name) {

    override var species: String = "Dog"
    override fun feeding() {
        println("Feeding Dog")
    }
}

class Master {

    fun playWithPet(pet:Pet) {
        println(pet.species)
        pet.feeding()
    }
}