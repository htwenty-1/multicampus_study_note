package dto

// Human 클래스 상속받음
// 이 클래스의 생성자 작성방법은 Java와 유사하다!
class Pitcher : Human {

    var win:Int = 0                 // 이긴 게임 수
    var lose:Int = 0                // 진 게임 수
    var defense:Double = 0.0        // 방어율

    // 기본 생성자 : 상속받은 부모 클래스의 생성자를 초기화
    constructor() : super(0, "", 0, 0.0)

    // 보조 생성자
    constructor(number: Int, name: String, age: Int, height: Double, win:Int, lose:Int, defense:Double) : super(number, name, age, height) {
        this.win = win
        this.lose = lose
        this.defense = defense
    }

    // toString(Override)
    override fun toString(): String {
        // 상속받은 부모 클래스의 toString + 이 클래스의 toString
        return super.toString() + "$win-$lose-$defense"
    }

}