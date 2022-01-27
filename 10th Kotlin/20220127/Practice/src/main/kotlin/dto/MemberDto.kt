package dto

open class Human(var index:Int, var number: Int, var name: String, var age:Int, var height: Double, var ref:Int) {

    override fun toString(): String {
        return "$index. 선수번호: $number, 선수이름: '$name', 나이: $age, 선수 신장: $height, "
    }

    open var win: Int
        get() { return win }
        set(value) { win = value }

    open var lost: Int
        get() { return lost }
        set(value) { lost = value }

    open var batCount: Int
        get() { return batCount }
        set(value) { batCount = value }

    open var hit: Int
        get() { return hit }
        set(value) { hit = value }

}

class Pitcher(index: Int, number: Int, name: String, age:Int, height: Double, ref:Int, override var win:Int, override var lost:Int, var defense:Double) : Human(index, number, name, age, height, ref) {

    override fun toString(): String {
        return super.toString() + "전적: ${win}승 / ${lost}패, 방어율: $defense"
    }

}

class Batter(index:Int, number:Int, name:String, age:Int, height:Double, ref:Int, override var batCount:Int, override var hit:Int, var batAvg:Double) : Human(index, number, name, age, height, ref) {

    override fun toString(): String {
        return super.toString() + "타수: $batCount, 안타수: $hit, 타율: $batAvg"
    }

}
