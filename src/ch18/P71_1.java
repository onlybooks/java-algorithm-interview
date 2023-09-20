package ch18;

public class P71_1 {
    public int search(int[] nums, int target) {
        // 왼쪽 포인터는 가장 좌측, 오른쪽 포인터는 가장 우측 지정
        int left = 0, right = nums.length - 1;
        // 왼쪽 포인터가 오른쪽 포인터보다 작다면 계속 탐색
        while (left < right) {
            // 중앙의 위치 계산 개선
            int mid = left + (right - left) / 2;

            // 만약 중앙값이 우측값보다 크다면 왼쪽 포인터 이동
            if (nums[mid] > nums[right])
                left = mid + 1;
            // 반대의 경우에는 오른쪽 포인터 이동
            else
                right = mid;
        }
        // 최솟값을 찾아 피벗 설정
        int pivot = left;

        // 왼쪽 포인터는 가장 좌측, 오른쪽 포인터는 가장 우측 지정
        left = 0;
        right = nums.length - 1;
        // 왼쪽 포인터가 오른쪽 포인터보다 작거나 같다면 계속 탐색
        while (left <= right) {
            // 중앙의 위치 계산 개선
            int mid = left + (right - left) / 2;
            // 중앙의 위치를 피벗의 위치만큼 이동하여 계산
            int midPivot = (mid + pivot) % nums.length;

            // 만약 피벗 중앙값이 타깃보다 작으면, 왼쪽 포인터를 중앙으로 이동
            if (nums[midPivot] < target)
                left = mid + 1;
            // 만약 피벗 중앙값이 타깃보다 크다면, 오른쪽 포인터를 중앙으로 이동
            else if (nums[midPivot] > target)
                right = mid - 1;
            // 정답을 찾은 경우이므로 결과 리턴
            else
                return midPivot;
        }
        // 모두 탐색했으나 정답을 찾지 못한 경우로 -1 리턴
        return -1;
    }
}

