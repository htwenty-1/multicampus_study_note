package dao

import dto.Batter
import dto.Human
import dto.Pitcher
import file.FileData

class MemberDao {

    //list
    private var list:MutableList<Human>? = null
    private var fd:FileData? = null

    constructor() {
        /*
        list = ArrayList()
        list?.add(Pitcher(1001, "홍길동", 25, 180.2, 100, 10, 0.2))
        list?.add(Pitcher(1002, "성춘향", 23, 179.7, 124, 5, 0.3))
        */

        fd = FileData("baseball")
        fd!!.createFile()

        list = fd!!.fileLoad() as MutableList<Human>
    }

    // CRUD
    fun insert() {
        println(">> 선수 등록")
        print("투수[1] / 타자[2] 중 등록하고자 하는 포지션 입력 >> ")
        val choice:Int = readLine()!!.toInt()

        // 공통 데이터 입력받기
        print("번호 : ")
        val number:Int = readLine()!!.toInt()

        print("이름 : ")
        val name:String = readLine()!!

        print("나이 : ")
        val age:Int = readLine()!!.toInt()

        print("신장 : ")
        val height:Double = readLine()!!.toDouble()

        var human:Human = if (choice == 1) {    // 투수
            print("승 : ")
            val win:Int = readLine()!!.toInt()
            print("패 : ")
            val lose:Int = readLine()!!.toInt()
            print("방어율 : ")
            val defense:Double = readLine()!!.toDouble()

            Pitcher(number, name, age, height, win, lose, defense)
        } else {                                // 타자
            print("타수 : ")
            val batCount:Int = readLine()!!.toInt()
            print("안타수 : ")
            val hit:Int = readLine()!!.toInt()
            print("타율 : ")
            val hitAvg:Double = readLine()!!.toDouble()

            Batter(number, name, age, height, batCount, hit, hitAvg)
        }

        list?.add(human)

    }

    fun delete() {
        print("방출할 선수의 이름 입력 >> ")
        val name:String? = readLine()
        var findIndex = search(name!!)

        if (findIndex == -1) {
            println("검색된 선수가 없습니다")
            return
        }

        list?.removeAt(findIndex)
        println("선택한 선수를 삭제하였습니다...")
    }

    fun select() {
        print("검색할 선수의 이름 입력 >> ")
        val name:String? = readLine()
        var findIndex = search(name!!)

        if (findIndex == -1) {
            println("검색된 선수가 없습니다")
            return
        }

        // instanceOf
        if(list!![findIndex] is Pitcher) {
            println("투수입니다")
        } else {
            println("타자입니다")
        }

        println(list!![findIndex].toString())
    }

    fun update() {
        print("수정할 선수의 이름 입력 >> ")
        val name:String? = readLine()
        var findIndex = search(name!!)

        if (findIndex == -1) {
            println("검색된 선수가 없습니다")
            return
        }

        println("수정할 데이터를 입력 >> ")
        if(list!![findIndex] is Pitcher) {
            print("승 : ")
            val win:Int? = readLine()?.toInt()
            print("패 : ")
            val lose:Int? = readLine()?.toInt()
            print("방어율 : ")
            val defense:Double? = readLine()?.toDouble()

            val pitcher = list!![findIndex] as Pitcher      // cast 변환
            pitcher.win = win!!
            pitcher.lose = lose!!
            pitcher.defense = defense!!

        } else {

        }
    }

    fun allPrint() {
        for (member in list!!) {
            println(member)
        }
    }

    // 유틸리티 함수
    fun search(name:String):Int {
        var findIndex:Int = -1
        for(i in list!!.indices) {
            if(list!![i].name == name) {
                findIndex = i
                break
            }
        }
        return findIndex
    }

    // 파일로 저장
    fun fileSave() {
        // list -> array
        val strArr = arrayOfNulls<String>(list!!.size)
        for (i in list!!.indices) {
            strArr[i] = list!![i].toString()
        }

        fd?.fileSave(strArr)

    }

    // 정렬
    fun hitAvgSort() {

    }

}