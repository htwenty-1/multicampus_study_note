import kotlin.system.exitProcess

fun main(args: Array<String>) {

    /*
        Random number 찾기

        범위 : 1 ~ 100까지 Random한 숫자를 받는다
        입력 : 범위를 초과하는 숫자는 잘못 입력되었음을 알려준다.

        예) 입력 받은 숫자의 Random Number 도달여부(너무 크다, 너무 작다)를 알려준다.

        기회는 default로 10번만 줄 것

        재시도 여부 묻기

    */

    println("***************************************")
    println("************숫자 맞추기 게임***************")

    while(true) {
        print("도전할 횟수를 입력해주세요 >> ")
        val play:Int = readLine()?.toInt()!!
        println("게임을 시작합니다.")

        val number:Int = ((Math.random() * 100) + 1).toInt()
        // println(number)

        var i:Int = 0
        var ref:Boolean = false
        while (i < play) {
            print("숫자를 입력해주세요. >> ")
            val input:Int = readLine()?.toInt()!!
            if(number == input) {
                println("정답입니다!")
                ref = true
                exitProcess(1)
            } else if (number > input) {
                println("입력된 숫자가 너무 작습니다")
            } else if (number < input) {
                println("입력된 숫자가 너무 큽니다")
            } else {
                println("잘못된 입력입니다.")
            }
            i++
        }

        if (!ref) {
            print("다시 시도하시겠습니까? [Y]es 또는 [N]o >> ")
            val regame: String? = readLine()!!
            if (regame == "N" || regame == "n") {
                println("게임을 종료합니다.")
                break
            } else {
                println("게임을 다시 시작합니다...")
            }
        }

    }




}