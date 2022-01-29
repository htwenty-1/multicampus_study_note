package file

import dto.Batter
import dto.Human
import dto.Pitcher
import java.io.*

// 파일 입출력을 위한 클래스
class FileData {

    // 생성자
    constructor(fileName:String){
        var dir:String = "/Users/hwangduil/test"    // 경로(폴더까지)
        file = File("$dir/$fileName")   // 파일 객체로 경로 잡아줌(파일까지)

        filePath = "$dir/$fileName.rtf"          // 파일의 경로
    }

    private var file: File? = null
    private var filePath:String? = null

    // 파일 생성
    fun createFile() {
        if(file!!.createNewFile()) {    // 생성자에서 잡아 준 경로에 파일 생성
            println(file!!.name + ".rtf 파일을 생성하였습니다.")
        } else {    // 이미 파일이 있다면 생성할 수 없음
            println("파일 생성에 실패하였습니다.")
        }
    }

    // 파일로 저장
    fun fileSave(arrStr: Array<String?>) {  // 선수정보를 배열로 받음
        /*
        val fileWriter = FileWriter(file)
        val bw = BufferedWriter(fileWriter)
        val pw = PrintWriter(bw)

        for (i in arrStr.indices) {
            pw.println(arrStr[i])
        }

        pw.close()
        */

        File(filePath).printWriter().use { out -> for(str in arrStr) { out.println(str) } }

        /*
            use
            - Executes the given block function on this resource and then closes it down correctly whether an exception is thrown or not.
            - Java의 AutoClosable을 Kotlin에서 구현해 놓은 것
        */
    }

    // 파일을 콘솔에 출력
    fun fileLoad():List<Human>? {
        val list:MutableList<Human> = ArrayList()

        /*
        val fileReader = FileReader(file)
        val br = BufferedReader(fileReader)
        var str = br.readLine()

        while(str != null && str != "") {       // 넘어오는 데이터 형식: 1001-XXX-00-000.0-00-00-0.0
            var split = str.split("-".toRegex()).toTypedArray()
            val position = split[0].toInt()

            var value:Human = if (position < 2000) {    // 투수
                Pitcher(split[0].toInt(),
                        split[1],
                        split[2].toInt(),
                        split[3].toDouble(),
                        split[4].toInt(),
                        split[5].toInt(),
                        split[6].toDouble()
                )
            } else {    // 타자
                Batter(split[0].toInt(),
                       split[1],
                       split[2].toInt(),
                       split[3].toDouble(),
                       split[4].toInt(),
                       split[5].toInt(),
                       split[6].toDouble()
                )
            }

            list.add(value)

            str = br.readLine()

        }
        */

        File(filePath).useLines {       // 줄 단위로 읽음
            lines -> lines.forEach {
                println(it)

                // toRegex() : 정규식 처리할 때 쓰는 메서드
                // toTypedArray() : 데이터가 컬렉션 내에 들어있기 때문에 배열로 변환한다.
                var split = it.split("-".toRegex()).toTypedArray()
                val position = split[0].toInt()

                var value:Human = if (position < 2000) {    // 투수
                    Pitcher(split[0].toInt(),
                        split[1],
                        split[2].toInt(),
                        split[3].toDouble(),
                        split[4].toInt(),
                        split[5].toInt(),
                        split[6].toDouble()
                    )
                } else {    // 타자
                    Batter(split[0].toInt(),
                        split[1],
                        split[2].toInt(),
                        split[3].toDouble(),
                        split[4].toInt(),
                        split[5].toInt(),
                        split[6].toDouble()
                    )
                }

                list.add(value)

            }
        }

        return list
    }

}