package ch19

class P79_2 {
    fun validUtf8(data: IntArray): Boolean {
        // 문자의 시작 바이트 인덱스
        var start = 0

        fun check(size: Int): Boolean {
            // size만큼 이동하면서 각 바이트 10으로 시작여부 확인
            for (i in start + 1 until start + size + 1) {
                if (i >= data.size || data[i] shr 6 != 2) {
                    return false
                }
            }
            return true
        }

        // 문자 전체 길이만큼 순회
        while (start < data.size) {
            // 문자의 시작 바이트
            val first = data[start]
            when {
                // 11110으로 시작하면 나머지가 3바이트여야 한다.
                first shr 3 == 30 && check(3) -> start += 4
                // 1110으로 시작하면 나머지가 2바이트여야 한다.
                first shr 4 == 14 && check(2) -> start += 3
                // 110으로 시작하면 나머지가 1바이트여야 한다.
                first shr 5 == 6 && check(1) -> start += 2
                // 1바이트 문자
                first shr 7 == 0 -> start++
                else -> return false
            }
        }
        return true
    }
}