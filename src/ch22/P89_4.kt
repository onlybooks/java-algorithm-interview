package ch22

class P89_4 {
    fun majorityElement(nums: IntArray): Int {
        fun majorityElement(left: Int, right: Int, nums: IntArray): Int {
            // 최소 분할 단위 리턴
            if (left == right)
                return nums[left]

            // 중앙 위치 인덱스 계산
            val mid = left + (right - left) / 2
            val a = majorityElement(left, mid, nums)
            val b = majorityElement(mid + 1, right, nums)

            var countA = 0
            // 해당 구간의 a 개수 계산
            for (i in left..right) {
                if (nums[i] == a)
                    countA++
            }

            // a가 과반수를 넘으면 a 리턴
            return if (countA > (right - left + 1) / 2)
                a
            else
                b
        }

        return majorityElement(0, nums.size - 1, nums)
    }
}