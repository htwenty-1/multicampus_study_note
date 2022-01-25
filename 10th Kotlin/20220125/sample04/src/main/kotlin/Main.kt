import kotlin.Exception

fun main(args: Array<String>) {

    /*
        변수를 자주 쓰는 경우 : insert, delete, update
        상수를 자주 쓰는 경우 : select
    */

    // try catch finally
    /*
    val a:Int = 6
    val b:Int = 0
    var c:Int

    try {
        c = a / b
    } catch(e:ArithmeticException) {        // 기본 Exception == e:Exception으로 쓸 수도 있다.
        println("${e.message}")
    } finally {
        println("finally")
    }
    */


    // var amount:Int = 600
    var amount:Int = 1000

    try {
        amount -= 100
        checkAmount(amount)
    } catch (e:Exception) {
        e.printStackTrace()
    }

    println("program end")



//    var x:Int = 123
//
//    try {
//        x = null!!
//        println("x에 정상적으로 대입됨")
//    } catch (e:Exception) {
//        e.printStackTrace()
//        println("Exception 발생!!")
//    }

}

fun checkAmount(amount:Int) {
    if (amount < 1000) {
        throw Exception("잔고가 $amount(으)로 1000이하 입니다.")
    }
}