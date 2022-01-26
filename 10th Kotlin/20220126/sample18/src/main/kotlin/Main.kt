fun main(args: Array<String>) {

    val langMap:Map<Int, String> = mapOf(1001 to "kotlin", 1002 to "Java", 1003 to "React")
    for((key, value) in langMap) {
        println("key=$key, value=$value")
    }

    println(langMap[1002])
    println(langMap.get(1002))
    println(langMap)
    println(langMap.keys)

    // 가변형 Map
    val capitalCityMap:MutableMap<String, String> = mutableMapOf("Korea" to "Seoul", "Japan" to "Tokyo", "China" to "Beijing")
    println(capitalCityMap)
    println(capitalCityMap.keys)
    println(capitalCityMap.values)

    capitalCityMap["UK"] = "London"
    capitalCityMap.remove("China")
    println(capitalCityMap)

    val addData = mutableMapOf("USA" to "Washington", "India" to "New Delly")
    capitalCityMap.putAll(addData)
    println(capitalCityMap)

    // 정렬
//    val sortedByValue = capitalCityMap.toList().sortedBy { it.first }   // 오름차순
    val sortedByValue = capitalCityMap.toList().sortedByDescending { it.first } // 내림차순
    println(sortedByValue)

}