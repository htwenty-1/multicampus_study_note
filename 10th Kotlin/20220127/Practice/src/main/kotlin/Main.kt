import dao.MemberDao
import kotlin.system.exitProcess

/*
 * 야구팀 관리 프로그램 작성하기
 *
 * DTO : Human(number, name, age, height)
 *       Pitcher(win, lose, defense(방어율))
 *       Batter(batCount(타수), hit(안타수), batAvg(타율))
 *
 * DAO : Mutablelist로 선수 추가, 삭제, 검색(이름으로), 수정, 정렬(타율순)
 *
 * 선수 명단 저장 및 불러오기 - 파일 입출력
*/

fun main(args: Array<String>) {

    // dao 생성
    val dao = MemberDao()

    while(true) {
        println("******************************************")
        println("************* 구단 관리 프로그램 *************")
        println("** 사용하실 메뉴 번호를 입력 후 엔터키를 누르세요. **")
        println("************* 1. 선수 등록 *****************")
        println("************* 2. 전체 선수 조회 *************")
        println("************* 3. 선수 검색 *****************")
        println("************* 4. 선수 정보 수정**************")
        println("************* 5. 선수 삭제 *****************")
        println("************* 6. 파일로 저장 ****************")
        println("************* 7. 파일 바로 출력 **************")
        println("************* 8. 프로그램 종료 ***************")
        print("****** 사용할 메뉴의 번호 >>>> ")

        var wantToUse: Int = readLine()!!.toInt()

        when (wantToUse) {
            1 -> dao.addMember()
            2 -> dao.printAllData()
            3 -> dao.searchWithName()
            4 -> dao.editTeamList()
            5 -> dao.deleteTeamList()
            6 -> dao.saveAsText()
            7 -> dao.printFileToConsole()
            8 -> {
                println("프로그램이 종료됩니다...")
                exitProcess(0)
            }
        }
    }



}