package ch17

class P67_2 {
    fun toSwap(n1: Int, n2: Int): Boolean {
        // a + b와 b + a를 비교해 후자가 크면 스왑이 필요하므로 true 리턴
        return (n1.toString() + n2).toLong() < (n2.toString() + n1).toLong()
    }

    fun largestNumber(nums: IntArray): String {
        var i = 1
        // 포인터 i가 전체 길이 내일 때 진행
        while (i < nums.size) {
            // 포인터 j를 처음에는 i와 동일하게
            var j = i
            // j + [j - 1]이 더 클 경우 스왑 진행하면서 j 이동
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                // j와 j - 1을 스왑
                nums[j] = nums[j - 1].also { nums[j - 1] = nums[j] }
                // 정렬된 배열을 가리키는 포인터 j는 왼쪽으로 이동
                j--
            }
            // 정렬되지 않은 배열을 가리키는 포인터 i는 오른쪽으로 이동
            i++
        }

        // 첫 번째 값이 0이면 00 같은 결과가 나오지 않도록 0을 최종 결과로 리턴
        return if (nums[0] == 0) {
            "0"
        } else {
            // 정수형 배열을 콤마(,)나 대괄호([]), 공백은 정규식으로 제거하고 문자열로 결과 리턴
            nums.contentToString().replace("\\[|\\]|,|\\s".toRegex(), "")
        }
    }
}