import java.io.*
import java.util.*

fun main(args: Array<String>) {

    // 파일 입출력

    val outString:String = "hello!"
    val path:String = "/Users/hwangduil/Activities/ref/myfile.rtf"

    // 파일 목록
    val files = File("/Users").listFiles()
    println(Arrays.toString(files))

    // 파일 복사
//    File(path).copyTo(File("/Users/hwangduil/Activities/ref/myfile2.rtf"))

    // 파일 내용 출력
    File(path).forEachLine { println(it) }

    //text토 읽기
    val text = File(path).readText()
    println(text)

    // 파일 읽기
    // regular
    /*
    val file = File(path)
    val inputStream:InputStream = file.inputStream()
    val inputStreamReader = InputStreamReader(inputStream)
    var line:String?
    val br = BufferedReader(inputStreamReader)
    val sb = StringBuffer()

    try {
        line = br.readLine()
        while (true) {
            sb.append(line, "\n")
            line = br.readLine()
        }

        println(sb)
    } catch (e:Exception) {
        e.printStackTrace()
    }
    */

    // use를 사용하여 좀 더 간략하게 파일 읽기
    val file = File(path)
    val inputStream:InputStream = file.inputStream()
    val readText = inputStream.bufferedReader().use { it.readText() }
    println(readText)

    // useLines
    val bufferedReader = File(path).bufferedReader()
    val lineList = mutableListOf<String>()
    bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
    lineList.forEach { println(it) }




    // write

    val str:String = "안녕하세요\r\nHello"
    // File(path).printWriter().use { it.println(str) }


    val writer = FileWriter(path)
    try {
        writer.write(str)
    } catch (e:Exception) {
        e.printStackTrace()
    } finally {
        writer.close()
    }


}