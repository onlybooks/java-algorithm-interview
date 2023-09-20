package ch18;

import java.util.HashSet;
import java.util.Set;

public class P72_1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        Set<Integer> result = new HashSet<>();
        // 두 집합 반복
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                // 값이 같으면 결과 삽입
                if (n1 == n2)
                    result.add(n1);
            }
        }
        // 자바 8+ 스트림 이용 결과인 HashSet<Integer> → int[] 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
