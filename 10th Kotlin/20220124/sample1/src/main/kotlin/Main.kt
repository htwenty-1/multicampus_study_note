import java.util.*

fun main(args:Array<String>){
    println("Hello World!")

    // 주석문 : command + /
    // 범위주석문: command + shift + /

    // 입출력
//    print("input = ")
//    val input = readLine()
//    println("Your input ==> $input")

    // 자바 입력받기
//    val read = Scanner(System.`in`)
//    print("Number? ==> ")
//    val number = read.nextInt()
//    println("number ===> $number")

    // 변수(variable)와 값(value)
//    var str:String = "abc"
//    val name:String = "홍길동"
//
//    str = "bcd"              // 변수이므로 값을 바꿀 수 있음.
//    // name = "성춘향"         // 상수이므로 변경할 수 없음.
//
//    println("str ==> $str")
//    println(str + name)

//    var a = 1
//    val str1 = "a = $a"
//    val str2 = "a = ${a + 1}"
//
//    println("str1: \"$str1\", str2: \"$str2\"")
//
//    val num1 = 5      // 자료형을 밝히지 않으면 컴파일러에서 (Int로) 추정
//    val num2 = 3
//    val num3:Int = num1 + num2
//
//    println("number1 + number2 = $num3")
//
    // 문자열 비교 (equals)
    var str3:String = "hello"
    var str4 = "world"
    var str5 = "hell"
    str5 += "o"

    println("${str3 == str5}")  // 자동적으로 equals를 호출하여 값을 비교해줌.
    println("${str3 === str5}") // 값 끼리 비교


    // 숫자 비교
    /*val num4:Int = 123
    val num5:Int = num4
    println(num4 === num5)

    val num6:Int = num4
    val num7:Int = num4
    val num8:Int = num6

    println(num6 == num7)
    println(num6 === num7)  // 값의 주소가 다르기 때문에 false?
    println(num6 === num8)*/

/*
    // ?와 !!
    // var a:Int = null ---> 에러발생
    var a:Int? = null
    var b:Int? = 10     // null이 들어갈 수도 있음을 알려줌

    // 다음과 같은 방법으로 표기해야 에러가 발생하지 않는다
    var c:Int? = b
    var d:Int = b!!

    var str1:String? = "Hello Kotlin"
    str1 = null


    // 자료형의 비교
    println("Byte min: ${Byte.MIN_VALUE} ~ max: ${Byte.MAX_VALUE}")
    println("Short min: ${Short.MIN_VALUE} ~ max: ${Short.MAX_VALUE}")
    println("Int min: ${Int.MIN_VALUE} ~ max: ${Int.MAX_VALUE}")
    println("Long min: ${Long.MIN_VALUE} ~ max: ${Long.MAX_VALUE}")
    println("Float min: ${Float.MIN_VALUE} ~ max: ${Float.MAX_VALUE}")      // 1.4E-45 : 1.4 * 10의 1/45승
    println("Double min: ${Double.MIN_VALUE} ~ max: ${Double.MAX_VALUE}")

    val num1:Double = 12.0
    val num2:Double = 23.1
    val num3:Double = 0.0
    var result:Double? = 0.0

    result = num1 + num2
//    result = num1 / num3      ==> Infinity

    println(result)


    var n = 10
    n++
    ++n
    println(n)

    */

//    var a:Int = 12
//    val b:Boolean = true
//    var d:Double = 12.345
//
//    // 자바에서 자료형변환
//    // String str = Integer.toString(a);
//    // 또는 String str = a + "";
//
//    val s = a.toString()
//    println(s)
//
//    var number:Int = s.toInt()
//    println("${number + 1}")

    val a:Int = 128
    val b = a
    println(a === b)        // 같은 객체

    val c:Int? = a
    val d:Int? = a
    println(c == d)         // 값 비교
    println(c === d)        // 객체(주소) 비교        ?가 들어가면서 wrapper가 된것인가...?
}