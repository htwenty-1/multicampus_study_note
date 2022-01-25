var global = 10

fun main(args: Array<String>) {

    val res1 = funcParam(3, 4, ::sum)
    println(res1)

    hello(::text)
    hello { a, b -> text(a, b) }


    // 일반 변수처럼 할당할 수 있음
    val likeLambda = ::sum
    println(likeLambda(6, 5))

    // 함수안에 함수를 넣을 수 있다? 전역변수란?
    global = 11
    fun localFunc() {
        global = 12
    }

    localFunc()
    println("global: $global")

}

fun sum(a:Int, b:Int) = a + b

fun funcParam(a:Int, b:Int, c:(Int, Int) -> Int):Int {
    return c(a, b)
}


fun text(a:String, b:String) = "Hi! $a $b"

fun hello(body:(String, String) -> String) {
    println(body("Hong", "Gildong"))
}