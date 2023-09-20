package ch18;

import java.util.Arrays;

public class P70_4 {
    public int search(int[] nums, int target) {
        // 자바의 이진 검색 메소드 호출, 찾는 값이 없으면 0 미만 값이 나오기 때문에 이 경우 -1 리턴
        return Arrays.binarySearch(nums, target) >= 0 ? Arrays.binarySearch(nums, target) : -1;
    }
}
