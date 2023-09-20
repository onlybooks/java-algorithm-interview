package ch19

class P78_3 {
    fun getSum(a: Int, b: Int): Int {
        // 정수형을 32비트 이진수 문자열로 변환
        val binA = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0')
        val binB = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0')

        // 결과 리스트
        val result: MutableList<Char> = mutableListOf()
        // 자리올림 수
        var carry = 0
        // 합
        var sum: Int

        // 32비트 모든 자리를 뒤에서부터 계산
        for (i in 0..31) {
            // 뒤에서부터 비트값을 정수형으로 추출
            val A = Character.getNumericValue(binA[31 - i])
            val B = Character.getNumericValue(binB[31 - i])

            // 전가산기 구현
            val Q1 = A and B
            val Q2 = A xor B
            val Q3 = Q2 and carry
            sum = carry xor Q2
            carry = Q1 or Q3

            // Int를 Char로 변환하여 리스트 앞쪽으로 추가
            result.add(0, Character.forDigit(sum, 2))
        }

        // 이진수 문자열을 정수형으로 변환하여 리턴
        return Integer.parseUnsignedInt(String(result.toCharArray()), 2)
    }
}