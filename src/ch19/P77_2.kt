package ch19

class P77_2 {
    fun hammingDistance(x: Int, y: Int): Int {
        // XOR 연산자를 사용해 두 수의 차이를 구한다.
        val xor = x xor y
        // 정수형을 이진수로 표현했을 때 값이 1인 자리의 개수를 구한다
        return Integer.bitCount(xor)
    }
}