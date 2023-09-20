package ch07

class P8_3 {
    fun trap(height: IntArray): Int {
        var volume = 0
        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]

        // 투 포인터가 서로 겹칠때까지 반복
        while (left < right) {
            leftMax = height[left].coerceAtLeast(leftMax)
            rightMax = height[right].coerceAtLeast(rightMax)

            // 더 높은 쪽을 향해 투 포인터 이동
            if (leftMax <= rightMax) {
                // 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left]
                left += 1
            } else {
                // 오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                volume += rightMax - height[right]
                right -= 1
            }
        }
        return volume
    }
}