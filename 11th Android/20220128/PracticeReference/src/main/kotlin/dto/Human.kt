package dto

// Batter, Pitcher 클래스에 상속해 줄 부모클래스
open class Human (var number:Int = 0,
             var name:String = "",
             var age:Int = 0,
             var height:Double = 0.0 ) {

    /*
    var number:Int = 0          // 선수 번호
    var name:String = ""        // 선수 이름
    var age:Int = 0             // 선수 나이
    var height:Double = 0.0     // 선수 신장

    // 기본 생성자
    constructor() {}

    // 보조 생성자
    constructor(number: Int, name: String, age: Int, height: Double) {
        this.number = number
        this.name = name
        this.age = age
        this.height = height
    }
    */

    // toString(Override)
    override fun toString(): String {
        return "$number-$name-$age-$height-"        // 출력을 토큰으로 구분
    }


}