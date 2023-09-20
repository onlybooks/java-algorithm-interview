package ch18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P72_2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        Set<Integer> result = new HashSet<>();
        // 한쪽은 정렬
        Arrays.sort(nums2);
        // 한쪽은 순차 반복
        for (int n1 : nums1) {
            // 이진 검색으로 일치하는 인덱스 추출
            int i2 = Arrays.binarySearch(nums2, n1);
            // 인덱스가 0 이상인 값이면 찾은 것이므로 결과 삽입
            if (i2 >= 0)
                result.add(n1);
        }
        // 자바 8+ 스트림 이용 결과인 HashSet<Integer> → int[] 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
