fun main(args: Array<String>) {


    /*
        Java에서 : for, if, switch case, etc.

    */

//    var num:Int = 50
//    val str = if(num > 30) {
//        "abc"
//    }
//    else {
//        "bcd"
//    }
//
//    println(str)


//    var num:Int = 50
//    var str:String  = ""
//    if(num > 30) {
//        str = "abc"
//    } else {
//        str = "bdc"
//    }
//    println("${str}")


    // 삼항연산자
    var num3:Int = 30
    val str = if(num3 > 30) "abc" else "bcd"
    println("${str}")


    // 정수 구분
    var num = 130
    if(num is Int) {
        println("정수임")
    } else {
        println("정수 아님")
    }

    if((num > 0) && (num < 300)) {
        println("Number는 300보다 작다")
    } else {
        println("Number는 300보다 크다")
    }

    if((num > 0) and (num < 300)) {
        println("Number는 300보다 작다")
    } else {
        println("Number는 300보다 크다")
    }

    if((num > 0) || (num < 300)) {
        println("Number는 300보다 작다")
    } else {
        println("Number는 300보다 크다")
    }

    if((num > 0) or (num < 300)) {
        println("Number는 300보다 작다")
    } else {
        println("Number는 300보다 크다")
    }


    val a = 12
    val b = 7
    val max:Int

    // 더 큰 숫자
    if(a > b) {
        max = a
        println("큰수는 $a")
    } else {
        max = b
        println("큰수는 $b")
    }

    val score = 96.7
//    val grade = if(score >= 90) {
//        "A"
//    } else if ((score >= 80) && (score < 90)) {
//        "B"
//    } else if ((score >= 70) && (score < 80)) {
//        "C"
//    } else {
//        "D"
//    }

//    val grade = if(score >= 90) {
//        "A"
//    } else if (score in 80.0..89.1) {
//        "B"
//    } else if (score in 70.0..79.9) {
//        "C"
//    } else {
//        "D"
//    }
//
//    println(grade)

    /*
    val x:Int = 3

    val s:String = when(x) {
        0 -> "abc"
        1, 2 -> "bcd"
        else -> "xyz"
    }

    println(s)
    */



/*
    val scr:Double = 85.0
    var grade:Char = 'F'

//    when (scr) {
//        in 90.0..100.0 -> grade = 'A'
//        in 80.0..89.9 -> grade = 'B'
//        in 70.0..79.9 -> grade = 'C'
//        !in 70.0..100.0 -> grade = 'F'
//    }

    // arguments가 없이 사용될 때
    when {
        scr >= 90.0 -> grade = 'A'
        scr in 80.0..89.9 -> grade = 'B'
        scr in 70.0..79.9 -> grade = 'C'
        scr < 70.0 -> grade = 'F'
    }

    println("score: $scr, grade: $grade")

*/

    // for each loop
    val array = arrayOf(1, 2, 3)
    for(number in array) {
        println(number)
    }

    // Java에서의 일반적인 for loop를 코틀린에서 이렇게
    for(i in 0 until 100) {
        println(i)
    }

    for (i in 99 downTo 0) {
        println(i)
    }

    for (i in 1..100) {
        println(i)
    }

    for (i in 0 until 100 step 2) { // 2씩 늘어남
        println(i)
    }


    // while문과 do while문
    var w:Int = 0
    while (w < 10) {
        println("w ==> $w")
        w++
    }

    w = 0
    do {
        w++
        println("w ==> $w")
    } while (w < 10)


    // continue와 break
    for(i in 1..5) {
        if (i == 3) break
        println(i)
    }

    for(i in 1..5) {
        if (i == 4) continue
        println(i)
    }






}