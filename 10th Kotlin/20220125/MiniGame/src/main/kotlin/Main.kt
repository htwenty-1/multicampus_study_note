import java.util.*
import kotlin.system.exitProcess

// 가위, 바위, 보 배열에서 랜덤으로 가져오기
fun getRandom(arr:Array<String>) : String {
    val random = Random().nextInt(arr.size)
    return arr[random]
}

fun main(args: Array<String>) {

    // 승, 패, 무승부 초기화
    var win:Int = 0             // 승
    var lose:Int = 0            // 패
    var tie:Int = 0             // 무승부
    var res:String = ""         // 결과 값을 담을 변수

    // 게임 진행
    while (true) {

        // 배열에서 무작위로 추출한 값을 변수에 저장
        val rockScissorPaper: Array<String> = arrayOf("가위", "바위", "보")
        var computer:String = getRandom(rockScissorPaper)

        println("************** 가위, 바위, 보 **************")
        println("***게임을 종료하려면 종료를 입력하고 엔터를 누르세요***")
        print("가위, 바위, 보 중에서 입력 >> ")
        val userInput = readLine()

        // 종료시
        if (userInput == "종료") exitProcess(0)

        // 가위
        when (computer == "가위") {
            userInput == "바위" -> res = "승리"
            userInput == "보" -> res = "패배"
            userInput == "가위" -> res = "무승부"
        }

        // 바위
        when (computer == "바위") {
            userInput == "보" -> res = "승리"
            userInput == "가위" -> res = "패배"
            userInput == "바위" -> res = "무승부"
        }

        // 보
        when (computer == "보") {
            userInput == "가위" -> res = "승리"
            userInput == "바위" -> res = "패배"
            userInput == "보" -> res = "무승부"
        }

        // 결과에 따라 1씩 증가
        if (res == "승리") win += 1
        if (res == "패배") lose += 1
        if (res == "무승부") tie += 1

        println("상대방이 낸 것은 $computer 입니다.")
        println("결과는 ${win}승 ${lose}패 ${tie}무 입니다.")
    }


}
