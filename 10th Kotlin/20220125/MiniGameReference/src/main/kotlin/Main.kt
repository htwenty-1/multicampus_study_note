fun main(args: Array<String>) {

    // 가위, 바위, 보 게임 참고

    var userNum:Int
    var comNum:Int

    var win:Int
    var lose:Int
    var draw:Int
    var result:Int

    win = 0.also { draw = it }.also { lose = it }

    println("가위 바위 보 게임입니다")

    while(true) {

        println("start game....")

        // random 값 얻어오기(0 ~ 2)
        comNum = (Math.random() * 3).toInt()

        // user input
        print("가위(0), 바위(1), 보(2) 입력 >>> ")
        userNum = readLine()!!.toInt()

        // win일 조건(user-com : 0-2, 1-0, 2-1)
        /*
    if(userNum == 0 && comNum == 2) {
        result = 0
    } else if (userNum == 1 && comNum == 0) {
        result = 0
    } else if (userNum == 2 && comNum == 1) {
        result = 0
    }
    */

        result = (comNum - userNum + 2) % 3

        var resultMsg = ""
        when (result) {
            1 -> {
                resultMsg = "You Win"
                win++
            }

            0 -> {
                resultMsg = "You Lose"
                lose++
            }

            2 -> {
                resultMsg = "DRAW"
                draw++
            }
        }

        var userChar = if (userNum == 0) "가위" else if (userNum == 1) "바위" else "보"
        var comChar = if (comNum == 0) "가위" else if (comNum == 1) "바위" else "보"

        println("${resultMsg} 당신은 ${userChar}이고 상대방은 ${comChar}입니다.")
        println("${win}승 ${draw}무 ${lose}패 입니다.")

        print("한 판 더 하시겠습니까? (Y/N) >> ")
        val msg:String = readLine()!!
        if (msg == "N" || msg == "n") {
            println("게임이 종료되었습니다")
            break
        }

        println("게임을 다시 시작합니다...")
    }

}