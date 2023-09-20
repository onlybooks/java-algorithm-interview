package ch18

import java.util.*

class P72_4 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        val result: MutableSet<Int> = HashSet()
        // 한쪽은 정렬
        Arrays.sort(nums2)
        // 한쪽은 순차 반복
        for (n1 in nums1) {
            // 이진 검색으로 일치하는 인덱스 추출
            val i2 = Arrays.binarySearch(nums2, n1)
            // 인덱스가 0 이상인 값이면 찾은 것이므로 결과 삽입
            if (i2 >= 0)
                result.add(n1)
        }
        // IntArray로 변환해서 리턴
        return result.toIntArray()
    }
}