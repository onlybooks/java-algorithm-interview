package ch18;

public class P70_1 {
    public int binarySearch(int[] nums, int target, int left, int right) {
        // 왼쪽 포인터가 오른쪽 포인터보다 작거나 같다면 계속 탐색
        if (left <= right) {
            // 중앙의 위치 계산
            int mid = (left + right) / 2;
            // 만약 중앙값이 타깃보다 작으면, 포인터를 우측으로 옮겨서 다시 탐색
            if (nums[mid] < target)
                return binarySearch(nums, target, mid + 1, right);
            // 만약 중앙값이 타깃보다 크다면, 포인터를 좌측으로 옮겨서 다시 탐색
            else if (nums[mid] > target)
                return binarySearch(nums, target, left, mid - 1);
            // 정답을 찾은 경우이므로 결과 리턴
            else
                return mid;
        } else
            // 모두 탐색했으나 정답을 찾지 못한 경우로 -1 리턴
            return -1;
    }

    public int search(int[] nums, int target) {
        // 왼쪽 포인터는 가장 좌측, 오른쪽 포인터는 가장 우측을 지정하고 이진 검색 시작
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}
