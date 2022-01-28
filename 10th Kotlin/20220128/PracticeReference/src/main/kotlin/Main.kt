import dao.MemberDao

fun main(args: Array<String>) {

    val dao = MemberDao()

    while (true) {
        println("<< Menu >>")
        println("1. 선수등록")
        println("2. 선수삭제")
        println("3. 선수검색")
        println("4. 선수수정")
        println("5. 선수 모두 출력")
        println("6. 선수명단 저장")
        println("7. 타율 순으로 정렬")
        println("8. 프로그램 종료")

        when(readLine()?.toInt()) {
            1 -> dao.insert()
            2 -> dao.delete()
            3 -> dao.select()
            4 -> dao.update()
            5 -> dao.allPrint()
            6 -> dao.fileSave()
            7 -> dao.hitAvgSort()
            8 -> break
            else -> {}
        }
    }

}