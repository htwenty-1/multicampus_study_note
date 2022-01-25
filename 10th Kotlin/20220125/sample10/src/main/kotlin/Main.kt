fun main(args: Array<String>) {
    println("Hello World!")

    val lazyTest = LazyClass()          // 실행순서 1
    lazyTest.flow()                     // 실행순서 3

}

class LazyClass {
    init {
        println("init block")           // 실행순서 2
    }

    val subject by lazy {
        println("lazy init")            // 실행순서 6, 아래가 실행순서 7
        "subject Value"
    }

    fun flow() {
        println("subject notflow")      // 실행순서 4
        println("subject: $subject")    // 실행순서 5 --> 최초 초기화
    }
}