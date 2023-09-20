package ch18

import java.util.*

class P73_4 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        // 배열 순회
        for (i in numbers.indices) {
            // 타깃에서 현재 값을 뺀, 찾아야 하는 값 지정
            val expected = target - numbers[i]
            // 이진 검색으로 값 찾기, 시작 인덱스는 현재 위치 다음으로 해서 찾아야 할 범위를 점점 좁힌다.
            val idx = Arrays.binarySearch(numbers, i + 1, numbers.size, expected)
            // 인덱스가 0 이상인 값이면 찾은 것이므로 결과 리턴
            if (idx >= 0) {
                return intArrayOf(i + 1, idx + 1)
            }
        }
        return intArrayOf()
    }
}