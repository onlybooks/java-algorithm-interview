package ch18

class P70_5 {
    fun search(nums: IntArray, target: Int): Int {
        // 왼쪽 포인터는 가장 좌측, 오른쪽 포인터는 가장 우측 지정
        var left = 0
        var right = nums.size - 1
        // 왼쪽 포인터가 오른쪽 포인터보다 작거나 같다면 계속 탐색
        while (left <= right) {
            // 중앙의 위치 계산 개선
            val mid = left + (right - left) / 2

            when {
                // 만약 중앙값이 타깃보다 작으면, 왼쪽 포인터를 중앙으로 이동
                nums[mid] < target -> left = mid + 1
                // 만약 중앙값이 타깃보다 크다면, 오른쪽 포인터를 중앙으로 이동
                nums[mid] > target -> right = mid - 1
                // 정답을 찾은 경우이므로 결과 리턴
                else -> return mid
            }
        }
        // 모두 탐색했으나 정답을 찾지 못한 경우로 -1 리턴
        return -1
    }
}