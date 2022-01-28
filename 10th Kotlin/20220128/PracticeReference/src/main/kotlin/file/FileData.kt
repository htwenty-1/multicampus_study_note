package file

import dto.Batter
import dto.Human
import dto.Pitcher
import java.io.*

class FileData {

    constructor(fileName:String){
        var dir:String = "User/user/hwangduil/test"
        file = File("$dir/$fileName.rtf")
    }
    // java
    private var file: File? = null
    fun createFile() {
        if(file!!.createNewFile()) {
            println(file!!.name + ".rtf 파일을 생성하였습니다.")
        } else {
            println("파일 생성에 실패하였습니다.")
        }
    }

    fun fileSave(arrStr: Array<String?>) {
        val fileWriter = FileWriter(file)
        val bw = BufferedWriter(fileWriter)
        val pw = PrintWriter(bw)

        for (i in arrStr.indices) {
            pw.println(arrStr[i])
        }

        pw.close()
    }

    fun fileLoad():List<Human>? {
        val list:MutableList<Human> = ArrayList()

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

            str = br.readLine()

            list.add(value)
        }

        return list
    }

}