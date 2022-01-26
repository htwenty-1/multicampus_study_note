/*
    Collection => ArrayList와 LinkedList
    HashMap과 TreeMap

*/

fun main(args: Array<String>) {

    // 리스트를 돌며 값 뽑아주기
    var numbers:List<Int> = listOf<Int>( 1, 2, 3, 4, 5 )
    for(n in numbers) print("$n ")
    println()

    var names:List<String> = listOf<String>("one", "two", "three")
    for (name in names) print("$name ")
    println()

    // 리스트의 크기
    println(names.size)

    // 해당 인덱스 값 가져오기
    println(names.get(1))
    println(names[1])   // 배열처럼 사용 가능

    // 인덱스 가져오기
    println(names.indexOf("three"))

    // 값 포함여부
    println(names.contains("two"))

    // 여러가지 타입
    var mixedType = listOf("hello", 123, true, 123.456)
    for(m in mixedType) print("$m ")
    println()

    // 리스트만을 생성
    var emptyList = emptyList<String>()

    // null이 아닌 element만을 리스트에 담기
    val notNullList:List<Int> = listOfNotNull(2, 3, 4, null, 5, 7, null)    //이라면
    println(notNullList)    // null은 반영되지 않음
    println(notNullList[3])

    val strList:ArrayList<String> = arrayListOf<String>("hello", "world", "success")
    strList.add("kotlin")

    // listOf로 만들어진 리스트는 배열처럼 값의 추가 삭제가 불가능하다
    // CRUD가 필요한 경우 ArrayList로 작성할 것..

    println(strList)

    // 가변형 리스트
    val mutableListNames:MutableList<String> = mutableListOf<String>("kim", "lee", "yun")
    mutableListNames.add("park")    // insert
    println(mutableListNames)

    mutableListNames.removeAt(2)    // delete(인덱스로 삭제)
    println(mutableListNames)

    mutableListNames[0] = "choi"    // update
    // 또는 .set()
    println(mutableListNames)

    val mutableListMix = mutableListOf("android", "react", 5, true)
    println(mutableListMix)

    // 불변형 리스트를 가변형 리스트로 변경하고 싶은 경우
    val newNames = names.toMutableList()
    newNames.add("five")
    println(newNames)

    // 안에 있는 내용 보여주기
    val fruits = listOf("apple", "banana", "kiwi")
    for(item in fruits) println(item)
    for(index in fruits.indices) println("fruits[$index] : ${fruits[index]}")

    // while
    var index = 0
    while(index < fruits.size) {
        println("fruits[$index] : ${fruits[index]}")
        index++
    }

    // index 찾기
    var findIndex = -1
    for (i in 0..fruits.size - 1 step(1)) {
        if (fruits.get(i) === "banana") {
            findIndex = i
            break
        }
    }

    println(fruits[findIndex])

    val list:MutableList<Duck> = mutableListOf()

    val duck = Duck("오리1", 2)
    list.add(duck)
    list.add(Duck("오리2", 2))
    list.add(Duck("오리3", 4))

    for (d in list) {
        println(d.name)
    }
    

}

class Duck(val name:String, val age:Int)