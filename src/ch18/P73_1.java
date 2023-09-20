package ch18;

public class P73_1 {
    public int[] twoSum(int[] numbers, int target) {
        // 왼쪽 포인터는 가장 좌측 지정
        int left = 0;
        // 오른쪽 포인터는 가장 우측 지정
        int right = numbers.length - 1;
        // 왼쪽 포인터가 오른쪽 포인터와 작다면 계속 탐색
        while (left != right) {
            // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if (numbers[left] + numbers[right] < target) {
                left += 1;
            // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 이동
            } else if (numbers[left] + numbers[right] > target) {
                right -= 1;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }
}
