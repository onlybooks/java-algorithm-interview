package ch18;

public class P73_2 {
    public int[] twoSum(int[] numbers, int target) {
        // 배열 순회
        for (int i = 0; i < numbers.length; i++) {
            // 왼쪽 포인터는 가장 좌측 지정
            int left = i + 1;
            // 오른쪽 포인터는 가장 우측 지정
            int right = numbers.length - 1;
            // 타깃에서 현재 값을 뺀, 찾아야 하는 값 지정
            int expected = target - numbers[i];
            // 이진 검색으로 값 찾기
            while (left <= right) {
                // 중앙의 위치 계산 개선
                int mid = left + (right - left) / 2;
                // 만약 중앙값이 찾는 값보다 작으면, 왼쪽 포인터를 중앙으로 이동
                if (numbers[mid] < expected)
                    left = mid + 1;
                // 만약 중앙값이 찾는 값보다 크다면, 오른쪽 포인터를 중앙으로 이동
                else if (numbers[mid] > expected)
                    right = mid - 1;
                // 정답을 찾은 경우이므로 결과 리턴
                else
                    return new int[]{i + 1, mid + 1};
            }
        }
        return null;
    }
}
