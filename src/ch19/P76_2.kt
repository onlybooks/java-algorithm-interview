package ch19

class P76_2 {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            // 각 수를 비트 연산자 XOR로 연산한 결과를 누적한다.
            result = result xor num
        }
        return result
    }
}