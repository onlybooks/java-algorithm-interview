package ch23

class P92_4 {
    fun maxSubArray(nums: IntArray): Int {
        // 첫 번째 값을 초깃값으로 리스트 선언
        val sums: MutableList<Int> = mutableListOf(nums[0])
        for (i in 1 until nums.size)
            // 이전까지 합이 0보다 크면 누적 합산
            sums.add(nums[i] + if (sums[i - 1] > 0) sums[i - 1] else 0)
        return sums.max()!!
    }
}