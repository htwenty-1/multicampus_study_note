import java.util.*

fun main(args: Array<String>) {

    // Array

    /*
        Java에서의 배열
        final int[] arr = { 1, 2, 3, 4, 5 };
    */

    /*
    val arr = intArrayOf(1, 2, 3, 4, 5)
    println(arr)
    println(arr[1])
    println(Arrays.toString(arr))
    println(arr.contentToString())      // kotlin 문법

    val arr1 = arrayOf(1, 1.23, "hi", true)
    println(arr1.contentToString())

    val arr2 = Array(10) { 33 }
    for (n in arr2) {
        println(n)
    }

    var i:Int = 1
    var arr3 = Array(10) { i++ }

    // generic
    var arr4 = arrayOf<Int>(10, 20, 30)
    arr4.forEach { println(it) }        // it = iterator(요소를 루프 돌면서 출력)

    var arr5 = arrayOf<String>("하나", "둘", "삼")
    arr5.forEach { println(it) }
    */

    /*
    val array = intArrayOf(1, 2, 3, 4, 5)
    println("${array.contentToString()}")
    println("${array.size}")                // 배열의 길이
    println("${array.sum()}")               // 배열 원소의 합

    println(array[2])
    println(array.get(2))

    array[0] = 10
    println("${array.contentToString()}")
    for (n in array) {
        println(n)
    }

    for (n in array.indices) {  // 배열의 인덱스 출력
        println(n)
    }

    for (n in array.indices) {  // 배열의 인덱스 출력
        println("$n : ${array[n]}")
    }

    for(i in 0..array.size - 1) {
        println("array[$i] = ${array[i]}")
    }

    for(i in 0 until array.size) {
        println("array[$i] = ${array[i]}")
    }

    println(array.contains(3))
    println(3 in array)
    */

    // filter
    val array = arrayOf(1, -2, 3, 4, -5, 0)

    // 배열 원소 출력
    array.filter { e -> e > 0 }.forEach { e -> print("$e ") }
    println()

    // 출력한 원소를 다른 배열로 저장
    val result = array.filter { e -> e > 0 }
    println(result)

    val fruits = arrayOf("banana", "pear", "apple", "kiwi", "avocado")
    fruits
        // .filter { it.startsWith("a") }    // 맨 앞글자가 a인 것
        // .sortedBy { it }                  // 오름차순 정렬
        .sortedByDescending { it }           // 내림차순 정렬
        .map { it.uppercase(Locale.getDefault()) }  // 대문자로
        .forEach { println(it) }

    when {  // 조건절
        "apple" in fruits -> println("Apple이 있습니다.");
    }

    val productes = arrayOf(
        Product("Mouse", 3000.0),
        Product("Keyboard", 5500.0),
        Product("Monitor", 250000.0),
        Product("Tablet", 180000.0),
    )

    productes.sortedBy { it.price }.forEach { println("${it.name}, ${it.price}") }
    productes.forEach { println("${it.name}, ${it.price}") }


}

// 클래스 선언           생성자?
data class Product(val name:String, val price:Double)