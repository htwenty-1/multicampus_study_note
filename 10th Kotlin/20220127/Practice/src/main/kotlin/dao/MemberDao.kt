package dao

import dto.Batter
import dto.Human
import dto.Pitcher
import java.io.File
import java.io.FileWriter

class MemberDao {

    var teamList:MutableList<Human> = mutableListOf(
        Pitcher(1, 1001, "Kim", 25, 181.5, 1, 100, 42, 75.0, ),
        Batter(2, 1002, "Park", 24, 181.5, 2, 75, 10, 24.0, )
    )



    // CRUD
    // CREATE
    fun addMember() {

        print("입력할 선수의 번호 >> ")
        var number:Int = readLine()!!.toInt()
        print("입력할 선수명 >> ")
        var name:String = readLine()!!
        print("입력할 선수의 나이 >> ")
        var age:Int = readLine()!!.toInt()
        print("입력할 선수의 신장 >> ")
        var height:Double = readLine()!!.toDouble()

        print("투수라면 1, 타자라면 2를 입력하세요 >> ")
        var ref:Int = readLine()!!.toInt()

        var index = 0
        index++

        when (ref) {
            1 -> {
                print("승리한 경기 수 >> ")
                var win:Int = readLine()!!.toInt()
                print("패배한 경기 수 >> ")
                var lost:Int = readLine()!!.toInt()
                var defense:Double = (win / lost).toDouble()

                teamList.add(Pitcher(index, number, name, age, height, ref, win, lost, defense))

                println("입력하신 선수가 추가되었습니다.")
            }

            2 -> {
                print("타수 >> ")
                var batCount:Int = readLine()!!.toInt()
                print("안타수 >> ")
                var hit:Int = readLine()!!.toInt()
                var batAvg:Double = (batCount / hit).toDouble()

                teamList.add(Batter(index, number, name, age, height, ref, batCount, hit, batAvg))
                println("입력하신 선수가 추가되었습니다.")
            }

            else -> println("잘못된 입력입니다. 다시 시도하세요.")
        }



    }


    // READ
    // 모든 데이터 출력
    fun printAllData() {
        if(teamList != null || teamList.size != 0) {
            for (item in teamList) println(item)
        } else if (teamList == null || teamList.size == 0) {
            println("작성된 명단이 한 건도 존재하지 않습니다.")
        }
    }

    // 검색
    fun searchWithName() {
        print("검색할 선수의 이름 입력 >> ")
        var inputName:String = readLine()!!

        for(item in teamList) {
            if (item.name == inputName) {
                println(item)
            } else {
                println("검색결과가 없습니다")
            }
        }
    }


    // UPDATE
    // 수정

    fun editTeamList() {
        printAllData()
        print("수정할 선수의 순번을 입력하세요 >> ")
        val wantEdit:Int = readLine()!!.toInt() - 1
        println("다음 선수의 정보를 수정합니다.")
        println("${teamList[wantEdit]}")

        println("수정할 내용을 선택하세요.")
        for (item in teamList) {
            if (item.ref == 1) {
                print("*** [1]선수번호, [2]선수이름, [3]나이, [4]신장, [5]이긴 게임 수, [6]진 게임 수 >> ")

                val editInform:Int = readLine()!!.toInt()

                when(editInform) {
                    1 -> {
                        print("변경할 선수번호를 입력하세요 >> ")
                        val newNumber:Int = readLine()!!.toInt()
                        teamList[wantEdit].number = newNumber
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    2-> {
                        print("변경할 선수이름을 입력하세요 >> ")
                        val newName:String = readLine()!!
                        teamList[wantEdit].name = newName
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    3-> {
                        print("변경할 선수나이를 입력하세요 >> ")
                        val newAge:Int = readLine()!!.toInt()
                        teamList[wantEdit].age = newAge
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    4-> {
                        print("변경할 선수신장을 입력하세요 >> ")
                        val newHeight:Double = readLine()!!.toDouble()
                        teamList[wantEdit].height = newHeight
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    5 -> {
                        print("변경할 이긴 게임 수를 입력하세요 >> ")
                        val newWinValue:Int = readLine()!!.toInt()
                        teamList[wantEdit].win = newWinValue
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    6 -> {
                        print("변경할 이긴 게임 수를 입력하세요 >> ")
                        val newWinValue:Int = readLine()!!.toInt()
                        teamList[wantEdit].lost = newWinValue
                        println("변경이 완료 되었습니다.")
                        break
                    }
                }

            } else if (item.ref == 2) {
                print("*** [1]선수번호, [2]선수이름, [3]나이, [4]신장, [5]타수, [6]안타수 >> ")

                val editInform:Int = readLine()!!.toInt()

                when(editInform) {
                    1 -> {
                        print("변경할 선수번호를 입력하세요 >> ")
                        val newNumber:Int = readLine()!!.toInt()
                        teamList[wantEdit].number = newNumber
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    2-> {
                        print("변경할 선수이름을 입력하세요 >> ")
                        val newName:String = readLine()!!
                        teamList[wantEdit].name = newName
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    3-> {
                        print("변경할 선수나이를 입력하세요 >> ")
                        val newAge:Int = readLine()!!.toInt()
                        teamList[wantEdit].age = newAge
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    4-> {
                        print("변경할 선수신장을 입력하세요 >> ")
                        val newHeight:Double = readLine()!!.toDouble()
                        teamList[wantEdit].height = newHeight
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    5 -> {
                        print("변경할 타수를 입력하세요 >> ")
                        val newBat:Int = readLine()!!.toInt()
                        teamList[wantEdit].batCount = newBat
                        println("변경이 완료 되었습니다.")
                        break
                    }

                    6 -> {
                        print("변경할 안타 수를 입력하세요 >> ")
                        val newHit:Int = readLine()!!.toInt()
                        teamList[wantEdit].hit = newHit
                        println("변경이 완료 되었습니다.")
                        break
                    }
                }
            }
        }

    }


    // DELETE
    fun deleteTeamList() {
        printAllData()
        print("삭제할 선수의 순번을 입력하세요 >> ")
        var wantToDelete = readLine()!!.toInt() - 1
        teamList.removeAt(wantToDelete)
    }

    // File IO
    // 파일로 저장
    fun saveAsText() {

        val path:String = "/User/hwangduil/test/test.rtf"
        val writer = FileWriter(path)

        try {
            writer.write(teamList.toString())
        } catch (e:Exception) {
            e.printStackTrace()
        } finally {
            writer.close()
        }

    }

    // 파일을 콘솔로 출력
    fun printFileToConsole() {

        val path:String = "/User/hwangduil/test/test.rtf"

        val br = File(path).bufferedReader()
        val list = mutableListOf<String>()
        br.useLines { e -> e.forEach { list.add(it) } }
        list.forEach { println(it) }

    }

}