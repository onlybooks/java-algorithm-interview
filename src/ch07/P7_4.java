package ch07;

public class P7_4 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left != right) {
            // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if (nums[left] + nums[right] < target) {
                left += 1;
            // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 이동
            } else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                return new int[]{left, right};
            }
        }
        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }
}
