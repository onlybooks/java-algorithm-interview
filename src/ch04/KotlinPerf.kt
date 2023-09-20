package ch04

fun main() {
    var startTime: Long
    var index: Int

    // IntArray 1억 개 삽입
    startTime = System.currentTimeMillis()
    val intElements = IntArray(100000000)
    for (i in 0 until 100000000 - 1)
        intElements[i] = 1
    intElements[100000000 - 1] = 2
    System.out.printf("IntArray 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime)

    // IntArray 1억 개 중 찾기
    startTime = System.currentTimeMillis()
    index = 0
    while (2 != intElements[index])
        index++
    System.out.printf("IntArray 1억 개 중 찾기: %s밀리초\n", System.currentTimeMillis() - startTime)

    // ---

    // Array<Int?> 1억 개 삽입
    startTime = System.currentTimeMillis()
    val integerElements = arrayOfNulls<Int?>(100000000)
    for (i in 0 until 100000000 - 1)
        integerElements[i] = 1
    integerElements[100000000 - 1] = 2
    System.out.printf("Array<Int?> 1억 개 삽입: %s밀리초\n", System.currentTimeMillis() - startTime)

    // Array<Int?> 1억 개 중 찾기
    startTime = System.currentTimeMillis()
    index = 0
    while (2 != integerElements[index])
        index++
    System.out.printf("Array<Int?> 1억 개 중 찾기 %s밀리초\n", System.currentTimeMillis() - startTime)
}