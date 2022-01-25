fun main(args: Array<String>) {

    /*
        함수

        fun 함수명(매개변수: 자료형, ...) : return 자료형 {
            처리
        }

    */

    val result = sum(1, 2)
    println(result)

    val m = max(7, 3)
    println(m)

    // default parameter를 갖는 함수 호출
    add("홍길동", "gildong@gmail.com")
    add("일지매")

    add2()
    add2(1000)

    namedParameter(100, 100, 300)
    namedParameter(x = 300, z = 500)
    namedParameter(z = 300)


    allocParam(1, 2, 3, 4, 5)
    allocParam(6, 7, 8)

}

//fun sum(a: Int, b: Int): Int {
//    return a + b
//}

fun sum(a: Int, b: Int) = a + b

fun max(a: Int, b: Int) = if (a > b) a else b

// 기본 인수 : default parameters
fun add(name: String, email: String = "nobody") {
    val output = "${name}님의 이메일은 ${email}입니다."
    println(output)
}

fun add2(x:Int = 100, y:Int = 200) {
    println(x + y)
}

fun namedParameter(x:Int = 100, y:Int = 200, z:Int) {
    println(x + y + z)
}

// 가변 인수
fun allocParam(vararg counts:Int) {
    for (num in counts) {
        print("$num ")
    }
    print("\n")
}