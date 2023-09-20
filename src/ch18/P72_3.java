package ch18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P72_3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 결과 변수로 중복을 허용하지 않는 집합 자료형 선언
        Set<Integer> result = new HashSet<>();
        // 양쪽 모두 정렬
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 투 포인터 선언
        int i = 0;
        int j = 0;

        // i는 nums1에 대한 포인터, j는 nums2에 대한 포인터. 둘 다 유효한 경우 반복
        while (i < nums1.length && j < nums2.length) {
            // 값이 작은 쪽의 포인터가 앞으로 이동
            if (nums1[i] > nums2[j])
                j++;
            else if (nums1[i] < nums2[j])
                i++;
            // 일치하는 경우이므로 결과 삽입 후 포인터 모두 이동
            else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        // 자바 8+ 스트림 이용 결과인 HashSet<Integer> → int[] 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
