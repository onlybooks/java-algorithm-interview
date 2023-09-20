package ch22;

public class P89_2 {
    public int majorityElement(int left, int right, int[] nums) {
        // 최소 분할 단위 리턴
        if (left == right)
            return nums[left];

        // 중앙 위치 인덱스 계산
        int mid = left + (right - left) / 2;
        int a = majorityElement(left, mid, nums);
        int b = majorityElement(mid + 1, right, nums);

        int countA = 0;
        // 해당 구간의 a 개수 계산
        for (int i = left; i <= right; i++) {
            if (nums[i] == a)
                countA++;
        }
        // a가 과반수를 넘으면 a 리턴
        return countA > (right - left + 1) / 2 ? a : b;
    }

    public int majorityElement(int[] nums) {
        return majorityElement(0, nums.length - 1, nums);
    }
}
