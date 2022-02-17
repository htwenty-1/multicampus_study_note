package dto

// Kotlin식 생성자 초기화
class Batter(number: Int, name: String, age: Int, height: Double,
             var batCount:Int, var hit:Int, var batAvg:Double)
      : Human(number, name, age, height) {

    // toString
    override fun toString(): String {
        return super.toString() + "$batCount-$hit-$batAvg"
    }
}